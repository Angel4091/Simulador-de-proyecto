package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recordatorio extends Elemento {

    private LocalDateTime fechaHora;
    private boolean alertaActiva;

    public Recordatorio(String titulo, String descripcion) {
        super(titulo, descripcion);
        this.fechaHora = LocalDateTime.now().plusHours(1);
        this.alertaActiva = true;
    }

    public Recordatorio(String titulo, String descripcion, LocalDateTime fechaHora) {
        super(titulo, descripcion);
        this.fechaHora = fechaHora;
        this.alertaActiva = true;
    }

    @Override
    public void mostrarInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("[Recordatorio #" + id + "] " + titulo +
            " | Cuándo: " + fechaHora.format(fmt) +
            " | Alerta: " + (alertaActiva ? "ON" : "OFF"));
    }

    public String obtenerDatosFecha() {
        return fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void modificarAlerta(boolean activa) {
        this.alertaActiva = activa;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
