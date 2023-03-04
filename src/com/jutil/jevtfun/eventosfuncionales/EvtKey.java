/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jevtfun.eventosfuncionales;

import com.jutil.jevtfun.funciones.FuncionesKey;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class EvtKey implements KeyListener {

    public final int KEY_TYPED = 0,
            KEY_PRESSED = 1,
            KEY_RELEASED = 2;
    private final ArrayList<FuncionesKey> LISTA[];

    public EvtKey() {
        LISTA = new ArrayList[3];
        for (int i = 0; i < LISTA.length; i++) {
            LISTA[i] = new ArrayList<>();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (FuncionesKey funcionesKey : LISTA[KEY_TYPED]) {
            funcionesKey.action(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (FuncionesKey funcionesKey : LISTA[KEY_PRESSED]) {
            funcionesKey.action(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (FuncionesKey funcionesKey : LISTA[KEY_RELEASED]) {
            funcionesKey.action(e);
        }
    }

    public void add(int tipo, FuncionesKey o) {
        LISTA[tipo].add(o);
    }

    public void remove(int tipo, FuncionesKey o) {
        LISTA[tipo].remove(o);
    }

    public void remove(int tipo, int index) {
        LISTA[tipo].remove(index);
    }
    
    public FuncionesKey get(int tipo, int index) {
        return LISTA[tipo].get(index);
    }
    
}
