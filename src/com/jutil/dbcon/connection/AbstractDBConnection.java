/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.connection;

import com.jutil.dbcon.cn.JConnection;
import static com.jutil.dbcon.cn.SimpleQuerys.DELETE;
import static com.jutil.dbcon.cn.SimpleQuerys.INSERT_COL;
import static com.jutil.dbcon.cn.SimpleQuerys.INSERT_VAL;
import static com.jutil.dbcon.cn.SimpleQuerys.SELECT;
import static com.jutil.dbcon.cn.SimpleQuerys.UPDATE_COL;
import static com.jutil.dbcon.cn.SimpleQuerys.UPDATE_VAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.jutil.dbcon.cn.JStamentModel;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractDBConnection implements JStamentModel, JConnection, AutoCloseable {

    final Connection connection;
    private boolean show_query;
    private boolean exec_query;

    protected AbstractDBConnection(int instance_type, Object... args) throws SQLException {
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
    public boolean update(String table, String olValue, String newValue, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = UPDATE_VAL.formatted(table, olValue, newValue, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

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

    void showQuery(String o) {
        if (show_query) {
            System.out.println(o);
        }
    }

    public void setShowQuery(boolean show_query) {
        this.show_query = show_query;
    }

    public boolean isShowQuery() {
        return show_query;
    }

    public void setExecQuery(boolean exec_query) {
        this.exec_query = exec_query;
    }

    public boolean isExecQuery() {
        return exec_query;
    }

    public static final int VALUES = 1;
    public static final int FIELDS = 2;
    public static final int UPDATE = 3;

    public Connection getConnection() {
        return connection;
    }

}
