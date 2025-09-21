/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.framework;

import com.jutil.dbcon.connection.JDBModels;

/**
 * Gestiona el inicio, el ciclo de vida y el apagado de la aplicación.
 * <p>
 * Esta clase implementa el patrón de diseño **Singleton** de manera segura para
 * hilos (thread-safe) para garantizar que solo exista una instancia del
 * lanzador de la aplicación. Delega las operaciones principales del sistema,
 * como la gestión de archivos, las conexiones a bases de datos y la caché, a un
 * objeto que implementa la interfaz {@link MainSystem}.
 *
 * @author juan-campos
 * @since 1.0
 */
public class LaunchApp implements MainSystem {

    //-------------------------------------------------------------------------
    // Atributos de la clase
    //-------------------------------------------------------------------------
    /**
     * La única instancia de la clase {@code LaunchApp}, que implementa el
     * patrón Singleton.
     */
    private static LaunchApp instance;

    /**
     * El sistema principal de la aplicación, responsable de manejar los eventos
     * del ciclo de vida.
     */
    private final MainSystem main;

    /**
     * Gestiona el estado de la sesión local de la aplicación.
     */
    private final LocalSession session;

    /**
     * Gestiona los modelos de tablas de la base de datos.
     */
    private final JDBModels tables;

    /**
     * Indicador para controlar si la caché principal de la aplicación debe
     * cargarse.
     */
    private boolean cache_load_main;

    /**
     * Indicador para controlar si el bucle de ejecución de la aplicación debe
     * reiniciarse.
     */
    private boolean reLoad;

    //-------------------------------------------------------------------------
    // Constructores y metodos Singleton
    //-------------------------------------------------------------------------
    /**
     * Devuelve la única instancia de {@code LaunchApp}, creándola si aún no
     * existe.
     * <p>
     * Este método es seguro para hilos (thread-safe).
     *
     * @param main La implementación de {@link MainSystem} que será utilizada
     * por el lanzador.
     * @return La única instancia compartida de {@code LaunchApp}.
     */
    public synchronized static LaunchApp getInstance(MainSystem main) {
        if (instance == null) {
            instance = new LaunchApp(main);
        }
        return instance;
    }

    /**
     * Devuelve la instancia única existente de {@code LaunchApp}.
     * <p>
     * Este método asume que la instancia ya ha sido creada. Es seguro para
     * hilos.
     *
     * @return La única instancia compartida de {@code LaunchApp}.
     */
    public synchronized static LaunchApp getInstance() {
        return instance;
    }

    /**
     * Constructor privado para el patrón Singleton.
     *
     * @param main El {@link MainSystem} principal a ser gestionado.
     */
    private LaunchApp(MainSystem main) {
        this(main, null, null);
    }

    /**
     * Constructor privado para el patrón Singleton, que permite inicializar
     * todos los atributos.
     *
     * @param main El {@link MainSystem} principal a ser gestionado.
     * @param session La {@link LocalSession} a ser utilizada por la aplicación.
     * @param tables Los {@link JDBModels} a ser utilizados por la aplicación.
     */
    private LaunchApp(MainSystem main, LocalSession session, JDBModels tables) {
        this.main = main;
        this.session = session;
        this.tables = tables;
    }

    //-------------------------------------------------------------------------
    // Delegacion de metodos de la interfaz MainSystem
    //-------------------------------------------------------------------------
    @Override
    public synchronized boolean conectionDB() {
        return main.conectionDB();
    }

    @Override
    public synchronized boolean appFiles() {
        return main.appFiles();
    }

    @Override
    public synchronized boolean cache() {
        return main.cache();
    }

    @Override
    public synchronized boolean run() {
        return main.run();
    }

    @Override
    public synchronized boolean openSys() {
        return main.openSys();
    }

    @Override
    public synchronized boolean closeSys() {
        return main.closeSys();
    }

    @Override
    public synchronized Object getResources(String key) {
        return main.getResources(key);
    }

    //-------------------------------------------------------------------------
    // Metodos del ciclo de vida de la aplicacion
    //-------------------------------------------------------------------------
    /**
     * Ejecuta el ciclo de vida estándar y lineal de la aplicación.
     * <p>
     * Este método realiza los siguientes pasos en secuencia: carga los
     * archivos, abre el sistema, se conecta a la base de datos, carga la caché
     * (si está habilitada), ejecuta la lógica principal de la aplicación,
     * espera una señal para detenerse y luego cierra el sistema.
     *
     * @throws InterruptedException Si el hilo es interrumpido mientras está
     * esperando.
     */
    public void main() throws InterruptedException {
        main.appFiles();
        main.openSys();
        main.conectionDB();
        if (cache_load_main) {
            main.cache();
        }
        synchronized (main) {
            main.run();
            main.wait();
        }
        main.closeSys();
    }

    /**
     * Ejecuta el ciclo de vida de la aplicación dentro de un bucle que puede
     * ser reiniciado.
     * <p>
     * El método realiza una configuración inicial, luego entra en un bucle para
     * ejecutar la lógica principal, esperar una señal y reiniciarse según el
     * estado del flag {@code reLoad}.
     *
     * @throws InterruptedException Si el hilo es interrumpido mientras está
     * esperando.
     */
    public void doWhileRun() throws InterruptedException {
        main.appFiles();
        main.openSys();
        do {
            main.conectionDB();
            if (cache_load_main) {
                main.cache();
            }
            synchronized (main) {
                main.run();
                main.wait();
            }
        } while (reLoad);
        main.closeSys();
    }

    //-------------------------------------------------------------------------
    // Metodos de configuracion (setters/getters)
    //-------------------------------------------------------------------------
    /**
     * Establece si la caché principal de la aplicación debe ser cargada.
     *
     * @param cache_load_main {@code true} para habilitar la carga de la caché;
     * {@code false} en caso contrario.
     */
    public void setCacheLoadMain(boolean cache_load_main) {
        this.cache_load_main = cache_load_main;
    }

    /**
     * Verifica si la carga de la caché principal de la aplicación está
     * habilitada.
     *
     * @return {@code true} si la carga de la caché está habilitada;
     * {@code false} en caso contrario.
     */
    public boolean isCacheLoadMain() {
        return cache_load_main;
    }

    /**
     * Establece si el bucle de ejecución de la aplicación debe reiniciarse.
     *
     * @param reLoad {@code true} para habilitar el reinicio del bucle;
     * {@code false} en caso contrario.
     */
    public void setReLoad(boolean reLoad) {
        this.reLoad = reLoad;
    }

    /**
     * Verifica si el reinicio del bucle de ejecución de la aplicación está
     * habilitado.
     *
     * @return {@code true} si el reinicio está habilitado; {@code false} en
     * caso contrario.
     */
    public boolean isReLoad() {
        return reLoad;
    }

    //-------------------------------------------------------------------------
    // Metodos para obtener atributos de la clase
    //-------------------------------------------------------------------------
    /**
     * Obtiene la instancia principal de {@link MainSystem} gestionada por este
     * lanzador.
     *
     * @return El objeto {@link MainSystem}.
     */
    public MainSystem getMain() {
        return main;
    }

    /**
     * Obtiene la instancia de {@link LocalSession} gestionada por este
     * lanzador.
     *
     * @return El objeto {@link LocalSession}.
     */
    public LocalSession getSession() {
        return session;
    }
}
