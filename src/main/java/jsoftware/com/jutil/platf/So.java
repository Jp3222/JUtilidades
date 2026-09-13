package jsoftware.com.jutil.platf;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Clase utilitaria para acceder a información del sistema operativo,
 * propiedades del entorno de usuario, gestión de temas visuales (Swing
 * LookAndFeel) y resolución de datos de red locales.
 *
 * @author jp
 * @version 1.0
 */
public final class So {

    private static final Logger LOGGER = Logger.getLogger(So.class.getName());

    // =========================================================================
    // CONSTANTES DE PROPIEDADES DEL SISTEMA
    // =========================================================================
    /**
     * Código de país de dos letras del usuario actual (ej. "MX", "US").
     */
    public static final String USER_COUNTRY = System.getProperty("user.country");

    /**
     * Directorio de trabajo actual desde donde se ejecutó la aplicación.
     */
    public static final String USER_DIR = System.getProperty("user.dir");

    /**
     * Directorio raíz o personal del usuario del sistema operativo.
     */
    public static final String USER_HOME = System.getProperty("user.home");

    /**
     * Idioma configurado en el entorno del usuario (ej. "es", "en").
     */
    public static final String USER_LANGUAGE = System.getProperty("user.language");

    /**
     * Nombre de la cuenta de usuario con la que se ejecuta la sesión activa.
     */
    public static final String USER_NAME = System.getProperty("user.name");

    /**
     * Arquitectura del procesador del sistema operativo (ej. "amd64", "x86").
     */
    public static final String OS_ARCH = System.getProperty("os.arch");

    /**
     * Nombre del sistema operativo (ej. "Windows 11", "Linux", "Mac OS X").
     */
    public static final String OS_NAME = System.getProperty("os.name");

    /**
     * Versión del núcleo/sistema operativo subyacente.
     */
    public static final String OS_VERSION = System.getProperty("os.version");

    /**
     * Separador de rutas utilizado por el SO (ej. ";" en Windows, ":" en Unix).
     */
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");

    /**
     * Separador de salto de línea específico del SO (ej. "\r\n" en Windows,
     * "\n" en Unix).
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * Constructor privado para prevenir la instanciación de esta clase
     * utilitaria.
     */
    private So() {
        throw new UnsupportedOperationException("Clase utilitaria: no debe ser instanciada.");
    }

    // =========================================================================
    // IDENTIFICACIÓN DEL SISTEMA OPERATIVO
    // =========================================================================
    /**
     * Determina si el sistema operativo anfitrión pertenece a la familia
     * Microsoft Windows.
     *
     * @return {@code true} si el nombre del SO contiene "windows";
     * {@code false} en caso contrario.
     */
    public static boolean isWindows() {
        return soName("windows");
    }

    /**
     * Determina si el sistema operativo anfitrión pertenece a la familia Apple
     * macOS.
     *
     * @return {@code true} si el nombre del SO contiene "mac"; {@code false} en
     * caso contrario.
     */
    public static boolean isMac() {
        return soName("mac");
    }

    /**
     * Determina si el sistema operativo anfitrión es una distribución Linux.
     *
     * @return {@code true} si el nombre del SO contiene "linux"; {@code false}
     * en caso contrario.
     */
    public static boolean isLinux() {
        return soName("linux");
    }

    /**
     * Evalúa de forma no sensible a mayúsculas si el parámetro coincide con el
     * nombre del sistema operativo.
     *
     * @param name Nombre o fragmento de la plataforma a buscar.
     * @return {@code true} si el parámetro está contenido en {@link #OS_NAME}.
     */
    private static boolean soName(String name) {
        return OS_NAME != null && OS_NAME.toLowerCase().contains(name);
    }

