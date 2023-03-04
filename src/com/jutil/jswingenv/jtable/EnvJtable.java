/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswingenv.jtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public class EnvJtable extends JPanel {

    private JLabel mensaje;
    private JTextField buscado;
    private JTable tabla;

    public EnvJtable(JTextField buscado, JTable tabla) {
        this.mensaje = new JLabel("Buscar");
        mensaje.setPreferredSize(new Dimension(100, 35));
        this.buscado = buscado;
        this.buscado.setPreferredSize(new Dimension(mensaje.getPreferredSize()));
        this.tabla = tabla;
        tabla.setPreferredSize(new Dimension(500, 200));
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
        p.add(mensaje);
        p.add(buscado);
        this.add(p, BorderLayout.NORTH);
        this.add(this.tabla, BorderLayout.SOUTH);

    }

}
