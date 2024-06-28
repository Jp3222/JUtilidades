/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.conexion;

import java.util.ArrayList;

/**
 *
 * @author juan-campos
 */
public interface RowResult {

    ArrayList<Object[]> getListRowsObject();

    ArrayList<String[]> getListRowsString();

    ArrayList<BDSuperObject> getListRowsItem();

    Object[][] getArrayRowsObject();

    String[][] getArrayRowsString();

    BDSuperObject[] getArrayRowsItems();
    
    
}
