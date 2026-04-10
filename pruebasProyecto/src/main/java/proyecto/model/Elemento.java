package proyecto.model;

import java.time.LocalDateTime;

public abstract class Elemento {

    protected String titulo;
    protected String descripcion;
    protected Estado estado;
    protected Prioridad prioridad;
    protected LocalDateTime fechaCreacion;
    protected Usuario creador;

    public Elemento() {
    }

    public Elemento(String titulo, String descripcion, Estado estado, Prioridad prioridad, LocalDateTime fechaCreacion, Usuario creador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.creador = creador;
    }

    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Estado: " + estado);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Fecha creacion: " + fechaCreacion);
        System.out.println("Creador: " + creador.getNombre());
    }

    public void cambiarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Usuario getCreador() {
        return creador;
    }
}
