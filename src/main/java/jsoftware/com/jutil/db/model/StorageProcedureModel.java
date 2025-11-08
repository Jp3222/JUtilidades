/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juanp
 */
public interface StorageProcedureModel {

    public void add(String name, String query);

    public ResultSet excecuteQuery(String name, Map<String, String> args) throws SQLException;

    public ResultSet excecuteQuery(String name, List<String> values) throws SQLException;

    public boolean excecuteFlag(String name, List<String> values) throws SQLException;
}
