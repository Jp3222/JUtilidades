/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import java.util.HashMap;
import java.util.Map;
import jsoftware.com.jutil.model.dto.DtoMapModel;
import jsoftware.com.jutil.util.Func;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractMapDTO implements DtoMapModel {

    protected final Map<String, Object> values;

    public AbstractMapDTO(Map<String, Object> map) {
        this.values = map;
    }

    public AbstractMapDTO(int size) {
        this(new HashMap<>(size));
    }

    public AbstractMapDTO() {
        this(20);
    }

    @Override
    public void put(String key, Object value) {
        Func.putIfPresentAndNotBlank(values, key, value);
    }

    @Override
    public Object get(String key) {
        return values.get(key);
    }

    @Override
    public void setMap(Map<String, Object> map) {
        if (!values.isEmpty()) {
            values.clear();
        }
        values.putAll(map);
    }

    @Override
    public Map<String, Object> getMap() {
        return values;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
