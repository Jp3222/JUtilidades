/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.subcomponents.sub;

import java.awt.BorderLayout;
import java.util.Optional;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class FormComponent<T extends JComponent> extends SubComponent {

    private final T component;
    private final JLabel label;

    public FormComponent(String text, String alingText, T component, String alingComp) {
        this.component = component;
        this.label = new JLabel(text);
        this.component.setName(text);
        //
        setLayout(new BorderLayout());
        add(this.label, alingText);
        add(component, alingComp);
        setName(text);

    }

    public FormComponent(String text, String alingText, T component) {
        this(text, alingText, component, BorderLayout.CENTER);
    }

    public FormComponent(String text, T component) {
        this(text, BorderLayout.NORTH, component, BorderLayout.CENTER);
    }

    @Override
    public Optional getValue() {
        Optional op;
        switch (component) {
            case JPasswordField o ->
                op = Optional.of(String.valueOf(o.getPassword()));
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
    public <T> void setValue(T data) {
        switch (component) {
            case JTextField o ->
                o.setText(String.valueOf(data));
            case JComboBox o ->
                o.setSelectedItem(data);
            case JSpinner o ->
                o.setValue(data);
            case JCheckBox o ->
                o.setSelected((boolean) data);
            case JList o ->
                o.setSelectedIndex((int) data);
            case SubComponent o ->
                o.setValue(data);
            default ->
                throw new AssertionError();
        }
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
                    case SpinnerListModel a ->
                        a.setValue(a.getList().getFirst());
                    case SpinnerDateModel a ->
                        a.setValue(a.getDate());

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

    public <T extends JComponent> T getComponent() {
        return (T) component;
    }

    public JLabel getLabel() {
        return label;
    }

}
