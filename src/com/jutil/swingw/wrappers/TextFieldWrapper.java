/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.wrappers;

import com.jutil.jevtfun.eventosfuncionales.EvtKey;
import com.jutil.jevtfun.eventosfuncionales.EvtMouse;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public class TextFieldWrapper {

    private final JTextField componente;
    private final String texto_inicial;
    private final EvtMouse eventos_mouse;
    private final EvtKey eventos_teclado;
    private boolean texto_borrado;

    public TextFieldWrapper(JTextField componente, String textInicial) {
        this.componente = componente;
        this.texto_inicial = textInicial;
        this.componente.setText(textInicial);
        this.texto_borrado = false;
        this.eventos_mouse = new EvtMouse();
        this.eventos_teclado = new EvtKey();
        this.componente.addMouseListener(eventos_mouse);
        this.componente.addKeyListener(eventos_teclado);

    }

    public void borrarAlClick() {
        eventos_mouse.addME(eventos_mouse.MOUSE_CLICKED, (e) -> {
            if (!texto_borrado) {
                componente.setText("");
                texto_borrado = true;
            }
        });
    }

    public void borrarAlFoco() {
        componente.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if (!texto_borrado) {
                    componente.setText("");
                    texto_borrado = true;
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
    }

    public void borrarAlEscribir() {
        eventos_teclado.add(eventos_teclado.KEY_TYPED, (e) -> {
            if (!texto_borrado) {
                componente.setText("");
                texto_borrado = true;
            }
        });
    }

    public void defectoAlEnter() {
        eventos_teclado.add(eventos_teclado.KEY_PRESSED, (e) -> {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                defecto();
            }
        });
    }

    public void defectoAlBar() {
        eventos_teclado.add(eventos_teclado.KEY_PRESSED, (e) -> {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                defecto();
            }
        });
    }

    public void defecto() {
        texto_borrado = false;
        componente.setText(texto_inicial);
    }

    public void quitarBorrado() {
        texto_borrado = true;
    }

    public void ponerBorardo() {
        texto_borrado = false;
    }
}
