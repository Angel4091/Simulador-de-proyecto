package proyecto.model;

import java.time.LocalDateTime;

public class Recordatorio extends Elemento {

    private LocalDateTime fechaHora;
    private String icono;

    // Constructor vacío
    public Recordatorio() {
        super(); //Llama al constructor vacío de Elemento
    }

    // Constructor con parámetros
    public Recordatorio(String titulo, String descripcion, Estado estado, Prioridad prioridad,
                        LocalDateTime fechaCreacion, LocalDateTime fechaHora, String icono) {
        super(titulo, descripcion, estado, prioridad, fechaCreacion); //Envía a la clase padre lo común
        //Atributos propios de Recordatorio
        this.fechaHora = fechaHora;
        this.icono = icono;
    }

    //Metodo propio de la clase Recordatorio
    public void programar() {
        System.out.println("Recordatorio programado para: " + fechaHora);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); //Para imprimir lo heredado
        System.out.println("Fecha y hora del recordatorio: " + fechaHora);
        System.out.println("Ícono: " + icono);
    }

    //Setters y Getters
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}