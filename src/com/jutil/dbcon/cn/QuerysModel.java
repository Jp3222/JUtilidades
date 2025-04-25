/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.dbcon.cn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan-campos
 */
public interface QuerysModel extends SimpleQuerys {

    /**
     * Este metodo se encarga de insertar 1 registro en la base de datos con el
     * siguiente formato de la variable estatica
     *
     * @param table - tabla de la base de datos a la cual se le aplicara la
     * inserccion de datos
     * @param fields - campos a los que se les aplicara la inserccion de datos
     * @param values - valores que se registraran en la base de datos
     * @return true si las columnas afectadas son mayores a 0; false si son
     * iguales a 0
     * @throws SQLException
     */
    boolean insert(String table, String fields, String values) throws SQLException;

    boolean update(String table, String olValue, String newValue, String where) throws SQLException;

    ResultSet select(String table, String fields, String where) throws SQLException;

    boolean delete(String table, String where) throws SQLException;

    ResultSet query(String query) throws SQLException;

    public int execute(String query) throws SQLException;
}
