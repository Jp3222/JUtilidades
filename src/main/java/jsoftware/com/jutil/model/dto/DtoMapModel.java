/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.model.dto;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author juanp
 */
public interface DtoMapModel extends Serializable, Cloneable {

    void put(String key, Object value);

    Object get(String key);

    void setMap(Map<String, Object> map);
    
    Map<String, Object> getMap();
}
