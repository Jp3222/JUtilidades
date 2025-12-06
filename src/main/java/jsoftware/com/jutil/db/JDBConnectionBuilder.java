/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import com.zaxxer.hikari.HikariConfig;
import java.util.Properties;
import jsoftware.com.jutil.db.model.ObjectsFactory;

/**
 * Clase Builder para configurar y construir la conexión JDBC.
 *
 * @author juanp
 */
public class JDBConnectionBuilder {

    /**
     * Indicador para mostrar las consultas SQL en la consola con fines de
     * depuración. El valor por defecto es {@code false}.
     */
    protected boolean show_query;

    /**
     * Indicador para deshabilitar la ejecución real de las consultas SQL,
     * permitiendo un modo de simulación o "solo lectura". El valor por defecto
     * es {@code false}.
     */
    protected boolean exec_query;

    /**
     * Tamaño máximo del pool de conexiones.
     */
    protected int max_poll_size;

    /**
     * Tamaño mínimo de conexiones inactivas.
     */
    protected int minimum_idle;

    /**
     * Tiempo de espera.
     */
    protected int time_out;

    /**
     * Usuario de la base de datos.
     */
    protected String user;

    /**
     * Contraseña de la base de datos.
     */
    protected String password;

    /**
     * URL de conexión JDBC.
     */
    protected String url;

    /**
     * Propiedades de la conexión.
     */
    protected Properties properties;

    /**
     * Configuración de HikariCP.
     */
    protected HikariConfig db_config;
    /**
     *
     */
    private ObjectsFactory factory;

    public JDBConnectionBuilder() {
        // Valores por defecto
        this.show_query = false;
        this.exec_query = false;
        this.max_poll_size = 500;
        this.minimum_idle = 100;
        this.time_out = 100;
        this.user = null;
        this.password = null;
        this.url = null;
        this.properties = null;
        this.db_config = new HikariConfig();
    }

    // ====================================================================
    // --- MÉTODOS BUILDER (SETERS FLUENTES) ---
    // ====================================================================
    /**
     * Establece el indicador para mostrar las consultas SQL.
     */
    public JDBConnectionBuilder setShowQuery(boolean show_query) {
        this.show_query = show_query;
        return this;
    }

    /**
     * Establece el indicador para la ejecución real de las consultas.
     */
    public JDBConnectionBuilder setExecQuery(boolean exec_query) {
        this.exec_query = exec_query;
        return this;
    }

    /**
     * Establece el tamaño máximo del pool de conexiones.
     */
    public JDBConnectionBuilder setMaxPollSize(int max_poll_size) {
        this.max_poll_size = max_poll_size;
        this.db_config.setMaximumPoolSize(max_poll_size);
        return this;
    }

    /**
     * Establece el tamaño mínimo de conexiones inactivas.
     */
    public JDBConnectionBuilder setMinimumIdle(int minimum_idle) {
        this.minimum_idle = minimum_idle;
        this.db_config.setIdleTimeout(minimum_idle);
        return this;
    }

    /**
     * Establece el tiempo de espera (timeout).
     */
    public JDBConnectionBuilder setTimeOut(int time_out) {
        this.time_out = time_out;
        this.db_config.setConnectionTimeout(time_out);
        return this;
    }

    /**
     * Establece el nombre de usuario de la base de datos.
     */
    public JDBConnectionBuilder setUser(String user) {
        this.user = user;
        this.db_config.setUsername(user);
        return this;
    }

    /**
     * Establece la contraseña de la base de datos.
     */
    public JDBConnectionBuilder setPassword(String password) {
        this.password = password;
        this.db_config.setPassword(password);
        return this;
    }

    /**
     * Establece la URL de conexión JDBC.
     */
    public JDBConnectionBuilder setUrl(String url) {
        this.url = url;
        this.db_config.setJdbcUrl(url);
        return this;
    }

    public JDBConnectionBuilder setFactory(ObjectsFactory factory) {
        this.factory = factory;
        return this;
    }

    /**
     * Establece las propiedades de la conexión.
     */
    public JDBConnectionBuilder setProperties(Properties properties) {
        this.properties = properties;
        this.db_config = new HikariConfig(properties);
        return this;
    }

    public boolean isShow_query() {
        return show_query;
    }

    public boolean isExec_query() {
        return exec_query;
    }

    public int getMax_poll_size() {
        return max_poll_size;
    }

    public int getMinimum_idle() {
        return minimum_idle;
    }

    public int getTime_out() {
        return time_out;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public Properties getProperties() {
        return properties;
    }

    public HikariConfig getDb_config() {
        return db_config;
    }

    public ObjectsFactory getFactory() {
        return factory;
    }

}
