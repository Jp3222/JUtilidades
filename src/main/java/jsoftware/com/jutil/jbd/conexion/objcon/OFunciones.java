/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.jbd.conexion.objcon;

import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class OFunciones {

    /**
     *
     * @param coleccion
     * @return
     */
    public static String crearConjunto(ArrayList<String[]> coleccion) {
        String col = "";
        for (int i = 0; i < coleccion.size() - 1; i++) {
            String[] it = coleccion.get(i);
            String conjunto = "(";
            for (int j = 0; j < it.length - 1; j++) {
                conjunto += "'" + it[i] + "',";
            }
            conjunto += "'" + it[it.length - 1] + "')";
            col += conjunto + ",";
        }
        col += coleccion.get(coleccion.size() - 1);
        return col;
    }

}
