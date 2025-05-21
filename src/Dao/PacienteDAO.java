package Dao;

import Model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    // Insertar paciente
    public boolean insert(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nombre, apellido, dni, telefono, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDni());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getEmail());
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(paciente.getFechaNacimiento()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }

            // Obtener el ID generado y setearlo en paciente
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    paciente.setId(generatedKeys.getInt(1));
                }
            }
            return true;
        }
    }

    // Actualizar paciente
    public boolean update(Paciente paciente) throws SQLException {
        String sql = "UPDATE pacientes SET nombre = ?, apellido = ?, dni = ?, telefono = ?, email = ?, fecha_nacimiento = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDni());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getEmail());
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(paciente.getFechaNacimiento()));
            ps.setInt(7, paciente.getId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Eliminar paciente por id
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Buscar paciente por id
    public Paciente getById(int id) throws SQLException {
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapPaciente(rs);
                } else {
                    return null;
                }
            }
        }
    }

    // Obtener todos los pacientes
    public List<Paciente> getAll() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pacientes.add(mapPaciente(rs));
            }
        }
        return pacientes;
    }

    // Método para mapear ResultSet a objeto Paciente
    private Paciente mapPaciente(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(rs.getInt("id"));
        paciente.setNombre(rs.getString("nombre"));
        paciente.setApellido(rs.getString("apellido"));
        paciente.setDni(rs.getString("dni"));
        paciente.setTelefono(rs.getString("telefono"));
        paciente.setEmail(rs.getString("email"));
        paciente.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento").toLocalDateTime());
        return paciente;
    }
}
