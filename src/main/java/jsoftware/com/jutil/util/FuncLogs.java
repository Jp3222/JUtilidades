/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class FuncLogs {

    // Formateadores reutilizables e inmutables (Evitan recarga en memoria en cada llamada)
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
    private static final DateTimeFormatter FILE_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd_MM_yyyy");

    /**
     * Registra un mensaje informativo en el log de un módulo específico.
     *
     * Este método es útil para registrar eventos o mensajes sin asociarlos a
     * una clase, método o excepción en particular.
     *
     * @param modulo Nombre del módulo o componente que genera el log.
     * @param mensaje Mensaje a registrar en el log.
     */
    public static void logError(String log_path, String modulo, String mensaje) throws IOException {
        logError(log_path, null, null, modulo, null, mensaje);
    }

    /**
     * Registra un mensaje informativo en el log de un módulo específico,
     * indicando el método donde ocurrió.
     *
     * Este método permite asociar el mensaje a un método específico, sin
     * necesidad de registrar una clase o excepción.
     *
     * @param modulo Nombre del módulo o componente que genera el log.
     * @param metodo Nombre del método donde se generó el mensaje.
     * @param mensaje Mensaje a registrar en el log.
     */
    public static void logError(String log_path, String modulo, String metodo, String mensaje) throws IOException {
        logError(log_path, null, null, modulo, metodo, mensaje);
    }

    /**
     * Registra un mensaje de error en el log de un módulo específico,
     * incluyendo el stack trace de una excepción.
     *
     * Este método es útil para registrar errores que incluyen una excepción,
     * permitiendo rastrear el origen del problema.
     *
     * @param e Excepción capturada que se desea registrar.
     * @param modulo Nombre del módulo o componente que genera el log.
     * @param metodo Nombre del método donde ocurrió el error.
     * @param mensaje Mensaje descriptivo del error.
     */
    public static void logError(String log_path, Exception e, String modulo, String metodo, String mensaje) throws IOException {
        logError(log_path, null, e, modulo, metodo, mensaje);
    }

    /**
     * Registra un mensaje operativo o una excepción en el archivo log del
     * módulo correspondiente.
     */
    public static void logError(String logPath, Class<?> cls, Exception e, String modulo, String metodo, String mensaje) throws IOException {
        if (modulo == null || mensaje == null) {
            throw new IllegalArgumentException("El nombre del módulo y el mensaje no pueden ser nulos.");
        }

        StringBuilder sb = new StringBuilder(256);
        sb.append(System.lineSeparator()); // Usa el salto de línea nativo del sistema de ejecución

        String dateTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);

        if (e == null) {
            sb.append(String.format("Info %s: %s - ", modulo, dateTime));
        } else {
            sb.append(String.format("Error en %s: %s {\n", modulo, dateTime));
        }

        if (cls != null) {
            sb.append("     Clase: ").append(cls.getName()).append("\n");
        }

        if (metodo != null) {
            sb.append("     Método: ").append(metodo).append(" - ").append(mensaje).append("\n");
        } else {
            sb.append(mensaje);
        }

        // Volcado fiel del Stack Trace sin iteraciones manuales ineficientes
        if (e != null) {
            sb.append("Stack trace:\n");
            try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
                e.printStackTrace(pw);
                sb.append(sw.toString());
            }
            sb.append("}\n");
        }

        String dateStr = LocalDate.now().format(FILE_DATE_FORMATTER);
        String fileName = String.format("%s_%s.log", modulo, dateStr);

        writeMessages(sb.toString(), logPath, fileName);
    }

    /**
     * Escribe el contenido utilizando la API NIO de Java, optimizando la
     * creación de directorios y el volcado de bytes de forma segura.
     */
    private static void writeMessages(String txt, String path, String fileName) throws IOException {
        Path directory = Paths.get(path);

        // Crea los directorios padres de forma segura si no existen
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        Path targetFile = directory.resolve(fileName);

        // CREATE: Si no existe lo crea, APPEND: Si existe concatena al final de forma atómica
        Files.writeString(
                targetFile,
                txt,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}
