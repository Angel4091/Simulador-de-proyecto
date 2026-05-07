package org.example.patterns;

import org.example.model.Usuario;

public class CreacionLimitada implements EstrategiaCreacion {

    @Override
    public boolean validarLimite(Usuario u) {
        return u.getContadorTareasActivas() < u.getLimiteTareas();
    }

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
