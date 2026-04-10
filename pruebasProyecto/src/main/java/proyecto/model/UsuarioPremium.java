package proyecto.model;

import java.time.LocalDateTime;

public class UsuarioPremium extends Usuario implements Colaborable {

    private double bono;

    public UsuarioPremium(int id, String nombre, String email, String password, LocalDateTime fechaRegistro, double bono) {
        super(id, nombre, email, password, fechaRegistro);
        this.bono = bono;
    }

    public double getBono() { return bono; }

    public String obtenerEstadisticas() {
        return "Usuario: " + getNombre() + " | Bono: " + bono;
    }

    @Override
    public void compartir(Usuario u) {
        if (u != null) {
            System.out.println(getNombre() + " comparte con " + u.getNombre());
        }
    }

    @Override
    public void eliminarCompartido(Usuario u) {
        if (u != null) {
            System.out.println("Acceso eliminado a " + u.getNombre());
        }
    }

    public void compartirElemento(Elemento e, Usuario u) {
        if (e != null && u != null) {
            System.out.println("Elemento compartido con " + u.getNombre());
        }
    }
}
