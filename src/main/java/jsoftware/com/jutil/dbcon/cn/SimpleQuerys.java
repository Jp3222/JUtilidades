/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.dbcon.cn;

/**
 * Almacena plantillas de consultas SQL estandar y simples para uso común.
 * <p>
 * Estas constantes son útiles para construir consultas SQL de forma dinámica
 * usando metodos de formato como {@link String#format(String, Object...)}.
 * <p>
 * <b>Advertencia de Seguridad:</b> El uso directo de estas plantillas con
 * entrada de usuario puede exponer la aplicacion a ataques de inyeccion SQL. Se
 * recomienda encarecidamente utilizar {@link java.sql.PreparedStatement} para
 * un manejo seguro de los datos.
 *
 * @author juan-campos
 * @since 1.0
 */
public interface SimpleQuerys {

    /**
     * Plantilla SQL para una insercion de un solo valor por columna.
     * <p>
     * Formato: {@code INSERT INTO <table> (<columns>) VALUES (<values>)}
     * <p>
     * <ul>
     * <li>{@code %s}: Nombre de la tabla</li>
     * <li>{@code %s}: Lista de columnas (ej. "nombre, edad")</li>
     * <li>{@code %s}: Marcadores de posicion de valores (ej. "?, ?") o valores
     * literales (ej. "'Juan', 30")</li>
     * </ul>
     */
    public static final String INSERT_VAL = "INSERT INTO %s (%s) values (%s)";

    /**
     * Plantilla SQL para una insercion de multiples filas.
     * <p>
     * Formato: {@code INSERT INTO <table> (<columns>) VALUES <rows>}
     * <p>
     * <ul>
     * <li>{@code %s}: Nombre de la tabla</li>
     * <li>{@code %s}: Lista de columnas (ej. "nombre, edad")</li>
     * <li>{@code %s}: Grupos de valores separados por coma (ej. "('Juan', 30),
     * ('Ana', 25)")</li>
     * </ul>
     */
    public static final String INSERT_COL = "INSERT INTO %s (%s) values %s";

    /**
     * Plantilla SQL para una consulta de seleccion con clausula WHERE.
     * <p>
     * Formato: {@code SELECT <columns> FROM <table> WHERE <condition>}
     * <p>
     * <ul>
     * <li>{@code %s}: Lista de columnas a seleccionar (ej. "*", "id,
     * nombre")</li>
     * <li>{@code %s}: Nombre de la tabla</li>
     * <li>{@code %s}: Condicion de filtro (ej. "id = ?")</li>
     * </ul>
     */
    public static final String SELECT = "SELECT %s FROM %s WHERE %s";

    /**
     * Plantilla SQL para una actualizacion de un solo valor.
     * <p>
     * Formato:
     * {@code UPDATE <table> SET <column> = '<value>' WHERE <condition>}
     * <p>
     * <ul>
     * <li>{@code %s}: Nombre de la tabla</li>
     * <li>{@code %s}: Nombre de la columna a actualizar</li>
     * <li>{@code %s}: Nuevo valor para la columna</li>
     * <li>{@code %s}: Condicion para el filtro (ej. "id = 1")</li>
     * </ul>
     */
    public static final String UPDATE_VAL = "UPDATE %s SET %s = '%s' WHERE %s";

    /**
     * Plantilla SQL para una actualizacion de multiples valores en una o varias
     * columnas.
     * <p>
     * Formato: {@code UPDATE <table> SET <assignments> WHERE <condition>}
     * <p>
     * <ul>
     * <li>{@code %s}: Nombre de la tabla</li>
     * <li>{@code %s}: Asignaciones de valores (ej. "nombre='Ana',
     * edad=25")</li>
     * <li>{@code %s}: Condicion para el filtro (ej. "id = 1")</li>
     * </ul>
     */
    public static final String UPDATE_COL = "UPDATE %s SET %s WHERE %s";

    /**
     * Plantilla SQL para una eliminacion de registros.
     * <p>
     * Formato: {@code DELETE FROM <table> WHERE <condition>}
     * <p>
     * <ul>
     * <li>{@code %s}: Nombre de la tabla</li>
     * <li>{@code %s}: Condicion para el filtro (ej. "id = 1")</li>
     * </ul>
     */
    public static final String DELETE = "DELETE FROM %s WHERE %s";

    /**
     * Plantilla SQL para contar registros.
     * <p>
     * Formato: {@code SELECT COUNT(<column>) FROM <table>}
     * <p>
     * <ul>
     * <li>{@code %s}: Columna a contar (ej. "*", "id")</li>
     * <li>{@code %s}: Nombre de la tabla</li>
     * </ul>
     */
    public static final String COUNT = "SELECT COUNT(%s) FROM %s";

    /**
     * Plantilla SQL para encontrar el valor maximo en una columna.
     * <p>
     * Formato: {@code SELECT MAX(<column>) FROM <table>}
     * <p>
     * <ul>
     * <li>{@code %s}: Columna a evaluar</li>
     * <li>{@code %s}: Nombre de la tabla</li>
     * </ul>
     */
    public static final String MAX = "SELECT MAX(%s) FROM %s";
}
