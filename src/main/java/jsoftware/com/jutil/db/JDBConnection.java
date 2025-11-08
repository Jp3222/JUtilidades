/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.db;

import com.zaxxer.hikari.HikariConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import jsoftware.com.jutil.db.abstr.AbstractJDBConnection;
import static jsoftware.com.jutil.db.model.SimpleQuerys.DELETE;
import static jsoftware.com.jutil.db.model.SimpleQuerys.INSERT_COL;
import static jsoftware.com.jutil.db.model.SimpleQuerys.INSERT_VAL;
import static jsoftware.com.jutil.db.model.SimpleQuerys.SELECT;
import static jsoftware.com.jutil.db.model.SimpleQuerys.UPDATE_COL;
import static jsoftware.com.jutil.db.model.SimpleQuerys.UPDATE_VAL;

/**
 *
 * @author juan-campos
 */
public final class JDBConnection extends AbstractJDBConnection {

    private static JDBConnection instance;

    @Deprecated

    public static JDBConnection getInstance() {
        return instance;
    }

    @Deprecated

    public static JDBConnection getInstance(String url) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(1, url);
        }
        return instance;
    }

    @Deprecated

    public static JDBConnection getInstance(String url, Properties info) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(2, url, info);
        }
        return instance;
    }

    @Deprecated

    public static JDBConnection getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(3, url, user, password);
        }
        return instance;
    }

    @Deprecated
    public static JDBConnection getPollConnection(int max_poll_size, int minimum_idle, int time_out, String user, String password, String url) throws SQLException {
        if (instance == null) {
            instance = new JDBConnection(INTANCE_POLL, max_poll_size, minimum_idle, time_out, user, password, url);
        }
        return instance;
    }

    @Deprecated
    public static JDBConnection getNewInstance(String url, String user, String password) throws SQLException {
        JDBConnection o = new JDBConnection(3, url, user, password);
        return o;
    }

    private StorageProcedure sp;

    @Deprecated
    private JDBConnection(int instance_type, Object... args) throws SQLException {
        super(instance_type, args);
        sp = new StorageProcedure(getConnection());
    }

    private JDBConnection(int instance_type, BuilderConnection build) throws SQLException {
        super(instance_type, build);
    }

    @Override
    public boolean insert(String table, String fields, String values) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = INSERT_VAL.formatted(table, fields, values);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean insert(String table, String fields, StringBuilder values) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = INSERT_COL.formatted(table, fields, values.toString());
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String field, String newValue, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = UPDATE_VAL.formatted(table, field, newValue, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean update(String table, String kv, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = UPDATE_COL.formatted(table, kv, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public boolean delete(String table, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = DELETE.formatted(table, where);
        showQuery(query);
        if (exec_query) {
            return false;
        }
        return st.executeUpdate(query) > 0;
    }

    @Override
    public ResultSet select(String table, String fields, String where) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = SELECT.formatted(table, fields, where);
        showQuery(query);
        if (exec_query) {
            return null;
        }
        return st.executeQuery(query);
    }

    @Override
    public ResultSet query(String query) throws SQLException {
        Statement st = getConnection().createStatement();
        showQuery(query);
        if (exec_query) {
            return null;
        }
        return st.executeQuery(query);
    }

    @Override
    public int execute(String query) throws SQLException {
        Statement st = getConnection().createStatement();
        showQuery(query);
        if (exec_query) {
            return 0;
        }
        return st.executeUpdate(query);
    }

    public StorageProcedure getStorageProcedure() {
        return sp;
    }

    public static class BuilderConnection {

        private int max_poll_size;
        private int minimum_idle;
        private int time_out;
        private String user;
        private String password;
        private String url;
        private Properties properties;
        private HikariConfig config;
        private int type_instance;

        public BuilderConnection() {
            this.max_poll_size = 0;
            this.max_poll_size = 0;
            this.max_poll_size = 0;
            this.user = null;
            this.user = null;
            this.user = null;
            this.properties = null;
            config = null;
            this.type_instance = JDBConnection.INTANCE_CREDENTIALS;
        }

        public BuilderConnection setMax_poll_size(int max_poll_size) {
            this.max_poll_size = max_poll_size;
            return this;
        }

        public BuilderConnection setMinimum_idle(int minimum_idle) {
            this.minimum_idle = minimum_idle;
            return this;
        }

        public BuilderConnection setPassword(String password) {
            this.password = password;
            return this;
        }

        public BuilderConnection setTime_out(int time_out) {
            this.time_out = time_out;
            return this;
        }

        public BuilderConnection setUrl(String url) {
            this.url = url;
            return this;
        }

        public BuilderConnection setUser(String user) {
            this.user = user;
            return this;
        }

        public BuilderConnection setProperties(Properties properties) {
            this.properties = properties;
            return this;
        }

        public BuilderConnection setConfig(HikariConfig config) {
            this.config = config;
            return this;
        }

        public int getMax_poll_size() {
            return max_poll_size;
        }

        public int getMinimum_idle() {
            return minimum_idle;
        }

        public int getTime_out() {
            return time_out;
        }

        public String getUser() {
            return user;
        }

        public String getPassword() {
            return password;
        }

        public String getUrl() {
            return url;
        }

        public Properties getProperties() {
            return properties;
        }

        public HikariConfig getConfig() {
            return config;
        }

        public BuilderConnection setTypeInstance(int type_instance) {
            this.type_instance = type_instance;
            return this;
        }

        public int getType_instance() {
            return type_instance;
        }

        public JDBConnection build() throws SQLException {
            return new JDBConnection(INTANCE_LITE, this);
        }
    }
}
