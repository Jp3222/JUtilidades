/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jff;

import com.jutil.jff.interfaces.Doc;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author jp
 */
public abstract class Documento implements Doc {

    private String[] columnas;
    private final LinkedList<String> datos;
    private final File root;

    public Documento(File root, String... col) {
        this.datos = new LinkedList<>();
        this.columnas = col;
        this.root = root;
    }

    
    void _crearDoc() throws IOException {
        if (root.exists()) {
            return;
        }
        root.createNewFile();
    }

}
