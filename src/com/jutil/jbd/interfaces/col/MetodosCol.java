/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.jbd.interfaces.col;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author jp
 */
public interface MetodosCol {

    boolean add(String[] con);

    boolean remove(int index);

    String[] get(int index);

    boolean set(int index, String[] con);

    List<String[]> getColeccion(Predicate<String[]> filtro);
}
