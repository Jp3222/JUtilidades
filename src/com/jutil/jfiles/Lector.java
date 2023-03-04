/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jfiles;

import com.jutil.jexception.Excp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Lector {

    private final File file;
    private FileReader fr;
    private BufferedReader br = new BufferedReader(fr);
    private boolean autoCerrar;

    public Lector(File file, boolean autoCerrar) throws FileNotFoundException {
        this.file = file;
        this.autoCerrar = autoCerrar;
        this.abrir();
    }

    public String readAll() throws FileNotFoundException, IOException {
        String it = null;
        do {
            it += br.readLine();
        } while (it != null);
        if (autoCerrar) {
            cerrar();
        }
        return it;
    }

    public ArrayList<String> leerLineasEnLista() throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        String it;
        do {
            it = br.readLine();
            lineas.add(it);
        } while (it != null);
        if (autoCerrar) {
            cerrar();
        }
        return lineas;
    }

    public String[] leer() throws IOException {
        ArrayList<String> lineas = leerLineasEnLista();
        String[] arr = new String[lineas.size()];
        arr = lineas.toArray(arr);
        lineas.clear();
        return arr;
    }

    public void setAutoCerrar(boolean autoCerrar) {
        this.autoCerrar = autoCerrar;
    }

    public BufferedReader getBr() {
        return br;
    }

    public File getFile() {
        return file;
    }

    public FileReader getFr() {
        return fr;
    }

    public final void abrir() throws FileNotFoundException {
        this.fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    public final void cerrar() {
        try {
            br.close();
            fr.close();
        } catch (IOException ex) {
            Excp.impTerminal(ex, this.getClass(), true);
        }

    }

}
