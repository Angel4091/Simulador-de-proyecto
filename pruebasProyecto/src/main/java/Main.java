import proyecto.model.*;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // USUARIOS QUEMADOS
        UsuarioClasico u1 = new UsuarioClasico(1, "Luis", "luis@gmail.com", "123", LocalDateTime.now(), 2); // límite de tareas

        UsuarioPremium u2 = new UsuarioPremium(2, "Maria", "maria@gmail.com", "123", LocalDateTime.now(), 50.0);

        System.out.println("=== LOGIN ===");
        u1.login("luis@gmail.com", "123");
        u2.login("maria@gmail.com", "123");

        // CREAR TAREAS
        System.out.println("\n=== CREAR TAREAS ===");

        Tarea t1 = u1.crearTarea("Estudiar", "POO examen", Prioridad.ALTA);
        Tarea t2 = u1.crearTarea("Hacer tarea", "Matematica", Prioridad.MEDIA);

        // Esta debería fallar por límite
        Tarea t3 = u1.crearTarea("Otra tarea", "Extra", Prioridad.BAJA);

        // Premium no tiene límite
        Tarea t4 = u2.crearTarea("Gym", "Ir al gimnasio", Prioridad.MEDIA);

        // MOSTRAR INFO
        System.out.println("\n=== MOSTRAR TAREAS ===");

        if (t1 != null) t1.mostrarInfo();
        if (t2 != null) t2.mostrarInfo();
        if (t4 != null) t4.mostrarInfo();

        // COMPARTIR TAREA
        System.out.println("\n=== COMPARTIR ===");

        if (t4 != null) {
            t4.compartir(u1);
        }

        // CAMBIAR ESTADO
        System.out.println("\n=== CAMBIAR ESTADO ===");

        if (t1 != null) {
            t1.cambiarEstado(Estado.COMPLETADO);
            t1.mostrarInfo();
        }

        // Logout
        System.out.println("=== LOGOUT ===");
        u1.logout();
        u2.logout();
    }
}


