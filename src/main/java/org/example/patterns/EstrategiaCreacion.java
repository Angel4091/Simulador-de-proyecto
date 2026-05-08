package org.example.patterns;

import org.example.model.Usuario;

/**
 * Contrato del patrón <b>Strategy</b> para las reglas de creación de elementos.
 * <p>
 * Cada implementación define un comportamiento intercambiable que el
 * {@link Usuario} delega al momento de crear un nuevo elemento. Permite que un
 * {@link org.example.model.UsuarioClasico} aplique límites distintos a un
 * {@link org.example.model.UsuarioPremium} sin modificar la jerarquía.
 *
 * @see CreacionLimitada
 * @see CreacionIlimitada
 */
public interface EstrategiaCreacion {

    /**
     * Indica si el usuario aún puede crear un nuevo elemento.
     *
     * @param u usuario sobre el que se evalúa la regla
     * @return {@code true} si la creación está permitida; {@code false} si se
     *         alcanzó el límite definido por la estrategia
     */
    boolean validarLimite(Usuario u);

    /**
     * Aplica las reglas de la estrategia justo antes de crear el elemento
     * (por ejemplo, verificar el límite e incrementar el contador).
     *
     * @param u usuario que ejecutará la creación
     * @throws IllegalStateException si la regla impide la creación
     */
    void aplicarReglas(Usuario u);
}
