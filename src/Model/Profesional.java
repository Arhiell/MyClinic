package Model;

import java.time.LocalDate;

public class Profesional extends Persona {
  private String matriculaProfesional;

  public Profesional() {
  }
  
  public Profesional(int id, String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
      String direccion, Rol rol, Especialidad especialidad, Estado estado, LocalDate fechaCreacion,
      LocalDate ultimaModificacion, String matriculaProfesional) {
    super(id, dni, nombre, apellido, email, telefono, fechaNacimiento,direccion, rol, especialidad, estado, 
    LocalDate.now(), LocalDate.now());
    this.matriculaProfesional = matriculaProfesional;
  }

  public String getMatriculaProfesional() {
    return matriculaProfesional;
  }

  public void setMatriculaProfesional(String matriculaProfesional) {
    this.matriculaProfesional = matriculaProfesional;
  }
  
  @Override
  public String toString() {
    return "Profesional [matriculaProfesional=" + matriculaProfesional + "]";
  }
}