    // =========================================================================
    // GESTIÓN DE LOOK AND FEEL (SWING)
    // =========================================================================
    /**
     * Establece el Look &amp; Feel nativo por defecto del sistema operativo
     * para la interfaz gráfica Swing.
     */
    public static void setDefaultLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, "Error al establecer el LookAndFeel por defecto del sistema", ex);
        }
    }

    /**
     * Establece el Look &amp; Feel mediante el nombre calificado de su clase.
     *
     * @param className Nombre de la clase que implementa el {@link LookAndFeel}
     * (ej. "com.sun.java.swing.plaf.windows.WindowsLookAndFeel").
     */
    public static void setDefaultLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, "Error al establecer el LookAndFeel: " + className, ex);
        }
    }

    /**
     * Establece el Look &amp; Feel pasando directamente una instancia válida.
     *
     * @param look Objeto de tipo {@link LookAndFeel} a aplicar a la interfaz.
     */
    public static void setDefaultLookAndFeel(LookAndFeel look) {
        try {
            UIManager.setLookAndFeel(look);
        } catch (UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, "El LookAndFeel especificado no es compatible en esta plataforma", ex);
        }
    }

    // =========================================================================
    // INFORMACIÓN DE RED LOCAL
    // =========================================================================
    /**
     * Obtiene el nombre del equipo host asignado en la red local.
     *
     * @return El nombre de host del dispositivo (ej. "LAPTOP-X123").
     * @throws UnknownHostException Si la dirección IP local no puede ser
     * resuelta.
     */
    public static String getHostName() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getHostName();
    }

    /**
     * Obtiene la dirección IP en formato numérico textual (IPv4 o IPv6).
     *
     * @return La dirección IP local representada como String (ej.
     * "192.168.1.15").
     * @throws UnknownHostException Si la dirección IP local no puede ser
     * resuelta.
     */
    public static String getHostAddress() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getHostAddress();
    }

    /**
     * Obtiene la dirección IP bruta del equipo como un arreglo de bytes.
     *
     * @return Arreglo de bytes con la representación binaria de la IP.
     * @throws UnknownHostException Si la dirección IP local no puede ser
     * resuelta.
     */
    public static byte[] getAddress() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getAddress();
    }

    /**
     * Obtiene el nombre de dominio cualificado (FQDN) para este host local.
     *
     * @return El nombre canónico del host (ej. "mi-equipo.midominio.com").
     * @throws UnknownHostException Si la dirección IP local no puede ser
     * resuelta.
     */
    public static String getCanonicalHostName() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getCanonicalHostName();
    }
    // =========================================================================
    // EJECUCIÓN DE COMANDOS DE CONSOLA / SISTEMA OPERATIVO
    // =========================================================================

    /**
     * Ejecuta un comando en la consola del sistema operativo detectado (Windows
     * via cmd.exe, Linux/Mac via /bin/sh) y retorna su salida estándar.
     *
     * @param command Comando o script a ejecutar en la consola.
     * @return {@link CommandResult} con el código de salida, salida estándar
     * (stdout) y error (stderr).
     * @throws java.io.IOException Si ocurre un error de E/S durante el inicio o
     * lectura del proceso.
     * @throws InterruptedException Si el hilo actual es interrumpido mientras
     * espera al proceso.
     */
    public static CommandResult executeCommand(String command) throws IOException, InterruptedException {
        return executeCommand(command, 30, java.util.concurrent.TimeUnit.SECONDS);
    }

    /**
     * Ejecuta un comando en la consola del sistema operativo con un tiempo
     * límite de espera (timeout).
     *
     * @param command Comando o script a ejecutar.
     * @param timeout Tiempo máximo a esperar antes de abortar el proceso.
     * @param unit Unidad de tiempo para el timeout.
     * @return Objeto {@link CommandResult} con el resultado detallado de la
     * ejecución.
     * @throws java.io.IOException Si ocurre un error de E/S.
     * @throws InterruptedException Si la ejecución es interrumpida.
     */
    public static CommandResult executeCommand(String command, long timeout, TimeUnit unit)
            throws java.io.IOException, InterruptedException {

        if (command == null || command.trim().isEmpty()) {
            throw new IllegalArgumentException("El comando a ejecutar no puede ser nulo o vacío.");
        }

        // Construir el comando según el Shell nativo del SO
        String[] shellCommand;
        if (isWindows()) {
            shellCommand = new String[]{"cmd.exe", "/c", command};
        } else if (isLinux() || isMac()) {
            shellCommand = new String[]{"/bin/sh", "-c", command};
        } else {
            // En caso de un SO Unix genérico no categorizado
            shellCommand = new String[]{"sh", "-c", command};
        }

        ProcessBuilder pb = new ProcessBuilder(shellCommand);
        Process process = pb.start();

        // Contenedores para capturar salidas
        StringBuilder stdout = new StringBuilder();
        StringBuilder stderr = new StringBuilder();

        // Leer la salida estándar y de error en hilos independientes para prevenir bloqueos de buffer
        Thread stdOutReader = new Thread(() -> readStream(process.getInputStream(), stdout));
        Thread stdErrReader = new Thread(() -> readStream(process.getErrorStream(), stderr));

        stdOutReader.start();
        stdErrReader.start();

        // Esperar finalización del proceso con Timeout
        boolean finished = process.waitFor(timeout, unit);

        if (!finished) {
            process.destroyForcibly(); // Forzar cierre si excede el tiempo
            stdOutReader.interrupt();
            stdErrReader.interrupt();
            return new CommandResult(-1, stdout.toString(), "Error: El comando superó el tiempo límite de espera (" + timeout + " " + unit.name() + ").");
        }

        stdOutReader.join();
        stdErrReader.join();

        return new CommandResult(process.exitValue(), stdout.toString().trim(), stderr.toString().trim());
    }

    /**
     * Utilidad privada para consumir los flujos de salida del proceso.
     */
    private static void readStream(java.io.InputStream is, StringBuilder destination) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(is, java.nio.charset.StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                destination.append(line).append(LINE_SEPARATOR);
            }
        } catch (java.io.IOException e) {
            // Manejo silencioso en interrupciones de stream
        }
    }

    // =========================================================================
    // CLASE INTERNA DE RESULTADO
    // =========================================================================
    /**
     * DTO inmutable que encapsula el resultado de la ejecución de un comando de
     * consola.
     */
    public static final class CommandResult {

        private final int exitCode;
        private final String stdout;
        private final String stderr;

        public CommandResult(int exitCode, String stdout, String stderr) {
            this.exitCode = exitCode;
            this.stdout = stdout;
            this.stderr = stderr;
        }

        public int getExitCode() {
            return exitCode;
        }

        public String getStdout() {
            return stdout;
        }

        public String getStderr() {
            return stderr;
        }

        public boolean isSuccess() {
            return exitCode == 0;
        }

        @Override
        public String toString() {
            return "CommandResult{"
                    + "exitCode=" + exitCode
                    + ", stdout='" + stdout + '\''
                    + ", stderr='" + stderr + '\''
                    + '}';
        }
    }
}
