import java.sql.*;
import java.util.*;

public class InformeEconomicoDAO {

    public Map<String, Double> obtenerIngresosPorEspecialidad() {
        Map<String, Double> resultado = new HashMap<>();
        String sql = """
            SELECT es.nombre AS especialidad, SUM(t.precio) AS ingresos
            FROM turno t
            JOIN especialista e ON t.id_especialista = e.id_especialista
            JOIN especialidad es ON e.id_especialidad = es.id_especialidad
            WHERE t.estado = 'Finalizado'
            GROUP BY es.nombre
        """;
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                resultado.put(rs.getString("especialidad"), rs.getDouble("ingresos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
