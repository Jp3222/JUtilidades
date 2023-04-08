/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.soyjvm;

/**
 *
 * @author jp
 */
public class SoInfo {

    public static String NOMBRE = System.getProperty("so.name");
    public static String HOME = System.getProperty("user.home");
    public static String IDIOMA = System.getProperty("user.le");
    public static String S = System.getProperty("user.home");

    public static boolean isWindows() {
        return NOMBRE.toLowerCase().contains("windows");
    }

    public static boolean isMac() {
        return NOMBRE.toLowerCase().contains("mac");
    }

    public static boolean isLinux() {
        return NOMBRE.toLowerCase().contains("linux");
    }
}
