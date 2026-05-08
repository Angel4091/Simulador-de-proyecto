package org.example.model;

import org.example.patterns.CreacionLimitada;

/**
 * Usuario clásico (cuenta gratuita): tiene un cupo máximo de elementos
 * activos y solo puede crear instancias de {@link Tarea}.
 * <p>
 * Es un <b>ConcreteCreator</b> del Factory Method y arranca con la
 * estrategia {@link CreacionLimitada} preconfigurada.
 */
public class UsuarioClasico extends Usuario {

    /** Cota por defecto para usuarios clásicos. */
    private static final int LIMITE_DEFAULT = 10;

    /**
     * Crea un usuario clásico con el límite estándar y la estrategia
     * limitada ya configurada.
     *
     * @param nombre   nombre visible
     * @param email    correo de inicio de sesión
     * @param password contraseña asociada
     */
    public UsuarioClasico(String nombre, String email, String password) {
        super(nombre, email, password, LIMITE_DEFAULT);
        setEstrategia(new CreacionLimitada());
    }

    /**
     * {@inheritDoc}
     * <p>Produce siempre una {@link Tarea}.
     */
    @Override
    public Elemento crearElemento(String titulo, String descripcion) {
        return new Tarea(titulo, descripcion);
    }

    /**
     * Atajo de conveniencia: comparte un elemento del usuario actual con
     * otro colaborador.
     *
     * @param e elemento sobre el que se concede acceso
     * @param u usuario que pasa a ser colaborador
     */
    public void agregarColaborador(Elemento e, Usuario u) {
        e.agregarColaborador(u);
    }
}
