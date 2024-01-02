/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import com.jutil.jbd.interfaces.MetodosBasicos;
import com.jutil.jbd.interfaces.MetodosBasicosCompuestos;
import com.jutil.jbd.util.Func;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jp
 */
public class Conexion extends BD implements MetodosBasicos, MetodosBasicosCompuestos {

    private static Conexion instancia;

    public static Conexion getInstancia(String url) throws SQLException {
        if (instancia == null) {
            instancia = new Conexion(url);
        }
        return instancia;
    }

    public static Conexion getInstancia(Properties propiedades, String url) throws SQLException {
        if (instancia == null) {
            instancia = new Conexion(propiedades, url);
        }
        return instancia;
    }

    public static Conexion getInstancia(String usuario, String contra, String url) throws SQLException {
        if (instancia == null) {
            instancia = new Conexion(usuario, contra, url);
        }
        return instancia;
    }

    public static void ConexionNULL() throws SQLException {
        if (instancia != null) {
            instancia.desconectar();
        }
        instancia = null;
    }
    
    /**
     * Metodo que retorna la instancia unica una vez que haya sido inicializada
     *
     * @return
     */
    public static Conexion getInstancia() {
        return instancia;
    }

    protected final Ejecutor ejc;

    protected Conexion(String url) throws SQLException {
        super(url);
        ejc = new Ejecutor(cn, st, rs, sql);
    }

    protected Conexion(Properties propiedades, String url) throws SQLException {
        super(propiedades, url);
        ejc = new Ejecutor(cn, st, rs, sql);
    }

    protected Conexion(String usuario, String contra, String url) throws SQLException {
        super(usuario, contra, url);
        ejc = new Ejecutor(cn, st, rs, sql);
    }

    @Override
    public boolean insert(String tabla, String campos, String datos) throws SQLException {
        return ejc.insert(tabla, campos, datos);
    }

    @Override
    public boolean update(String tabla, String campos, String datos) throws SQLException {
        return ejc.update(tabla, campos, datos);
    }

    @Override
    public boolean delete(String tabla, String where) throws SQLException {
        return ejc.delete(tabla, where);
    }

    @Override
    public ResultSet select(String tabla, String campos, String where) throws SQLException {
        return ejc.select(tabla, campos, where);
    }

    public void closeST() throws SQLException {
        ejc.cerrarStatement();
    }

    public void closeRS() throws SQLException {
        ejc.cerrarResultSet();
        ejc.cerrarStatement();
    }

    @Override
    public boolean insert(String tabla, String datos) throws SQLException {
        return ejc.insert(tabla, null, datos);
    }

    @Override
    public boolean update(String tabla, String campo, String valor, String where) throws SQLException {
        return ejc.update(tabla, campo + "=" + "'" + valor + "'", where);
    }

    @Override
    public boolean update(String tabla, String[] campos, String[] valors, String where) throws SQLException {
        String upt = getCamposDatos(campos, valors);
        return ejc.update(tabla, upt, where);
    }

    @Override
    public ResultSet select(String tabla) throws SQLException {
        return ejc.select(tabla, "*", null);
    }

    public Connection getConexion() {
        return cn;
    }

    public boolean isConectado() throws SQLException {
        return cn != null && !cn.isClosed();
    }

    @Override
    public ResultSet select(String tabla, String campos) throws SQLException {
        return ejc.select(tabla, campos, null);
    }

    @Override
    public boolean instruccion(String query) throws SQLException {
        return ejc.instruccion(query);
    }

    @Override
    public ResultSet queryResult(String query) throws SQLException {
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
