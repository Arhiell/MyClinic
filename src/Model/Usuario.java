package Model;

public class Usuario {
  private int idUsuario;
  private String nombreUsuario;
  private String contrasena;
  private Persona persona;
  private Estado estado;
  private String rol;

  public Usuario() {}

  public Usuario(int idUsuario, String nombreUsuario, String contrasena, Persona persona, Estado estado, String rol) {
    this.idUsuario = idUsuario;
    this.nombreUsuario = nombreUsuario;
    this.contrasena = contrasena;
    this.persona = persona;
    this.estado = estado;
    this.rol = rol;
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }
  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  @Override
  public String toString() {
    return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena
        + ", persona=" + persona + ", estado=" + estado + "]";
  }

}
