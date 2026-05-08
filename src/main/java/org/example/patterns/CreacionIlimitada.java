package org.example.patterns;

import org.example.model.Usuario;

/**
 * Estrategia que permite crear elementos sin tope. Pensada para
 * {@link org.example.model.UsuarioPremium}.
 * <p>
 * El contador del usuario se sigue incrementando con fines de auditoría,
 * pero la validación nunca falla.
 */
public class CreacionIlimitada implements EstrategiaCreacion {

    /**
     * {@inheritDoc}
     * <p>Siempre {@code true}: los usuarios premium no tienen límite.
     */
    @Override
    public boolean validarLimite(Usuario u) {
        return true;
    }

    /**
     * {@inheritDoc}
     * <p>Solo incrementa el contador; no impone restricciones.
     */
    @Override
    public void aplicarReglas(Usuario u) {
        u.setContadorTareasActivas(u.getContadorTareasActivas() + 1);
    }
}
