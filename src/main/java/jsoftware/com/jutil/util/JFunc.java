/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

/**
 * Clase de utilidades con métodos estáticos para validación de datos. Incluye
 * validaciones básicas (texto, números) y documentos mexicanos (CURP, RFC).
 *
 * @author jp
 */
public interface JFunc {

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
}
