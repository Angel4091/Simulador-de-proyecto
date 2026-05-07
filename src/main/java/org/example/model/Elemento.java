package org.example.model;

import org.example.catalog.Estado;
import org.example.catalog.Prioridad;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Elemento implements Colaborable {

    private static final AtomicInteger SECUENCIA = new AtomicInteger(1);

    protected int id;
    protected String titulo;
    protected String descripcion;
    protected Estado estado;
    protected Prioridad prioridad;
    protected LocalDateTime fechaCreacion;
    protected List<Usuario> colaboradores;

    protected Elemento(String titulo, String descripcion) {
        this.id = SECUENCIA.getAndIncrement();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
        this.prioridad = Prioridad.MEDIA;
        this.fechaCreacion = LocalDateTime.now();
        this.colaboradores = new ArrayList<>();
    }

    public abstract void mostrarInfo();

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public void establecerPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public List<Usuario> obtenerColaboradores() {
        return colaboradores;
    }

    @Override
    public void agregarColaborador(Usuario u) {
        if (!colaboradores.contains(u)) {
            colaboradores.add(u);
            u.getItemsCompartidos().add(this);
        }
    }

    @Override
    public void eliminarColaborador(Usuario u) {
        if (colaboradores.remove(u)) {
            u.getItemsCompartidos().remove(this);
        }
    }

    @Override
    public boolean estaCompartido() {
        return !colaboradores.isEmpty();
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public Estado getEstado() { return estado; }
    public Prioridad getPrioridad() { return prioridad; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
