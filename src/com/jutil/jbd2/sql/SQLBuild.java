/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.sql;

/**
 *
 * @author juan-campos
 */
public interface SQLBuild {

    public String insert(String table);

    public String insert(String table, String data);

    public String insert(String table, String colums, String data);

    public String update(String table, String colums[], String data[]);

    public String update(String table, String colums, String data);

    public String update(String table, String key_value_col);

    public String delete(String table, String where);

    public String deleteFull(String table);

    public String select(String table);

    public String select(String table, String where);

    public String select(String table, String colums, String where);
}
