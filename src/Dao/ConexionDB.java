import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "xxxxxxxxxxxx";
    private static final String USER = "root";
    private static final String PASSWORD = "xxxxxxxxxxxxxxxxxx";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
