/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion.objcon;

/**
 * Esta clase permite crear una instancia de su super clase Objeto, la cual es
 * una clase abstracta.
 * <br>
 * esta clase nos sirve para preparar metodos genericos, contenedor de objetos
 * hijos o iterador para ir clonando clases hijos
 *
 * @author jp
 */
public class ObjetoCont extends ObjetoPadreCon {

    public ObjetoCont(String... elementos) {
        super(elementos);
    }

    public ObjetoCont() {
    }

}
