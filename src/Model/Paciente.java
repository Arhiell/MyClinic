package Model;

import java.time.LocalDateTime;

public class Paciente extends Persona {
  private String obraSocial;

  public Paciente() {
  }
   public Paciente(int id, String dni, String nombre, String apellido, String email, String telefono, LocalDateTime fechaNacimiento,
      String direccion, Rol rol, Especialidad especialidad, Estado estado, LocalDateTime fechaCreacion,
      LocalDateTime ultimaModificacion, String obraSocial) {
    super(id, dni, nombre, apellido, email, telefono, fechaNacimiento,direccion, rol, especialidad, estado, 
    LocalDateTime.now(), LocalDateTime.now());
    this.obraSocial = obraSocial;
  }


  public String getObraSocial() {
    return obraSocial;
  }
  public void setObraSocial(String obraSocial) {
    this.obraSocial = obraSocial;
  }
  @Override
  public String toString() {
    return "Paciente [obraSocial=" + obraSocial + "]";
  }
  
}
