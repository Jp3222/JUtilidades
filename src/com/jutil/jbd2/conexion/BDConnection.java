/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.jbd2.conexion;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author juan-campos
 */
public class BDConnection extends BD {

    public static String DEFAULT_INSTANCE = "first-conection";
    private static Map<String, BDConnection> instance_control = new HashMap<>(3);

    public static BDConnection instance;

    public static BDConnection getBDConnection(String url) {
        if (instance == null) {
            instance = new BDConnection(url);
        }
        instance_control.put(DEFAULT_INSTANCE, instance);
        return instance;
    }

    public BDConnection getBDConnection(String url, Properties properties) {
        if (instance == null) {
            instance = new BDConnection(url, properties);
        }
        instance_control.put(DEFAULT_INSTANCE, instance);
        return instance;
    }

    public BDConnection getBDConnection(String user, String password, String url) {
        if (instance == null) {
            instance = new BDConnection(user, password, url);
        }
        instance_control.put(DEFAULT_INSTANCE, instance);
        return instance;
    }

    public static boolean putConnection(String name, BDConnection connection) {
        int status = checkStatusPutInstance(name, connection);
        if (status == 1) {
            return false;
        }
        instance_control.put(name, instance);
        return true;
    }

    public static int checkStatusPutInstance(String name, BDConnection connection) {
        if (instance_control.containsKey(name)) {
            return 1;
        }
        if (instance_control.containsValue(connection)) {
            return 2;
        }
        return 0;
    }

    public static boolean removeConnection(String key) {
        return instance_control.remove(key) != null;
    }

    private BDConnection(String url) {
        super(url);
    }

    private BDConnection(String url, Properties properties) {
        super(url, properties);
    }

    private BDConnection(String user, String password, String url) {
        super(user, password, url);
    }

}
