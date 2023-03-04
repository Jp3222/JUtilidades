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
public interface MetodosBasicos {

    boolean insert(String tabla, String campos, String datos);

    boolean update(String tabla, String campos, String datos);

    boolean delete(String tabla, String where);

    boolean query(String query);
    
    ResultSet select(String tabla, String campos, String where);
    
    ResultSet queryResult(String query);
    
}
