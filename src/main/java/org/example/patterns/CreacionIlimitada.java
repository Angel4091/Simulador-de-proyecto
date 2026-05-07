package org.example.patterns;

import org.example.model.Usuario;

public class CreacionIlimitada implements EstrategiaCreacion {

    @Override
    public boolean validarLimite(Usuario u) {
        return true;
    }

    @Override
    public void aplicarReglas(Usuario u) {
        u.setContadorTareasActivas(u.getContadorTareasActivas() + 1);
    }
}
