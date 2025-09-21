/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.dbcon.cn;


import java.io.Serializable;
import java.util.Map;

/**
 * Define el modelo de un objeto de transferencia de datos (DTO) de base de
 * datos que representa un registro con una estructura de clave-valor.
 * <p>
 * Esta interfaz es ideal para la lectura de consultas complejas o para mapear
 * objetos que no tienen una estructura de campos fija, a diferencia de
 * {@code JDBObjectModel}. Proporciona un contrato para gestionar datos como un
 * mapa, ofreciendo una mayor flexibilidad al manejar registros de la base de
 * datos con una estructura dinámica o desconocida.
 *
 * @author juan-campos
 * @see JDBObjectModel
 * @see Cloneable
 * @see Serializable
 * @see Comparable
 * @since 1.0
 */
public interface JDBObjectMapModel extends Cloneable, Serializable, Comparable<JDBObjectMapModel> {

    /**
     * Almacena un par clave-valor en el objeto.
     * <p>
     * Este método se utiliza para asignar un valor a un campo específico del
     * registro. La clave representa el nombre de la columna y el valor, el dato
     * asociado.
     *
     * @param key La clave del mapa (nombre de la columna de la base de datos).
     * @param value El valor del dato a almacenar.
     */
    void put(String key, Object value);

    /**
     * Recupera el valor asociado a una clave específica.
     * <p>
     * Se utiliza para obtener el dato de un campo a partir del nombre de su
     * columna.
     *
     * @param key La clave del mapa (nombre de la columna).
     * @return El valor del dato asociado a la clave, o {@code null} si la clave
     * no existe.
     */
    Object get(String key);

    /**
     * Asigna un mapa de datos completo al objeto.
     * <p>
     * Este método es útil para inicializar el objeto a partir de una estructura
     * de datos de clave-valor ya existente, como la que se podría obtener de un
     * {@link java.sql.ResultSet}.
     *
     * @param map El mapa que contiene los pares clave-valor a asignar al
     * objeto.
     */
    void setData(Map<String, Object> map);
}
