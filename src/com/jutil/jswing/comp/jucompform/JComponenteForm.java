/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.comp.jucompform;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jp
 */
public class JComponenteForm extends JPanel {

    private final BorderLayout ly;
    private JLabel lb;

    public JComponenteForm(JCompAbstrac... comp) {
        ly = new BorderLayout();
    }

}
