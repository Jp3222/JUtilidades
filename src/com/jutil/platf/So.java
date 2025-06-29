/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.platf;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jp
 */
public class So {

    public static final String USER_COUNTRY = System.getProperty("user.country");
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String USER_LANGUAGE = System.getProperty("user.language");
    public static final String USER_NAME = System.getProperty("user.name");
    public static final String OS_ARCH = System.getProperty("os.arch");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static boolean isWindows() {
        return soName("windows");
    }

    public static boolean isMac() {
        return soName("mac");
    }

    public static boolean isLinux() {
        return soName("linux");
    }

    private static boolean soName(String name) {
        return OS_NAME.toLowerCase().contains(name);
    }

    public static void setDefaultLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(So.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setDefaultLookAndFeel(String name) {
        try {
            UIManager.setLookAndFeel(name);
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(So.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setDefaultLookAndFeel(LookAndFeel look) {
        try {
            UIManager.setLookAndFeel(look);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(So.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
