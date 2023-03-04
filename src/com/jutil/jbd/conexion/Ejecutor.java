/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import com.jutil.interfaces.MetodosBasicos;
import com.jutil.jbd.sql.SQL;
import com.jutil.jexception.Excp;
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
    public boolean insert(String tabla, String campos, String datos) {
        try {
            st = cn.createStatement();
            st.execute(sql.insert(tabla, campos, datos));
            closeST();
            return true;
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
        return false;
    }

    @Override
    public boolean update(String tabla, String kv, String where) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.update(tabla, kv, where));
            closeST();
            return true;
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
        return false;
    }

    @Override
    public boolean delete(String tabla, String where) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.delete(tabla, where));
            closeST();
            return true;
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
        return false;
    }

    @Override
    public ResultSet select(String tabla, String campos, String where) {
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql.select(tabla, campos, where));
            return rs;
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
        return null;
    }

    @Override
    public boolean query(String query) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.query(query));
            closeST();
            return true;
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
        return false;
    }

    @Override
    public ResultSet queryResult(String query) {
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql.query(query));
            return rs;
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
        return null;
    }

    public void closeRS() {
        try {
            rs.close();
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
    }

    public void closeST() {
        try {
            st.close();
        } catch (SQLException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }
    }

}
