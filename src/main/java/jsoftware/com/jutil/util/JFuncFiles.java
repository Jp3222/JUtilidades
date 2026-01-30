/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.util;

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

    public static int filesCount(String url) {
        return filesCount(new File(url), 0);
    }

    public static int filesCount(File root, int count) {
        if ((root == null || !root.exists()) || ((root.isDirectory() || root.isFile()) && !root.canRead())) {

            return count;
        }
        if (root.listFiles() == null) {
            return count;
        }
        for (File i : root.listFiles()) {
            if (i.isFile()) {
                count += 1;
            } else {
                count = filesCount(i, count);
            }
        }
        return count;
    }

}
