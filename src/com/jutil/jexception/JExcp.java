/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jexception;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author juanp
 */
public class JExcp {

    private static JExcp instance;

    public static synchronized JExcp getInstance(boolean autoExit, boolean print) {
        if (instance == null) {
            instance = new JExcp();
        }
        return instance;
    }
    private boolean autoExit;
    private boolean stack;

    private JExcp(boolean autoExit, boolean stack) {
        this.autoExit = autoExit;
        this.stack = stack;
    }

    public JExcp() {
        this(false, true);
    }

    public void print(Exception e, Class c) {
        String error_in = "ERROR EN LA CLASE: %s".formatted(c.getName());
        System.out.println(error_in);
        if (stack) {
            try (PrintWriter pw = new PrintWriter(System.out)) {
                e.printStackTrace(pw);
            }
        }
    }

    public void print(Exception e, Class c, String name_method) {
        String error_in = "ERROR EN LA CLASE: %s\n Metodo: %s".formatted(c.getName(), name_method);
        System.out.println(error_in);
        if (stack) {
            try (PrintWriter pw = new PrintWriter(System.out)) {
                e.printStackTrace(pw);
            }
        }
        if (autoExit) {
            SysExit();
        }
    }

    public void show(Exception e, Class c) {
        JOptionPane.showMessageDialog(null, e.getMessage(), c.getClass().getName(), JOptionPane.ERROR_MESSAGE);
    }

    public void printAndShow(Exception e, Class c) {
        show(e, c);
        print(e, c);
    }

    public void SysExit() {
        System.exit(1);
    }
}
