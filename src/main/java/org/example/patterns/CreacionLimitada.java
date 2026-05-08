package org.example.patterns;

import org.example.model.Usuario;

/**
 * Estrategia que limita el número de elementos activos que puede crear un
 * usuario. Pensada para {@link org.example.model.UsuarioClasico}.
 * <p>
 * Si el contador del usuario alcanza su {@code limiteTareas}, lanza
 * {@link IllegalStateException} y bloquea la creación.
 */
public class CreacionLimitada implements EstrategiaCreacion {

    /**
     * {@inheritDoc}
     * <p>Permite la creación solo si el contador del usuario es estrictamente
     * menor que su límite configurado.
     */
    @Override
    public boolean validarLimite(Usuario u) {
        return u.getContadorTareasActivas() < u.getLimiteTareas();
    }

    /**
     * {@inheritDoc}
     * <p>Incrementa el contador de tareas activas; si el límite ya se alcanzó,
     * aborta la operación con una excepción.
     */
    @Override
    public void aplicarReglas(Usuario u) {
        if (!validarLimite(u)) {
            throw new IllegalStateException(
                "El usuario " + u.getNombre() +
                " alcanzó el límite de " + u.getLimiteTareas() + " tareas activas."
            );
        }
        u.setContadorTareasActivas(u.getContadorTareasActivas() + 1);
    }
}
