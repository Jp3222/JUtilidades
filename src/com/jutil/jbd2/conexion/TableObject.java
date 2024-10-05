/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author juan-campos
 */
public class TableObject {

    private final String NAME;
    private final String[] COLUMNS;

    public TableObject(String name, String... columns) {
        this.NAME = name;
        this.COLUMNS = columns;
    }

    public String[] getColumns() {
        return COLUMNS;
    }

    public String getName() {
        return NAME;
    }

    public int getSize() {
        return COLUMNS.length;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TableObject other = (TableObject) obj;
        if (!Objects.equals(this.NAME, other.NAME)) {
            return false;
        }
        return Arrays.deepEquals(this.COLUMNS, other.COLUMNS);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TableObject{");
        sb.append("NAME=").append(NAME);
        sb.append(", COLUMNS=").append(COLUMNS);
        sb.append('}');
        return sb.toString();
    }
    
    
}
