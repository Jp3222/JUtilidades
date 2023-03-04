/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.interfaces;

/**
 *
 * @author jp
 */
public interface SQLMetodosBasicos {

    String sentencia(String sentencia);

    String insert(String tabla, String campos, String datos);

    String update(String tabla, String kv, String where);

    String delete(String tabla, String where);

    String select(String tabla, String campos, String where);

    String query(String query);

}
