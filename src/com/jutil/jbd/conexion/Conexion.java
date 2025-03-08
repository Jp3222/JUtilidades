/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import com.jutil.dbcon.cn.JConnection;
import com.jutil.dbcon.cn.SimpleQuerys;
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
public class Conexion extends BD implements SimpleQuerys, MetodosBasicosCompuestos, JConnection {

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

    private final Ejecutor EXCE;

    protected Conexion(String url) throws SQLException {
        super(url);
        EXCE = new Ejecutor(cn, st, rs, sql);
    }

    protected Conexion(Properties propiedades, String url) throws SQLException {
        super(propiedades, url);
        EXCE = new Ejecutor(cn, st, rs, sql);
    }

    protected Conexion(String usuario, String contra, String url) throws SQLException {
        super(usuario, contra, url);
        EXCE = new Ejecutor(cn, st, rs, sql);
    }

    @Override
    public boolean insert(String tabla, String campos, String datos) throws SQLException {
        return EXCE.insert(tabla, campos, datos);
    }

    public boolean update(String tabla, String campos, String datos) throws SQLException {
        return EXCE.update(tabla, campos, datos);
    }

    @Override
    public boolean delete(String tabla, String where) throws SQLException {
        return EXCE.delete(tabla, where);
    }

    @Override
    public ResultSet select(String tabla, String campos, String where) throws SQLException {
        return EXCE.select(tabla, campos, where);
    }

    public void closeST() throws SQLException {
        EXCE.cerrarStatement();
    }

    public void closeRS() throws SQLException {
        EXCE.cerrarResultSet();
        EXCE.cerrarStatement();
    }

    @Override
    public boolean insert(String tabla, String datos) throws SQLException {
        return EXCE.insert(tabla, null, datos);
    }

    public boolean insert(String tabla, String campos, StringBuilder valores) throws SQLException {
        return EXCE.insert(tabla, campos, valores);
    }

    @Override
    public boolean update(String tabla, String campo, String valor, String where) throws SQLException {
        return EXCE.update(tabla, campo + "=" + "'" + valor + "'", where);
    }

    @Override
    public boolean update(String tabla, String[] campos, String[] valors, String where) throws SQLException {
        String upt = getCamposDatos(campos, valors);
        return EXCE.update(tabla, upt, where);
    }

    @Override
    public ResultSet select(String tabla) throws SQLException {
        return EXCE.select(tabla, "*", null);
    }

    public Connection getConexion() {
        return cn;
    }

    public boolean isConectado() throws SQLException {
        return cn != null && !cn.isClosed();
    }

    public boolean isServerON() throws SQLException {
        return cn != null && !cn.isValid(1000);
    }

    @Override
    public ResultSet select(String tabla, String campos) throws SQLException {
        return EXCE.select(tabla, campos, null);
    }

    public boolean instruccion(String query) throws SQLException {
        return EXCE.instruccion(query);
    }

    @Override
    public ResultSet query(String query) throws SQLException {
        return EXCE.queryResult(query);
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
