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
public abstract class BD {

    protected Connection connection;
    protected String user;
    protected String password;
    protected final String url;
    protected Properties properties;

    public BD(String url) {
        this.url = url;
    }

    public BD(String url, Properties properties) {
        this.url = url;
        this.properties = properties;
    }

    public BD(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;

    }

    public void conectar(int type) throws SQLException, Exception {
        switch (type) {
            case 1:
                connection = DriverManager.getConnection(url);
                break;
            case 2:
                connection = DriverManager.getConnection(url, properties);
                break;
            case 3:
                connection = DriverManager.getConnection(url, user, password);
                break;
            default:
                throw new Exception("Type don't exist");
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
