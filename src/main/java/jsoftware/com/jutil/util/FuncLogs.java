/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class FuncLogs {

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
     * Registra un mensaje de error en un archivo de log correspondiente a un
     * módulo específico.
     *
     * Este método construye un mensaje detallado que incluye: - Fecha y hora
     * del error - Nombre del módulo - Clase y método donde ocurrió el error (si
     * están disponibles) - Mensaje personalizado - Stack trace de la excepción
     * (si se proporciona)
     *
     * El mensaje se guarda en un archivo cuyo nombre se forma con el nombre del
     * módulo y la fecha/hora del error.
     *
     * @param cls Clase donde se produjo el error. Puede ser {@code null}.
     * @param e Excepción capturada. Si se proporciona, se registra el stack
     * trace.
     * @param modulo Nombre del módulo o componente que genera el log.
     * @param metodo Nombre del método donde ocurrió el error. Puede ser
     * {@code null}.
     * @param mensaje Mensaje personalizado que describe el error.
     */
    public static void logError(String log_path, Class<?> cls, Exception e, String modulo, String metodo, String mensaje) throws IOException {
        try {
            if (modulo == null || mensaje == null) {
                throw new IllegalArgumentException("El nombre del módulo y el mensaje no pueden ser nulos.");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(System.getProperty("line.separator"));
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss"));
            if (e == null) {
                sb.append(String.format("Info %s: %s - ", modulo, dateTime));
            } else {
                sb.append(String.format("Error en %s: %s {\n", modulo, dateTime));
            }
            if (cls != null) {
                sb.append("     Clase: ").append(cls.getName()).append("\n");
            }

            if (metodo != null) {
                //Error
                sb.append("     Método: ").append(metodo).append(" - ").append(mensaje).append("\n");
            } else {
                //info
                sb.append(mensaje);
            }
            if (e != null) {
                sb.append("Stack trace:\n");
                for (StackTraceElement element : e.getStackTrace()) {
                    sb.append("     ").append(element.getClassName());
                    sb.append(".").append(element.getMethodName());
                    sb.append(" (línea ").append(element.getLineNumber()).append(")\n");
                }
            }
            if (e != null) {
                sb.append("}\n");
            }
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
            String fileName = String.format("%s_%s.log", modulo, date);
            writerMessages(sb.toString(), log_path, fileName);
        } catch (IOException | IllegalArgumentException ex) {
            throw ex;
        }
    }

    /**
     * Escribe el contenido de texto especificado en un archivo ubicado en el
     * path y nombre indicados.
     *
     * Este método utiliza un flujo de salida con búfer para mejorar el
     * rendimiento de escritura. Si el archivo no existe, se intenta crear antes
     * de escribir.
     *
     * @param txt El texto que se desea escribir en el archivo.
     * @param path Ruta del directorio donde se ubicará el archivo.
     * @param file_name Nombre del archivo donde se escribirá el texto.
     */
    private static void writerMessages(String txt, String path, String file_name) throws FileNotFoundException, IOException {
        File file = getFile(path, file_name);
        try (OutputStream ops = new FileOutputStream(file, true); BufferedOutputStream bos = new BufferedOutputStream(ops)) {
            bos.write(txt.getBytes(StandardCharsets.UTF_8));
            bos.flush();
            ops.flush();
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
    }

    /**
     * Obtiene una instancia de archivo en la ruta y nombre especificados. Si el
     * archivo no existe, intenta crearlo.
     *
     * @param path Ruta del directorio donde se ubicará el archivo.
     * @param file_name Nombre del archivo.
     * @return El objeto {@link File} si el archivo existe o fue creado
     * exitosamente; de lo contrario, retorna {@code null}.
     */
    private static File getFile(String path, String file_name) throws IOException {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(path, file_name);
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;

        } catch (IOException e) {
            throw e;
        }
    }
}
