/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jevtfun.eventosfuncionales.env;

import com.jutil.jevtfun.eventosfuncionales.EvtKey;
import com.jutil.jevtfun.eventosfuncionales.EvtMouse;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public class BorrarAlClick {

    private final JTextField componente;
    private final String textoInicial;
    private boolean click;
    private final EvtMouse evtMouse;
    private final EvtKey evtKey;

    public BorrarAlClick(JTextField componente, String textInicial) {
        this.componente = componente;
        this.textoInicial = textInicial;
        this.componente.setText(textInicial);
        this.click = false;
        this.evtMouse = new EvtMouse();
        this.eventos();
        this.evtKey = new EvtKey();
        this.componente.addMouseListener(evtMouse);
        this.componente.addKeyListener(evtKey);

    }

    private void eventos() {
        evtMouse.addME(evtMouse.MOUSE_CLICKED, (e) -> {
            if (!click) {
                componente.setText("");
                click = true;
            }
        });
    }

    public void defectoAlEnter() {
        evtKey.add(evtKey.KEY_PRESSED, (e) -> {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                defecto();
            }
        });
    }

    public void defectoAlBar() {
        evtKey.add(evtKey.KEY_PRESSED, (e) -> {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                defecto();
            }
        });
    }

    public void defecto() {
        click = false;
        componente.setText(textoInicial);
    }

}
