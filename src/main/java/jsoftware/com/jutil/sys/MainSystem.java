/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.sys;

/**
 * Proporciona una API para la configuración y gestión del ciclo de vida de una
 * aplicación.
 * <p>
 * Esta interfaz define un contrato para inicializar recursos, manejar la
 * configuración, y controlar el inicio y cierre del sistema de manera
 * estructurada.
 *
 * @author jp
 * @since 1.0
 */
public interface MainSystem {

    /**
     * Inicializa la conexión a la base de datos de la aplicación.
     * <p>
     * Este método se encarga de establecer la conexión con la base de datos y
     * realizar cualquier configuración inicial necesaria.
     *
     * @return {@code true} si la conexión se establece correctamente;
     * {@code false} en caso contrario.
     */
    boolean conectionDB();

    /**
     * Lee y procesa los archivos de configuración necesarios para la
     * aplicación.
     * <p>
     * Este método es responsable de cargar archivos de propiedades, de
     * configuración o cualquier otro recurso vital para el funcionamiento del
     * sistema.
     *
     * @return {@code true} si todos los archivos se leen y procesan
     * correctamente; {@code false} si falla la lectura.
     */
    boolean appFiles();

    /**
     * Inicializa la memoria caché del sistema.
     * <p>
     * Se utiliza para precargar datos o configuraciones en memoria para un
     * acceso rápido.
     *
     * @return {@code true} si la caché se inicializa correctamente;
     * {@code false} si falla.
     */
    boolean cache();

    /**
     * Inicia los servicios y procesos principales del sistema.
     * <p>
     * Este es el método principal que pone en marcha la aplicación después de
     * que todos los recursos y configuraciones han sido cargados.
     *
     * @return {@code true} si el sistema se inicia correctamente; {@code false}
     * en caso contrario.
     */
    boolean run();

    /**
     * Abre recursos compartidos del sistema.
     * <p>
     * Puede ser utilizado para inicializar conexiones de red, flujos de E/S u
     * otros recursos que deben estar disponibles durante la ejecución.
     *
     * @return {@code true} si los recursos se abren correctamente;
     * {@code false} si falla.
     */
    boolean openSys();

    /**
     * Cierra y libera los recursos del sistema.
     * <p>
     * Este método se utiliza para realizar una limpieza ordenada al finalizar
     * la ejecución, cerrando conexiones de base de datos, flujos de E/S, etc.
     *
     * @return {@code true} si los recursos se cierran correctamente;
     * {@code false} si falla.
     */
    boolean closeSys();

    /**
     * Recupera un recurso compartido del sistema por su clave.
     * <p>
     * Permite acceder a objetos de configuración o recursos como una instancia
     * de conexión a la base de datos o un objeto {@code Properties} que
     * contiene las configuraciones cargadas.
     *
     * @param key La clave o nombre del recurso a recuperar.
     * @return El objeto del recurso solicitado, o {@code null} si no se
     * encuentra la clave.
     */
    Object getResources(String key);
}
