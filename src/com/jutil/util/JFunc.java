/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.util;

/**
 *
 * @author jp
 */
public class JFunc {

    public static String RG_CHAR_TXT = "[a-z-A-ZáéíóúñÑ]";
    public static String RG_CHAR_NUM_P = "[0-9]";
    public static String RG_CHAR_NUM_N = "-([0-9])";

    public boolean txtValido(String o) {
        return !txtNull(o) && !txtBlanco(o);
    }

    public boolean txtVacios(String o) {
        return o.isEmpty();
    }

    public boolean txtNull(String o) {
        return o == null;
    }

    public boolean txtBlanco(String o) {
        return o.isBlank();
    }

}
