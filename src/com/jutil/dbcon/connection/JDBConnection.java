/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.connection;

import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author juan-campos
 */
public final class JDBConnection extends AbstractDBConnection {

    private static JDBConnection instance;

    public static JDBConnection getInstance() {
        return instance;
    }

    public static JDBConnection getInstance(String url) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(1, url);
        }
        return instance;
    }

    public static JDBConnection getInstance(String url, Properties info) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(2, url, info);
        }
        return instance;
    }

    public static JDBConnection getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(3, url, user, password);
        }
        return instance;
    }

    public static JDBConnection getNewInstance(String url, String user, String password) throws SQLException {
        JDBConnection o = new JDBConnection(3, url, user, password);
        return o;
    }

    private StorageProcedure sp;

    private JDBConnection(int instance_type, Object... args) throws SQLException {
        super(instance_type, args);
        sp = new StorageProcedure(connection);
    }

    public StorageProcedure getStorageProcedure() {
        return sp;
    }

    @Override
    public void setExecQuery(boolean exec_query) {
        super.setExecQuery(exec_query); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        sp.setExecQuery(exec_query);
    }

    @Override
    public void setShowQuery(boolean show_query) {
        super.setShowQuery(show_query); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        sp.setShowQuery(show_query);
    }

}
