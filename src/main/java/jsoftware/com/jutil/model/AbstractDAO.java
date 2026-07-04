/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import jsoftware.com.jutil.util.JFunc;

/**
 *
 * @author juanp
 */
public class AbstractDAO extends AbstractMonitoreableClass {

    public static final int INSERT_DEFAULT_RETURN = -1;

    public static final boolean UPDATE_DEFAULT_RETURN = false;

    public static final boolean DELETE_DEFAULT_RETURN = false;

    public AbstractDAO(boolean flag_dev_log, String name_module) {
        super(flag_dev_log, name_module);
    }

    /**
     * Inserta un valor de forma segura en un PreparedStatement, gestionando
     * valores nulos.
     * <p>
     * Este método centraliza la lógica de "Null-Safety". Si el objeto es nulo
     * según {@link JFunc#isNull}, utiliza {@code setNull} con el tipo
     * {@link java.sql.Types#OTHER}. En caso contrario, delega al driver la
     * inferencia del tipo mediante {@code setObject}.</p>
     *
     * * @param ps El {@link PreparedStatement} en el que se inyectará el
     * parámetro.
     * @param index La posición del parámetro (basado en 1).
     * @param value El objeto a insertar (puede ser String, Integer, Double,
     * Date o null).
     * @throws SQLException Si ocurre un error de acceso a la base de datos o el
     * driver no soporta Types.OTHER.
     */
    public void setNull(PreparedStatement ps, int index, Object value) throws SQLException {
        if (JFunc.isNull(value)) {
            // Nota: En MySQL Types.NULL o Types.VARCHAR suelen ser más compatibles que OTHER
            ps.setNull(index, Types.NULL);
            return;
        }
        ps.setObject(index, value);
    }

    /**
     * Convierte de manera genérica y automática la fila actual de un ResultSet
     * en un mapa de Strings, utilizando la metadata de las columnas.
     * <br><br>
     * <strong>Nota de uso:</strong> Esta función NO avanza el cursor (no invoca
     * a {@code rs.next()}), por lo que debe ser llamada cuando el ResultSet ya
     * se encuentre posicionado en una fila válida.
     *
     * @param rs ResultSet activo y posicionado en la fila a extraer.
     * @return Un mapa con los datos de la fila actual indexado por las columnas
     * en minúsculas.
     * @throws SQLException Si ocurre un error de lectura física en el driver de
     * MySQL.
     */
    public Map<String, Object> getMap(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int size = md.getColumnCount();

        // 1. Extraemos las etiquetas o alias de la consulta SQL
        String[] fields = new String[size];
        for (int i = 0; i < size; i++) {
            fields[i] = md.getColumnLabel(i + 1);
        }

        // Capacidad inicial optimizada para albergar los campos sin redimensionar
        Map<String, Object> map = new HashMap<>(26);

        // 2. Mapeo directo de la fila actual
        for (String column : fields) {
            String key = column.toLowerCase();
            String value = rs.getString(column);

            // Sanitización defensiva: Evitamos nulos transformándolos en cadenas vacías limpias
            map.put(key, (value != null) ? value.trim() : "");
        }

        return map;
    }
}
