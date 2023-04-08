/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import com.jutil.jbd.interfaces.MetodosBasicos;
import com.jutil.jbd.sql.SQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jp
 */
class Ejecutor implements MetodosBasicos {

    private final Connection cn;
    private Statement st;
    private ResultSet rs;
    //
    private final SQL sql;

    public Ejecutor(Connection cn, Statement st, ResultSet rs, SQL sql) {
        this.cn = cn;
        this.st = st;
        this.rs = rs;
        this.sql = sql;
    }

    @Override
    public boolean insert(String tabla, String campos, String datos) throws SQLException {
        st = cn.createStatement();
        int af = st.executeUpdate(sql.insert(tabla, campos, datos));
        cerrarStatement();
        return af > 0;

    }

    @Override
    public boolean update(String tabla, String kv, String where) throws SQLException {
        st = cn.createStatement();
        int af = st.executeUpdate(sql.update(tabla, kv, where));
        cerrarStatement();
        return af > 0;
    }

    @Override
    public boolean delete(String tabla, String where) throws SQLException {
        st = cn.createStatement();
        int af = st.executeUpdate(sql.delete(tabla, where));
        cerrarStatement();
        return af > 0;

    }

    @Override
    public ResultSet select(String tabla, String campos, String where) throws SQLException {
        st = cn.createStatement();
        rs = st.executeQuery(sql.select(tabla, campos, where));
        return rs;

    }

    @Override
    public boolean instruccion(String query) throws SQLException {
        st = cn.createStatement();
        int res = st.executeUpdate(sql.query(query));
        cerrarStatement();
        return res > 0;
    }

    @Override
    public ResultSet queryResult(String query) throws SQLException {
        st = cn.createStatement();
        rs = st.executeQuery(sql.query(query));
        return rs;
    }

    public void cerrarResultSet() throws SQLException {
        rs.close();
    }

    public void cerrarStatement() throws SQLException {
        st.close();
    }

}
