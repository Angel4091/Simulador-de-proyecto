package proyecto.model;

import java.time.LocalDateTime; //Para guardar fechas con hora
import java.util.ArrayList; //Implementación concreta de una lista.
import java.util.List; //Para manejar listas

//Heredad e Interface
public class Tarea extends Elemento implements Colaborable {

    //Atributos propios de Tarea
    private List<Usuario> usuariosCompartidos;
    private LocalDateTime fechaVencimiento;

    // Constructor vacío
    public Tarea() {
        super();
        this.usuariosCompartidos = new ArrayList<>();
    }

    // Constructor con parametros
    public Tarea(String titulo, String descripcion, Estado estado, Prioridad prioridad,
                 LocalDateTime fechaCreacion, LocalDateTime fechaVencimiento) {
        super(titulo, descripcion, estado, prioridad, fechaCreacion);
        this.fechaVencimiento = fechaVencimiento;
        this.usuariosCompartidos = new ArrayList<>();
    }

    @Override
    //Metodo compartir
    public void compartir(Usuario u) {
        if (u != null && !usuariosCompartidos.contains(u)) { //Verifica que el usuario no sea nulo y que no esté en la lista
            usuariosCompartidos.add(u); //Agrega el usuario a la lista
        }
    }

    @Override
    //Metodo Eliminar Compartido
    public void eliminarCompartido(Usuario u) { //elimina un usuario de la lista de compartidos
        usuariosCompartidos.remove(u);
    }

    public boolean estaCompartidaCon(Usuario u) {
        return usuariosCompartidos.contains(u);
    }

    @Override
    //Metodo mostrar información
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de vencimiento: " + fechaVencimiento);
        System.out.println("Usuarios compartidos: " + usuariosCompartidos.size());
    }

    // Getters y setters
    public List<Usuario> getUsuariosCompartidos() {
        return usuariosCompartidos;
    }

    public void setUsuariosCompartidos(List<Usuario> usuariosCompartidos) {
        this.usuariosCompartidos = usuariosCompartidos;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}