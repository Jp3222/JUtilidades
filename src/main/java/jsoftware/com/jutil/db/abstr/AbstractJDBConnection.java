/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.abstr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import jsoftware.com.jutil.db.model.JConnectionModel;
import jsoftware.com.jutil.db.model.JStamentModel;
import jsoftware.com.jutil.jexception.JExcp;

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
public abstract class AbstractJDBConnection implements JStamentModel, JConnectionModel, AutoCloseable {

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
    protected Connection connection;

    /**
     *
     * @param show_query
     * @param exec_query
     * @param connection
     */
    public AbstractJDBConnection(boolean show_query, boolean exec_query, Connection connection) {
        this.show_query = show_query;
        this.exec_query = exec_query;
        this.connection = connection;
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
        return connection;
    }

    @Override
    public void setAutoCommit(boolean auto) {
        try {
            connection.setAutoCommit(auto);
        } catch (SQLException ex) {
            JExcp.getInstance(false, show_query).print(ex, getClass(), "setAutoCommit");
        }
    }

    @Override
    public void rollBack() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            JExcp.getInstance(false, show_query).print(ex, getClass(), "setAutoCommit");
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            JExcp.getInstance(false, show_query).print(ex, getClass(), "setAutoCommit");
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

    public PreparedStatement getNewPreparedStatement(String query, int opc) throws SQLException {
        return connection.prepareStatement(query, opc);
    }

    public CallableStatement getNewCallableStatement(String query) throws SQLException {
        return connection.prepareCall(query);
    }

}
