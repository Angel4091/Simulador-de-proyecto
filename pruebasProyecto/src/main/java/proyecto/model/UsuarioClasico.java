package proyecto.model;

import java.time.LocalDateTime;

public class UsuarioClasico extends User {

    private int limiteTareas;
    private int contadorTareas;

    public UsuarioClasico(int id, String nombre, String email, String password, LocalDateTime fecha, int limiteTareas) {
        super(id, nombre, email, password, fecha);
        this.limiteTareas = limiteTareas;
        this.contadorTareas = 0;
    }

    public int getLimiteTareas() { return limiteTareas; }
    public int getContadorTareas() { return contadorTareas; }

    public boolean validarLimite() {
        return contadorTareas < limiteTareas;
    }

    public boolean agregarTarea() {
        if (validarLimite()) {
            contadorTareas++;
            return true;
        } else {
            System.out.println("Has alcanzado el límite de tareas.");
            return false;
        }
    }
}
