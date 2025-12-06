/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.model;

import jsoftware.com.jutil.db.JDBArrayObject;
import jsoftware.com.jutil.db.JDBMapObject;

/**
 *
 * @author juanp
 */
public interface ObjectsFactory<T extends JDBMapObject, K extends JDBArrayObject> {

    public T getMapObject(Class<T> cls);

    public K getArrayObject(Class<K> cls);

}
