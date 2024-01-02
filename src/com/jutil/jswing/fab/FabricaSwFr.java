/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jswing.fab;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author jp
 */
public final class FabricaSwFr {

    public static JFrame JFrameExit() {
        JFrame o = new JFrame();
        o.pack();
        o.setSize(500, 500);
        o.getPreferredSize().setSize(o.getSize());
        o.setLocationRelativeTo(null);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        o.setLayout(new BorderLayout());
        return o;
    }

    public static JFrame JFrameDispose() {
        JFrame o = JFrameExit();
        o.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return o;
    }
}
