/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.escdtar.interfaces;

/**
 *
 * @author jp
 */
public interface ColeccionDeTareas {

    void agregar(Tarea tarea);

    void registrar(String clave, Tarea tarea);

    void removerInicio();

    Tarea get(String clave);
    
}
