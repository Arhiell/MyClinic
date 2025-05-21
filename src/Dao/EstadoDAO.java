import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    
    public List<Estado> obtenerEstadosPorEntidad(String entidad) {
        List<Estado> estados = new ArrayList<>();
        String sql = "SELECT * FROM estado WHERE entidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entidad);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estado e = new Estado();
                e.setId(rs.getInt("id_estado"));
                e.setNombre(rs.getString("nombre"));
                e.setEntidad(rs.getString("entidad"));
                estados.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estados;
    }
}
