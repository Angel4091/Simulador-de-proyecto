package org.example.model;

/**
 * Contrato para entidades que pueden iniciar sesión en el sistema.
 * <p>
 * Implementado por {@link Usuario} y sus subclases. Permite inyectar
 * mecanismos de autenticación distintos sin acoplar la lógica al modelo
 * concreto del usuario.
 */
public interface Autenticable {

    /**
     * Verifica las credenciales proporcionadas.
     *
     * @param email    correo electrónico ingresado
     * @param password contraseña ingresada (en texto plano para esta demo)
     * @return {@code true} si las credenciales son válidas; {@code false} en
     *         caso contrario
     */
    boolean autenticar(String email, String password);
}
