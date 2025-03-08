/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.util;

import java.io.File;

/**
 *
 * @author juan-campos
 */
public interface JFuncFiles {

    public static boolean isNull(File file) {
        return JFunc.isNull(file);
    }

    public static boolean fileOK(File file) {
        return !isNull(file) && file.exists() && file.isFile();
    }

    public static boolean dirOK(File dir) {
        return !isNull(dir) && dir.exists() && dir.isDirectory();
    }

}
