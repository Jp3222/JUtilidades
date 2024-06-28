/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import java.util.Arrays;

/**
 *
 * @author juan-campos
 */
public class BDSuperObject {

    protected final String[] data;

    public BDSuperObject(String[] data) {
        this.data = data;
    }

    public String getStringR(){
        return Arrays.toString(data);
    }

    public String getValue(int index) {
        return data[index];
    }

    public void setValue(int index, String newString) {
        data[index] = newString;
    }

    public boolean isEmpty() {
        if (data == null) {
            return true;
        }
        if (data.length == 0) {
            return true;
        }
        for (String i : data) {
            if (i == null) {
                return true;
            }
        }
        return false;
    }
}
