/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import com.jutil.jbd2.inter.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan-campos
 */
public class DBConnection extends DB implements Query {

    private static DBConnection instance;

    public static DBConnection getInstance() throws Exception {
        return instance;
    }

    public static DBConnection getInstance(String url) throws Exception {
        if (instance == null) {
            instance = new DBConnection(url);
        }
        return instance;
    }

    public static DBConnection getInstance(String url, Properties properties) throws Exception {
        if (instance == null) {
            instance = new DBConnection(url, properties);
        }
        return instance;
    }

    public static DBConnection getInstance(String user, String password, String url) throws Exception {
        if (instance == null) {
            instance = new DBConnection(user, password, url);
        }
        return instance;
    }

    private DBConnection(String url) throws Exception {
        super(url);
    }

    private DBConnection(String url, Properties properties) throws Exception {
        super(url, properties);
    }

    private DBConnection(String user, String password, String url) throws Exception {
        super(user, password, url);
    }

    @Override
    public int setQuery(String query) {
        int result = -1;
        try (Statement st = connection.createStatement()) {
            result = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ResultSet getQuery(String query) {
        ResultSet rs = null;
        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
