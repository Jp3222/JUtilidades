/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion.virtual.cache;

import com.jutil.jbd.conexion.Conexion;
import com.jutil.jbd.conexion.virtual.Cache;
import com.jutil.jbd.interfaces.col.MetodosCol;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author jp
 */
public class CacheList extends Cache implements MetodosCol {

    public static CacheList getCacheArrayList(Conexion conexion, String tabla) {
        return new CacheList(new ArrayList(), conexion, tabla);
    }

    public static CacheList getCacheLinkedList(Conexion conexion, String tabla) {
        return new CacheList(new LinkedList(), conexion, tabla);
    }

    private CacheList(List lista, Conexion conexion, String tabla) {
        super(lista, conexion, tabla);
    }

    @Override
    public boolean add(String[] col) {
        return this._lista.add(col);
    }

    @Override
    public boolean remove(int index) {
        return this._lista.remove(index) != null;
    }

    @Override
    public String[] get(int index) {
        return this._lista.get(index);
    }

    @Override
    public boolean set(int index, String[] con) {
        return this._lista.set(index, con) != null;
    }

    @Override
    public List<String[]> getColeccion(Predicate<String[]> filtro) {
        List<String[]> lista = null;
        if (_lista instanceof ArrayList) {
            lista = new ArrayList<>();
        } else if (lista instanceof LinkedList) {
            lista = new LinkedList<>();
        }
        for (String[] strings : _lista) {
            if (filtro.test(strings)) {
                this._lista.add(strings.clone());
            }
        }
        return lista;
    }
}
