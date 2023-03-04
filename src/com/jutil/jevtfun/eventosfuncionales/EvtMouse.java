/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jevtfun.eventosfuncionales;

import com.jutil.jevtfun.funciones.FuncionMouse;
import com.jutil.jevtfun.funciones.FuncionMouse2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author jp
 */
public class EvtMouse implements MouseInputListener, MouseListener, MouseMotionListener, MouseWheelListener {

    public final int 
            MOUSE_CLICKED = 0,
            MOUSE_PRESSED = 1,
            MOUSE_RELEASED = 2,
            MOUSE_ENTERED = 3,
            MOUSE_EXITED = 4,
            MOUSE_DRAGGED = 5,
            MOUSE_MOVED = 6;

    private final ArrayList<FuncionMouse>[] LISTA_ME;
    private final ArrayList<FuncionMouse2> LISTA_MWE;

    public EvtMouse() {
        this.LISTA_ME = new ArrayList[7];
        this.LISTA_MWE = new ArrayList<>();
        for (int i = 0; i < this.LISTA_ME.length; i++) {
            LISTA_ME[i] = new ArrayList<>(5);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_CLICKED]) {
            funcionMouse.action(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_PRESSED]) {
            funcionMouse.action(e);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_RELEASED]) {
            funcionMouse.action(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_ENTERED]) {
            funcionMouse.action(e);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_EXITED]) {
            funcionMouse.action(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_DRAGGED]) {
            funcionMouse.action(e);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (FuncionMouse funcionMouse : LISTA_ME[MOUSE_MOVED]) {
            funcionMouse.action(e);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        for (FuncionMouse2 funcionMouse2 : LISTA_MWE) {
            funcionMouse2.action(e);
        }
    }

    public void addME(int tipo, FuncionMouse o) {
        LISTA_ME[tipo].add(o);
    }

    public void removeME(int tipo, FuncionMouse o) {
        LISTA_ME[tipo].remove(o);
    }

    public void removeME(int tipo, int index) {
        LISTA_ME[tipo].remove(index);
    }

    public FuncionMouse getME(int tipo, int index) {
        return LISTA_ME[tipo].get(index);
    }

    public void addMWE(int tipo, FuncionMouse2 o) {
        LISTA_MWE.add(o);
    }

    public void removeMWE(int tipo, FuncionMouse2 o) {
        LISTA_MWE.remove(o);
    }

    public void removeMWE(int tipo, int index) {
        LISTA_MWE.remove(index);
    }

    public FuncionMouse2 getMWE(int tipo, int index) {
        return LISTA_MWE.get(index);
    }

}
