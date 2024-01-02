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

    private FileReader fr;
    private BufferedReader br;
    private boolean autoCerrar;

    public Lector(File file) throws FileNotFoundException {
        fr = new FileReader(file);
        br = new BufferedReader(fr);

    }

    public String getTexto() throws IOException {
        String aux;
        StringBuilder s = new StringBuilder();
        do {
            aux = br.readLine();
            if (aux == null) {
                break;
            }
            s.append(aux);
        } while (true);
        return s.toString();
    }

    public ArrayList<String> getLineas() throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        do {
            String aux = br.readLine();
            if (aux == null) {
                break;
            }
            lista.add(aux);
        } while (true);
        return lista;
    }

    public String getSubString(int inicio, int fin) throws IOException {
        return getTexto().substring(inicio, fin);
    }

}
