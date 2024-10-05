/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd2.inter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractRow implements RowModel, AutoCloseable {

    protected final ResultSet rs;

    public AbstractRow(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public Object[][] getArray(int size) throws SQLException {
        ArrayList<Object[]> data = new ArrayList<>();
        Object[] aux;
        while (rs.next()) {
            aux = new Object[size];
            for (int i = 1; i <= size; i++) {
                aux[i - 1] = rs.getObject(i);
            }
            data.add(aux);
        }
        Object[][] out = new Object[data.size()][size];
        int i = 0;
        for (Object[] j : data) {
            out[i] = j;
        }
        return out;
    }

    @Override
    public void close() throws SQLException {
        rs.close();
    }

}
