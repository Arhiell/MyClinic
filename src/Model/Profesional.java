package Model;

import java.time.LocalDateTime;

public class Profesional extends Persona {
  private String matriculaProfesional;

  public Profesional() {
  }
  
  public Profesional(int id, String dni, String nombre, String apellido, String email, String telefono, String direccion,
      Rol rol, Especialidad especialidad, Estado estado, String matriculaProfesional) {
    super(id, dni, nombre, apellido, email, telefono, direccion, rol, especialidad, estado,
        LocalDateTime.now(), LocalDateTime.now());
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
