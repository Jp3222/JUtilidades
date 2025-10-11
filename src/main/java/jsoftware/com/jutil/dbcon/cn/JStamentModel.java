/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.dbcon.cn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Proporciona una API de alto nivel para ejecutar consultas SQL y manipular
 * datos.
 * <p>
 * Esta interfaz simplifica las operaciones comunes de bases de datos al
 * encapsular la lógica de {@link java.sql.Statement} y
 * {@link java.sql.ResultSet}. Está diseñada para ser utilizada con las
 * plantillas de consultas definidas en {@link SimpleQuerys} para una
 * construcción rápida de sentencias SQL.
 *
 * @author juan-campos
 * @see SimpleQuerys
 * @since 1.0
 */
public interface JStamentModel extends SimpleQuerys {

    /**
     * Inserta un solo registro en la base de datos usando un formato de
     * valores.
     * <p>
     * Este método utiliza la plantilla {@link SimpleQuerys#INSERT_VAL} para
     * construir la consulta SQL.
     *
     * @param table El nombre de la tabla de destino.
     * @param fields Los nombres de las columnas a insertar (ej. "nombre,
     * edad").
     * @param values Los valores a insertar (ej. "'Juan', 30").
     * @return {@code true} si la operación insertó al menos un registro;
     * {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    boolean insert(String table, String fields, String values) throws SQLException;

    /**
     * Inserta múltiples registros en la base de datos usando una sintaxis de
     * valores agrupados.
     * <p>
     * Este método utiliza la plantilla {@link SimpleQuerys#INSERT_COL} para
     * construir la consulta SQL, que permite una inserción más eficiente de
     * varios registros a la vez.
     *
     * @param table El nombre de la tabla de la base de datos a la cual se le
     * aplicará la inserción de datos.
     * @param fields Los nombres de los campos a los que se les aplicará la
     * inserción de datos (ej. "nombre, edad, email").
     * @param values La cadena de valores a registrar, formateada como grupos
     * separados por comas (ej. "('Juan', 30, 'juan@mail.com'), ('Ana', 25,
     * 'ana@mail.com')").
     * @return {@code true} si al menos un registro fue insertado; {@code false}
     * en caso contrario.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    public boolean insert(String table, String fields, StringBuilder values) throws SQLException;

    /**
     * Actualiza un registro en la base de datos.
     * <p>
     * Este método está diseñado para actualizar un único campo con un nuevo
     * valor.
     *
     * @param table El nombre de la tabla donde se realizará la actualización.
     * @param field El nombre de la columna que será actualizada.
     * @param newValue El nuevo valor a asignar a la columna especificada.
     * @param where La condición SQL {@code WHERE} que especifica qué registros
     * actualizar (ej., "id = 101" o "estado = 'pendiente'").
     * @return {@code true} si al menos un registro fue modificado;
     * {@code false} si no se modificó ningún registro.
     * @throws SQLException Si ocurre un error de acceso a la base de datos o si
     * la consulta SQL es inválida.
     */
    boolean update(String table, String field, String newValue, String where) throws SQLException;

    /**
     * Actualiza uno o más registros en la base de datos con múltiples pares de
     * clave-valor.
     * <p>
     * Este método es útil para actualizar varios campos a la vez sin tener que
     * construir una sentencia SQL manualmente.
     *
     * @param table El nombre de la tabla donde se realizará la actualización.
     * @param kv Un String con los pares de clave-valor a actualizar, separados
     * por comas. Ejemplo: "columna1 = 'valor1', columna2 = 'valor2'".
     * @param where La condición SQL {@code WHERE} que especifica qué registros
     * actualizar (ej., "id = 101" o "estado = 'pendiente'").
     * @return {@code true} si al menos un registro fue modificado;
     * {@code false} si no se modificó ningún registro.
     * @throws SQLException Si ocurre un error de acceso a la base de datos o si
     * la consulta SQL es inválida.
     */
    public boolean update(String table, String kv, String where) throws SQLException;

    /**
     * Selecciona registros de una tabla basándose en una condición.
     *
     * @param table El nombre de la tabla a consultar.
     * @param fields Los campos a seleccionar (ej. "*", "id, nombre").
     * @param where La condición {@code WHERE} para el filtro (ej. "edad > 18").
     * @return Un objeto {@link ResultSet} con los datos de la consulta.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    ResultSet select(String table, String fields,
            String where) throws SQLException;

    /**
     * Elimina registros de una tabla.
     *
     * @param table El nombre de la tabla de la que se eliminarán los registros.
     * @param where La condición {@code WHERE} para el filtro de la eliminación
     * (ej. "id = 5").
     * @return {@code true} si la operación eliminó al menos un registro;
     * {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
     */
    boolean delete(String table, String where) throws SQLException;

    /**
     * Ejecuta una consulta SQL genérica que devuelve un conjunto de resultados.
     * <p>
     * Este método es util para consultas SELECT complejas que no pueden ser
     * manejadas por metodos mas simples.
     *
     * @param query La consulta SQL completa a ejecutar.
     * @return Un objeto {@link ResultSet} con los resultados de la consulta.
     * @throws SQLException Si la consulta es invalida o si ocurre un error de
     * acceso a la base de datos.
     */
    ResultSet query(String query) throws SQLException;

    /**
     * Ejecuta una consulta SQL que no devuelve un conjunto de resultados.
     * <p>
     * Este metodo es ideal para sentencias DML como INSERT, UPDATE o DELETE, y
     * para sentencias DDL como CREATE TABLE.
     *
     * @param query La consulta SQL completa a ejecutar.
     * @return El numero de filas afectadas por la operacion.
     * @throws SQLException Si la consulta es invalida o si ocurre un error de
     * acceso a la base de datos.
     */
    public int execute(String query) throws SQLException;
}
