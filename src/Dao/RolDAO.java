package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Rol;

public class RolDAO implements BaseDAO<Rol> {

    @Override
    public Rol obtenerPorId(int id) {
        String sql = "SELECT * FROM rol WHERE id_rol = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Rol(rs.getInt("id_rol"), rs.getString("nombre"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rol> obtenerTodos() {
        List<Rol> roles = new ArrayList<>();
        String sql = "SELECT * FROM rol";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                roles.add(new Rol(rs.getInt("id_rol"), rs.getString("nombre"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public boolean insertar(Rol rol) {
        String sql = "INSERT INTO rol (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Rol rol) {
        String sql = "UPDATE rol SET nombre = ?, descripcion = ? WHERE id_rol = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rol.getNombre());
            stmt.setString(2, rol.getDescripcion());
            stmt.setInt(3, rol.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM rol WHERE id_rol = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
