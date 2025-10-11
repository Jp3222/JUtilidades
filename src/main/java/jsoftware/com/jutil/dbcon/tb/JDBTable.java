/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.dbcon.tb;

import java.util.Arrays;

/**
 *
 * @author juan-campos
 */
public class JDBTable {

    private final String table_name;
    private final String[] fields;
    private String[] graphics_fields;

    public JDBTable(String table, String[] fields, String[] graphics_field) {
        this.table_name = table;
        this.fields = fields;
        this.graphics_fields = graphics_field;
    }

    public JDBTable(String table, String... fields) {
        this(table, fields, fields);
    }

    public String getTableName() {
        return table_name;
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
