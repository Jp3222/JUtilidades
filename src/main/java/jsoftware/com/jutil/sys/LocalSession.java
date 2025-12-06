/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.sys;

import jsoftware.com.jutil.db.model.JDBObject;

/**
 *
 * @author juan-campos
 * @param <T>
 */
public interface LocalSession<T extends JDBObject> {

    boolean isOpen();

    void writer();

    void setUser(T user);
}
