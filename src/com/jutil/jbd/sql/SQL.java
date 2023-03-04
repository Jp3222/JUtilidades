/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.sql;

import com.jutil.interfaces.SQLMetodosBasicos;
import com.jutil.interfaces.Sintaxis;

/**
 *
 * @author jp
 */
public class SQL implements SQLMetodosBasicos, Sintaxis {

    @Override
    public String sentencia(String sentencia) {
        return sentencia;
    }

    @Override
    public String insert(String tabla, String campos, String datos) {
        String sql = INSERT + " into " + tabla;
        if (campos != null && !campos.isEmpty()) {
            sql += "(" + campos + ")";
        }
        sql += " values(" + datos + ")";
        //System.out.println(sql);
        return sql;
    }

    @Override
    public String update(String tabla, String kv, String where) {
        String sql = UPDATE + " " + tabla + " set " + kv + " where " + where;
        return sql;
    }

    @Override
    public String delete(String tabla, String where) {
        String sql = "delete from " + tabla + " where " + where;
        return sql;
    }

    //select id,nombre from tabla where id > 45
    @Override
    public String select(String tabla, String campos, String where) {
        String sql = SELECT;
        if (campos != null && !campos.isEmpty()) {
            sql += " " + campos;
        } else {
            sql += " *";
        }
        sql += " from " + tabla;

        if (where != null && !where.isEmpty()) {
            sql += " where " + where;
        }
        return sql;
    }

    @Override
    public String query(String query) {
        return query;
    }
    
    
}
