import java.sql.*;
import java.util.*;

public class InformeTurnoDAO {

    public Map<String, Integer> obtenerCantidadTurnosPorEspecialidad() {
        Map<String, Integer> resultado = new HashMap<>();
        String sql = """
            SELECT es.nombre AS especialidad, COUNT(t.id_turno) AS cantidad
            FROM turno t
            JOIN especialista e ON t.id_especialista = e.id_especialista
            JOIN especialidad es ON e.id_especialidad = es.id_especialidad
            GROUP BY es.nombre
        """;
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                resultado.put(rs.getString("especialidad"), rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
