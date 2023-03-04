/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author jp
 */
public class Tabla {

    private String nombre;
    private String[] campos;
    private Conexion conexion;
    public Tabla(Conexion conexion) throws SQLException {
        this.conexion = conexion;
        DatabaseMetaData metaData = conexion.getConexion().getMetaData();
        metaData.getTables(nombre, nombre, nombre, campos);
    }
    
    
}
