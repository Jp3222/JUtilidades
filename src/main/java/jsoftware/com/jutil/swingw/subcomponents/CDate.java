/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.swingw.subcomponents;

import jsoftware.com.jutil.swingw.subcomponents.sub.FormComponent;
import jsoftware.com.jutil.swingw.subcomponents.sub.SubComponent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author juan-campos
 */
public class CDate extends SubComponent {

    private SpinnerNumberModel dayModel;
    private SpinnerNumberModel monthModel;
    private SpinnerNumberModel yearModel;

    private JSpinner day;
    private JSpinner month;
    private JSpinner year;

    private LocalDate date;

    public CDate() {
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
        date = LocalDate.now();
        setLayout(new GridLayout(1, 3, 5, 5));
        //
        dayModel = new SpinnerNumberModel(date.getDayOfMonth(), 1, date.getMonth().length(date.isLeapYear()), 1);
        monthModel = new SpinnerNumberModel(date.getMonthValue(), 1, 12, 1);
        yearModel = new SpinnerNumberModel(date.getYear(), date.getYear() - 2, date.getYear() + 2, 1);
        //
        day = new JSpinner(dayModel);
        JSpinner.NumberEditor s = (JSpinner.NumberEditor) day.getEditor();
        s.setEnabled(false);
        System.out.println(day.getEditor().getClass());

        month = new JSpinner(monthModel);
        month.getEditor().setEnabled(false);
        year = new JSpinner(yearModel);
        year.getEditor().setEnabled(false);
        //

        add(new FormComponent("day", BorderLayout.NORTH, month));
        add(new FormComponent("Month", BorderLayout.NORTH, month, BorderLayout.CENTER));
        add(new FormComponent("Year", BorderLayout.NORTH, year, BorderLayout.CENTER));
    }

    @Override
    public void initialState() {
        dayModel.setValue(dayModel.getMinimum());
        monthModel.setValue(monthModel.getMinimum());
        yearModel.setValue(yearModel.getMinimum());
    }

    @Override
    public void finalState() {

    }

    @Override
    public LocalDate getValue() {
        int _day = dayModel.getNumber().intValue();
        int _month = monthModel.getNumber().intValue();
        int _year = yearModel.getNumber().intValue();
        return LocalDate.of(_year, _month, _day);
    }

    @Override
    public <T> void setValue(T data) {
        if (!(data instanceof LocalDate) && !(data instanceof String)) {
            throw new ClassCastException("The value is not suppor for this implementation");
        }
        if (data instanceof LocalDate o) {
            dayModel.setValue(o.getDayOfMonth());
            monthModel.setValue(o.getMonthValue());
            yearModel.setValue(o.getYear());
        }

        if (data instanceof String f) {
            LocalDate o = LocalDate.parse(f);
            dayModel.setValue(o.getDayOfMonth());
            monthModel.setValue(o.getMonthValue());
            yearModel.setValue(o.getYear());
        }
    }

    public void setDayRange(int min, int max) {
        dayModel.setMinimum(min);
        dayModel.setMaximum(max);
    }

    public void setMonthRange(int min, int max) {
        monthModel.setMinimum(min);
        monthModel.setMaximum(max);
    }

    public void setYearRange(int min, int max) {
        yearModel.setMinimum(min);
        yearModel.setMaximum(max);
    }

}
