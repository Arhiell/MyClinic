package Dao;

import Model.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolDAO {

    // Buscar un rol por nombre
    public Rol buscarPorNombre(String nombre) {
        Rol rol = null;
        String sql = "SELECT id, nombre FROM roles WHERE nombre = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombre(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }

    // Guardar un rol nuevo
    public void guardarRol(Rol rol) {
        String sql = "INSERT INTO roles (nombre) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, rol.getNombre());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un rol (opcional)
    public void eliminarRol(int id) {
        String sql = "DELETE FROM roles WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
