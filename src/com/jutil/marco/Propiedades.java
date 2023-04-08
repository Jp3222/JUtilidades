/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.marco;

/**
 *
 * @author jp
 */
public abstract class Propiedades {

    protected final String _NOMBRE_DEL_PROGRAMA;
    protected final String _VERSION;
    protected final String _APARTADOS[];
    protected int _apartado;

    protected Propiedades(String _NOMBRE_DEL_PROGRAMA, String _VERSION, String... _APARTADOS) {
        this._NOMBRE_DEL_PROGRAMA = _NOMBRE_DEL_PROGRAMA;
        this._VERSION = _VERSION;
        this._APARTADOS = _APARTADOS;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Programa");
        s.append("\nNombre del programa=").append(_NOMBRE_DEL_PROGRAMA);
        s.append("\nVersion=").append(_VERSION);
        s.append("\nApartados{");
        for (String string : _APARTADOS) {
            s.append("\n ").append(string).append(",");
        }
        s.append("\n}");
        return s.toString();
    }

}
