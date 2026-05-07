package org.example.model;

import java.util.List;

public interface Colaborable {
    boolean estaCompartido();
    List<Usuario> obtenerColaboradores();
    void agregarColaborador(Usuario u);
    void eliminarColaborador(Usuario u);
}
