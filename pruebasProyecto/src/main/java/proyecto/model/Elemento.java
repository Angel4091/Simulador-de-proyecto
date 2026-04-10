package proyecto.model;

import java.time.LocalDateTime;

public abstract class Elemento {

    //atributos
    protected String titulo;
    protected String descripcion;
    protected Estado estado;
    protected Prioridad prioridad;
    protected LocalDateTime fechaCreacion;

    //Constructor vacio
    public Elemento() {}

    //Constructor Parametrizado
    public Elemento(String titulo, String descripcion, Estado estado, Prioridad prioridad, LocalDateTime fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
    }

    //metodos
    public void mostrarInfo(){
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Estado: " + estado);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Fecha creacion: " + fechaCreacion);
    }

    public void cambiarEstado(Estado nuevoEstado){
        this.estado = nuevoEstado;
    }

    public Usuario getCreador(){
        return creador();
    }

    //Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setNombre(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
