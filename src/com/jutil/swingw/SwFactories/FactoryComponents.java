/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.SwFactories;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author juan-campos
 */
public class FactoryComponents {

    private static FactoryComponents instance;

    public static synchronized FactoryComponents get() {
        if (instance == null) {
            instance = new FactoryComponents();
        }
        return instance;
    }

    private FactoryComponents() {

    }

    public JButton getButton(String txt) {
        JButton obj = new JButton(txt);
        return obj;
    }

    public JRadioButton getRadioButton(String txt) {
        JRadioButton o = new JRadioButton(txt);
        return o;
    }

    public JLabel getLabel(String txt) {
        JLabel obj = new JLabel(txt);
        return obj;
    }

    public JTextField getTextField() {
        JTextField o = new JTextField();
        return o;
    }

    public JPasswordField getPassword() {
        JPasswordField o = new JPasswordField();
        return o;
    }

    public JTextArea getTextArea() {
        JTextArea o = new JTextArea();
        return o;
    }

    public JTextPane getTextPane() {
        JTextPane o = new JTextPane();
        return o;
    }

    public <T> JComboBox<T> getComboBox() {
        JComboBox<T> o = new JComboBox();
        return o;
    }

    public <T> JList<T> getList() {
        JList<T> o = new JList<>();
        return o;
    }

}
