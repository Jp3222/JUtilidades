/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.jexception;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanp
 */
public class JExcpWritter {

    private File root;
    private boolean auto_writter;
    private FileWriter fw;
    private BufferedWriter bw;

    public JExcpWritter(File root) {
        this(root, true);
    }

    public JExcpWritter(File root, boolean auto_writter) {
        this.root = root;
        this.auto_writter = auto_writter;
    }

    public void addLine() {

    }

    public void writter(StringBuilder sb) {
    }
}
