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

    /**
     * Query con el siguiente formato INSERT_VAL = "INSERT INTO %s (%s) values
     * (%s)"
     */
    public static final String INSERT_VAL = "INSERT INTO %s (%s) values (%s)";

    /**
     * Query con el siguiente formato INSERT_COL = "INSERT INTO %s (%s) values
     * %s"
     */
    public static final String INSERT_COL = "INSERT INTO %s (%s) values %s";

    /**
     * Query con el siguiente formato SELECT = "SELECT %s FROM %s WHERE %s"
     */
    public static final String SELECT = "SELECT %s FROM %s WHERE %s";

    /**
     * Query con el siguiente formato UPDATE_VAL = "UPDATE %s SET %s = '%s'
     * WHERE %s"
     */
    public static final String UPDATE_VAL = "UPDATE %s SET %s = '%s' WHERE %s";

    /**
     * Query con el siguiente formato UPDATE_COL = "UPDATE %s SET %s WHERE %s"
     */
    public static final String UPDATE_COL = "UPDATE %s SET %s WHERE %s";

    /**
     * Query con el siguiente formato DELETE = "DELETE FROM %s WHERE %s";
     */
    public static final String DELETE = "DELETE FROM %s WHERE %s";

    /**
     * Query con el siguiente formato COUNT = "SELECT COUNT(%s) FROM %s";
     */
    public static final String COUNT = "SELECT COUNT(%s) FROM %s";

    /**
     * Query con el siguiente formato MAX = "SELECT MAX(%s) FROM %s";
     */
    public static final String MAX = "SELECT MAX(%s) FROM %s";
}
