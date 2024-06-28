/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import com.jutil.jbd2.util.FunctionRowApply;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan-campos
 */
public class Row implements RowResult {

    private final ResultSet row;
    private boolean closeFinaly;

    public Row(ResultSet row, boolean closeFinaly) {
        this.row = row;
    }

    public void For(FunctionRowApply dis) throws SQLException {
        while (row.next()) {
            dis.apply(row);
        }
        closeFinaly();
    }

    @Override
    public ArrayList<Object[]> getListRowsObject() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            int i;
            Object item;
            ArrayList<Object> arr_aux = new ArrayList<>(10);
            while (row.next()) {
                i = 0;
                while ((item = row.getObject(i)) != null) {
                    arr_aux.add(item);
                    i++;
                }
                data.add(arr_aux.toArray());
                arr_aux.clear();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Row.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeFinaly();
        return data;
    }

    @Override
    public ArrayList<String[]> getListRowsString() {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            int i;
            String item;
            ArrayList<String> arr_aux = new ArrayList<>(10);
            while (row.next()) {
                i = 0;
                while ((item = row.getString(i)) != null) {
                    arr_aux.add(item);
                    i++;
                }
                data.add(arr_aux.toArray(String[]::new));
                arr_aux.clear();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Row.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeFinaly();
        return data;
    }

    @Override
    public ArrayList<BDSuperObject> getListRowsItem() {
        ArrayList<String[]> list = getListRowsString();
        ArrayList<BDSuperObject> aux = new ArrayList<>(list.size());
        for (String[] i : list) {
            aux.add(new BDSuperObject(i));
        }
        closeFinaly();
        return aux;
    }

    @Override
    public Object[][] getArrayRowsObject() {
        ArrayList<Object[]> list = getListRowsObject();
        int x = list.size(),
                y = list.get(0).length;

        Object[][] arr = new Object[x][y];

        int i = 0;
        for (Object[] item : arr) {
            arr[i] = item;
            i++;
        }
        list.clear();
        closeFinaly();
        return arr;
    }

    @Override
    public String[][] getArrayRowsString() {
        ArrayList<String[]> list = getListRowsString();
        int x = list.size(),
                y = list.get(0).length;
        String[][] arr = new String[x][y];
        int i = 0;
        for (String[] item : arr) {
            arr[i] = item;
            i++;
        }
        list.clear();
        closeFinaly();
        return arr;
    }

    @Override
    public BDSuperObject[] getArrayRowsItems() {
        return getListRowsItem().toArray(BDSuperObject[]::new);
    }

    public void close() {
        try {
            if (!row.isClosed()) {
                row.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Row.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeFinaly() {
        if (closeFinaly) {
            close();
        }
    }

    public boolean isCloseFinaly() {
        return closeFinaly;
    }

    public void setCloseFinaly(boolean closeFinaly) {
        this.closeFinaly = closeFinaly;
    }

    public ResultSet getRow() {
        return row;
    }

}
