/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.comp;

import com.jutil.jswing.comp.jucompform.JCompAbstrac;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jp
 */
public class JFormumlario extends JPanel {

    private GridLayout ly;
    private int rows;
    private int cols;

    public JFormumlario(int rows, JCompAbstrac... componentes) {
        this.rows = rows;
        this.cols = 1;
        ly = new GridLayout(rows, cols);
        setLayout(ly);
        for (JCompAbstrac i : componentes) {
            add(i);
        }
    }

}
