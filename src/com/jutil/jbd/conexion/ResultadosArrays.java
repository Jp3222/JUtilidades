/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class ResultadosArrays {

    public static ArrayList<String[]> getListaArraysString(ResultSet rs, int noColumnas) throws SQLException {
        ArrayList<String[]> lista = new ArrayList<>();
        try (rs) {
            whileRun(rs, lista, noColumnas);
        }
        return lista;

    }

    public static void whileRun(ResultSet rs, ArrayList<String[]> lista, int noColumnas) throws SQLException {
        while (rs.next()) {
            lista.add(forRun(rs, noColumnas));
        }
    }

    public static String[] forRun(ResultSet rs, int noColumnas) throws SQLException {
        String[] o = new String[noColumnas];
        for (int i = 0; i < o.length; i++) {
            o[i] = rs.getString(i);
        }
        return o;
    }

}
