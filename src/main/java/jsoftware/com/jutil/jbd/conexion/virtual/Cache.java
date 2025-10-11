/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.jbd.conexion.virtual;

import jsoftware.com.jutil.jbd.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author jp
 */
public abstract class Cache {

    protected final List<String[]> _lista;
    protected int _id_inicial, _id_final;
    protected int _id_minimo, _id_maximo, _id_pasos;
    protected Conexion _conexion;
    protected String _tabla;

    public Cache(List lista, Conexion conexion, String tabla) {
        this._lista = lista;
        this._conexion = conexion;
        this._tabla = tabla;

    }

    protected void leerIdsMinMax() throws SQLException {
        try (ResultSet primer_id = _conexion.query("SELECT id FROM " + _tabla + " LIMIT 1")) {
            if (primer_id.next()) {
                _id_inicial = Integer.parseInt(primer_id.getString("id"));
            }
        }

        try (ResultSet ultimo_id = _conexion.query("SELECT id FROM " + _tabla + " ORDER BY id desc LIMIT 1")) {
            if (ultimo_id.next()) {
                _id_final = Integer.parseInt(ultimo_id.getString("id"));
            }
        }
    }

    public void irAnterior() {
        if (_id_minimo > 0) {
            _id_minimo -= _id_pasos;
            _id_maximo -= _id_pasos;
        }
    }

    public void irSiguiente() {
        _id_minimo += _id_pasos;
        _id_maximo += _id_pasos;
    }

    public void setRango(int pasos) {
        this._id_pasos = pasos;
    }

    public boolean sig() {
        return _lista.isEmpty();
    }

    public boolean ant() {
        return _lista.isEmpty();
    }

    public void actualizar() {
    }

    public String[] getBuscar(Predicate<String[]> buscar) {
        String[] o = null;
        for (String[] strings : _lista) {
            if (buscar.test(strings)) {
                o = strings;
            }
        }
        return o;
    }

    public ArrayList<String[]> getBuscarCol(Predicate<String[]> buscar) {
        ArrayList<String[]> lista = new ArrayList<>();
        for (String[] strings : lista) {
            if (buscar.test(strings)) {
                lista.add(strings);
            }
        }
        return lista;
    }

}
