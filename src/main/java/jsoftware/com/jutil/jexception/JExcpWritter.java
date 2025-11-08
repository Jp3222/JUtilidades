/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.jexception;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author juanp
 */
public class JExcpWritter {

    public static final String INFO = "Info";
    public static final String ERROR = "Error";
    public static final String WARNING = "Advertencia";

    public static JExcpWritter instance;

    public static synchronized JExcpWritter getInstance(String path, String module_name) {
        if (instance == null) {
            instance = new JExcpWritter();
        }
        instance.setPath(path);
        instance.setModule_name(module_name);
        return instance;
    }

    private String path;
    private String module_name;

    public JExcpWritter() {
    }

    public void registerLog(String type, Class cls, Throwable error, String method, String msg) {
        StringBuilder sb = new StringBuilder(10000);
        sb.append(type).append(" { \n");
        sb.append("     ").append(type).append(" en la clase: ").append(cls.getName()).append("\n");
        sb.append("     ").append("En el metodo: ").append(method).append(": ").append(msg).append("\n");
        if (error != null) {
            putStackTrace(sb, error);
        }
        sb.append("}");
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
        String file_name = path + File.separator + fecha + File.separator + module_name + ".log";
        writeLogEntry(file_name, sb.toString());
    }

    private void putStackTrace(StringBuilder sb, Throwable e) {
        for (StackTraceElement i : e.getStackTrace()) {
            sb.append("     ").append(i.getClassName());
            sb.append(": ").append(i.getMethodName());
            sb.append("(line: ").append(i.getLineNumber()).append(")\n");
        }
    }

    /**
     * Escribe una entrada de log en un archivo específico, añadiéndola al
     * final.
     *
     * * @param fileName El nombre del archivo de log.
     * @param txt El texto a escribir.
     */
    private void writeLogEntry(String fileName, String txt) {
        // Asume que createFile(fileName) maneja la creación de la ruta/archivo.
        File file = createFile(fileName);

        // Usamos la clase Files y la codificación UTF-8
        try {
            // Files.write es más moderno. Usa StandardOpenOption.APPEND para añadir al final
            // Usa StandardOpenOption.CREATE para asegurar que el archivo exista
            java.nio.file.Files.write(
                    file.toPath(),
                    txt.getBytes(java.nio.charset.StandardCharsets.UTF_8),
                    java.nio.file.StandardOpenOption.APPEND,
                    java.nio.file.StandardOpenOption.CREATE
            );

        } catch (IOException e) {
            // El error de escritura de log es reportado
            System.getLogger(JExcpWritter.class.getName())
                    .log(System.Logger.Level.ERROR, "ERROR al escribir el log en: " + fileName, e);
        }
    }

    private File createFile(String file_name) {
        File file = null;
        boolean rt;
        try {
            file = new File(file_name);
            rt = file.createNewFile();
            return rt ? file : null;
        } catch (IOException e) {
            System.getLogger(JExcpWritter.class.getName()).log(System.Logger.Level.ERROR, "ARCHIVO CORRUPTO");
        }
        return file;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

}
