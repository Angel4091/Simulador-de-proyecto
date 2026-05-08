package org.example.model;

import java.util.List;

/**
 * Contrato para elementos que admiten colaboración entre usuarios.
 * <p>
 * Implementado por {@link Elemento}. Centraliza la gestión de la lista de
 * colaboradores: consultar, añadir o eliminar usuarios con acceso al
 * elemento.
 */
public interface Colaborable {

    /**
     * @return {@code true} si al menos un colaborador tiene acceso al
     *         elemento, además del propietario
     */
    boolean estaCompartido();

    /**
     * @return lista (posiblemente vacía) de usuarios con los que se compartió
     *         el elemento
     */
    List<Usuario> obtenerColaboradores();

    /**
     * Añade un usuario como colaborador del elemento.
     *
     * @param u usuario al que se concede acceso
     */
    void agregarColaborador(Usuario u);

    /**
     * Revoca el acceso de un colaborador previamente añadido.
     *
     * @param u usuario al que se le quita el acceso
     */
    void eliminarColaborador(Usuario u);
}
