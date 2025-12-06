/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.model;

import java.sql.ResultSet;

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

    public ResultSet query(String query, String[] query_args);

    public int execute(String query, String[] args);
}
