package jsoftware.com.jutil.db.abstr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsoftware.com.jutil.db.JDBConnection;
import jsoftware.com.jutil.db.model.JPrepareStamentModel;

public class AbstractPsConnection implements JPrepareStamentModel {

    private JDBConnection connection;

    public AbstractPsConnection(JDBConnection connection) {
        this.connection = connection;
    }

    /**
     * Ejecuta una consulta (SELECT) con parámetros.
     *
     * @param query La sentencia SQL con placeholders (?).
     * @param query_args Los valores de los parámetros.
     * @return El ResultSet de la consulta.
     */
    @Override
    public ResultSet query(String query, String[] query_args) {
        ResultSet res = null;
        try (PreparedStatement ps = connection.getNewPreparedStatement(query)) {
            if (query_args != null) {
                // CORRECCIÓN CLAVE: El índice debe incrementarse.
                for (int i = 0; i < query_args.length; i++) {
                    // JDBC usa índices base 1, por lo que se usa (i + 1)
                    ps.setString(i + 1, query_args[i]);
                }
            }
            // NOTA: El ResultSet no se cierra aquí. La capa que llama DEBE cerrarlo.
            res = ps.executeQuery();
        } catch (SQLException e) {
            // Manejo de errores
            throw new RuntimeException("Error al ejecutar consulta: " + query, e);
        }
        return res;
    }

    /**
     * Ejecuta una actualización (INSERT, UPDATE, DELETE).
     *
     * @param query La sentencia SQL con placeholders (?).
     * @param args Los valores de los parámetros.
     * @return El número de filas afectadas.
     */
    @Override
    // CORRECCIÓN TIPOGRÁFICA: Cambiado de 'excecute' a 'execute'
    public int execute(String query, String[] args) {
        int res = -1;
        try (PreparedStatement ps = connection.getNewPreparedStatement(query)) {
            if (args != null) {
                // CORRECCIÓN CLAVE: El índice debe incrementarse.
                for (int i = 0; i < args.length; i++) {
                    // JDBC usa índices base 1, por lo que se usa (i + 1)
                    ps.setString(i + 1, args[i]);
                }
            }
            res = ps.executeUpdate();
        } catch (Exception e) {
            // Manejo de errores
            throw new RuntimeException("Error al ejecutar actualización: " + query, e);
        }
        return res;
    }
}
