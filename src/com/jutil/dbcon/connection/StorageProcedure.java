/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.dbcon.connection;

import java.util.Map;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juanp
 */
public class StorageProcedure implements StorageProcedureModel {

    private final Map<String, String> map;
    private final Connection connection;
    boolean exec_query;
    boolean show_query;

    public StorageProcedure(Connection connection) {
        this.map = new HashMap<>(30);
        this.connection = connection;
    }

    @Override
    public void add(String name, String query) {
        map.put(name, query);
    }

    @Override
    public ResultSet excecuteQuery(String name, Map<String, String> args) throws SQLException {
        CallableStatement cs = connection.prepareCall(P_CALL.formatted(name, getNumArgs(args.size())));
        for (Map.Entry<String, String> i : args.entrySet()) {
            cs.setString(i.getKey(), i.getValue());
        }
        return cs.executeQuery();
    }

    @Override
    public ResultSet excecuteQuery(String name, List<String> values) throws SQLException {
        CallableStatement cs = connection.prepareCall(P_CALL.formatted(name, getNumArgs(values.size())));
        for (int i = 1; i <= values.size(); i++) {
            cs.setString(i, values.get(i));
        }
        return cs.executeQuery();
    }

    @Override
    public boolean excecuteFlag(String name, List<String> values) throws SQLException {
        boolean flags;
        try (ResultSet rs = excecuteQuery(name, values)) {
            flags = rs.next();
        }
        return flags;
    }

    private String getNumArgs(int count_args) {
        final String v = "?";
        String aux = v;

        for (int i = 0; i <= count_args; i++) {
            aux = aux.concat(v).concat(",");
        }
        aux = aux.concat(v);
        return aux;
    }

    private final String P_CALL = "{call %s(%s)}";

    public void setExecQuery(boolean exec_query) {
        this.exec_query = exec_query;
    }

    public void setShowQuery(boolean show_query) {
        this.show_query = show_query;
    }

   

}
