/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.dbcon.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.util.Properties;
import jsoftware.com.jutil.dbcon.cn.JConnectionModel;
import jsoftware.com.jutil.dbcon.cn.JStamentModel;

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
    protected final Connection connection;

    /**
     * Indicador para mostrar las consultas SQL en la consola con fines de
     * depuración. El valor por defecto es {@code false}.
     */
    private boolean show_query;

    /**
     * Indicador para deshabilitar la ejecución real de las consultas SQL,
     * permitiendo un modo de simulación o "solo lectura". El valor por defecto
     * es {@code false}.
     */
    private boolean exec_query;

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
     */
    protected AbstractJDBConnection(int instance_type, Object... args) throws SQLException {
        switch (instance_type) {
            case 1 ->
                connection = DriverManager.getConnection((String) args[0]);
            case 2 ->
                connection = DriverManager.getConnection((String) args[0], (Properties) args[1]);
            case 3 ->
                connection = DriverManager.getConnection((String) args[0], (String) args[1], (String) args[2]);
            default ->
                throw new AssertionError();
        }
        show_query = false;
        exec_query = false;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    @Override
    public boolean insert(String table, String fields, String values) throws SQLException {
        Statement st = connection.createStatement();
        String query = INSERT_VAL.formatted(table, fields, values);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean insert(String table, String fields, StringBuilder values) throws SQLException {
        Statement st = connection.createStatement();
        String query = INSERT_COL.formatted(table, fields, values.toString());
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String field, String newValue, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = UPDATE_VAL.formatted(table, field, newValue, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String kv, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = UPDATE_COL.formatted(table, kv, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean delete(String table, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = DELETE.formatted(table, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public ResultSet select(String table, String fields, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = SELECT.formatted(table, fields, where);
        showQuery(query);
        if (exec_query) {
            return null;
        }
        return st.executeQuery(query);
    }

    @Override
    public ResultSet query(String query) throws SQLException {
        Statement st = connection.createStatement();
        showQuery(query);
        if (exec_query) {
            return null;
        }
        return st.executeQuery(query);
    }

    @Override
    public int execute(String query) throws SQLException {
        Statement st = connection.createStatement();
        showQuery(query);
        if (exec_query) {
            return 0;
        }
        return st.executeUpdate(query);
    }

    public static final int VALUES = 1;
    public static final int FIELDS = 2;
    public static final int UPDATE = 3;

    @Override
    public Connection getConnection() {
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
