
package MODELO;

import java.time.LocalDateTime;

public class Venta {
    private String id_venta;
    private String id_cliente;
    private LocalDateTime fecha_hora_venta;
    private double total_venta;

    // Constructor vacío
    public Venta() {
    }

    // Constructor con todos los campos
    public Venta(String id_venta, String id_cliente, LocalDateTime fecha_hora_venta, double total_venta) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.fecha_hora_venta = fecha_hora_venta;
        this.total_venta = total_venta;
    }

    // Getters y Setters
    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getFecha_hora_venta() {
        return fecha_hora_venta;
    }

    public void setFecha_hora_venta(LocalDateTime fecha_hora_venta) {
        this.fecha_hora_venta = fecha_hora_venta;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }
}