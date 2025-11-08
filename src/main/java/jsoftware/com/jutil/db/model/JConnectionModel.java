/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.model;

import java.io.Serializable;
import java.sql.Connection;

/**
 * Proporciona una API de alto nivel para la gestión simplificada de conexiones
 * de base de datos JDBC.
 * <p>
 * Esta interfaz abstrae las operaciones de bajo nivel de la clase
 * {@link java.sql.Connection}, ofreciendo métodos "envoltorio" para tareas
 * comunes como establecer el auto-commit, realizar confirmaciones (commit) y
 * deshacer (rollback) transacciones, manejando las excepciones
 * {@link java.sql.SQLException} internamente.
 * <p>
 * Al extender {@link java.io.Serializable}, permite que los objetos que la
 * implementan puedan ser serializados. Al extender
 * {@link java.lang.AutoCloseable}, asegura que los recursos de la conexión se
 * cierren de forma segura y automática cuando se usa en un bloque
 * try-with-resources.
 *
 * @author juan-campos
 * @since 1.0
 */
public interface JConnectionModel extends Serializable, AutoCloseable {

    static final int INTANCE_LITE = 1;
    static final int INTANCE_PROPERTIES = 2;
    static final int INTANCE_CREDENTIALS = 3;
    static final int INTANCE_POLL = 4;
    static final int INTANCE_POLL_CONFIG = 5;

    /**
     * Proporciona acceso al objeto de conexión JDBC subyacente.
     * <p>
     * Este método es útil cuando se necesita realizar operaciones directas o
     * avanzadas que no están cubiertas por la API de alto nivel de esta clase.
     *
     * @return El objeto {@link Connection} actualmente en uso, que no debe ser
     * cerrado directamente por el código que lo llama.
     */
    Connection getConnection();

    /**
     * Establece el modo de confirmación automática (auto-commit) para el objeto
     * de conexión subyacente.
     * <p>
     * Este método es un "envoltorio" que simplifica la llamada al método
     * {@code setAutoCommit} de la conexión JDBC, manejando la excepción
     * {@link java.sql.SQLException} internamente. Esto permite al código
     * cliente habilitar o deshabilitar las transacciones sin tener que usar
     * bloques try-catch.
     *
     * @param auto {@code true} para habilitar el modo de auto-commit (cada
     * sentencia es una transacción); {@code false} para deshabilitarlo (se
     * necesita una confirmación manual con commit).
     */
    void setAutoCommit(boolean auto);

    /**
     * Deshace (rollback) la transacción actual en la conexión subyacente.
     * <p>
     * Este método es un "envoltorio" que simplifica el proceso de llamar al
     * método {@code rollback()} de la conexión JDBC, manejando la excepción
     * {@link java.sql.SQLException} internamente. Se utiliza para revertir
     * todos los cambios realizados en una transacción desde el último punto de
     * confirmación o desde el inicio de la transacción, si el auto-commit está
     * deshabilitado.
     */
    void rollBack();

    /**
     * Confirma (commit) la transacción actual en la conexión subyacente.
     * <p>
     * Este método es un "envoltorio" que simplifica el proceso de llamar al
     * método {@code commit()} de la conexión JDBC, manejando la excepción
     * {@link java.sql.SQLException} internamente. Se utiliza para guardar
     * permanentemente todos los cambios realizados en la transacción actual,
     * asumiendo que el modo de auto-commit está deshabilitado.
     */
    void commit();

    /**
     * Establece si las consultas SQL deben mostrarse en la consola.
     * <p>
     * Este método se utiliza con fines de depuración y análisis para visualizar
     * las consultas que se ejecutan contra la base de datos.
     *
     * @param flag {@code true} para habilitar la visualización del query;
     * {@code false} para deshabilitarla.
     */
    void setShowQuery(boolean flag);

    /**
     * Verifica si la visualización de las consultas SQL está habilitada.
     *
     * @return {@code true} si la visualización del query está habilitada;
     * {@code false} en caso contrario.
     */
    boolean isShowQuery();

    /**
     * Habilita o deshabilita la ejecución de consultas SQL.
     * <p>
     * Este método se utiliza con fines de depuración y pruebas para controlar
     * si las consultas a la base de datos deben ejecutarse realmente o ser
     * ignoradas, por ejemplo, en un modo de simulación o "solo lectura".
     *
     * @param flag {@code true} para permitir la ejecución de las consultas;
     * {@code false} para impedir su ejecución.
     */
    void setExceQuery(boolean flag);

    /**
     * Verifica si la ejecución de consultas SQL está habilitada.
     *
     * @return {@code true} si las consultas pueden ejecutarse; {@code false} en
     * caso contrario.
     */
    boolean canExceQuery();
}
