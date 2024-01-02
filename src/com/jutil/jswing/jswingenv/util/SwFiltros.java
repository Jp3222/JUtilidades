/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.jswingenv.util;

import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public abstract class SwFiltros {

    private SwFiltros() {
    }

    public boolean txtValido(JTextField o) {
        return !txtNull(o) && !txtBlanco(o);
    }

    public boolean txtVacios(JTextField o) {
        
        return o.getText().isEmpty();
    }

    public boolean txtNull(JTextField o) {
        return o == null || o.getText() == null;
    }

    public boolean txtBlanco(JTextField o) {
        return o.getText().isBlank();
    }
    
    
}
