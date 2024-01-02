/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jp
 */
public class Resultados {

    public static LinkedList<String[]> getLista(ResultSet rs, String[] col) throws SQLException {
        return runWhile(rs, col);
    }

    private static LinkedList<String[]> runWhile(ResultSet rs, String[] col) throws SQLException {
        LinkedList<String[]> ls = new LinkedList<>();
        while (rs.next()) {
            String[] o = runFor(rs, col);
            ls.add(o);
        }
        return ls;
    }

    private static String[] runFor(ResultSet rs, String[] col) throws SQLException {
        String[] o = new String[col.length];
        for (int i = 0; i < col.length; i++) {
            o[i] = rs.getString(col[i]);
        }
        return o;
    }

}
