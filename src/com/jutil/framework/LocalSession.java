/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.framework;

import com.jutil.dbcon.cn.DBObjectModel;

/**
 *
 * @author juan-campos
 * @param <T>
 */
public interface LocalSession<T extends DBObjectModel> {

    boolean isOpen();

    void writer();

    void setUser(T user);
}
