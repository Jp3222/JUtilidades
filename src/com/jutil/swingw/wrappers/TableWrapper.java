/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.wrappers;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public class TableWrapper extends JPanel {

    private JTextField buscador;
    private JLabel mensaje;
    private final JTable comp;
    public TableWrapper(JTable tabla) {
        this.comp = tabla;
    }

}
