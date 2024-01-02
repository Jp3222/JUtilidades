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
    protected boolean _activo;

    public SistemaPrincipal() {

    }

    abstract boolean conexionBD();

    abstract boolean archivosDS();

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

    public void setActivo(boolean _activo) {
        this._activo = _activo;
    }

    public boolean isActivo() {
        return _activo;
    }

}
