package Model;

import java.time.LocalDateTime;

public class Paciente extends Persona {
  private String obraSocial;

  public Paciente() {
  }
   public Paciente(int id, String dni, String nombre, String apellido, String email, String telefono, String direccion,
      Rol rol, Especialidad especialidad, Estado estado, String obraSocial) {
    super(id, dni, nombre, apellido, email, telefono, direccion, rol, especialidad, estado,
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
