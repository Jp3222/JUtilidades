/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import java.util.Arrays;
import jsoftware.com.jutil.model.AbstractMapDTO;

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

    public String[] buildRow(AbstractMapDTO dto) {
        String arr[] = new String[graphics_fields.length];
        int i = 0;
        for (String j : graphics_fields) {
            arr[i] = dto.get(j).toString();
            i++;
        }
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(fields).replace("[", ")").replace("]", ")");
    }

}
