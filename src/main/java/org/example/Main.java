package org.example;

import org.example.catalog.Estado;
import org.example.catalog.Prioridad;
import org.example.model.Tarea;
import org.example.model.Usuario;
import org.example.model.UsuarioClasico;
import org.example.model.UsuarioPremium;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de gestion de tareas ===\n");

        Usuario clasico = new UsuarioClasico("Ana", "ana@mail.com", "1234");
        Usuario premium = new UsuarioPremium("Beto", "beto@mail.com", "abcd");

        System.out.println("Autenticacion Ana: " + clasico.autenticar("ana@mail.com", "1234"));
        System.out.println("Autenticacion Beto: " + premium.autenticar("beto@mail.com", "wrong"));
        System.out.println();

        clasico.ejecutarCreacion("Comprar pan", "Ir a la panaderia");
        clasico.ejecutarCreacion("Estudiar UML", "Repasar diagrama de clases");
        premium.ejecutarCreacion("Reunion", "Recordatorio de reunion semanal");

        if (!clasico.getItemsCreados().isEmpty()
                && clasico.getItemsCreados().get(0) instanceof Tarea tarea) {
            tarea.establecerPrioridad(Prioridad.ALTA);
            tarea.modificarEstado(Estado.EN_PROGRESO);
        }

        if (clasico instanceof UsuarioClasico uc && !uc.getItemsCreados().isEmpty()) {
            uc.agregarColaborador(uc.getItemsCreados().get(0), premium);
        }

        System.out.println();
        clasico.imprimirItemsCreados();
        System.out.println();
        premium.imprimirItemsCreados();
        System.out.println();
        premium.imprimirItemsCompartidos();
    }
}
