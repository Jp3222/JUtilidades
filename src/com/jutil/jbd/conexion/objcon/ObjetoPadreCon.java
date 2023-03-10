/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd.conexion.objcon;

import java.io.Serializable;
import java.util.Arrays;

/**
 * - Esta clase almacena datos de una fila leida de la base de datos, dichos
 * valores se almacenan en un array al cual se le denomina 'conjunto'.
 * <br>
 * - El conjunto considera que el campo numero '1' es el 'id' por lo que se debe
 * tomar en cuenta al momento de usar el metodo equalIgnoreID
 * <br>
 * - Tambien contiene algunas operaciones para manipular dicho _conjunto
 *
 * @author jp
 */
public abstract class ObjetoPadreCon implements Cloneable, Serializable {

    /**
     * arry - contenedor de la informacion leida
     */
    protected String[] _conjunto;

    /**
     * Crea una instancia del
     *
     * @param valores
     */
    protected ObjetoPadreCon(String... valores) {
        this._conjunto = valores;
    }

    protected ObjetoPadreCon() {
        this._conjunto = null;
    }

    public String[] getConjunto() {
        return _conjunto;
    }

    public void setConjunto(String[] conjunto) {
        this._conjunto = conjunto;
    }

    public String getValor(int index) {
        return _conjunto[index];
    }

    public void setValor(int index, String valor) {
        this._conjunto[index] = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Arrays.deepHashCode(this._conjunto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjetoPadreCon other = (ObjetoPadreCon) obj;
        return Arrays.deepEquals(this._conjunto, other._conjunto);
    }

    public boolean equalsIgnoreID(ObjetoPadreCon obj) {
        return Arrays.equals(_conjunto, 1, _conjunto.length,
                obj._conjunto, 1, obj._conjunto.length,
                (a, b) -> a.compareTo(b)
        );
    }

    public String getSubCon(int... indices) {
        String subcon = "";
        for (int indice : indices) {
            subcon += _conjunto[indice] + ",";
        }
        subcon = subcon.substring(0, subcon.length() - 1);
        return subcon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < _conjunto.length - 1; i++) {
            sb.append(_conjunto[i]).append(",");
        }
        sb.append(_conjunto[_conjunto.length - 1]);
        sb.append(')');
        return sb.toString();
    }

}
