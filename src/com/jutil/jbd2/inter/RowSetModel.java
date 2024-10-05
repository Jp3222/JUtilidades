/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.inter;

import com.jutil.jbd2.conexion.DBObject;
import java.util.Set;

/**
 *
 * @author juan-campos
 */
public interface RowSetModel extends RowModel {

    Set<String> getSet();

    Set<Object> getObjectSet();

    Set<DBObject> getDBObjectSet();

}
