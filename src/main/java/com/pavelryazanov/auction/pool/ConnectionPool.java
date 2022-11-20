package com.pavelryazanov.auction.pool;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    private static ConnectionPool instance;
    private static int CAPACITY = 8;
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(CAPACITY);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(CAPACITY);

    private ConnectionPool() {
        String URL = "jdbc:mysql://localhost:3306/auction_epam";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");

        for (int i = 0; i < CAPACITY; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(URL, prop);
            } catch (SQLException e) {
                throw new ExceptionInInitializerError(e);
            }
            free.add(connection);

        }
    }

    public static ConnectionPool getInstance() {
        //lock
        instance = new ConnectionPool();
        //unlock
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = free.take();
            used.put(connection);
        } catch (InterruptedException e) {
            // log
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        try {
            used.remove(connection);
            free.put(connection);
        } catch (InterruptedException e) {
            // log
            Thread.currentThread().interrupt();
        }
    }

    // deregisterDriver
    public void destroyPool() {
        for (int i = 0; i < CAPACITY; i++) {
            try {
                free.take().close();
            } catch (SQLException | InterruptedException e) {
                //log.e.printStackTrace();
            }
        }
    }
}
