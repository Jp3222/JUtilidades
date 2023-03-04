/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import com.jutil.interfaces.MetodosBasicos;
import com.jutil.interfaces.MetodosBasicosCompuestos;
import com.jutil.jbd.util.Func;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author jp
 */
public class Conexion extends BD implements MetodosBasicos, MetodosBasicosCompuestos {

    public static Conexion instancia;

    public static Conexion getInstancia(String url) {
        if (instancia == null) {
            instancia = new Conexion(url);
        }
        return instancia;
    }

    public static Conexion getInstancia(Properties propiedades, String url) {
        if (instancia == null) {
            instancia = new Conexion(propiedades, url);
        }
        return instancia;
    }

    public static Conexion getInstancia(String usuario, String contra, String url) {
        if (instancia == null) {
            instancia = new Conexion(usuario, contra, url);
        }
        return instancia;
    }

    /**
     * Metodo que retorna la instancia unica una vez que haya sido inicializada
     *
     * @return
     */
    public static Conexion getInstancia() {
        return instancia;
    }

    private final Ejecutor ejc;

    private Conexion(String url) {
        super(url);
        ejc = new Ejecutor(cn, st, rs, sql);
    }

    private Conexion(Properties propiedades, String url) {
        super(propiedades, url);
        ejc = new Ejecutor(cn, st, rs, sql);
    }

    private Conexion(String usuario, String contra, String url) {
        super(usuario, contra, url);
        ejc = new Ejecutor(cn, st, rs, sql);
    }

    @Override
    public boolean insert(String tabla, String campos, String datos) {
        return ejc.insert(tabla, campos, datos);
    }

    @Override
    public boolean update(String tabla, String campos, String datos) {
        return ejc.update(tabla, campos, datos);
    }

    @Override
    public boolean delete(String tabla, String where) {
        return ejc.delete(tabla, where);
    }

    @Override
    public ResultSet select(String tabla, String campos, String where) {
        return ejc.select(tabla, campos, where);
    }

    public void closeST() {
        ejc.closeST();
    }

    public void closeRS() {
        ejc.closeRS();
        ejc.closeST();
    }

    @Override
    public boolean insert(String tabla, String datos) {
        return ejc.insert(tabla, null, datos);
    }

    @Override
    public boolean update(String tabla, String campo, String valor, String where) {
        return ejc.update(tabla, campo + "=" + "'" + valor + "'", where);
    }

    @Override
    public boolean update(String tabla, String[] campos, String[] valors, String where) {
        String upt = "";
        return ejc.update(tabla, upt, where);
    }

    @Override
    public ResultSet select(String tabla) {
        return ejc.select(tabla, "*", null);
    }

    public Connection getConexion() {
        return cn;
    }

    @Override
    public ResultSet select(String tabla, String campos) {
        return ejc.select(tabla, campos, null);
    }

    @Override
    public boolean query(String query) {
        return ejc.query(query);
    }

    @Override
    public ResultSet queryResult(String query) {
        return ejc.queryResult(query);
    }

    public String getCampos(String... campos) {
        return Func.getCampos(campos);
    }

    public String getDatos(String... datos) {
        return Func.getDatos(datos);
    }

    public String getCamposDatos(String[] campos, String[] datos) {
        return Func.getCamposDatos(campos, datos);
    }
}
