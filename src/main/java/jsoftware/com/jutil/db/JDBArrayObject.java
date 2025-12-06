/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import jsoftware.com.jutil.db.model.JDBObject;
import jsoftware.com.jutil.model.AbstractArrayDTO;

/**
 *
 * @author juanp
 */
public class JDBArrayObject extends AbstractArrayDTO implements JDBObject {

    public JDBArrayObject() {
        super();
    }

    public JDBArrayObject(Object[] values) {
        super(values);
    }
    

    @Override
    public String getId() {
        return values[0].toString();
    }

    @Override
    public int compareTo(JDBObject o) {
        return getId().compareTo(o.getId());
    }

}
