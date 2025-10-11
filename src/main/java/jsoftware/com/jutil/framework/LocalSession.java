/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.framework;

import jsoftware.com.jutil.dbcon.cn.JDBObjectModel;

/**
 *
 * @author juan-campos
 * @param <T>
 */
public interface LocalSession<T extends JDBObjectModel> {

    boolean isOpen();

    void writer();

    void setUser(T user);
}
