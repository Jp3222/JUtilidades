/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.connection;

import com.jutil.dbcon.tb.DBTable;


/**
 *
 * @author juan-campos
 */
public interface DBModels {

    DBTable getTable(String name);

}
