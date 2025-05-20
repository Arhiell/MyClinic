package Model;

public class Especialidad {
  private int id;
  private String nombre;
  private String descripcion;
  private Estado estado;
  
  public Especialidad() {
  }

  public Especialidad(int id, String nombre, String descripcion, Estado estado) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Especialidad [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
        + "]";
  }

}
