/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.SwFactories;

import com.jutil.platf.So;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juan-campos
 */
public class FactorySw {

    public static void setDefaultLookAndFeel() {
        So.setDefaultLookAndFeel();
    }

    public static Dimension getDimension(int width, int height) {
        return new Dimension(width, height);
    }

    public static JPanel createDefaultField(String txt, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(txt), BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    public static JPanel createField(String txt, String alingTxt, JComponent component, String alingComp) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(txt), alingTxt);
        panel.add(component, alingComp);
        return panel;
    }

    public static JFrame getDefaultFrame() {
        return getFrame(500, 600, JFrame.EXIT_ON_CLOSE, true, true);
    }

    public static JFrame getFrame(int width, int height, int defaulCloseOperation, boolean visible, boolean pack) {
        JFrame frame = new JFrame("My Frame");
        frame.setPreferredSize(getDimension(width, height));
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(defaulCloseOperation);
        if (pack) {
            frame.pack();
        }
        frame.setVisible(visible);
        return frame;
    }

    public static JButton getButton(String txt) {
        return new JButton(txt);
    }

}
