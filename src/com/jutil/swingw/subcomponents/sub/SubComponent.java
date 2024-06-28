/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.subcomponents.sub;

import com.jutil.framework.ComponentStates;
import java.awt.BorderLayout;
import java.util.Optional;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author juan-campos
 */
public abstract class SubComponent extends JPanel implements ComponentStates {

    public SubComponent() {

    }

    public abstract <T> T getValue();

    public static class FormComponent extends SubComponent {

        private final JComponent component;

        public FormComponent(String text, String alingText, JComponent component, String alingComp) {
            this.component = component;
            setLayout(new BorderLayout());
            add(new JLabel(text), alingText);
            add(component, alingComp);
        }

        public FormComponent(String text, JComponent component) {
            this.component = component;
            setLayout(new BorderLayout());
            add(new JLabel(text), BorderLayout.NORTH);
            setName(text);
            this.component.setName(text);
            add(component, BorderLayout.CENTER);
        }

        @Override
        public Optional getValue() {
            Optional op;
            switch (component) {
                case JTextField o ->
                    op = Optional.of(o.getText());
                case JSpinner o ->
                    op = Optional.of(o.getValue());
                case JComboBox o ->
                    op = Optional.of(o.getItemAt(o.getSelectedIndex()));
                case JCheckBox o ->
                    op = Optional.of(o.isSelected());
                case JList o ->
                    op = Optional.of(o.getModel().getElementAt(o.getSelectedIndex()));
                case SubComponent o ->
                    op = Optional.of(o.getValue());
                default ->
                    op = Optional.empty();
            }
            return op;
        }

        @Override
        public void build() {

        }

        @Override
        public void events() {
        }

        @Override
        public void components() {

        }

        @Override
        public void initialState() {
            switch (component) {
                case JTextField o ->
                    o.setText(null);
                case JSpinner o -> {
                    switch (o.getModel()) {
                        case SpinnerNumberModel a ->
                            a.setValue(a.getMinimum());

                        default ->
                            throw new AssertionError();
                    }
                }
                case JComboBox o ->
                    o.setSelectedItem(0);
                case JCheckBox o ->
                    o.setSelected(false);
                case JList o ->
                    o.setSelectedIndex(0);
                case SubComponent o ->
                    o.initialState();
                default -> {

                }
            }
        }

        @Override
        public void finalState() {

        }

        public JComponent getComponent() {
            return component;
        }

    }
}
