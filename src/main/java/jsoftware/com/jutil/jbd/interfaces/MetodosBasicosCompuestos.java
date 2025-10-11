/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.jbd.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jp
 */
public interface MetodosBasicosCompuestos {

    boolean insert(String tabla, String datos) throws SQLException;

    boolean update(String tabla, String campo, String valor, String where) throws SQLException;

    boolean update(String tabla, String campos[], String valors[], String where) throws SQLException;

    ResultSet select(String tabla) throws SQLException;

    ResultSet select(String tabla, String campos) throws SQLException;

}
