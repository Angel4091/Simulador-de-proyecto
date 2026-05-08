package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Producto concreto del Factory Method que representa un recordatorio con
 * fecha/hora puntual y alerta opcional. Producido por {@link UsuarioPremium}.
 *
 * @see Elemento
 */
public class Recordatorio extends Elemento {

    /** Momento exacto en el que debe dispararse el recordatorio. */
    private LocalDateTime fechaHora;
    /** Indica si la notificación está habilitada. */
    private boolean alertaActiva;

    /**
     * Crea un recordatorio para dentro de una hora con la alerta activa.
     *
     * @param titulo      título del recordatorio
     * @param descripcion descripción extendida
     */
    public Recordatorio(String titulo, String descripcion) {
        super(titulo, descripcion);
        this.fechaHora = LocalDateTime.now().plusHours(1);
        this.alertaActiva = true;
    }

    /**
     * Crea un recordatorio en una fecha/hora específica.
     *
     * @param titulo      título del recordatorio
     * @param descripcion descripción extendida
     * @param fechaHora   instante en el que debe dispararse
     */
    public Recordatorio(String titulo, String descripcion, LocalDateTime fechaHora) {
        super(titulo, descripcion);
        this.fechaHora = fechaHora;
        this.alertaActiva = true;
    }

    /**
     * {@inheritDoc}
     * <p>Imprime id, título, fecha/hora del aviso y estado de la alerta.
     */
    @Override
    public void mostrarInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("[Recordatorio #" + id + "] " + titulo +
            " | Cuándo: " + fechaHora.format(fmt) +
            " | Alerta: " + (alertaActiva ? "ON" : "OFF"));
    }

    /** @return fecha/hora del aviso formateada como cadena legible */
    public String obtenerDatosFecha() {
        return fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    /**
     * Habilita o deshabilita la alerta del recordatorio.
     *
     * @param activa {@code true} para activar, {@code false} para silenciar
     */
    public void modificarAlerta(boolean activa) {
        this.alertaActiva = activa;
    }

    /** @return instante exacto en el que se disparará el recordatorio */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
