/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model.dto;

import java.io.Serializable;

/**
 *
 * @author juanp
 */
public interface DtoArrayModel extends Serializable, Cloneable {

    void set(int index, Object value);

    Object get(int index);

    void setValues(String... values);

    Object[] getValues();
}
