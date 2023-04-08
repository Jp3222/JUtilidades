/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jp
 */
public interface MetodosBasicos {

    /**
     * Este metodo hara una inseccion en la base de datos con los campos y
     * valores especificados
     *
     * @param tabla - tabla de la base de datos a la cual se le hara la
     * inserccion
     * @param campos - campos a los cuales se les hara la insercion
     * @param valores - valores a insertar
     * @return true si la inserccion se hizo correctamente
     * @throws SQLException
     */
    boolean insert(String tabla, String campos, String valores) throws SQLException;

    /**
     * Este metodo hara una actualizacion en la base de datos a los campos
     * especificados con los valores dados.
     * <br><br>
     * Nota: en el parametro cv se especifica el campo con el nuevo valor como
     * normalmente lo haria en la sintaxis sql
     * <br> campos = 'nuevo valor' o campo = numero
     * <br><br>
     * Nota la condificion especificada se escribe usando la sintaxis sql, sin
     * usar la palabra 'where'
     * <br> ejemplo: "id = 0" o "codigo = '11345'"
     *
     * @param tabla - tabla de la base de datos en la cual se hara la
     * actualizacion
     * @param cv campos y valores nuevos
     * @param where - especificacion de donde se hara la actualizacion
     * @return true si la actualizacion se hizo correctamente
     * @throws SQLException
     */
    boolean update(String tabla, String cv, String where) throws SQLException;

    /**
     * Este metodo hara una eliminacion de la base de datos usando una condicion
     * especificada
     * <br><br>
     * Nota la condificion especificada se escribe usando la sintaxis sql, sin
     * usar la palabra 'where'
     * <br> ejemplo: "id = 0" o "codigo = '11345'"
     *
     * @param tabla - tabla de la base de datos en la cual se hara la
     * actualizacion
     * @param where - especificacion de donde se hara la actualizacion
     * @return true si la eliminacion se hizo correctamente
     * @throws SQLException
     */
    boolean delete(String tabla, String where) throws SQLException;
    
    /**
     * Este metodo
     * @param query
     * @return
     * @throws SQLException 
     */
    boolean instruccion(String query) throws SQLException;

    ResultSet select(String tabla, String campos, String where) throws SQLException;

    ResultSet queryResult(String query) throws SQLException;

}
