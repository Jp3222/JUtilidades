/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.db.model;

import java.io.Serializable;

/**
 *
 * @author juanp
 */
public interface JDBObject extends Cloneable, Serializable, Comparable<JDBObject>{

    /**
     * Retorna la clave primaria (primary key) del registro de la tabla.
     * <p>
     * Se espera que este método devuelva el valor del campo que actúa como
     * identificador único para el objeto.
     *
     * @return El valor de la clave primaria como un {@link String}.
     */
    String getId();
}
