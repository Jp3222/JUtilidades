/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import java.util.HashMap;
import java.util.Map;
import jsoftware.com.jutil.model.dto.DtoMapModel;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractMapDTO extends AbstractMonitoreable implements DtoMapModel {

    protected final Map<String, Object> values;

    public AbstractMapDTO(boolean flag_dev_log, String name_module) {
        super(flag_dev_log, name_module);
        values = new HashMap<>(20);
    }

    @Override
    public void put(String key, Object value) {
        values.put(key, value);
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
