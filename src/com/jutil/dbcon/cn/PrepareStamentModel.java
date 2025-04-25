/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.cn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan-campos
 */
public interface PrepareStamentModel extends SimpleQuerys {

    /**
     * Este metodo se encarga de insertar 1 registro en la base de datos con el
     * siguiente formato de la variable estatica usando PrepareStament
     *
     * @param table - tabla de la base de datos a la cual se le aplicara la
     * inserccion de datos
     * @param fields - campos a los que se les aplicara la inserccion de datos
     * @param values - valores que se registraran en la base de datos
     * @return true si las columnas afectadas son mayores a 0; false si son
     * iguales a 0
     * @throws SQLException
     */
    boolean psInsert(String table, String fields, String values) throws SQLException;

    /**
     * Este metodo se encarga de actualizar 1 registro en la base de datos con
     * el siguiente formato de la variable estatica usando PrepareStament
     *
     * @param table - tabla de la base de datos a la cual se le aplicara la
     * inserccion de datos
     * @param olValue
     * @param newValue
     * @param where
     * @return true si las columnas afectadas son mayores a 0; false si son
     * iguales a 0
     * @throws SQLException
     */
    boolean psUpdate(String table, String olValue, String newValue, String where) throws SQLException;

    /**
     * Este metodo se encarga de seleccionar registros de la base de datos con
     * el siguiente formato de la variable estatica usando PrepareStament
     *
     * @param table - tabla de la base de datos a la cual se le aplicara la
     * inserccion de datos
     * @param fields - campos a los que se les aplicara la inserccion de datos
     * @param where
     * @return
     * @throws SQLException
     */
    ResultSet psSelect(String table, String fields, String where) throws SQLException;

    /**
     * Este metodo se encarga de eliminar registros en la base de datos con el
     * siguiente formato de la variable estatica usando PrepareStament
     *
     * @param table - tabla de la base de datos a la cual se le aplicara la
     * inserccion de datos
     * @param where
     * @return true si las columnas afectadas son mayores a 0; false si son
     * iguales a 0
     * @throws SQLException
     */
    boolean psDelete(String table, String where) throws SQLException;

    /**
     * Este metodo ejecuta el query pasado por parametros
     *
     * @param query
     * @return
     * @throws SQLException
     */
    ResultSet psQuery(String query) throws SQLException;

    /**
     * Este metodo ejecuta el query pasado por parametros
     *
     * @param query
     * @return
     * @throws SQLException
     */
    int psExecute(String query) throws SQLException;
}
