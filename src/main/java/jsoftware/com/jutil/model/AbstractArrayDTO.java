/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import jsoftware.com.jutil.model.dto.DtoArrayModel;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractArrayDTO implements DtoArrayModel {

    protected Object[] values;

    public AbstractArrayDTO(Object[] values) {
        this.values = values;
    }

    public AbstractArrayDTO() {
        this(null);
    }

    @Override
    public void set(int index, Object value) {
        values[index] = value;
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public void setValues(String... values) {
        this.values = values;
    }

    @Override
    public Object[] getValues() {
        return values;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
