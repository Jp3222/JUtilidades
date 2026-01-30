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
public final class Func implements JFuncArrays, JFuncFiles, JFunc {
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
    public static void putIfPresentAndNotBlank(Map<String, Object> map, String key, Object value) {
        if (value != null && !value.toString().isBlank()) {
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
    public static void putIfNotNull(Map<String, Object> map, String key, Object value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    public static String getIfNotNull(Map<String, Object> map, String key) {
        if (map.containsKey(key) && map.get(key) != null) {
            return map.get(key).toString();
        }
        return "";
    }
}
