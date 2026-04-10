package proyecto.model;

import java.time.LocalDateTime;

public class Recordatorio extends Elemento {

    private LocalDateTime fechaHora;
    private String icono;

    public Recordatorio() {
        super();
    }

    public Recordatorio(String titulo, String descripcion, Estado estado, Prioridad prioridad,
                        LocalDateTime fechaCreacion, LocalDateTime fechaHora, String icono, User creador) {

        super(titulo, descripcion, estado, prioridad, fechaCreacion, creador);
        this.fechaHora = fechaHora;
        this.icono = icono;
    }

    public void programar() {
        System.out.println("Recordatorio programado para: " + fechaHora);
    }
}
