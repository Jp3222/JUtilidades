/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.soyjvm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jp
 */
public class So {

    public static String SO_NAME = System.getProperty("os.name");
    public static String SO_VERSION = System.getProperty("os.version");

    public static String USER_NAME = System.getProperty("user.name");
    public static String USER_HOME = System.getProperty("user.home");
    public static String USER_LANGUAJE = System.getProperty("user.language");
    public static String USER_DIR = System.getProperty("user.dir");

    public static boolean isWindows() {
        return SO_NAME.toLowerCase().contains("windows");
    }

    public static boolean isMac() {
        return SO_NAME.toLowerCase().contains("mac");
    }

    public static boolean isLinux() {
        return SO_NAME.toLowerCase().contains("linux");
    }

    public static void setDefaultLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(So.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
