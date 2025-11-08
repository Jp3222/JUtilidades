/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

import java.util.Map;

/**
 *
 * @author juan-campos
 */
public class Func implements JArrays, JFiles, JFunc {
    // Método auxiliar

    public static void addIfChanged(Map<String, String> map, String key, String oldValue, String newValue) {
        if (oldValue == null && newValue != null && !newValue.isBlank()) {
            map.put(key, newValue);
        } else if (oldValue != null && newValue != null && !newValue.isBlank() && !oldValue.equals(newValue)) {
            map.put(key, newValue);
        }
    }

    /**
     * Pone una clave y un valor en el mapa si el valor no es nulo y no está en
     * blanco.
     *
     * @param map
     * @param key
     * @param value
     */
    public static void putIfPresentAndNotBlank(Map<String, String> map, String key, String value) {
        if (value != null && !value.isBlank()) {
            map.put(key, value);
        }
    }

    /**
     * Pone una clave y un valor en el mapa si el valor no es nulo.
     *
     * @param map
     * @param key
     * @param value
     */
    public static void putIfNotNull(Map<String, String> map, String key, String value) {
        if (value != null) {
            map.put(key, value);
        }
    }
}
