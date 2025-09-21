/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jutil.dbcon.cn;

import java.io.Serializable;

/**
 * Define el modelo estándar para un objeto de transferencia de datos (DTO) que
 * representa una fila de una tabla de base de datos.
 * <p>
 * Esta interfaz establece un contrato para las clases que actúan como
 * representaciones de filas, facilitando la conversión de datos desde la base
 * de datos a objetos Java. Al extender {@link Cloneable} y
 * {@link Serializable}, los objetos pueden ser fácilmente clonados y enviados a
 * través de la red o guardados en archivos.
 * <p>
 * Se recomienda usar esta interfaz para objetos simples como catálogos o para
 * la lectura completa de tablas con campos no complejos. Para la creación de
 * objetos más complejos o para mapear múltiples tablas, es preferible usar la
 * interfaz {@code JDBObjectMapModel}.
 *
 * @author juan-campos
 * @see Cloneable
 * @see Serializable
 * @see Comparable
 * @see JDBObjectMapModel
 * @since 1.0
 */
public interface JDBObjectModel extends Cloneable, Serializable, Comparable<JDBObjectModel> {

    /**
     * Retorna la clave primaria (primary key) del registro de la tabla.
     * <p>
     * Se espera que este método devuelva el valor del campo que actúa como
     * identificador único para el objeto.
     *
     * @return El valor de la clave primaria como un {@link String}.
     */
    String getId();

    /**
     * Asigna la información de una fila de la base de datos al objeto.
     *
     * @param data Un arreglo de {@link String} que contiene los valores de las
     * columnas de una fila de la base de datos. La implementación debe mapear
     * estos valores a los atributos internos del objeto.
     */
    void setData(String[] data);

    /**
     * Retorna la información del objeto como un arreglo de cadenas.
     * <p>
     * La implementación debe extraer los valores de los atributos del objeto y
     * devolverlos en el mismo orden que se recuperaron de la base de datos,
     * para facilitar su procesamiento.
     *
     * @return Un arreglo de {@link String} con los valores de los campos del
     * objeto.
     */
    String[] getData();

    /**
     * Verifica si el objeto está vacío.
     * <p>
     * Un objeto se considera vacío si es {@code null} o si todos sus elementos
     * o atributos principales son {@code null} o cadenas vacías.
     *
     * @return {@code true} si el objeto está vacío o nulo; {@code false} en
     * caso contrario.
     */
    boolean isEmpty();

    /**
     * Realiza una copia superficial (shallow copy) de este objeto.
     * <p>
     * Las clases que implementan esta interfaz deben proporcionar una
     * implementación que devuelva un nuevo objeto con los mismos valores de sus
     * atributos.
     *
     * @return Una copia del objeto.
     * @throws CloneNotSupportedException Si el objeto no puede ser clonado.
     */
    Object clone() throws CloneNotSupportedException;
}
