/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion.obj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author juan-campos
 */
public class DBSuperTable {

    private final String table_name;
    private final List<String> columns;

    public DBSuperTable(String table_name) {
        this.table_name = table_name;
        this.columns = new ArrayList();
    }

    public DBSuperTable(String table_name, ArrayList<String> columns) {
        this.table_name = table_name;
        this.columns = columns;
    }

    public DBSuperTable(String table_name, String... columns) {
        this.table_name = table_name;
        this.columns = new ArrayList(Arrays.asList(columns));
    }

    public String getQAllColumns() {
        return concat(columns);
    }

    public String getQAndExcludeColl(String... col) {
        return getQ(col);
    }

    private String getQ(String... exclude) {
        Arrays.sort(exclude);
        List<String> toList = columns.stream()
                .filter(e -> Arrays.binarySearch(exclude, e) == -1)
                .toList();
        return concat(toList);
    }

    private String concat(List l) {
        StringBuilder sb = new StringBuilder(columns.get(0).length() * columns.size());
        int i = 0;
        while (i < l.size() - 1) {
            sb.append(l.get(i));
            i++;
        }
        sb.append(l.get(i));
        return sb.toString();
    }

    public String getTableName() {
        return table_name;
    }
    
    

}
