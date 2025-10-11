/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.jbd.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author jp
 */
public class ConexionPQ extends Conexion {
    
    private final Connection conexion;
    private final HashMap<String, PreparedStatement> mapa;

    public ConexionPQ(String url) throws SQLException {
        super(url);
        conexion = cn;
        mapa = new HashMap<>();
    }

    public ConexionPQ(Properties propiedades, String url) throws SQLException {
        super(propiedades, url);
        conexion = cn;
        mapa = new HashMap<>();
    }

    public ConexionPQ(String usuario, String contra, String url) throws SQLException {
        super(usuario, contra, url);
        conexion = cn;
        mapa = new HashMap<>();
    }

    public void add(String nombre, String query) {
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            mapa.put(nombre, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param nombre
     */
    public void remove(String nombre) {
        try {
            PreparedStatement ps = mapa.remove(nombre);
            if (!ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param nombre
     * @param valores
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet ejecutarRS(String nombre, String... valores) throws SQLException {
        PreparedStatement query = mapa.get(nombre);
        for (int i = 0; i < valores.length; i++) {
            query.setString(i + 1, valores[i]);
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
    public void ejecutar(String key, String... values) throws SQLException {
        try (PreparedStatement query = mapa.get(key)) {
            for (int i = 0; i < values.length; i++) {
                query.setString(i + 1, values[i]);
            }
            query.executeUpdate();
        }
    }

}
