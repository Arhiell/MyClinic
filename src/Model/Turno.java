package Model;

import java.time.LocalDate;

public class Turno {
  private int id;
  private String comprobante;
  private Paciente paciente;
  private Profesional profesional;
  private LocalDate fecha_hora;
  private int duracion;
  private Estado estado;
  private String obserbacion;
  private LocalDate fechaCreacion;
  private LocalDate ultimaModificacion;

  public Turno() {
  }

  public Turno(int id, String comprobante, Paciente paciente, Profesional profesional, LocalDate fecha_hora,
      int duracion, Estado estado, String obserbacion, LocalDate fechaCreacion, LocalDate ultimaModificacion) {
    this.id = id;
    this.comprobante = comprobante;
    this.paciente = paciente;
    this.profesional = profesional;
    this.fecha_hora = fecha_hora;
    this.duracion = duracion;
    this.estado = estado;
    this.obserbacion = obserbacion;
    this.fechaCreacion = fechaCreacion;
    this.ultimaModificacion = ultimaModificacion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getComprobante() {
    return comprobante;
  }

  public void setComprobante(String comprobante) {
    this.comprobante = comprobante;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public Profesional getProfesional() {
    return profesional;
  }

  public void setProfesional(Profesional profesional) {
    this.profesional = profesional;
  }

  public LocalDate getFecha_hora() {
    return fecha_hora;
  }

  public void setFecha_hora(LocalDate fecha_hora) {
    this.fecha_hora = fecha_hora;
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public String getObserbacion() {
    return obserbacion;
  }

  public void setObserbacion(String obserbacion) {
    this.obserbacion = obserbacion;
  }

  public LocalDate getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public LocalDate getUltimaModificacion() {
    return ultimaModificacion;
  }

  public void setUltimaModificacion(LocalDate ultimaModificacion) {
    this.ultimaModificacion = ultimaModificacion;
  }

  @Override
  public String toString() {
    return "Turno [id=" + id + ", comprobante=" + comprobante + ", paciente=" + paciente + ", profesional="
        + profesional + ", fecha_hora=" + fecha_hora + ", duracion=" + duracion + ", estado=" + estado
        + ", obserbacion=" + obserbacion + ", fechaCreacion=" + fechaCreacion + ", ultimaModificacion="
        + ultimaModificacion + "]";
  }

  
}
