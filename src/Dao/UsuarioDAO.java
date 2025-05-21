package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Usuario;

public class UsuarioDAO implements BaseDAO<Usuario> {

    @Override
    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre_usuario, clave, id_persona, id_rol) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setInt(3, usuario.getIdUsuario());
            stmt.setString(4, usuario.getRol());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre_usuario = ?, clave = ?, id_persona = ?, id_rol = ? WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setInt(3, usuario.getIdUsuario());
            stmt.setString(4, usuario.getRol());
            stmt.setInt(5, usuario.getIdUsuario());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("id_usuario"));
        u.setNombreUsuario(rs.getString("nombre_usuario"));
        u.setClave(rs.getString("clave"));
        u.setIdPersona(rs.getInt("id_persona"));
        u.setIdRol(rs.getInt("id_rol"));
        return u;
    }
}