/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jsoftware.com.jutil.db.model.ObjectsFactory;

/**
 *
 * @author juanp
 */
public class Adapters<T extends JDBMapObject, K extends JDBArrayObject> {

    private ObjectsFactory<T, K> factory;

    public Adapters(ObjectsFactory factory) {
        this.factory = factory;
    }

    public ArrayList<T> getMapAdapter(Class<T> cls, ResultSet rs, String[] fields) throws SQLException {
        ArrayList<T> res = new ArrayList<>(1000);
        JDBMapObject obj;
        while (rs.next()) {
            obj = factory.getMapObject(cls);
            for (String i : fields) {
                obj.put(i, rs.getString(i));
            }
            res.add((T) obj);
        }
        return res;
    }

    public ArrayList<K> getArrayAdapter(Class<K> cls, ResultSet rs, String[] fields) throws SQLException {
        ArrayList<K> res = new ArrayList<>(1000);
        JDBArrayObject obj;
        int i = 0;
        while (rs.next()) {
            obj = factory.getArrayObject(cls);
            for (String j : fields) {
                obj.set(i, rs.getString(j));
            }
            res.add((K) obj);
        }
        return res;
    }

}
