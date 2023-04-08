/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.jswingenv;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public class EnvJtable extends JPanel {

    private JTextField buscador;
    private JLabel mensaje;
    private final JTable comp;
    public EnvJtable(JTable tabla) {
        this.comp = tabla;
    }

}
