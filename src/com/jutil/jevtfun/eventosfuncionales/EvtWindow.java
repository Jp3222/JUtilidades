/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jevtfun.eventosfuncionales;

import com.jutil.jevtfun.funciones.FuncionWindow;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import javax.swing.WindowConstants;

/**
 *
 * @author jp
 */
public class EvtWindow implements WindowListener, WindowFocusListener, WindowStateListener, WindowConstants {

    public final int WINDOW_OPENED = 0,
            WINDOW_CLOSING = 1,
            WINDOW_CLOSED = 2,
            WINDOW_ICONIFIED = 3,
            WINDOW_DEICONIFIED = 4,
            WINDOW_ACTIVATED = 5,
            WINDOW_DEACTIVATED = 6,
            WINDOW_GAINEDFOCUS = 7,
            WINDOW_LOSTFOCUS = 8,
            WINDOW_STATE_CHANGED = 9;

    private final ArrayList<FuncionWindow> LISTA[];

    public EvtWindow() {
        this.LISTA = new ArrayList[10];
        for (int i = 0; i < LISTA.length; i++) {
            LISTA[i] = new ArrayList<>();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_OPENED]) {
            o.action(e);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_CLOSING]) {
            o.action(e);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_CLOSED]) {
            o.action(e);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_ICONIFIED]) {
            o.action(e);
        }
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_DEICONIFIED]) {
            o.action(e);
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_ACTIVATED]) {
            o.action(e);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_DEACTIVATED]) {
            o.action(e);
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_GAINEDFOCUS]) {
            o.action(e);
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_LOSTFOCUS]) {
            o.action(e);
        }
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        for (FuncionWindow o : LISTA[WINDOW_STATE_CHANGED]) {
            o.action(e);
        }
    }

    public void add(int tipo, FuncionWindow o) {
        LISTA[tipo].add(o);
    }

    public void remove(int tipo, int index) {
        LISTA[tipo].remove(index);
    }

    public void remove(int tipo, FuncionWindow o) {
        LISTA[tipo].remove(o);
    }
    
    public FuncionWindow get(int tipo, int index){
        return LISTA[tipo].get(index);
    }
}
