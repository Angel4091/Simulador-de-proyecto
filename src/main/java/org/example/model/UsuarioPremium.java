package org.example.model;

import org.example.patterns.CreacionIlimitada;

import java.util.ArrayList;
import java.util.List;

public class UsuarioPremium extends Usuario {

    private final List<Recordatorio> repertorioRecordatorios = new ArrayList<>();

    public UsuarioPremium(String nombre, String email, String password) {
        super(nombre, email, password, Integer.MAX_VALUE);
        setEstrategia(new CreacionIlimitada());
    }

    @Override
    public Elemento crearElemento(String titulo, String descripcion) {
        Recordatorio r = new Recordatorio(titulo, descripcion);
        repertorioRecordatorios.add(r);
        return r;
    }

    public List<Recordatorio> getRepertorioRecordatorios() {
        return repertorioRecordatorios;
    }
}
