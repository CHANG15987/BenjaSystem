
package MODELO;

import java.time.LocalDateTime;

public class DetalleVenta {
    private int id;
    private String id_venta;
    private String id_producto;
    private String id_usuario;
    private String nombre;
    private int cantidad_vendida;
    private double total_venta;
    private LocalDateTime fecha_hora_venta;

    // Constructor vacío
    public DetalleVenta() {
    }

    // Constructor con todos los campos
    public DetalleVenta(int id, String id_venta, String id_producto, String id_usuario, String nombre, int cantidad_vendida, double total_venta, LocalDateTime fecha_hora_venta) {
        this.id = id;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.cantidad_vendida = cantidad_vendida;
        this.total_venta = total_venta;
        this.fecha_hora_venta = fecha_hora_venta;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public LocalDateTime getFecha_hora_venta() {
        return fecha_hora_venta;
    }

    public void setFecha_hora_venta(LocalDateTime fecha_hora_venta) {
        this.fecha_hora_venta = fecha_hora_venta;
    }
}