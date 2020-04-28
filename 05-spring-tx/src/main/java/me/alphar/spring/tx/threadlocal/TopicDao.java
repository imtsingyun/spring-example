package me.alphar.spring.tx.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TopicDao {

    // 使用 ThreadLocal 保存 Connection 变量
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
        if (connectionThreadLocal.get() == null) {
            // new 一个 Connection
            Connection conn = DriverManager.getConnection("url");
            connectionThreadLocal.set(conn);
            return conn;
        } else {
            return connectionThreadLocal.get();
        }
    }

    public void addTopic() throws SQLException {
        Statement stat = getConnection().createStatement();
    }
}
