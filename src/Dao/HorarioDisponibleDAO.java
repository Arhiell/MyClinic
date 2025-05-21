import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorarioDisponibleDAO implements BaseDAO<HorarioDisponible> {

    @Override
    public HorarioDisponible obtenerPorId(int id) {
        String sql = "SELECT * FROM horario_disponible WHERE id_horario = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapear(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HorarioDisponible> obtenerTodos() {
        List<HorarioDisponible> lista = new ArrayList<>();
        String sql = "SELECT * FROM horario_disponible";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean insertar(HorarioDisponible horario) {
        String sql = "INSERT INTO horario_disponible (id_especialista, fecha, hora_inicio, hora_fin, disponible) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, horario.getIdEspecialista());
            stmt.setDate(2, Date.valueOf(horario.getFecha()));
            stmt.setTime(3, Time.valueOf(horario.getHoraInicio()));
            stmt.setTime(4, Time.valueOf(horario.getHoraFin()));
            stmt.setBoolean(5, horario.isDisponible());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(HorarioDisponible horario) {
        String sql = "UPDATE horario_disponible SET fecha=?, hora_inicio=?, hora_fin=?, disponible=? WHERE id_horario=?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(horario.getFecha()));
            stmt.setTime(2, Time.valueOf(horario.getHoraInicio()));
            stmt.setTime(3, Time.valueOf(horario.getHoraFin()));
            stmt.setBoolean(4, horario.isDisponible());
            stmt.setInt(5, horario.getIdHorario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM horario_disponible WHERE id_horario=?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<HorarioDisponible> obtenerPorEspecialista(int idEspecialista) {
        List<HorarioDisponible> lista = new ArrayList<>();
        String sql = "SELECT * FROM horario_disponible WHERE id_especialista = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEspecialista);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private HorarioDisponible mapear(ResultSet rs) throws SQLException {
        HorarioDisponible h = new HorarioDisponible();
        h.setIdHorario(rs.getInt("id_horario"));
        h.setIdEspecialista(rs.getInt("id_especialista"));
        h.setFecha(rs.getDate("fecha").toLocalDate());
        h.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
        h.setHoraFin(rs.getTime("hora_fin").toLocalTime());
        h.setDisponible(rs.getBoolean("disponible"));
        return h;
    }
}
