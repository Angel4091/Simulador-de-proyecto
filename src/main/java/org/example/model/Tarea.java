package org.example.model;

import org.example.catalog.Estado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Producto concreto del Factory Method que representa una tarea con fecha
 * de vencimiento. Producida por {@link UsuarioClasico}.
 *
 * @see Elemento
 */
public class Tarea extends Elemento {

    /** Fecha y hora límite para completar la tarea. */
    private LocalDateTime fechaVencimiento;

    /**
     * Crea una tarea con vencimiento por defecto a 7 días.
     *
     * @param titulo      título de la tarea
     * @param descripcion descripción extendida
     */
    public Tarea(String titulo, String descripcion) {
        super(titulo, descripcion);
        this.fechaVencimiento = LocalDateTime.now().plusDays(7);
    }

    /**
     * Crea una tarea especificando manualmente la fecha de vencimiento.
     *
     * @param titulo           título de la tarea
     * @param descripcion      descripción extendida
     * @param fechaVencimiento fecha límite concreta
     */
    public Tarea(String titulo, String descripcion, LocalDateTime fechaVencimiento) {
        super(titulo, descripcion);
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * {@inheritDoc}
     * <p>Imprime id, título, estado, prioridad y fecha de vencimiento.
     */
    @Override
    public void mostrarInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("[Tarea #" + id + "] " + titulo +
            " | Estado: " + estado +
            " | Prioridad: " + prioridad +
            " | Vence: " + fechaVencimiento.format(fmt));
    }

    /** @return estado actual (alias del getter heredado) */
    public Estado getEstadoActual() {
        return estado;
    }

    /**
     * Modifica el estado de la tarea.
     *
     * @param nuevoEstado nuevo estado del ciclo de vida
     */
    public void modificarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /** @return fecha y hora límite para completar la tarea */
    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Actualiza la fecha de vencimiento.
     *
     * @param fechaVencimiento nueva fecha límite
     */
    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
