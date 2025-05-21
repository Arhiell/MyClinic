package Dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
impoort Model.Estado;
import Model.Paciente;  
import Model.Profesional;
import Model.Turno;
import Dao.BaseDAO;

public class TurnoDAO implements BaseDAO<Turno> {

  private Connection connection;

  public TurnosDAO(Connection connection) {
      this.connection = connection;
  }

  public List<Turno> obtenerTodos() throws SQLException {
      List<Turno> turnos = new ArrayList<>();
      String sql = "SELECT id_turno, comprobante, id_paciente, id_profesional, fecha_hora, duracion, id_estado, observaciones FROM turno";

      try (PreparedStatement ps = connection.prepareStatement(sql);
           ResultSet rs = ps.executeQuery()) {
          while (rs.next()) {
              Turno t = new Turno();
              t.setIdTurno(rs.getInt("id_turno"));
              t.setComprobante(rs.getString("comprobante"));
              t.setIdPaciente(rs.getInt("id_paciente"));
              t.setIdProfesional(rs.getInt("id_profesional"));
              t.setFechaHora(rs.getTimestamp("fecha_hora"));
              t.setDuracion(rs.getInt("duracion"));
              t.setIdEstado(rs.getInt("id_estado"));
              t.setObservaciones(rs.getString("observaciones"));
              turnos.add(t);
          }
      }

      return turnos;
  }

  public boolean insertarTurno(Turno turno) throws SQLException {
      String sql = "INSERT INTO turno (comprobante, id_paciente, id_profesional, fecha_hora, duracion, id_estado, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
      try (PreparedStatement ps = connection.prepareStatement(sql)) {
          ps.setString(1, turno.getComprobante());
          ps.setPaciente(2, turno.getIdPaciente());
          ps.setInt(3, turno.getIdProfesional());
          ps.setTimestamp(4, new Timestamp(turno.getFechaHora().getTime()));
          ps.setInt(5, turno.getDuracion());
          ps.setInt(6, turno.getIdEstado());
          ps.setString(7, turno.getObservaciones());
          int filas = ps.executeUpdate();
          return filas > 0;
      }
  }

  // Agregar más métodos como actualizar, eliminar, buscar por id, etc.
}
