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

public class TableModel extends DefaultTableModel implements Serializable {

    public TableModel(int rowCount, String... columnNames) {
        super(columnNames, rowCount);

    }

    public TableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    public TableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
        super(data, columnNames);
    }

    public TableModel(Vector<?> columnNames, int rowCount) {
        super(columnNames, rowCount);

    }

    public TableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);

    }

    protected boolean cellsEditables;

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
    
    public void removeAllRows(){
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
    
    
}
