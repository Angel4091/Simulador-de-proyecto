package org.example.model;

import org.example.patterns.EstrategiaCreacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase base abstracta para todos los usuarios del sistema.
 * <p>
 * Define el estado común (datos de cuenta, contador de tareas, estrategia de
 * creación) y juega el rol de <b>Creator</b> en el patrón <b>Factory Method</b>:
 * delega en sus subclases qué tipo concreto de {@link Elemento} producir
 * mediante {@link #crearElemento(String, String)}.
 * <p>
 * Además, actúa como <b>Context</b> del patrón <b>Strategy</b>: mantiene una
 * referencia a {@link EstrategiaCreacion} que decide si la creación está
 * permitida.
 *
 * @see UsuarioClasico
 * @see UsuarioPremium
 */
public abstract class Usuario implements Autenticable {

    /** Nombre visible del usuario. */
    protected String nombre;
    /** Correo electrónico, usado como identificador de inicio de sesión. */
    protected String email;
    /** Contraseña en texto plano (solo para fines didácticos). */
    protected String password;
    /** Número de elementos activos creados por el usuario. */
    protected int contadorTareasActivas;
    /** Cota superior de elementos activos permitidos por la estrategia. */
    protected int limiteTareas;
    /** Estrategia inyectada que decide si se puede crear un nuevo elemento. */
    protected EstrategiaCreacion estrategiaCreacion;

    /** Elementos creados por este usuario (es su propietario). */
    protected final List<Elemento> itemsCreados = new ArrayList<>();
    /** Elementos creados por otros que han sido compartidos con este usuario. */
    protected final List<Elemento> itemsCompartidos = new ArrayList<>();

    /**
     * Constructor protegido para uso de las subclases concretas.
     *
     * @param nombre        nombre visible
     * @param email         correo de inicio de sesión
     * @param password      contraseña asociada
     * @param limiteTareas  cota superior de elementos activos
     */
    protected Usuario(String nombre, String email, String password, int limiteTareas) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.limiteTareas = limiteTareas;
        this.contadorTareasActivas = 0;
    }

    /**
     * {@inheritDoc}
     * <p>Compara las credenciales recibidas contra las almacenadas.
     */
    @Override
    public boolean autenticar(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    /**
     * <b>Factory Method.</b> Cada subclase decide qué tipo concreto de
     * {@link Elemento} producir.
     *
     * @param titulo      título del nuevo elemento
     * @param descripcion descripción del nuevo elemento
     * @return instancia recién creada del producto correspondiente
     */
    public abstract Elemento crearElemento(String titulo, String descripcion);

    /** Imprime por consola todos los elementos creados por este usuario. */
    public void imprimirItemsCreados() {
        System.out.println("Items creados por " + nombre + ":");
        for (Elemento e : itemsCreados) {
            e.mostrarInfo();
        }
    }

    /** Imprime por consola los elementos que otros usuarios han compartido. */
    public void imprimirItemsCompartidos() {
        System.out.println("Items compartidos con " + nombre + ":");
        for (Elemento e : itemsCompartidos) {
            e.mostrarInfo();
        }
    }

    /**
     * Inyecta o reemplaza la estrategia de creación.
     *
     * @param estrategia nueva estrategia (no nula)
     */
    public void setEstrategia(EstrategiaCreacion estrategia) {
        this.estrategiaCreacion = estrategia;
    }

    /**
     * Orquesta la creación: aplica las reglas de la estrategia, invoca el
     * Factory Method y registra el elemento en la lista de items creados.
     *
     * @param titulo      título del nuevo elemento
     * @param descripcion descripción del nuevo elemento
     * @throws IllegalStateException si no hay estrategia configurada o si
     *                               la estrategia rechaza la creación
     */
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

    /** @return nombre visible del usuario */
    public String getNombre() { return nombre; }
    /** @return correo asociado a la cuenta */
    public String getEmail() { return email; }
    /** @return número actual de elementos activos creados */
    public int getContadorTareasActivas() { return contadorTareasActivas; }
    /** @param v nuevo valor del contador (uso interno de las estrategias) */
    public void setContadorTareasActivas(int v) { this.contadorTareasActivas = v; }
    /** @return cota superior de elementos activos */
    public int getLimiteTareas() { return limiteTareas; }
    /** @return estrategia de creación actualmente configurada */
    public EstrategiaCreacion getEstrategiaCreacion() { return estrategiaCreacion; }
    /** @return lista mutable de elementos creados por el usuario */
    public List<Elemento> getItemsCreados() { return itemsCreados; }
    /** @return lista mutable de elementos compartidos con el usuario */
    public List<Elemento> getItemsCompartidos() { return itemsCompartidos; }
}
