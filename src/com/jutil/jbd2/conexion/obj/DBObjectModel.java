/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.conexion.obj;

/**
 *
 * @author juan-campos
 */
public interface DBObjectModel {

    String getId();
    
    String[] getValues();
    
    boolean isEmpty();
}