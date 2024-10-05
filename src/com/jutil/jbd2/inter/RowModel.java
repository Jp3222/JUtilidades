/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.inter;

import java.sql.SQLException;

/**
 *
 * @author juan-campos
 */
public interface RowModel {

    Object[] getArray(int size) throws SQLException;
    
    
}
