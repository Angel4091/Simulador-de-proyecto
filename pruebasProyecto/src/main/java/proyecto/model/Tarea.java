package proyecto.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tarea extends Elemento implements Colaborable {

    private List<User> usuariosCompartidos;
    private LocalDateTime fechaVencimiento;

    public Tarea() {
        super();
        this.usuariosCompartidos = new ArrayList<>();
    }

    public Tarea(String titulo, String descripcion, Estado estado, Prioridad prioridad,
                 LocalDateTime fechaCreacion, LocalDateTime fechaVencimiento, User creador) {

        super(titulo, descripcion, estado, prioridad, fechaCreacion, creador);
        this.fechaVencimiento = fechaVencimiento;
        this.usuariosCompartidos = new ArrayList<>();
    }

    @Override
    public void compartir(User u) {
        if (u != null && !usuariosCompartidos.contains(u)) {
            usuariosCompartidos.add(u);
            System.out.println("Compartido con " + u.getNombre());
        }
    }

    @Override
    public void eliminarCompartido(User u) {
        usuariosCompartidos.remove(u);
    }

    public boolean estaCompartidaCon(User u) {
        return usuariosCompartidos.contains(u);
    }
}
