/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion.obj;

import java.util.Arrays;

/**
 *
 * @author juan-campos
 */
public class AbstractDBObject implements DBObjectModel {

    protected final String[] values;

    public AbstractDBObject(String[] data) {
        this.values = data;
    }

    @Override
    public String getId() {
        return values[0];
    }

    @Override
    public String[] getValues() {
        return values;
    }

    @Override
    public boolean isEmpty() {
        return values == null || values.length == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

}
