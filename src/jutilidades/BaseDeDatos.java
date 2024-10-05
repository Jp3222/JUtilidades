/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jutilidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan-campos
 */
public class BaseDeDatos {

    public static BaseDeDatos instance;

    public static synchronized BaseDeDatos getInstance(String nombre) {
        if (instance == null) {
            instance = new BaseDeDatos(nombre);
        }
        return instance;
    }

    private BaseDeDatos(String nombre) {
        db = new ArrayList<>(100);
    }

    public void add(Objetos o) {
        db.add(o);
    }

    private List<Objetos> db;

}
