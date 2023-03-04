/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import com.jutil.jbd.sql.SQL;
import com.jutil.jexception.Excp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jp
 */
public abstract class BD {

    protected Connection cn;
    protected Statement st;
    protected ResultSet rs;
    protected final SQL sql;
    //
    private Properties propiedades;
    private String usuario, contra;
    private final String url;
    private final int opcion;

    protected BD(String url) {
        this.url = url;
        this.opcion = 0;
        this.sql = new SQL();
        this.conectar();
    }

    protected BD(Properties propiedades, String url) {
        this.propiedades = propiedades;
        this.url = url;
        this.opcion = 1;
        this.sql = new SQL();
        this.conectar();
    }

    protected BD(String usuario, String contra, String url) {
        this.usuario = usuario;
        this.contra = contra;
        this.url = url;
        this.opcion = 2;
        this.sql = new SQL();
        this.conectar();
    }

    public synchronized final void conectar() {
        conectar(opcion);
    }

    private synchronized void conectar(int i) {
        try {
            switch (i) {
                case 0:
                    cn = DriverManager.getConnection(url);
                    break;
                case 1:
                    cn = DriverManager.getConnection(url, propiedades);
                    break;
                case 2:
                    cn = DriverManager.getConnection(url, usuario, contra);
                    break;
            }
        } catch (SQLException e) {
            Excp.impTerminal(e, this.getClass(), true);
        }
    }

    public void desconectar() {
        try {
            this.cn.close();
        } catch (SQLException e) {
            Excp.impTerminal(e, this.getClass(), true);
        }
    }

}
