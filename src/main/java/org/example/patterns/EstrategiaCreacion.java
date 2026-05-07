package org.example.patterns;

import org.example.model.Usuario;

public interface EstrategiaCreacion {
    boolean validarLimite(Usuario u);
    void aplicarReglas(Usuario u);
}
