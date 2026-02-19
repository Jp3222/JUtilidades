/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import jsoftware.com.jutil.util.JFunc;

/**
 *
 * @author juanp
 */
public class AbstractDAO extends AbstractMonitoreableClass {

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
}
