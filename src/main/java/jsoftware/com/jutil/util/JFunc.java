/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de utilidades con métodos estáticos para validación de datos. Incluye
 * validaciones básicas (texto, números) y documentos mexicanos (CURP, RFC).
 *
 * @author jp
 */
public abstract class JFunc {

    // --- Expresiones Regulares Básicas (Ajustadas y mejoradas) ---
    // ^ -> Inicio, $ -> Fin, + -> Uno o más caracteres
    // Solo letras, acentos, ñ/Ñ y espacios.
    public static String REGEX_ONLY_TEXT = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";

    // Números enteros (positivos o negativos: 1, -5, 0).
    public static String REGEX_INTEGER = "^-?\\d+$";

    // Números reales/decimales (positivos o negativos: 1.5, -0.5, 10).
    public static String REGEX_DECIMAL_NUMBER = "^-?\\d+(\\.\\d+)?$";

    // --- Expresiones Regulares Específicas ---
    // Email: Formato estándar (ej: usuario@dominio.com)
    public static String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    // Contraseña: Mínimo 8 caracteres, al menos una mayúscula, una minúscula y un número.
    public static String REGEX_PASSWORD_STRONG = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    // CURP: 18 caracteres. 4 letras, 6 números (fecha de nacimiento), 6 alfanuméricos (estado/género), 1 dígito verificador, 1 carácter final.
    public static String REGEX_CURP = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}[0-9]{2}$";

    // RFC con homoclave (13 caracteres: 4 letras, 6 números, 3 alfanuméricos)
    public static String REGEX_RFC_PERSONA = "^[A-Z]{4}\\d{6}[A-Z0-9]{3}$";

    // RFC moral (12 caracteres: 3 letras, 6 números, 3 alfanuméricos)
    public static String REGEX_RFC_EMPRESA = "^[A-Z]{3}\\d{6}[A-Z0-9]{3}$";

    // --- Métodos de Validación de Texto/Nombres ---
    /**
     * Valida que la cadena contenga solo letras, acentos y espacios.
     *
     * @param txt La cadena a validar (Ej: "Juan Pérez").
     */
    public static boolean isOnlyText(String txt) {
        if (isNullEmptyBlank(txt)) {
            return false;
        }
        // Se valida contra la expresión REGEX_ONLY_TEXT
        return txt.matches(REGEX_ONLY_TEXT);
    }

    // --- Métodos de Validación Específicos ---
    /**
     * Valida el formato de un correo electrónico.
     *
     * @param email La cadena a validar (Ej: "usuario@dominio.com").
     */
    public static boolean isValidEmail(String email) {
        if (isNullEmptyBlank(email)) {
            return false;
        }
        return email.matches(REGEX_EMAIL);
    }

    /**
     * Valida una contraseña fuerte: Mínimo 8 caracteres, al menos 1 mayúscula,
     * 1 minúscula y 1 número.
     *
     * @param password La contraseña a validar.
     */
    public static boolean isValidPassword(String password) {
        if (isNullEmptyBlank(password)) {
            return false;
        }
        return password.matches(REGEX_PASSWORD_STRONG);
    }

    /**
     * Valida el formato de una CURP (18 caracteres).
     *
     * @param curp La CURP a validar.
     */
    public static boolean isValidCurp(String curp) {
        if (isNullEmptyBlank(curp)) {
            return false;
        }
        // CURP se pasa a mayúsculas para la validación
        return curp.toUpperCase().matches(REGEX_CURP);
    }

    /**
     * Valida si la cadena es un RFC (persona física o moral) válido.
     *
     * @param rfc El RFC a validar.
     */
    public static boolean isValidRfc(String rfc) {
        if (isNullEmptyBlank(rfc)) {
            return false;
        }
        String rfcUpper = rfc.toUpperCase();

        // Verifica si coincide con el formato de persona física (13) O moral (12)
        return rfcUpper.matches(REGEX_RFC_PERSONA) || rfcUpper.matches(REGEX_RFC_EMPRESA);
    }

    // --- Métodos Numéricos (Ejemplo de uso de los campos REGEX_INTEGER, etc.) ---
    public static boolean isInteger(String txt) {
        if (isNullEmptyBlank(txt)) {
            return false;
        }
        return txt.matches(REGEX_INTEGER);
    }

    public static boolean isDecimalNumber(String txt) {
        if (isNullEmptyBlank(txt)) {
            return false;
        }
        return txt.matches(REGEX_DECIMAL_NUMBER);
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNullEmptyBlank(String o) {
        return isNull(o) || o.isEmpty() || o.isBlank();
    }

    public static boolean isNotNullEmptyBlank(String o) {
        return !isNullEmptyBlank(o);
    }

    public static Object ifNull(Object input, Object output_default) {
        if (isNotNull(input)) {
            return input;
        }
        return output_default;
    }

    public static String ifStringNull(String input, String output_default) {
        return ifNull(input, output_default).toString();
    }

    // Método auxiliar
    public static void addIfChanged(Map<String, Object> map, String key, String oldValue, String newValue) {
        if (oldValue == null && newValue != null && !newValue.isBlank()) {
            map.put(key, newValue);
        } else if (oldValue != null && newValue != null && !newValue.isBlank() && !oldValue.equals(newValue)) {
            map.put(key, newValue);
        }
    }

    /**
     * Pone una clave y un valor en el mapa si el valor no es nulo y no está en
     * blanco.
     *
     * @param map
     * @param key
     * @param value
     */
    public static void putIfPresentAndNotBlank(Map<String, Object> map, String key, Object value) {
        if (value != null && !value.toString().isBlank()) {
            map.put(key, value);
        }
    }

    /**
     * Pone una clave y un valor en el mapa si el valor no es nulo.
     *
     * @param map
     * @param key
     * @param value
     */
    public static void putIfNotNull(Map<String, Object> map, String key, Object value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    // -----------------------------------------------------------------
    // 1. Método Base Central (Manejo de Contenido y Nulidad)
    // -----------------------------------------------------------------
    /**
     * Recupera el valor de la clave del Map si está presente. Si la clave no
     * existe o el valor es null, retorna null.
     */
    public static Object getIfNotNull(Map<?, ?> map, String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Object value = map.get(key);
        // Retorna null si el valor recuperado es null
        return value;
    }

    // -----------------------------------------------------------------
    // 2. Métodos de Acceso Tipado y Seguro contra NULL
    // -----------------------------------------------------------------
    // --- Tipos String ---
    /**
     * Obtiene el valor como String. Retorna null si el valor es null o no
     * existe.
     */
    public static String getString(Map<?, ?> map, String key) {
        Object value = getIfNotNull(map, key);
        // Corrección: Usar toString() si no es null, de lo contrario, null.
        return value != null ? value.toString() : null;
    }

    // --- Tipos Numéricos Primitivos (int) ---
    /**
     * Obtiene el valor como int. Retorna el valorPorDefecto si es null o la
     * conversión falla.
     */
    public static int getInt(Map<?, ?> map, String key, int defaultValue) {
        Object value = getIfNotNull(map, key);
        if (value == null) {
            return defaultValue;
        }
        try {
            if (value instanceof Number) {
                return ((Number) value).intValue();
            }
            // Intenta parsear si es una cadena
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            // Manejo de error: la conversión falla
            return defaultValue;
        }
    }

    /**
     * Sobrecarga de getInt: Retorna 0 si es null o falla la conversión.
     */
    public static int getInt(Map<?, ?> map, String key) {
        return getInt(map, key, 0);
    }

    // --- Tipos Numéricos Wrapper (Integer) ---
    /**
     * Obtiene el valor como Integer (permite null).
     */
    public static Integer getInteger(Map<?, ?> map, String key) {
        Object value = getIfNotNull(map, key);
        if (value == null) {
            return null;
        }
        try {
            if (value instanceof Number number) {
                return number.intValue();
            }
            return Integer.valueOf(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // --- Tipos Decimales (BigDecimal) ---
    /**
     * Obtiene el valor como BigDecimal. Retorna null si el valor es null o la
     * conversión falla.
     */
    public static BigDecimal getBigDecimal(Map<?, ?> map, String key) {
        Object value = getIfNotNull(map, key);
        if (value == null) {
            return null;
        }
        try {
            if (value instanceof BigDecimal bigDecimal) {
                return bigDecimal;
            }
            // Utilizar String constructor para evitar pérdida de precisión con Double
            return new BigDecimal(value.toString());
        } catch (Exception e) {
            return null;
        }
    }

    // --- Tipos Fecha (LocalDate) ---
    /**
     * Obtiene el valor como LocalDate. Asume que el valor es una cadena en
     * formato ISO (YYYY-MM-DD).
     */
    public static LocalDate getLocalDate(Map<?, ?> map, String key) {
        String dateString = getString(map, key);
        if (dateString == null) {
            return null;
        }
        try {
            // Se asume el formato ISO estándar (YYYY-MM-DD)
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            // Manejo de error si el formato es incorrecto
            return null;
        }
    }

    // --- Tipos Booleanos ---
    /**
     * Obtiene el valor como boolean. Retorna false si es null, si es 0, o si es
     * la cadena "false".
     */
    public static boolean getBoolean(Map<?, ?> map, String key) {
        Object value = getIfNotNull(map, key);
        if (value == null) {
            return false;
        }
        if (value instanceof Boolean aBoolean) {
            return aBoolean;
        }
        String str = value.toString().toLowerCase();
        // Evalúa 1/true/yes/si como true
        return str.equals("true") || str.equals("1") || str.equals("yes") || str.equals("si");
    }

    /**
     * Compara dos mapas (Map<String, Object>) y devuelve un nuevo mapa con las
     * entradas que han cambiado o que son nuevas.
     *
     * La comparación de valores se realiza convirtiéndolos a String e ignorando
     * la capitalización (comportamiento similar al original, pero seguro).
     *
     * @param oldMap El mapa de referencia (valores antiguos).
     * @param newMap El mapa con los valores más recientes (valores nuevos).
     * @return Un mapa que contiene solo las entradas actualizadas o insertadas.
     */
    public static Map<String, Object> getChangedStringEntries(
            Map<String, Object> oldMap, Map<String, Object> newMap) {

        if (newMap == null || newMap.isEmpty()) {
            return new HashMap<>(); // Si el nuevo mapa está vacío, no hay cambios para reportar.
        }

        // Creamos el mapa de resultados (delta)
        Map<String, Object> changes = new HashMap<>();

        // Iteramos sobre el mapa más reciente (newMap) para detectar INSERCIONES y ACTUALIZACIONES
        for (Map.Entry<String, Object> newEntry : newMap.entrySet()) {
            String key = newEntry.getKey();
            Object newValue = newEntry.getValue();

            // 1. Caso de Adición (INSERT)
            if (!oldMap.containsKey(key)) {
                changes.put(key, newValue);
                continue; // Pasamos a la siguiente entrada
            }

            // 2. Caso de Actualización (UPDATE)
            Object oldValue = oldMap.get(key);

            // --- COMPARACIÓN SEGURA Y CASO-INSENSIBLE ---
            // Seguridad Nulo 1: Si ambos son nulos, no hay cambio.
            if (oldValue == null && newValue == null) {
                continue;
            }

            // Seguridad Nulo 2: Si solo uno es nulo, hay un cambio. (Se usa Objects.equals() para simplificar)
            // Ya que el código original usaba String, forzaremos la comparación case-insensitive:
            // Convertir a String, tratando nulo como cadena vacía para la comparación insensible
            String oldValStr = (oldValue != null) ? oldValue.toString() : "";
            String newValStr = (newValue != null) ? newValue.toString() : "";

            // Corregimos la lógica: Si las representaciones String NO son iguales, hay un cambio.
            if (!oldValStr.equalsIgnoreCase(newValStr)) {
                changes.put(key, newValue);
            }
        }

        // NOTA: Este método ignora las "Eliminaciones" (claves en oldMap que ya no están en newMap),
        // que es el comportamiento esperado para una función que prepara datos para un INSERT/UPDATE.
        return changes;
    }

    // --- Nuevas Expresiones Regulares ---
    // Teléfono: 10 dígitos (formato México)
    public static String REGEX_PHONE = "^\\d{10}$";

    // Código Postal: 5 dígitos
    public static String REGEX_CP = "^\\d{5}$";

    /**
     * Limpia un String para evitar caracteres maliciosos o espacios extra antes
     * de enviarlo a un query manual.
     */
    public static String sanitize(String input) {
        if (isNullEmptyBlank(input)) {
            return "";
        }
        return input.trim().replaceAll("['\";\\\\]", "");
    }

    /**
     * Convierte un valor del mapa a formato moneda ($ 0.00). Ideal para mostrar
     * saldos en el Wizard de pagos.
     */
    public static String getAsMoney(Map<?, ?> map, String key) {
        BigDecimal value = getBigDecimal(map, key);
        if (value == null) {
            return "$ 0.00";
        }
        return String.format("$ %.2f", value);
    }

    /**
     * Valida si un String es una fecha válida antes de intentar parsearla a
     * LocalDate (evita que el programa truene con fechas como 31/02/2024).
     */
    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determina si el cambio entre dos valores es "Significativo". Útil para no
     * disparar el HistoryDAO si solo cambió un espacio o una mayúscula.
     */
    public static boolean isSignificantChange(Object oldValue, Object newValue) {
        String s1 = (oldValue == null) ? "" : oldValue.toString().trim();
        String s2 = (newValue == null) ? "" : newValue.toString().trim();
        return !s1.equalsIgnoreCase(s2);
    }

    /**
     * Crea un "Map de Respuesta" rápido. Útil para tus controladores cuando
     * quieres devolver un estado de éxito/error.
     */
    public static Map<String, Object> createResponse(boolean success, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", message);
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

}
