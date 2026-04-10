package proyecto.model;

public interface Autenticable {
    boolean login(String email, String pass);
    void logout();
}
