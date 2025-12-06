/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import java.util.HashMap;
import java.util.Map;
import jsoftware.com.jutil.db.model.JDBObject;
import jsoftware.com.jutil.model.AbstractMapDTO;

/**
 *
 * @author juanp
 */
public class JDBMapObject extends AbstractMapDTO implements JDBObject {

    public JDBMapObject(Map<String, Object> map) {
        super(map);
    }

    public JDBMapObject(int size) {
        super(new HashMap<>(size));
    }

    public JDBMapObject() {
        super(20);
    }

    @Override
    public String getId() {
        return get("id").toString();
    }

    @Override
    public int compareTo(JDBObject o) {
        return getId().compareTo(o.getId());
    }

}
