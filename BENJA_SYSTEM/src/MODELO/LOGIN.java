
package MODELO;

import java.time.LocalDate;

public class LOGIN {
    private String id;
    private int dni;
    private String nombre;
    private String Apellido;
    private String email;
    private String pass;
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private String distrito;
    private int telefono;
    private String tipo;
    private String estado;
    private LocalDate fecha_creacion;

    public LOGIN() {
    }

    public LOGIN(String id, int dni, String nombre, String Apellido, String email, String pass, LocalDate fechaNacimiento, String genero, String direccion, String distrito, int telefono, String tipo, String estado, LocalDate fecha_creacion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.email = email;
        this.pass = pass;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.distrito = distrito;
        this.telefono = telefono;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
     
}
