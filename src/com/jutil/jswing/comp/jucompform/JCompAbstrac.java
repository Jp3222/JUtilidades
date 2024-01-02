/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.comp.jucompform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jp
 * @param <T>
 */
public class JCompAbstrac<T extends JComponent> extends JPanel implements Cloneable {

    private final BorderLayout ly;
    private final T componente;
    private final String campo;
    private JLabel lb;
    private JCheckBox ch;

    public JCompAbstrac(String campo) {
        this.ly = new BorderLayout();
        setLayout(ly);
        this.componente = (T) new JTextField();
        this.campo = campo;
        componente.setPreferredSize(new Dimension(300, 50));
        setPreferredSize(new Dimension(300, 50));
    }

    public JLabel addInCompLabel() {
        lb = new JLabel(campo);
        lb.setPreferredSize(new Dimension(WIDTH, 20));
        add(lb, BorderLayout.NORTH);
        return lb;
    }

    public JCheckBox addInCompCheckBox(String text) {
        ch = new JCheckBox(text);
        add(ch, BorderLayout.EAST);
        return ch;
    }

    public void construir() {
        add(componente, BorderLayout.CENTER);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public JCompAbstrac<T> copy(){
        try {
            return (JCompAbstrac<T>) clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(JCompAbstrac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}
