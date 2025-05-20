package Model;

import java.time.LocalDateTime;

public abstract class Persona {
  protected int id;
  protected String dni;
  protected String nombre;
  protected String apellido;
  protected String email;
  protected String telefono;
  protected DATE fechaNcimiento;
  protected String direccion;
  protected Rol rol;
  protected Especialidad especialidad; // null si no aplica
  protected Estado estado;
  protected LocalDateTime fechaCreacion;
  protected LocalDateTime ultimaModificacion;

  public Persona() {
  }

  public Persona(int id, String dni, String nombre, String apellido, String email, String telefono, DATE fechaNcimiento,
      String direccion, Rol rol, Especialidad especialidad, Estado estado, LocalDateTime fechaCreacion,
      LocalDateTime ultimaModificacion) {
    this.id = id;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.fechaNcimiento = fechaNcimiento;
    this.direccion = direccion;
    this.rol = rol;
    this.especialidad = especialidad;
    this.estado = estado;
    this.fechaCreacion = fechaCreacion;
    this.ultimaModificacion = ultimaModificacion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public DATE getFechaNcimiento() {
    return fechaNcimiento;
  }

  public void setFechaNcimiento(DATE fechaNcimiento) {
    this.fechaNcimiento = fechaNcimiento;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  public Especialidad getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(Especialidad especialidad) {
    this.especialidad = especialidad;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public LocalDateTime getUltimaModificacion() {
    return ultimaModificacion;
  }

  public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
    this.ultimaModificacion = ultimaModificacion;
  }

  @Override
  public String toString() {
    return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
        + ", telefono=" + telefono + ", fechaNcimiento=" + fechaNcimiento + ", direccion=" + direccion + ", rol=" + rol
        + ", especialidad=" + especialidad + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion
        + ", ultimaModificacion=" + ultimaModificacion + "]";
  }


}
