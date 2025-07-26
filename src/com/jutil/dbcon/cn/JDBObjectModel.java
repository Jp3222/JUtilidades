/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.dbcon.cn;

import java.io.Serializable;

/**
 *
 * @author juan-campos
 */
public interface JDBObjectModel extends Cloneable, Serializable, Comparable<JDBObjectModel>{

    String getId();

    boolean isEmpty();
}
