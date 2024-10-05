/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.subcomponents;

import com.jutil.swingw.subcomponents.sub.FormComponent;
import com.jutil.swingw.subcomponents.sub.SubComponent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author juan-campos
 */
public class CTime extends SubComponent {

    private SpinnerNumberModel hourModel;
    private SpinnerNumberModel minuteModel;
    private SpinnerNumberModel secondModel;

    private JSpinner hour;
    private JSpinner minute;
    private JSpinner second;
    private LocalTime time;

    public CTime() {
        build();
    }

    @Override
    public final void build() {
        components();
        events();
        finalState();
        initialState();
    }

    @Override
    public void events() {

    }

    @Override
    public void components() {
        time = LocalTime.now();
        setLayout(new GridLayout(1, 3, 5, 5));
        //
        hourModel = new SpinnerNumberModel(time.getHour(), 1, 23, 1);
        minuteModel = new SpinnerNumberModel(time.getMinute(), 1, 59, 1);
        secondModel = new SpinnerNumberModel(time.getSecond(), 1, 59, 1);
        //
        hour = new JSpinner(hourModel);
        JSpinner.NumberEditor s = (JSpinner.NumberEditor) hour.getEditor();
        s.setEnabled(false);
        System.out.println(hour.getEditor().getClass());

        minute = new JSpinner(minuteModel);
        minute.getEditor().setEnabled(false);
        second = new JSpinner(secondModel);
        second.getEditor().setEnabled(false);
        //

        add(new FormComponent("Hora", BorderLayout.NORTH, hour));
        add(new FormComponent("Minuto", BorderLayout.NORTH, minute));
        add(new FormComponent("segundo", BorderLayout.NORTH, second));
    }

    @Override
    public void initialState() {

    }

    @Override
    public void finalState() {

    }

    @Override
    public LocalDate getValue() {
        int _day = hourModel.getNumber().intValue();
        int _month = minuteModel.getNumber().intValue();
        int _year = secondModel.getNumber().intValue();
        return LocalDate.of(_year, _month, _day);
    }

    @Override
    public <T> void setValue(T data) {
        if (!(data instanceof LocalDate) && !(data instanceof String)) {
            throw new ClassCastException("The value is not suppor for this implementation");
        }
        if (data instanceof LocalDate o) {
            hourModel.setValue(o.getDayOfMonth());
            minuteModel.setValue(o.getMonthValue());
            secondModel.setValue(o.getYear());
        }
        if (data instanceof String f) {
            LocalDate o = LocalDate.parse(f);
            hourModel.setValue(o.getDayOfMonth());
            minuteModel.setValue(o.getMonthValue());
            secondModel.setValue(o.getYear());
        }
    }

    public void setHourRange(int min, int max) {
        hourModel.setMinimum(min);
        hourModel.setMaximum(max);
    }

    public void setRange(int min, int max) {
        hourModel.setMinimum(min);
        hourModel.setMaximum(max);
    }

    public void setYearRange(int min, int max) {
        hourModel.setMinimum(min);
        hourModel.setMaximum(max);
    }

}
