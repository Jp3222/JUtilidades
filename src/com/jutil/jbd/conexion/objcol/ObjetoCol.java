/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion.objcol;

import java.util.HashMap;
import java.util.Map;

/**
 * Objetos basado en colecciones
 *
 * @author jp
 */
public class ObjetoCol {

    private HashMap<String, String> coleccion;

    public ObjetoCol(HashMap<String, String> coleccion) {
        this.coleccion = coleccion;
    }

    public ObjetoCol() {
        this.coleccion = null;
    }

    public void addValor(String clave, String valor) {
        coleccion.put(clave, valor);
    }

    public String getValor(String clave) {
        return coleccion.get(clave);
    }

    public String[] getClavesValores() {
        String claves = "";
        String valores = "";
        for (Map.Entry<String, String> entry : coleccion.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            claves += key + ",";
            valores += val + ",";
        }
        claves = claves.substring(0, claves.length() - 1);
        valores = valores.substring(0, valores.length() - 1);
        return new String[]{claves, valores};
    }

    public HashMap<String, String> getColeccion() {
        return coleccion;
    }

    public void setColeccion(HashMap<String, String> coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjetoCol{");
        sb.append("coleccion=").append(coleccion);
        sb.append('}');
        return sb.toString();
    }

}
