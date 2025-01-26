/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.SwFactories;

import java.awt.Dimension;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author juan-campos
 */
public class FactorySw {

    public static void setDefaultLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FactorySw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean setLookAndFeel(int index) {
        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        if (index < 0 && index >= installedLookAndFeels.length) {
            return false;
        }
        try {
            UIManager.setLookAndFeel(installedLookAndFeels[index].getClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FactorySw.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
    
    public static FactoryComponents getCompontent(){
        return FactoryComponents.get();
    }
    
    public static FactoryPanels getPanels(){
        return null;
    }

}
