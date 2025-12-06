/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jsoftware.com.jutil.db.abstr.AbstractJDBConnection;
import jsoftware.com.jutil.db.model.ObjectsFactory;
import static jsoftware.com.jutil.db.model.SimpleQuerys.DELETE;
import static jsoftware.com.jutil.db.model.SimpleQuerys.INSERT_COL;
import static jsoftware.com.jutil.db.model.SimpleQuerys.INSERT_VAL;
import static jsoftware.com.jutil.db.model.SimpleQuerys.SELECT;
import static jsoftware.com.jutil.db.model.SimpleQuerys.UPDATE_COL;
import static jsoftware.com.jutil.db.model.SimpleQuerys.UPDATE_VAL;
import jsoftware.com.jutil.jexception.JExcp;

/**
 *
 * @author juan-campos
 */
public final class JDBConnection extends AbstractJDBConnection {

    private static JDBConnection instance;

    private StorageProcedure sp;
    private ObjectsFactory factory;
    private Adapters adapter;

    public JDBConnection(JDBConnectionBuilder builder, Connection connection) {
        super(
                builder.isShow_query(),
                builder.isExec_query(),
                connection
        );
        this.factory = builder.getFactory();
    }

    @Override
    public boolean insert(String table, String fields, String values) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = INSERT_VAL.formatted(table, fields, values);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean insert(String table, String fields, StringBuilder values) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = INSERT_COL.formatted(table, fields, values.toString());
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String field, String newValue, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = UPDATE_VAL.formatted(table, field, newValue, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String kv, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = UPDATE_COL.formatted(table, kv, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean delete(String table, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = DELETE.formatted(table, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public ResultSet select(String table, String fields, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = SELECT.formatted(table, fields, where);
        showQuery(query);
        if (exec_query) {
            return null;
        }
        return st.executeQuery(query);
    }

    @Override
    public ResultSet query(String query) throws SQLException {
        Statement st = getConnection().createStatement();
        showQuery(query);
        if (exec_query) {
            return null;
        }
        return st.executeQuery(query);
    }

    @Override
    public int execute(String query) throws SQLException {
        Statement st = getConnection().createStatement();
        showQuery(query);
        if (exec_query) {
            return 0;
        }
        return st.executeUpdate(query);
    }

    public boolean execute(String query, String[] args) {
        boolean res = false;
        try (PreparedStatement ps = getNewCallableStatement(query)) {
            if (args != null) {
                int i = 0;
                for (String j : args) {
                    ps.setString(i, j);
                    i++;
                }
            }
            res = ps.executeUpdate() > 0;
        } catch (Exception e) {
            JExcp.getInstance(false, show_query).print(e, getClass(), "execute");
        }
        return res;
    }

    public ResultSet query(String query, String[] args) {
        ResultSet res = null;
        try (PreparedStatement ps = getNewCallableStatement(query)) {
            if (args != null) {
                int i = 0;
                for (String j : args) {
                    ps.setString(i, j);
                    i++;
                }
            }
            res = ps.executeQuery();
        } catch (Exception e) {
            JExcp.getInstance(false, show_query).print(e, getClass(), "execute");
        }
        return res;
    }

    public StorageProcedure getStorageProcedure() {
        return sp;
    }

    public void setFactory(ObjectsFactory factory) {
        this.factory = factory;
    }

    public ObjectsFactory getFactory() {
        return factory;
    }

}
