/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Proporciona una API de alto nivel para la gestión de consultas SQL usando
 * sentencias preparadas ({@link java.sql.PreparedStatement}).
 * <p>
 * Esta interfaz ofrece un método seguro y robusto para interactuar con la base
 * de datos, mitigando el riesgo de ataques de inyección SQL en comparación con
 * las consultas de {@link java.sql.Statement}.
 *
 * @author juan-campos
 * @see SimpleQuerys
 * @since 1.0
 */
public interface JPrepareStamentModel extends SimpleQuerys {

    /**
     * Inserta un solo registro en la base de datos de manera segura.
     * <p>
     * Se espera que la cadena de valores contenga marcadores de posición
     * {@code ?} para una inserción segura.
     *
     * @param table El nombre de la tabla de destino.
     * @param fields Los nombres de las columnas a insertar (ej. "nombre,
     * edad").
     * @param values Los marcadores de posición de los valores a registrar (ej.
     * "?, ?").
     * @return {@code true} si la operación insertó al menos un registro;
     * {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    boolean psInsert(String table, String fields, String values) throws SQLException;

    /**
     * Actualiza uno o más registros en la base de datos de manera segura.
     *
     * @param table El nombre de la tabla a actualizar.
     * @param olValue El nombre del campo a actualizar (debería ser la constante
     * del campo).
     * @param newValue El nuevo valor a establecer en la columna (debe ser un
     * marcador de posición {@code ?}).
     * @param where La condición de filtro para la actualización (ej. "id = ?").
     * @return {@code true} si al menos un registro fue modificado;
     * {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    boolean psUpdate(String table, String olValue, String newValue, String where) throws SQLException;

    /**
     * Selecciona registros de una tabla de manera segura.
     *
     * @param table El nombre de la tabla a consultar.
     * @param fields Los campos a seleccionar (ej. "*", "id, nombre").
     * @param where La condición de filtro (ej. "edad > ?").
     * @return Un objeto {@link ResultSet} con los datos de la consulta.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    ResultSet psSelect(String table, String fields, String where) throws SQLException;

    /**
     * Elimina registros de una tabla de manera segura.
     *
     * @param table El nombre de la tabla de la que se eliminarán los registros.
     * @param where La condición de filtro para la eliminación (ej. "id = ?").
     * @return {@code true} si al menos un registro fue eliminado; {@code false}
     * en caso contrario.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    boolean psDelete(String table, String where) throws SQLException;

    /**
     * Ejecuta una consulta SQL genérica con marcadores de posición.
     *
     * @param query La consulta SQL completa a ejecutar con marcadores de
     * posición {@code ?}.
     * @return Un objeto {@link ResultSet} con los resultados de la consulta.
     * @throws SQLException Si la consulta es inválida o si ocurre un error de
     * acceso a la base de datos.
     */
    ResultSet psQuery(String query) throws SQLException;

    /**
     * Ejecuta una consulta SQL DML (Data Manipulation Language) o DDL (Data
     * Definition Language).
     *
     * @param query La consulta SQL completa a ejecutar con marcadores de
     * posición {@code ?}.
     * @return El número de filas afectadas por la operación.
     * @throws SQLException Si la consulta es inválida o si ocurre un error de
     * acceso a la base de datos.
     */
    int psExecute(String query) throws SQLException;
}
