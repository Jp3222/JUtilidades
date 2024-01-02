/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.configprog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Propiedades {

    private final String format = "%s=%s\n";
    private final File file_config;
    private final Map<String, String> mapa;
    private boolean auto_wr, auto_rd;

    public Propiedades(File file_config) throws IOException {
        this.file_config = file_config;
        this.mapa = new HashMap<>(20);
        init();

    }

    private void init() throws IOException {
        if (!file_config.exists()) {
            file_config.createNewFile();
        }
    }

    public void put(String key, String value) {
        mapa.put(key, value);
        if (auto_wr) {
            try {
                writer();
            } catch (IOException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void remove(String key) {
        mapa.remove(key);
    }

    public String get(String key) {
        return mapa.get(key);
    }

    public boolean isEmpty() {
        return mapa.isEmpty();
    }

    public List<String> getValues() {
        if (isEmpty()) {
            return new ArrayList<>();
        }
        return List.copyOf(mapa.values());
    }

    public void writer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file_config));
        try (bw) {
            StringBuilder sb = new StringBuilder(200);
            mapa.forEach((key, value) -> {
                sb.append(String.format(format, key, value));
            });
            System.out.println(sb.toString());
            bw.write(sb.toString());
            bw.flush();
        }
    }

    public void writerLine(String key, String value) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file_config));
        try (bw) {
            bw.append(String.format(format, key, value));
            bw.flush();
        }
    }

    public void read() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_config));
        try (br) {
            String aux;
            String arr[];
            while ((aux = br.readLine()) != null) {
                System.out.println(aux);
                arr = aux.split("=");
                
                mapa.put(
                        arr[0].trim(),
                        arr[1].trim()
                );
            }

        }

    }

    public void setAuto_rd(boolean auto_rd) {
        this.auto_rd = auto_rd;
    }

    public void setAuto_wr(boolean auto_wr) {
        this.auto_wr = auto_wr;
    }

    public boolean isAuto_rd() {
        return auto_rd;
    }

    public boolean isAuto_wr() {
        return auto_wr;
    }

}
