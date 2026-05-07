package org.example.model;

import org.example.patterns.CreacionLimitada;

public class UsuarioClasico extends Usuario {

    private static final int LIMITE_DEFAULT = 10;

    public UsuarioClasico(String nombre, String email, String password) {
        super(nombre, email, password, LIMITE_DEFAULT);
        setEstrategia(new CreacionLimitada());
    }

    @Override
    public Elemento crearElemento(String titulo, String descripcion) {
        return new Tarea(titulo, descripcion);
    }

    public void agregarColaborador(Elemento e, Usuario u) {
        e.agregarColaborador(u);
    }
}
