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
public interface JFiles {

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
        //System.out.println(root.getName());
        for (File i : root.listFiles()) {
            if (i.isFile()) {
                count += 1;
                //System.out.println(i.getName() + ": " + count);
            } else {
                count = filesCount(i, count);
            }
        }
        return count;
    }

}
