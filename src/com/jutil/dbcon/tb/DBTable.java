/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.tb;

import java.util.Arrays;

/**
 *
 * @author juan-campos
 */
public class DBTable {

    private final String table;
    private final String[] fields;
    private String[] graphics_fields;

    public DBTable(String table, String[] fields, String[] graphics_field, int real_count_fields) {
        this.table = table;
        this.fields = fields;
        this.graphics_fields = graphics_field;
    }

    public DBTable(String table, String... fields) {
        this(table, fields, fields, fields.length);
    }

    public String getTable() {
        return table;
    }

    public String[] getFields() {
        return fields;
    }

    public void setGraphicsField(String... graphics_field) {
        this.graphics_fields = graphics_field;
    }

    public String[] getGraphicsField() {
        return graphics_fields;
    }

    @Override
    public String toString() {
        return Arrays.toString(fields).replace("[", ")").replace("]", ")");
    }
    
    
}
