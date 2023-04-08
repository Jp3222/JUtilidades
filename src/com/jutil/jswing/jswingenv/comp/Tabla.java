/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.jswingenv.comp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class Tabla extends Componente {

    private JLabel mensaje_buscador;
    private JTextField buscador;
    private JTable tabla;
    private BorderLayout layout;

    private ArrayList<String[]> informacion;

    public Tabla() {
        this.tabla = new JTable();
        tabla.setPreferredSize(new Dimension(300, 300));
        tabla.setModel(new DefaultTableModel(100, 10));
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabla);
        scroll.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL));
        //
        this.layout = new BorderLayout();
        this.setLayout(layout);
        this.add(scroll, BorderLayout.CENTER);
    }

    public void crearBarraSuperior(String label) {
        buscador = new JTextField();
        mensaje_buscador = new JLabel(label);
        BorderLayout ly = new BorderLayout(5, 5);
        JPanel o = new JPanel(ly);
        o.add(mensaje_buscador, BorderLayout.WEST);
        o.add(buscador, BorderLayout.CENTER);
        this.add(o, BorderLayout.NORTH);
    }

    public void setInformacion(ArrayList<String[]> informacion) {
        this.informacion = informacion;
    }

    public void buscardor(String txt) {

    }

}
