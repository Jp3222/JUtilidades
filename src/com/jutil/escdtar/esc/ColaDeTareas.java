/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.escdtar.esc;

import com.jutil.escdtar.EstructuraTareas;
import com.jutil.escdtar.interfaces.Tarea;
import com.jutil.jexception.Excp;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author jp
 */
public class ColaDeTareas extends EstructuraTareas {

    private final Queue<Nodo> cola;

    public ColaDeTareas() {
        this.cola = new LinkedList<>();
    }

    @Override
    public void agregar(Tarea tarea) {
        Nodo o = new Nodo("temp", tarea, true);
        cola.add(o);
    }

    @Override
    public void registrar(String clave, Tarea tarea) {
        Nodo o = new Nodo(clave, tarea, false);
        cola.add(o);
    }

    @Override
    public void removerInicio() {
        cola.poll();
    }

    
    @Override
    public Tarea get(String clave) {
        for (Nodo nodo : cola) {
            if (nodo.getClave().equalsIgnoreCase(clave)) {
                return nodo.getTarea();
            }
        }
        return null;
    }

    @Override
    public void run() {
        try {
            do {
                if (_pausado) {
                    Nodo peek = cola.peek();
                    if (peek.isTemporal()) {
                        Nodo poll = cola.poll();
                        poll.ejecutar();
                    } else {
                        peek.ejecutar();
                    }
                }
                dormir();
            } while (!_parar);
        } catch (InterruptedException e) {
            Excp.impTerminal(e, getClass(), true);
        } finally {
            _corriendo = false;
        }
    }

    void dormir() throws InterruptedException {
        Thread.sleep(1000);
    }

}
