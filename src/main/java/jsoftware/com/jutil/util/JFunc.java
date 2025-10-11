/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

/**
 *
 * @author jp
 */
public interface JFunc {

    public static String RG_CHAR_TXT = "[a-z-A-ZáéíóúñÑ]";
    public static String RG_CHAR_NUM_P = "[0-9]";
    public static String RG_CHAR_NUM_N = "-([0-9])";

    public static boolean txtValido(String o) {
        return !txtNull(o) && !txtBlanco(o);
    }

    public static boolean txtVacios(String o) {
        return o.isEmpty();
    }

    public static boolean txtNull(String o) {
        return o == null;
    }

    public static boolean txtBlanco(String o) {
        return o.isBlank();
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

}
