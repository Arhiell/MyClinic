package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Especialidad;
import Model.Estado;

public class EspecialidadDAO implements BaseDAO<Especialidad> {

    @Override
    public Especialidad obtenerPorId(int id) {
        String sql = "SELECT * FROM especialidad WHERE id_especialidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearEspecialidad(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Especialidad> obtenerTodos() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidad";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearEspecialidad(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean insertar(Especialidad especialidad) {
        String sql = "INSERT INTO especialidad (nombre, descripcion, estado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especialidad.getNombre());
            stmt.setString(2, especialidad.getDescripcion());
            stmt.setString(3, especialidad.getEstado().toString());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Especialidad especialidad) {
        String sql = "UPDATE especialidad SET nombre = ?, descripcion = ?, estado = ? WHERE id_especialidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especialidad.getNombre());
            stmt.setString(2, especialidad.getDescripcion());
            stmt.setString(3, especialidad.getEstado().toString());
            stmt.setInt(4, especialidad.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM especialidad WHERE id_especialidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Especialidad mapearEspecialidad(ResultSet rs) throws SQLException {
        Especialidad e = new Especialidad();
        e.setId(rs.getInt("id_especialidad"));
        e.setNombre(rs.getString("nombre"));
        e.setDescripcion(rs.getString("descripcion"));
        e.setEstado(Estado.valueOf(rs.getString("estado")));
        return e;
    }
}