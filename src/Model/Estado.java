package Model;

public class Estado {
  private int id;
  private String nombre;
  private String descripcion;
  private Entidad entidad;

  public Estado() {
  }

  public Estado(int id, String nombre, String descripcion, Entidad entidad) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.entidad = entidad;
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

  public Entidad getEntidad() {
    return entidad;
  }

  public void setEntidad(Entidad entidad) {
    this.entidad = entidad;
  }

  @Override
  public String toString() {
    return "Estado [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", entidad=" + entidad + "]";
  }

}
