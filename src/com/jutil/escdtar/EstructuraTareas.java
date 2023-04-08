/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.escdtar;

import com.jutil.escdtar.interfaces.ColeccionDeTareas;

/**
 *
 * @author jp
 */
public abstract class EstructuraTareas implements ColeccionDeTareas, Runnable {

    protected int _retardo;
    protected Thread _hilo;
    protected boolean _corriendo, _parar, _pausado;

    void cicloGeneral() {
    }

    void cicloxHora() {
    }

    void cicloxDia() {
    }

    public void correr() {
        this._corriendo = true;
        this._hilo.start();
    }

    public void parar() {
        this._parar = true;
    }

    public void pausar() {
        this._pausado = true;
    }

}
