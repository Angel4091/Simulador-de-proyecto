package org.example;

import org.example.catalog.Estado;
import org.example.catalog.Prioridad;
import org.example.model.Tarea;
import org.example.model.Usuario;
import org.example.model.UsuarioClasico;
import org.example.model.UsuarioPremium;

/**
 * Punto de entrada de la aplicación. Demo manual que ejercita los patrones
 * Strategy y Factory Method y la colaboración entre usuarios.
 * <p>
 * Flujo del demo:
 * <ol>
 *   <li>Crea un {@link UsuarioClasico} y un {@link UsuarioPremium}.</li>
 *   <li>Verifica autenticación con credenciales correctas e incorrectas.</li>
 *   <li>Cada usuario crea elementos a través de {@code ejecutarCreacion}.</li>
 *   <li>Modifica prioridad/estado de la primera tarea.</li>
 *   <li>El usuario clásico comparte la tarea con el usuario premium.</li>
 *   <li>Imprime los items creados y los items compartidos.</li>
 * </ol>
 */
public class Main {

    /**
     * Lanza el demo del sistema de gestión de tareas.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        System.out.println("=== Sistema de gestión de tareas ===\n");

        // 1. Crear usuarios: clásico (con límite) y premium (sin límite).
        Usuario clasico = new UsuarioClasico("Ana", "ana@mail.com", "1234");
        Usuario premium = new UsuarioPremium("Beto", "beto@mail.com", "abcd");

        // 2. Probar autenticación con credenciales válidas e inválidas.
        System.out.println("Autenticación Ana: " + clasico.autenticar("ana@mail.com", "1234"));
        System.out.println("Autenticación Beto: " + premium.autenticar("beto@mail.com", "wrong"));
        System.out.println();

        // 3. Crear elementos: ejecutarCreacion aplica la estrategia y luego
        //    delega en el Factory Method (crearElemento) de cada subclase.
        clasico.ejecutarCreacion("Comprar pan", "Ir a la panadería");
        clasico.ejecutarCreacion("Estudiar UML", "Repasar diagrama de clases");
        premium.ejecutarCreacion("Reunión", "Recordatorio de reunión semanal");

        // 4. Modificar prioridad y estado de la primera tarea creada por Ana.
        if (!clasico.getItemsCreados().isEmpty()
                && clasico.getItemsCreados().get(0) instanceof Tarea tarea) {
            tarea.establecerPrioridad(Prioridad.ALTA);
            tarea.modificarEstado(Estado.EN_PROGRESO);
        }

        // 5. Compartir la primera tarea de Ana con Beto (colaboración).
        if (clasico instanceof UsuarioClasico uc && !uc.getItemsCreados().isEmpty()) {
            uc.agregarColaborador(uc.getItemsCreados().get(0), premium);
        }

        // 6. Imprimir el estado final: items propios y compartidos.
        System.out.println();
        clasico.imprimirItemsCreados();
        System.out.println();
        premium.imprimirItemsCreados();
        System.out.println();
        premium.imprimirItemsCompartidos();
    }
}
