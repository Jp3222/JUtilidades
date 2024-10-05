/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.inter;

import java.sql.ResultSet;

/**
 *
 * @author juan-campos
 */
public interface Query {

    public int setQuery(String query);

    public ResultSet getQuery(String query);

}
