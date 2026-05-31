/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import java.util.HashMap;
import java.util.Map;
import jsoftware.com.jutil.model.dto.DtoMapModel;

/**
 * Clase DTO abstracta.
 * <br>
 * El contenedor de datos interno mantiene la informacion sin importar la
 * estructura.
 *
 * @author JUAN PABLO CAMPOS CASASANERO
 * @since 2025-11-08
 * @version 1.0
 */
public abstract class AbstractMapDTO implements DtoMapModel {

    // Cambiamos 'final' en la referencia para permitir que 'setMap' reasigne la estructura de forma segura,
    // pero mantenemos el modificador 'protected' para que subclases como SessionDTO operen rápido.
    protected Map<String, Object> values;

    public AbstractMapDTO(Map<String, Object> map) {
        // Nos aseguramos de que values nunca sea null; si pasan null, inicializamos un mapa vacío
        this.values = (map != null) ? map : new HashMap<>(20);
    }

    public AbstractMapDTO(int size) {
        this(new HashMap<>(size));
    }

    public AbstractMapDTO() {
        this(20);
    }

    @Override
    public void put(String key, Object value) {
        values.put(key, value);
    }

    @Override
    public Object get(String key) {
        return values.get(key);
    }

    @Override
    public void setMap(Map<String, Object> map) {
        if (map == null) {
            values.clear();
            return;
        }
        // SOLUCIÓN AL BUG: En lugar de limpiar y hacer putAll sobre la misma referencia (que puede tronar),
        // creamos una nueva instancia mutuable de HashMap con los datos recibidos.
        this.values = new HashMap<>(map);
    }

    public void addAll(Map<String, Object> map) {
        values.putAll(map);
    }

    @Override
    public Map<String, Object> getMap() {
        return values;
    }

    /**
     * Implementación de Clonación Profunda (Deep Copy) para evitar que dos DTOs
     * compartan el mismo mapa en memoria al duplicar registros en Swing.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        AbstractMapDTO clone = (AbstractMapDTO) super.clone();
        // Duplicamos el mapa interno para que el clon sea 100% independiente
        clone.values = new HashMap<>(this.values);
        return clone;
    }

    // Método utilitario excelente para que tus subclases validen estados fácilmente
    public boolean isEmpty() {
        return values == null || values.isEmpty();
    }

}
