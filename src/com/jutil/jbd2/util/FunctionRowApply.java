/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.util;

import java.sql.ResultSet;

/**
 *
 * @author juan-campos
 */
@FunctionalInterface
public interface FunctionRowApply {
    
    void apply(ResultSet row);
}
