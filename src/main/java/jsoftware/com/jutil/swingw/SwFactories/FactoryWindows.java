/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.swingw.SwFactories;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 *
 * @author juan-campos
 */
public class FactoryWindows {

    private final Dimension size;

    public FactoryWindows() {
        this.size = new Dimension(500, 500);
    }

    public JWindow getWindow() {
        JWindow o = new JWindow();
        o.setPreferredSize(size);
        o.setSize(size);
        o.setLocationRelativeTo(null);
        return o;
    }

    public JFrame getFrame(String title) {
        return getFrame(title, true, true);
    }

    public JFrame getFrame(String title, boolean pack, boolean exit_on_close) {
        JFrame o = new JFrame(title);
        o.setPreferredSize(size);
        o.setSize(size);
        o.setLocationRelativeTo(null);
        if (exit_on_close) {
            o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (pack) {
            o.pack();
        }
        return o;
    }

    public JDialog getDialog(JFrame owner, String title, boolean modal) {
        JDialog o = new JDialog(owner, title, modal);
        return o;
    }
}
