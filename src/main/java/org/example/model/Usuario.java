package org.example.model;

import org.example.patterns.EstrategiaCreacion;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Autenticable {

    protected String nombre;
    protected String email;
    protected String password;
    protected int contadorTareasActivas;
    protected int limiteTareas;
    protected EstrategiaCreacion estrategiaCreacion;

    protected final List<Elemento> itemsCreados = new ArrayList<>();
    protected final List<Elemento> itemsCompartidos = new ArrayList<>();

    protected Usuario(String nombre, String email, String password, int limiteTareas) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.limiteTareas = limiteTareas;
        this.contadorTareasActivas = 0;
    }

    @Override
    public boolean autenticar(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public abstract Elemento crearElemento(String titulo, String descripcion);

    public void imprimirItemsCreados() {
        System.out.println("Items creados por " + nombre + ":");
        for (Elemento e : itemsCreados) {
            e.mostrarInfo();
        }
    }

    public void imprimirItemsCompartidos() {
        System.out.println("Items compartidos con " + nombre + ":");
        for (Elemento e : itemsCompartidos) {
            e.mostrarInfo();
        }
    }

    public void setEstrategia(EstrategiaCreacion estrategia) {
        this.estrategiaCreacion = estrategia;
    }

    public void ejecutarCreacion(String titulo, String descripcion) {
        if (estrategiaCreacion == null) {
            throw new IllegalStateException(
                "El usuario " + nombre + " no tiene estrategia de creacion asignada."
            );
        }
        estrategiaCreacion.aplicarReglas(this);
        Elemento nuevo = crearElemento(titulo, descripcion);
        itemsCreados.add(nuevo);
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getContadorTareasActivas() { return contadorTareasActivas; }
    public void setContadorTareasActivas(int v) { this.contadorTareasActivas = v; }
    public int getLimiteTareas() { return limiteTareas; }
    public EstrategiaCreacion getEstrategiaCreacion() { return estrategiaCreacion; }
    public List<Elemento> getItemsCreados() { return itemsCreados; }
    public List<Elemento> getItemsCompartidos() { return itemsCompartidos; }
}
