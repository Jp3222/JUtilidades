/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.connection;

import com.jutil.dbcon.cn.JConnection;
import com.jutil.dbcon.cn.SimpleQuerys;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author juan-campos
 */
public class DBConnection implements SimpleQuerys, JConnection {

    private static DBConnection instance;

    public static DBConnection getInstance() {
        return instance;
    }

    public static DBConnection getInstance(String url) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(url);
        }
        return instance;
    }

    public static DBConnection getInstance(String url, Properties info) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(url, info);
        }
        return instance;
    }

    public static DBConnection getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(url, user, password);
        }
        return instance;
    }

    public static DBConnection getNewInstance(String url, String user, String password) throws SQLException {
        DBConnection o = new DBConnection(url, user, password);
        return o;
    }

    private final Connection connection;
    private boolean show_query;
    private boolean exec_query;

    protected DBConnection(String url) throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    protected DBConnection(String url, Properties info) throws SQLException {
        connection = DriverManager.getConnection(url, info);
    }

    protected DBConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void close() throws SQLException {
        connection.close();
    }

    @Override
    public boolean insert(String table, String fields, String values) throws SQLException {
        Statement st = connection.createStatement();
        String query = INSERT_VAL.formatted(table, fields, values);
        System.out.println(query);
        return st.executeUpdate(query) > 0;
    }

    public boolean insert(String table, String fields, StringBuilder values) throws SQLException {
        Statement st = connection.createStatement();
        String query = INSERT_COL.formatted(table, fields, values.toString());
        showQuery(query);
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String olValue, String newValue, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = UPDATE_VAL.formatted(table, olValue, newValue, where);
        showQuery(query);
        return st.executeUpdate(query) > 0;
    }

    public boolean update(String table, String kv, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = UPDATE_COL.formatted(table, kv, where);
        showQuery(query);
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean delete(String table, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = DELETE.formatted(table, where);
        showQuery(query);
        return st.executeUpdate(query) > 0;
    }

    @Override
    public ResultSet select(String table, String fields, String where) throws SQLException {
        Statement st = connection.createStatement();
        String query = SELECT.formatted(table, fields, where);
        showQuery(query);
        return st.executeQuery(query);
    }

    @Override
    public ResultSet query(String query) throws SQLException {
        Statement st = connection.createStatement();
        return st.executeQuery(query);
    }

    private void showQuery(String o) {
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

    private final String fmt_cvc = "'%s'";
    private final String fmt_kv = "%s='%s'";

    public static final int VALUES = 1;
    public static final int FIELDS = 2;
    public static final int UPDATE = 3;

    public Connection getConnection() {
        return connection;
    }

}
