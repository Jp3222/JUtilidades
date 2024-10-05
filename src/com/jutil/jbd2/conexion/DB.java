/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author juan-campos
 */
public abstract class DB {

    protected Connection connection;
    protected String user;
    protected String password;
    protected final String url;
    protected Properties properties;

    public DB(String url) throws Exception {
        this.url = url;
        conectar(1);
    }

    public DB(String url, Properties properties) throws Exception {
        this.url = url;
        this.properties = properties;
        conectar(2);
    }

    public DB(String user, String password, String url) throws Exception {
        this.user = user;
        this.password = password;
        this.url = url;
        conectar(3);
    }

    /**
     *
     * @param type
     * @throws SQLException
     */
    private void conectar(int type) throws SQLException {
        switch (type) {
            case 1 -> connection = DriverManager.getConnection(url);
            case 2 -> connection = DriverManager.getConnection(url, properties);
            case 3 -> connection = DriverManager.getConnection(url, user, password);
            default -> throw new SQLException("Connection Type Not Exist");
        }
    }

    public void desconectar() throws SQLException {
        connection.close();
        connection = null;
    }

    public void saveProperties(String path_name, String comments) throws FileNotFoundException, IOException {
        File file = new File(path_name);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileOutputStream fos = new FileOutputStream(file);
        properties.store(fos, comments);
    }

    public Connection getConnection() {
        return connection;
    }
    
    public boolean isConnection() throws SQLException{
        return !connection.isClosed();
    }
    
    public boolean isValid() throws SQLException{
        return connection.isValid(1000);
    }
    
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public Properties getProperties() {
        return properties;
    }

}
