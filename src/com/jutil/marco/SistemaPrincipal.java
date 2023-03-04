/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.marco;

import com.jutil.jbd.conexion.Conexion;

/**
 *
 * @author jp
 */
public abstract class SistemaPrincipal {

    protected boolean _reincio;
    protected Conexion _con;

    public SistemaPrincipal() {
    }

    abstract boolean conexion();

    abstract boolean archivos();

    abstract boolean cache();

    abstract boolean run();

    abstract void reinicio();

    abstract void finalizacion();

    public void setReincio(boolean _reincio) {
        this._reincio = _reincio;
    }

    public boolean isReincio() {
        return _reincio;
    }

}
