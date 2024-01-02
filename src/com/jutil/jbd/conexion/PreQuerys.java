/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class PreQuerys {

    private final Conexion conexion;
    private final HashMap<String, PreparedStatement> MAPA;

    public PreQuerys(Conexion cn) {
        this.conexion = cn;
        this.MAPA = new HashMap<>(10);
    }

    public void add(String name, String query) {
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(query);
            MAPA.put(name, ps);
        } catch (SQLException ex) {
            Logger.getLogger(PreQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param key
     */
    public void remove(String key) {
        try {
            PreparedStatement ps = MAPA.remove(key);
            if (!ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PreQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param key
     * @param values
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet ejecutarResultSet(String key, String... values) throws SQLException {
        PreparedStatement query = MAPA.get(key);
        for (int i = 0; i < values.length; i++) {
            query.setString(i + 1, values[i]);
        }
        return query.executeQuery();

    }

    /**
     * Insercciones - Actualizaciones - Eliminaciones
     *
     * @param key
     * @param values
     * @throws java.sql.SQLException
     */
    public void ejecutar(String key, String[] values) throws SQLException {
        try (PreparedStatement query = MAPA.get(key)) {
            for (int i = 0; i < values.length; i++) {
                query.setString(i + 1, values[i]);
            }
            query.executeUpdate();
        }
    }

}
