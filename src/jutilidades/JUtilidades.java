/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jutilidades;

import com.jutil.configprog.Propiedades;
import com.jutil.soyjvm.So;
import java.io.File;

/**
 *
 * @author jp
 */
public class JUtilidades {

    public static void main(String[] args) throws Exception {
        Propiedades o = new Propiedades(new File(So.USER_HOME, "jutil.confi"));
        for (int i = 0; i < 3000; i++) {
            o.put("key " + i, i + "");
        }
        o.writer();
    }

}
