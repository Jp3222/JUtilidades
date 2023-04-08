/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.escdtar.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jp
 */
public interface ColeccionDeTareasFechadas {
    
    void registrar(String clave, Tarea tarea, LocalDate fecha);

    void registrar(String clave, Tarea tarea, LocalTime hora);

    void registrar(String clave, Tarea tarea, LocalDate fecha, LocalTime hora);

    void remover(String clave);

    void get(String clave);

    void get(LocalDate fecha);

    void get(LocalTime hora);

    void getRango(LocalDate inicio, LocalDate fin);

    void getRango(LocalTime inicio, LocalTime fin);

}
