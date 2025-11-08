/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.model;

import jsoftware.com.jutil.db.JDBConnection;

/**
 *
 * @author juanp
 */
public class AbstractDAO extends AbstractMonitoreable {

    private JDBConnection connection;

    public AbstractDAO(boolean flag_dev_log, String name_module) {
        super(flag_dev_log, name_module);
        connection = JDBConnection.getInstance();
    }

    public JDBConnection getConnection() {
        return connection;
    }

    public void setConnection(JDBConnection connection) {
        this.connection = connection;
    }

}
