package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Entidad;

public class EntidadDAO implements BaseDAO<Entidad> {
  @Override
    public Entidad obtenerPorId(int id) {
        String sql = "SELECT * FROM entidad WHERE id_entidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Entidad entidad = new Entidad();
                entidad.setId(rs.getInt("id_entidad"));
                entidad.setNombre(rs.getString("nombre"));
                entidad.setDescripcion(rs.getString("descripcion"));
                return entidad;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
      public List<Entidad> obtenerTodos() {
        List<Entidad> entidades = new ArrayList<>();
        String sql = "SELECT * FROM entidad";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionDB.obtenerConexion();
            stmt = (Statement) conn.createStatement();
            rs = ((java.sql.Statement) stmt).executeQuery(sql);
    
            while (rs.next()) {
                Entidad entidad = new Entidad();
                entidad.setId(rs.getInt("id_entidad"));
                entidad.setNombre(rs.getString("nombre"));
                entidad.setDescripcion(rs.getString("descripcion"));
                entidades.add(entidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
          try { if (stmt != null) stmt.clone(); } catch (SQLException e) { e.printStackTrace(); }
          try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
      }
        return entidades;
    }

    @Override
    public boolean insertar(Entidad entidad) {
        String sql = "INSERT INTO entidad (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDescripcion());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Entidad entidad) {
        String sql = "UPDATE entidad SET nombre = ?, descripcion = ? WHERE id_entidad = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDescripcion());
            stmt.setInt(3, entidad.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM entidad WHERE id_entidad = ?";
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
