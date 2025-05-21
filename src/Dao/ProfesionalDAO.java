package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Especialidad;
import Model.Profesional;

public class ProfesionalDAO implements BaseDAO<Profesional> {

    @Override
    public ProfesionalDAO obtenerPorId(int id) {
        String sql = "SELECT * FROM especialista WHERE id_especialista = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearEspecialista(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Especialista> obtenerTodos() {
        List<Especialista> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialista";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearEspecialista(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean insertar(Especialista especialista) {
        String sql = "INSERT INTO especialista (id_especialidad,id_persona) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especialista.getNombre());
            stmt.setString(2, especialista.getApellido());
            stmt.setString(3, especialista.getEmail());
            stmt.setInt(4, especialista.getIdEspecialidad());
            stmt.setString(5, especialista.getTelefono());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Especialista especialista) {
        String sql = "UPDATE especialista SET nombre = ?, apellido = ?, email = ?, id_especialidad = ?, telefono = ? WHERE id_especialista = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especialista.getNombre());
            stmt.setString(2, especialista.getApellido());
            stmt.setString(3, especialista.getEmail());
            stmt.setInt(4, especialista.getIdEspecialidad());
            stmt.setString(5, especialista.getTelefono());
            stmt.setInt(6, especialista.getIdEspecialista());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM especialista WHERE id_especialista = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método privado para mapear resultado SQL a objeto Especialista
    private Especialista mapearEspecialista(ResultSet rs) throws SQLException {
        Especialista e = new Especialista();
        e.setIdEspecialista(rs.getInt("id_especialista"));
        e.setNombre(rs.getString("nombre"));
        e.setApellido(rs.getString("apellido"));
        e.setEmail(rs.getString("email"));
        e.setIdEspecialidad(rs.getInt("id_especialidad"));
        e.setTelefono(rs.getString("telefono"));
        return e;
    }

    // Operaciones específicas para especialistas:

    // Obtener especialistas por especialidad
    public List<Especialista> obtenerPorEspecialidad(int idEspecialidad) {
        List<Especialista> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialista WHERE id_especialidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEspecialidad);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(mapearEspecialista(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Buscar especialistas por nombre o apellido (ejemplo de búsqueda)
    public List<Especialista> buscarPorNombreApellido(String texto) {
        List<Especialista> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialista WHERE nombre LIKE ? OR apellido LIKE ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String filtro = "%" + texto + "%";
            stmt.setString(1, filtro);
            stmt.setString(2, filtro);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(mapearEspecialista(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}