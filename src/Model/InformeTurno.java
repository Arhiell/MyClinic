package Model;

import java.time.LocalDateTime;


public class InformeTurno {
  private int id;
  private Turno turno;
  private Paciente paciente;
  private Especialidad especialidad;
  private Profesional profesional;
  private String observaciones;
  private LocalDateTime fechaCreacion;
  private Estado estado;

  public InformeTurno() {
  }

  public InformeTurno(int id, Turno turno, Paciente paciente, Especialidad especialidad, Profesional profesional,
      String observaciones, LocalDateTime fechaCreacion, Estado estado) {
    this.id = id;
    this.turno = turno;
    this.paciente = paciente;
    this.especialidad = especialidad;
    this.profesional = profesional;
    this.observaciones = observaciones;
    this.fechaCreacion = fechaCreacion;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public Especialidad getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(Especialidad especialidad) {
    this.especialidad = especialidad;
  }

  public Profesional getProfesional() {
    return profesional;
  }

  public void setProfesional(Profesional profesional) {
    this.profesional = profesional;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "InformeTurno [id=" + id + ", turno=" + turno + ", paciente=" + paciente + ", especialidad=" + especialidad
        + ", profesional=" + profesional + ", observaciones=" + observaciones + ", fechaCreacion=" + fechaCreacion
        + ", estado=" + estado + "]";
  }

}
