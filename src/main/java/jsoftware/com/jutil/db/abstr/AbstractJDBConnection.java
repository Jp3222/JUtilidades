/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.abstr;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import jsoftware.com.jutil.db.JDBConnection;
import jsoftware.com.jutil.db.model.JConnectionModel;
import jsoftware.com.jutil.db.model.JStamentModel;

/**
 * Clase abstracta que proporciona una implementación base para la gestión de
 * conexiones y la ejecución de sentencias SQL en JDBC.
 * <p>
 * Esta clase sirve como una API de alto nivel que implementa las interfaces
 * {@link JStamentModel} y {@link JConnectionModel}, encapsulando la complejidad
 * de manejar {@link java.sql.Connection} y {@link java.sql.Statement}. Los
 * métodos de esta clase manejan internamente las excepciones SQL y proporcionan
 * funcionalidades de depuración como la visualización y simulación de
 * consultas.
 *
 * @author juan-campos
 * @see JStamentModel
 * @see JConnectionModel
 * @see java.sql.Connection
 * @since 1.0
 */
public abstract class AbstractJDBConnection implements JStamentModel, JConnectionModel {

    /**
     * El objeto de conexión JDBC subyacente.
     * <p>
     * Esta conexión es protegida para ser accesible por las subclases, y final
     * ya que se inicializa una sola vez en el constructor.
     */
    private Connection connection;

    /**
     * Indicador para mostrar las consultas SQL en la consola con fines de
     * depuración. El valor por defecto es {@code false}.
     */
    protected boolean show_query;

    /**
     * Indicador para deshabilitar la ejecución real de las consultas SQL,
     * permitiendo un modo de simulación o "solo lectura". El valor por defecto
     * es {@code false}.
     */
    protected boolean exec_query;
    /**
     *
     */
    private int max_poll_size;
    /**
     *
     */
    private int minimum_idle;
    /**
     *
     */
    private int time_out;
    /**
     *
     */
    private String user;
    /**
     *
     */
    private String password;
    /**
     *
     */
    private String url;
    /**
     *
     */
    private Properties properties;
    /**
     *
     */
    private HikariConfig db_config;
    /**
     *
     */
    private HikariDataSource data_source;

    /**
     * Crea una nueva instancia de conexión JDBC a partir de un tipo de conexión
     * predefinido y un conjunto de argumentos variables.
     *
     * @param instance_type El tipo de conexión a crear (1, 2 o 3).
     * <p>
     * <ul>
     * <li>1: Solo URL (ej. "jdbc:mysql://localhost:3306/db")</li>
     * <li>2: URL y propiedades (ej. "jdbc:mysql:...", Properties)</li>
     * <li>3: URL, usuario y contraseña (ej. "jdbc:mysql:...", "user",
     * "pass")</li>
     * </ul>
     * @param args Los argumentos necesarios para la conexión, que dependen del
     * tipo de instancia.
     * @throws SQLException Si ocurre un error al establecer la conexión con la
     * base de datos.
     * @throws AssertionError Si el tipo de instancia proporcionado no es
     * valido.
     * @deprecated
     */
    protected AbstractJDBConnection(int instance_type, Object... args) throws SQLException {
        switch (instance_type) {
            case INTANCE_LITE ->
                connection = DriverManager.getConnection((String) args[0]);
            case INTANCE_PROPERTIES ->
                connection = DriverManager.getConnection((String) args[0], (Properties) args[1]);
            case INTANCE_CREDENTIALS ->
                connection = DriverManager.getConnection((String) args[0], (String) args[1], (String) args[2]);
            case INTANCE_POLL ->{}
//                intancePoll(
//                        Integer.parseInt(args[0].toString()),
//                        Integer.parseInt(args[1].toString()),
//                        Integer.parseInt(args[2].toString()),
//                        String.valueOf(args[3]),
//                        String.valueOf(args[4]),
//                        String.valueOf(args[5])
//                );
            default ->
                throw new AssertionError();
        }
        show_query = false;
        exec_query = false;
    }

    protected AbstractJDBConnection(int instance_type, JDBConnection.BuilderConnection build) throws SQLException {
        switch (instance_type) {
            case INTANCE_LITE ->
                connection = DriverManager.getConnection(build.getUrl());
            case INTANCE_PROPERTIES ->
                connection = DriverManager.getConnection(build.getUrl(), build.getProperties());
            case INTANCE_CREDENTIALS ->
                connection = DriverManager.getConnection(
                        build.getUrl(),
                        build.getUser(),
                        build.getPassword()
                );
            case INTANCE_POLL_CONFIG -> {
                db_config = build.getConfig();
                data_source = new HikariDataSource(db_config);
            }
            case INTANCE_POLL -> {
                db_config.setUsername(user);
                db_config.setPassword(password);
                db_config.setJdbcUrl(url);
                if (max_poll_size > 0) {
                    db_config.setMaximumPoolSize(max_poll_size);
                }
                if (minimum_idle > 0) {
                    db_config.setMinimumIdle(minimum_idle);
                }
                if (time_out > 0) {
                    db_config.setConnectionTimeout(time_out);
                }
            }
            default ->
                throw new AssertionError();
        }
        show_query = false;
        exec_query = false;
    }

    private Connection getNewConnection() throws SQLException {
        if (data_source == null) {
            throw new IllegalStateException("El pool de conexiones no ha sido inicializado.");
        }
        return data_source.getConnection();
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    public static final int VALUES = 1;
    public static final int FIELDS = 2;
    public static final int UPDATE = 3;

    @Override
    public Connection getConnection() {
        if (connection == null) {
            try {
                return getNewConnection();
            } catch (SQLException ex) {
                System.getLogger(AbstractJDBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        return connection;
    }

    @Override
    public void setAutoCommit(boolean auto) {
        try {
            connection.setAutoCommit(auto);
        } catch (SQLException ex) {
            System.getLogger(JDBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void rollBack() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.getLogger(JDBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            System.getLogger(JDBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void setShowQuery(boolean flag) {
        this.show_query = flag;
    }

    @Override
    public boolean isShowQuery() {
        return show_query;
    }

    @Override
    public void setExceQuery(boolean flag) {
        this.exec_query = flag;
    }

    @Override
    public boolean canExceQuery() {
        return exec_query;
    }

    protected void showQuery(String query) {
        if (show_query) {
            System.out.println(query);
        }
    }

    public Statement getNewStament() throws SQLException {
        return connection.createStatement();
    }

    public PreparedStatement getNewPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public CallableStatement getNewCallableStatement(String query) throws SQLException {
        return connection.prepareCall(query);
    }

}
