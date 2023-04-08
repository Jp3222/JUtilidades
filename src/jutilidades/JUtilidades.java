/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jutilidades;

import com.jutil.jswing.jswingenv.comp.Tabla;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author jp
 */
public class JUtilidades {
    
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Tabla con buscador");
        Dimension dimensiones = new Dimension(300, 300);
        frame.setSize(dimensiones);
        frame.setPreferredSize(dimensiones);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //
        Tabla tabla = new Tabla();
        tabla.crearBarraSuperior("Buscar");
        tabla.setSize(dimensiones);
        
        frame.add(tabla);
        frame.setVisible(true);
    }
    
}
