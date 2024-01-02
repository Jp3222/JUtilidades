/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author jp
 */
public class Escritor {

    private FileWriter fw;
    private BufferedWriter bw;

    public Escritor(File file) throws IOException {
        fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
    }

    public void escribir(String txt) throws IOException {
        bw.write(txt, 0, txt.length());
    }

    public Writer escribirAppend(String txt) throws IOException {
        return bw.append(txt);
    }
}
