/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.dbcon.cn;

/**
 *
 * @author juan-campos
 */
public interface SimpleQuerys {
    
    public static final String INSERT_VAL = "INSERT INTO %s (%s) values (%s)";
    public static final String INSERT_COL = "INSERT INTO %s (%s) values %s";
    
    public static final String SELECT = "SELECT %s FROM %s WHERE %s";
    
    public static final String UPDATE_VAL = "UPDATE %s SET %s = '%s' WHERE %s";
    public static final String UPDATE_COL = "UPDATE %s SET %s WHERE %s";
    
    public static final String DELETE = "DELETE FROM %s WHERE %s";
}
