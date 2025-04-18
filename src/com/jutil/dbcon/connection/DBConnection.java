/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;

/**
 *
 * @author juan-campos
 */
public class DBConnection extends AbstractDBConnection {

    private static DBConnection instance;

    public static DBConnection getInstance() {
        return instance;
    }

    public static DBConnection getInstance(String url) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(1, url);
        }
        return instance;
    }

    public static DBConnection getInstance(String url, Properties info) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(2, url, info);
        }
        return instance;
    }

    public static DBConnection getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(3, url, user, password);
        }
        return instance;
    }

    public static DBConnection getNewInstance(String url, String user, String password) throws SQLException {
        DBConnection o = new DBConnection(1, url, user, password);
        return o;
    }

    public DBConnection(int instance_type, Object... args) throws SQLException {
        super(instance_type, args);
    }

    @Override
    public boolean psInsert(String table, String fields, String values) throws SQLException {
        return true;
    }

    @Override
    public boolean psUpdate(String table, String olValue, String newValue, String where) throws SQLException {
        return true;

    }

    @Override
    public ResultSet psSelect(String table, String fields, String where) throws SQLException {
        return null;
    }

    @Override
    public boolean psDelete(String table, String where) throws SQLException {
        return true;
    }

    @Override
<<<<<<< HEAD
    public ResultSet query(String query) throws SQLException {
        Statement st = connection.createStatement();
        showQuery(query);
        return st.executeQuery(query);
=======
    public ResultSet psQuery(String query) throws SQLException {
        return null;
>>>>>>> a2d6bd5463c68fa324c9cb3119b5f817d4e135ed
    }
    
    public int execute(String e) throws SQLException{
    Statement st = connection.createStatement();
        showQuery(e);
        return st.executeUpdate(e);
    }

    private ResultSet psQuery(String query, String... args) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query, args);
        showQuery(query);
        nullQuery(query);
        return ps.executeQuery();
    }

}
