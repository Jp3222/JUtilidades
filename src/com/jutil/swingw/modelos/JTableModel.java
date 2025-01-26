/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.swingw.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class JTableModel extends DefaultTableModel implements Serializable {

    public JTableModel(String[] columnNames, int rowCount) {
        super(columnNames, rowCount);

    }

    public JTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    public JTableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
        super(data, columnNames);
    }

    public JTableModel(Vector<?> columnNames, int rowCount) {
        super(columnNames, rowCount);

    }

    public JTableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);

    }

    protected boolean cellsEditables;

    /**
     * Este metodo usa el metodo addRow con la diferencia de que es para añadir
     * datos dinamicamente
     *
     * @param data datos añadidos a la fila
     */
    public void addData(Object... data) {
        addRow(data);
    }

    public void setCellsEditables(boolean cellsEditables) {
        this.cellsEditables = cellsEditables;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return cellsEditables;
    }

    public boolean isCellsEditables() {
        return cellsEditables;
    }

    public void removeAllRows() {
        dataVector.removeAllElements();
        fireTableRowsDeleted(0, dataVector.size());
    }

    public List<String> getRowData(int column) {
        ArrayList<String> lista = new ArrayList<>(dataVector.capacity());
        for (Vector vector : dataVector) {
            lista.add((String) vector.get(column));
        }
        return lista;
    }

    public boolean isRowsEmpty() {
        return dataVector.isEmpty();
    }

    public String[] getRow(int index) {
        Vector get = dataVector.get(index);
        String[] arr = new String[get.size()];
        int j = 0;
        for (Object i : get) {
            arr[j] = (String) i;
            j++;
        }
        return arr;
    }

}
