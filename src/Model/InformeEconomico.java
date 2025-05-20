package Model;

import java.time.LocalDateTime;

public class InformeEconomico {
  private int id;
  private Especialidad especialidad;
  private int cantidadTurnos;
  private double totalFacturado;
  private LocalDateTime fechaInicio;
  private LocalDateTime fechaFin;
  private LocalDateTime fechaCreacion;
  private Estado estado;
  
  public InformeEconomico() {
  }

  public InformeEconomico(int id, Especialidad especialidad, int cantidadTurnos, double totalFacturado,
      LocalDateTime fechaInicio, LocalDateTime fechaFin, LocalDateTime fechaCreacion, Estado estado) {
    this.id = id;
    this.especialidad = especialidad;
    this.cantidadTurnos = cantidadTurnos;
    this.totalFacturado = totalFacturado;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.fechaCreacion = fechaCreacion;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Especialidad getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(Especialidad especialidad) {
    this.especialidad = especialidad;
  }

  public int getCantidadTurnos() {
    return cantidadTurnos;
  }

  public void setCantidadTurnos(int cantidadTurnos) {
    this.cantidadTurnos = cantidadTurnos;
  }

  public double getTotalFacturado() {
    return totalFacturado;
  }

  public void setTotalFacturado(double totalFacturado) {
    this.totalFacturado = totalFacturado;
  }

  public LocalDateTime getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDateTime fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDateTime getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDateTime fechaFin) {
    this.fechaFin = fechaFin;
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
    return "InformeEconomico [id=" + id + ", especialidad=" + especialidad + ", cantidadTurnos=" + cantidadTurnos
        + ", totalFacturado=" + totalFacturado + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
        + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + "]";
  }

  
}
