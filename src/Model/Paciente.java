package Model;

import java.time.LocalDate;

public class Paciente extends Persona {
  private String obraSocial;

  public Paciente() {
  }
   public Paciente(int id, String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
      String direccion, Rol rol, Especialidad especialidad, Estado estado, LocalDate fechaCreacion,
      LocalDate ultimaModificacion, String obraSocial) {
    super(id, dni, nombre, apellido, email, telefono, fechaNacimiento,direccion, rol, especialidad, estado, 
    LocalDate.now(), LocalDate.now());
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
