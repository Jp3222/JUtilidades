/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.inter;

import com.jutil.jbd2.conexion.DBObject;
import java.util.List;

/**
 *
 * @author juan-campos
 * @param <T>
 */
public interface RowListModel extends RowModel{

    List<String[]> getList();
    
    List<Object[]> getObjectList();
    
    List<DBObject> getDBObjectList();
}
