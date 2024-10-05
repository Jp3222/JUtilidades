/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import com.jutil.jbd2.inter.AbstractRow;
import com.jutil.jbd2.inter.RowListModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan-campos
 */
public class RowList extends AbstractRow implements RowListModel {

    public static int ARRAY_LIST = 0;
    public static int LINKED_LIST = 1;
    public static int STACK = 2;

    private int type;

    public RowList(ResultSet rs, String cols) {
        this(rs, ARRAY_LIST, cols);
    }

    public RowList(ResultSet rs, int type, int cols) {
        super(rs);
        this.type = type;
    }

    public RowList(ResultSet rs, int type, String cols) {
        super(rs);
        this.type = type;
    }

    @Override
    public List<String[]> getList() {
        List<String[]> res = getTypeList(type);
        List<String> aux_list = new ArrayList<>(15);
        try {
            String aux;
            int i;
            while (rs.next()) {
                i = 0;
                aux_list.clear();
                while ((aux = rs.getNString(i)) != null) {
                    if (aux != null) {
                        aux_list.add(String.valueOf(aux));
                        i++;
                    }
                }
                String[] col = aux_list.toArray(String[]::new);
                res.add(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RowList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public List<Object[]> getObjectList() {
        List<Object[]> res = getTypeList(type);
        List<Object> aux_list = new ArrayList<>(15);
        try {
            Object aux;
            int i;
            while (rs.next()) {
                i = 0;
                aux_list.clear();
                while ((aux = rs.getObject(i)) != null) {
                    if (aux != null) {
                        aux_list.add(String.valueOf(aux));
                        i++;
                    }
                }
                Object[] col = aux_list.toArray(String[]::new);
                res.add(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RowList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public List<DBObject> getDBObjectList() {
        List<DBObject> res = getTypeListO(type);
        List<String[]> res_red = getList();
        for (String[] i : res_red) {
            DBObject o = new DBObject(i);
            res.add(o);
        }
        return res;
    }

    private <T> List<T[]> getTypeList(int type) {
        return switch (type) {
            case 1:
                yield new LinkedList();
            case 2:
                yield new Stack();
            default:
                yield new ArrayList();
        };
    }

    private List<DBObject> getTypeListO(int type) {
        return switch (type) {
            case 1:
                yield new LinkedList();
            case 2:
                yield new Stack();
            default:
                yield new ArrayList();
        };
    }
}
