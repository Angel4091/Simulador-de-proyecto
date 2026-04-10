package proyecto.model;

import java.time.LocalDateTime;

public abstract class User implements Autenticable {

    private int id;
    private String nombre;
    private String email;
    private String password;
    private LocalDateTime fechaRegistro;

    public User(int id, String nombre, String email, String password, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean login(String email, String pass) {
        if (this.email.equals(email) && this.password.equals(pass)) {
            System.out.println("Accediendo...");
            return true;
        } else {
            System.out.println("Error, email o contraseña incorrectos");
            return false;
        }
    }

    public void logout() {
        System.out.println("Cerrando sesión de: " + nombre);
    }

    public Tarea crearTarea(String titulo, String descripcion, Prioridad p) {

        if (this instanceof UsuarioClasico) {
            UsuarioClasico uc = (UsuarioClasico) this;
            if (!uc.agregarTarea()) {
                return null;
            }
        }

        return new Tarea(
                titulo,
                descripcion,
                Estado.PENDIENTE,
                p,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                this
        );
    }

    public Recordatorio crearRecordatorio(String titulo, LocalDateTime fecha, Prioridad p) {
        return new Recordatorio(
                titulo,
                "Sin descripción",
                Estado.PENDIENTE,
                p,
                LocalDateTime.now(),
                fecha,
                "default",
                this
        );
    }
}
