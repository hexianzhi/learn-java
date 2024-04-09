package src.jdbc.src.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) throws SQLException {
    // JDBC连接的URL, 不同数据库有不同的格式:
    String JDBC_URL = "jdbc:mysql://aws.gedune.space:23306/learnjdbc";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "Gedune150.";
    // 获取连接:
    try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
      try (Statement stmt = conn.createStatement()) {
        try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
          while (rs.next()) {
            long id = rs.getLong(1); // 注意：索引从1开始
            long grade = rs.getLong(2);
            String name = rs.getString(3);
            int gender = rs.getInt(4);
          }
        }
      }
      conn.close();
    }

    System.out.println("hello");
  }

}
