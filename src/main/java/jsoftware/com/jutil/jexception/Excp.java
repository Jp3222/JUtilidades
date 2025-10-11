/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.jexception;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Excp {

    protected static final BufferedOutputStream bosExeption = new BufferedOutputStream(System.out);
    protected static final PrintWriter pwExeption = new PrintWriter(bosExeption);

    public static void closeExeptionBuffer() {
        try {
            pwExeption.close();
            bosExeption.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void impTerminal(Exception e, Class c, boolean stack) {
        String clase = "Error en la clase: " + c.getName();
        String mensaje = "Error lanzado: " + e.getMessage();
        System.out.println(clase);
        System.out.println(mensaje);
        System.out.println("pila");
        if (stack) {
            e.printStackTrace(pwExeption);
            closeExeptionBuffer();
        }
    }

    public static void impJopPane(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE);
    }

    public static void imp(Exception e, Class c, boolean stackProg, boolean mensajeUsuario) {
        if (mensajeUsuario) {
            impJopPane(e);
        }
        impTerminal(e, c, stackProg);
    }
    
    public static void SysExit(){
        System.exit(1);
    }
}
