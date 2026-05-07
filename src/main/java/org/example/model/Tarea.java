package org.example.model;

import org.example.catalog.Estado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarea extends Elemento {

    private LocalDateTime fechaVencimiento;

    public Tarea(String titulo, String descripcion) {
        super(titulo, descripcion);
        this.fechaVencimiento = LocalDateTime.now().plusDays(7);
    }

    public Tarea(String titulo, String descripcion, LocalDateTime fechaVencimiento) {
        super(titulo, descripcion);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public void mostrarInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("[Tarea #" + id + "] " + titulo +
            " | Estado: " + estado +
            " | Prioridad: " + prioridad +
            " | Vence: " + fechaVencimiento.format(fmt));
    }

    public Estado getEstadoActual() {
        return estado;
    }

    public void modificarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
