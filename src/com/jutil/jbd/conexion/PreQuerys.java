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

    private final Conexion CN;
    private final HashMap<String, PreparedStatement> MAPA;

    public PreQuerys(Conexion cn) {
        this.CN = cn;
        this.MAPA = new HashMap<>(10);
    }

    public void add(String name, String query) {
        try {
            PreparedStatement ps = CN.getConexion().prepareStatement(query);
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
     */
    public ResultSet ejecutarResultSet(String key, String... values) throws SQLException {
        PreparedStatement get = MAPA.get(key);
        for (int i = 0; i < values.length; i++) {
            get.setString(i, values[i]);
        }
        return get.executeQuery();

    }

    /**
     * Insercciones - Actualizaciones - Eliminaciones
     *
     * @param key
     * @param values
     */
    public void ejecutar(String key, String[] values) throws SQLException {
        try (PreparedStatement get = MAPA.get(key)) {
            for (int i = 0; i < values.length; i++) {
                get.setString(i, values[i]);
            }
            get.executeUpdate();
        }
    }

}
