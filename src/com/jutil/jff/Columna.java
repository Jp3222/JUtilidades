/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jff;

import java.util.Objects;

/**
 *
 * @author jp
 */
public class Columna {

    private final String nombre;
    private final String tipo;
    private int rango;

    public Columna(String nombre, String tipo, int rango) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.rango = rango;
    }

    public Columna(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.rango = -1;
    }

    public Columna(String nombre) {
        this.nombre = nombre;
        this.tipo = "str";
        this.rango = -1;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Columna other = (Columna) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[(nombre=").append(nombre).append("),");
        sb.append("(tipo=").append(tipo).append(")]");
        return sb.toString();
    }

}
