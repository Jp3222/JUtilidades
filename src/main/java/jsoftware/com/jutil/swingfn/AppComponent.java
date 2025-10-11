/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.swingfn;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 *
 * @author juan-campos
 */
@FunctionalInterface
public interface AppComponent {

    <T> JComponent component(T o);
}
