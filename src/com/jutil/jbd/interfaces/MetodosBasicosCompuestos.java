/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.interfaces;

import java.sql.ResultSet;

/**
 *
 * @author jp
 */
public interface MetodosBasicosCompuestos {

    boolean insert(String tabla, String datos);

    boolean update(String tabla, String campo, String valor, String where);

    boolean update(String tabla, String campos[], String valors[], String where);

    ResultSet select(String tabla);

    ResultSet select(String tabla, String campos);

}
