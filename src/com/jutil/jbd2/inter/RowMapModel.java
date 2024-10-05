/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.inter;

import com.jutil.jbd2.conexion.obj.AbstractDBObject;
import java.util.Map;

/**
 *
 * @author juan-campos
 */
public interface RowMapModel extends RowModel {

    Map<Object, String> getStringArrayList();

    Map<Object, Object> getOBjectArrayList();

    Map<Object, AbstractDBObject> getSOArrayList();

    void setKeys(Object[] keys);

}
