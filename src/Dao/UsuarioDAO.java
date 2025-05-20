package Dao;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

  // Buscar un usuario por username
  public Usuario buscarPorUsername(String username) {
    Usuario usuario = null;
    String sql = "SELECT id, username, password, rol FROM usuarios WHERE username = ?";

    try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, username);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setPassword(rs.getString("password"));
        usuario.setRol(rs.getString("rol"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuario;
  }

  // Validar credenciales (username + password)
  public boolean validarCredenciales(String username, String password) {
    Usuario usuario = buscarPorUsername(username);
    if (usuario != null) {
      // Aquí podés agregar hash si usás passwords encriptadas
      return usuario.getPassword().equals(password);
    }
    return false;
  }

  // Guardar un usuario nuevo en la BD
  public void guardarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuarios (username, password, rol) VALUES (?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, usuario.getUsername());
      ps.setString(2, usuario.getPassword());
      ps.setString(3, usuario.getRol());

      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}