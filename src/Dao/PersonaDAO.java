package Dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import Model.Paciente;
import Model.Persona;

public class PersonaDAO implements BaseDAO<Persona>{
  @Override
  public Persona obtenerPorId(int id) {
      String sql = "SELECT * FROM persona WHERE id_persona = ?";
      try (Connection conn = ConexionDB.obtenerConexion();
           PreparedStatement stmt = conn.prepareStatement(sql)) {
           
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();
          if (rs.next()) {
              return mapearPersona(rs);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }

  @Override
  public List<Persona> obtenerTodos() {
      List<Persona> lista = new ArrayList<>();
      String sql = "SELECT * FROM persona";
      try (Connection conn = ConexionDB.obtenerConexion();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql)) {

          while (rs.next()) {
              lista.add(mapearPersona(rs));
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return lista;
  }

  @Override
  public boolean insertar(Persona persona) {
      String sql = "INSERT INTO persona (nombre, apellido, dni, fecha_nacimiento, telefono, email, direccion) VALUES (?, ?, ?, ?, ?, ?, ?)";
      try (Connection conn = ConexionDB.obtenerConexion();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

          stmt.setString(1, persona.getNombre());
          stmt.setString(2, persona.getApellido());
          stmt.setString(3, persona.getDni());
          stmt.setDate(4, java.sql.Date.valueOf(persona.getFechaNacimiento()));
          stmt.setString(5, persona.getTelefono());
          stmt.setString(6, persona.getEmail());
          stmt.setString(7, persona.getDireccion());

          return stmt.executeUpdate() > 0;

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return false;
  }

  @Override
  public boolean actualizar(Persona persona) {
      String sql = "UPDATE persona SET nombre = ?, apellido = ?, dni = ?, fecha_nacimiento = ?, telefono = ?, email = ?, direccion = ? WHERE id_persona = ?";
      try (Connection conn = ConexionDB.obtenerConexion();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

          stmt.setString(1, persona.getNombre());
          stmt.setString(2, persona.getApellido());
          stmt.setString(3, persona.getDni());
          stmt.setDate(4, Date.valueOf(persona.getFechaNacimiento()));
          stmt.setString(5, persona.getTelefono());
          stmt.setString(6, persona.getEmail());
          stmt.setString(7, persona.getDireccion());
          stmt.setInt(8, persona.getId());

          return stmt.executeUpdate() > 0;

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return false;
  }

  @Override
  public boolean eliminar(int id) {
      String sql = "DELETE FROM persona WHERE id_persona = ?";
      try (Connection conn = ConexionDB.obtenerConexion();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

          stmt.setInt(1, id);
          return stmt.executeUpdate() > 0;

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return false;
  }

  private Persona mapearPersona(ResultSet rs) throws SQLException {
      Persona p = new Paciente();
      p.setId(rs.getInt("id_persona"));
      p.setNombre(rs.getString("nombre"));
      p.setApellido(rs.getString("apellido"));
      p.setDni(rs.getString("dni"));
      p.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
      p.setTelefono(rs.getString("telefono"));
      p.setEmail(rs.getString("email"));
      p.setDireccion(rs.getString("direccion"));
      return p;
  }
}
