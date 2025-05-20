package Model;

import java.time.LocalTime;

public class HorarioDisponible {
  private int id;
  private Profesional profesional;
  private String diaSemana;
  private LocalTime horarioInicio;
  private LocalTime horarioFin;
  private Estado estado;

  public HorarioDisponible() {
  }

  public HorarioDisponible(int id, Profesional profesional, String diaSemana, LocalTime horarioInicio,
      LocalTime horarioFin, Estado estado) {
    this.id = id;
    this.profesional = profesional;
    this.diaSemana = diaSemana;
    this.horarioInicio = horarioInicio;
    this.horarioFin = horarioFin;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Profesional getProfesional() {
    return profesional;
  }

  public void setProfesional(Profesional profesional) {
    this.profesional = profesional;
  }

  public String getDiaSemana() {
    return diaSemana;
  }

  public void setDiaSemana(String diaSemana) {
    this.diaSemana = diaSemana;
  }

  public LocalTime getHorarioInicio() {
    return horarioInicio;
  }

  public void setHorarioInicio(LocalTime horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  public LocalTime getHorarioFin() {
    return horarioFin;
  }

  public void setHorarioFin(LocalTime horarioFin) {
    this.horarioFin = horarioFin;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "HorarioDisponible [id=" + id + ", profesional=" + profesional + ", diaSemana=" + diaSemana
        + ", horarioInicio=" + horarioInicio + ", horarioFin=" + horarioFin + ", estado=" + estado + "]";
  }

  
}
