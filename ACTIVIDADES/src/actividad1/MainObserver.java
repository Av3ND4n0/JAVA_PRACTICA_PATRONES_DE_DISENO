package actividad1;
import java.util.ArrayList;
import java.util.List;
interface Observer {
    void update(String mensaje);
}
class Usuario implements Observer {
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public void update(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}
class Notificacion {
    private List<Observer> usuarios = new ArrayList<>();
    public void suscribir(Observer usuario) {
        usuarios.add(usuario);
    }
    public void desuscribir(Observer usuario) {
        usuarios.remove(usuario);
    }
    public void enviarNotificacion(String mensaje) {
        for (Observer usuario : usuarios) {
            usuario.update(mensaje);
        }
    }
}
public class MainObserver {
    public static void main(String[] args) {
        Notificacion notificacion = new Notificacion();
        Usuario usuario1 = new Usuario("Juan");
        Usuario usuario2 = new Usuario("Pedro");
        Usuario usuario3 = new Usuario("Maria");
        notificacion.suscribir(usuario1);
        notificacion.suscribir(usuario2);
        notificacion.suscribir(usuario3);
        System.out.println("Primera notificación:");
        notificacion.enviarNotificacion("Nueva promoción disponible");
        notificacion.desuscribir(usuario2);
        System.out.println("\nSegunda notificación:");
        notificacion.enviarNotificacion("Nuevo producto disponible");
    }
}