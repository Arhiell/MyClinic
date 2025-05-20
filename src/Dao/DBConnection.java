package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  public class DBConnection {
    private static final String URL = "xxxxxxxxxxxxxx";
    private static final String USER = "xxxxxxxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxxxxx";

    public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, USER, PASSWORD);
  }
  }
}
