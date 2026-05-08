package org.example.model;

import org.example.patterns.CreacionIlimitada;

import java.util.ArrayList;
import java.util.List;

/**
 * Usuario premium (cuenta de pago): puede crear elementos sin tope y se
 * especializa en producir {@link Recordatorio}.
 * <p>
 * Es un <b>ConcreteCreator</b> del Factory Method y arranca con la
 * estrategia {@link CreacionIlimitada} preconfigurada. Mantiene un
 * repertorio paralelo de los recordatorios creados para acceso rápido.
 */
public class UsuarioPremium extends Usuario {

    /** Repertorio dedicado de recordatorios (típico de la cuenta premium). */
    private final List<Recordatorio> repertorioRecordatorios = new ArrayList<>();

    /**
     * Crea un usuario premium sin límite de creación.
     *
     * @param nombre   nombre visible
     * @param email    correo de inicio de sesión
     * @param password contraseña asociada
     */
    public UsuarioPremium(String nombre, String email, String password) {
        super(nombre, email, password, Integer.MAX_VALUE);
        setEstrategia(new CreacionIlimitada());
    }

    /**
     * {@inheritDoc}
     * <p>Produce un {@link Recordatorio} y lo añade al repertorio interno.
     */
    @Override
    public Elemento crearElemento(String titulo, String descripcion) {
        Recordatorio r = new Recordatorio(titulo, descripcion);
        repertorioRecordatorios.add(r);
        return r;
    }

    /** @return repertorio (mutable) de recordatorios creados por el usuario */
    public List<Recordatorio> getRepertorioRecordatorios() {
        return repertorioRecordatorios;
    }
}
