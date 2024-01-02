/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jfiles;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author jp
 */
public class Archivo {

    private File archivo;
    private String ruta, nombre, terminacion;
    private final Escritor es;
    private final Lector lc;

    public Archivo(File archivo) throws IOException {
        this.archivo = archivo;

        es = new Escritor(archivo);
        lc = new Lector(archivo);
    }

    public Archivo(String ruta, String nombre, String terminacion) {
        this.ruta = ruta;
        this.nombre = nombre;
        this.terminacion = terminacion;
        this.es = null;
        this.lc = null;
    }

    public Archivo() {
        this.es = null;
        this.lc = null;
    }

    public void crear() throws IOException {
        archivo = new File(ruta + nombre + terminacion);
        if (archivo.exists()) {
            return;
        }
        archivo.createNewFile();
    }

}
