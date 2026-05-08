package org.example.model;

import org.example.catalog.Estado;
import org.example.catalog.Prioridad;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase base abstracta para los elementos manipulables por los usuarios
 * (tareas, recordatorios, etc.). Juega el rol de <b>Product</b> en el
 * patrón <b>Factory Method</b> implementado por {@link Usuario}.
 * <p>
 * Implementa {@link Colaborable} para gestionar la colaboración compartida
 * entre usuarios y mantiene atributos comunes como estado, prioridad y
 * fecha de creación.
 *
 * @see Tarea
 * @see Recordatorio
 */
public abstract class Elemento implements Colaborable {

    /** Generador autoincremental thread-safe para el id de cada elemento. */
    private static final AtomicInteger SECUENCIA = new AtomicInteger(1);

    /** Identificador único asignado al crear el elemento. */
    protected int id;
    /** Título corto del elemento. */
    protected String titulo;
    /** Descripción extendida del elemento. */
    protected String descripcion;
    /** Estado actual dentro del ciclo de vida (ver {@link Estado}). */
    protected Estado estado;
    /** Nivel de urgencia (ver {@link Prioridad}). */
    protected Prioridad prioridad;
    /** Marca temporal de cuándo se creó el elemento. */
    protected LocalDateTime fechaCreacion;
    /** Usuarios con los que se ha compartido el elemento. */
    protected List<Usuario> colaboradores;

    /**
     * Constructor protegido. Inicializa id, fecha de creación y valores por
     * defecto ({@link Estado#PENDIENTE}, {@link Prioridad#MEDIA}).
     *
     * @param titulo      título del elemento
     * @param descripcion descripción extendida
     */
    protected Elemento(String titulo, String descripcion) {
        this.id = SECUENCIA.getAndIncrement();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
        this.prioridad = Prioridad.MEDIA;
        this.fechaCreacion = LocalDateTime.now();
        this.colaboradores = new ArrayList<>();
    }

    /** Imprime por consola la información completa del elemento. */
    public abstract void mostrarInfo();

    /**
     * Actualiza el estado del elemento.
     *
     * @param estado nuevo estado del ciclo de vida
     */
    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Actualiza la prioridad del elemento.
     *
     * @param prioridad nueva prioridad
     */
    public void establecerPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    /** {@inheritDoc} */
    @Override
    public List<Usuario> obtenerColaboradores() {
        return colaboradores;
    }

    /**
     * {@inheritDoc}
     * <p>Si el usuario aún no era colaborador, lo añade y refleja el cambio
     * en su lista de items compartidos.
     */
    @Override
    public void agregarColaborador(Usuario u) {
        if (!colaboradores.contains(u)) {
            colaboradores.add(u);
            u.getItemsCompartidos().add(this);
        }
    }

    /**
     * {@inheritDoc}
     * <p>También limpia la referencia inversa en la lista del usuario.
     */
    @Override
    public void eliminarColaborador(Usuario u) {
        if (colaboradores.remove(u)) {
            u.getItemsCompartidos().remove(this);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean estaCompartido() {
        return !colaboradores.isEmpty();
    }

    /** @return identificador único del elemento */
    public int getId() { return id; }
    /** @return título del elemento */
    public String getTitulo() { return titulo; }
    /** @return descripción del elemento */
    public String getDescripcion() { return descripcion; }
    /** @return estado actual del elemento */
    public Estado getEstado() { return estado; }
    /** @return prioridad actual del elemento */
    public Prioridad getPrioridad() { return prioridad; }
    /** @return marca temporal de creación */
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
