package org.example.database;

import org.example.props.Props;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection connection;

    private Database() {
        String connectionUrl = Props.getConnectionUrl();

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public int initDB(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
