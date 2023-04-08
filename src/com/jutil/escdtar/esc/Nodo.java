/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.escdtar.esc;

import com.jutil.escdtar.interfaces.Tarea;
import java.util.Objects;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jp
 */
class Nodo {

    private final String clave;
    private final Tarea tarea;
    private LocalDate fecha;
    private LocalTime hora;

    private final boolean temporal;

    public Nodo(String clave, Tarea tarea, LocalDate fecha, LocalTime hora, boolean temporal) {
        this.clave = clave;
        this.tarea = tarea;
        this.fecha = fecha;
        this.hora = hora;
        this.temporal = temporal;
    }

    public Nodo(String clave, Tarea tarea, LocalDate fecha, boolean temporal) {
        this.clave = clave;
        this.tarea = tarea;
        this.fecha = fecha;
        this.temporal = temporal;
    }

    public Nodo(String clave, Tarea tarea, boolean temporal) {
        this.clave = clave;
        this.tarea = tarea;
        this.temporal = temporal || clave.equalsIgnoreCase("temp");
    }

    public String getClave() {
        return clave;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void ejecutar() {
        LocalDate x = LocalDate.now();
        if (fecha == null || !x.isEqual(fecha)) {
            return;
        }
        LocalTime y = LocalTime.now();
        if (hora == null || y.isBefore(hora) || y.isAfter(hora)) {
            return;
        }
        tarea.Tarea();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.clave);
        hash = 53 * hash + Objects.hashCode(this.tarea);
        hash = 53 * hash + (this.temporal ? 1 : 0);
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
        final Nodo other = (Nodo) obj;
        if (this.temporal != other.temporal) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return Objects.equals(this.tarea, other.tarea);
    }

    private static final Logger LOG = Logger.getLogger(Nodo.class.getName());

    @Override
    public String toString() {
        return "Nodo{" + "clave=" + clave + ", temporal=" + temporal + '}';
    }

}
