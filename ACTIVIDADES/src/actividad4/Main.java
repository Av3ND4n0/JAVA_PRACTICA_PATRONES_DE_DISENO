package actividad4;
import java.util.ArrayList;
import java.util.List;
interface Observer {
    void actualizar(String mensaje);
}
class Usuario implements Observer {
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}
class Tienda {
    private List<Observer> usuarios = new ArrayList<>();
    public void suscribir(Observer usuario) {
        usuarios.add(usuario);
    }
    public void notificar(String mensaje) {
        for (Observer usuario : usuarios) {
            usuario.actualizar(mensaje);
        }
    }
}
interface EstrategiaDescuento {
    double aplicar(double precio);
}
class SinDescuento implements EstrategiaDescuento {
    public double aplicar(double precio) {
        return precio;
    }
}
class DescuentoDiez implements EstrategiaDescuento {
    public double aplicar(double precio) {
        return precio * 0.90;
    }
}
class Calculadora {
    private EstrategiaDescuento estrategia;
    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }
    public double calcular(double precio) {
        return estrategia.aplicar(precio);
    }
}
interface Command {
    void execute();
}
class CompraCommand implements Command {

    private Tienda tienda;
    private double precio;

    public CompraCommand(Tienda tienda, double precio) {
        this.tienda = tienda;
        this.precio = precio;
    }

    public void ejecutar() {
        System.out.println("\nCompra realizada por S/ " + precio);
        tienda.notificar("Compra realizada");
    }

	@Override
	public void execute() {
	}
}
class ControlCompra {
    private Command comando;
    public void setCommand(Command comando) {
        this.comando = comando;
    }
    public void ejecutar() {
        comando.execute();
    }
}
public class Main {

    public static void main(String[] args) {

        // OBSERVER
        Tienda tienda = new Tienda();

        Usuario usuario1 = new Usuario("Juan");
        Usuario usuario2 = new Usuario("Pedro");

        tienda.suscribir(usuario1);
        tienda.suscribir(usuario2);

        // STRATEGY
        Calculadora calculadora = new Calculadora();

        double precioOriginal = 200;

        calculadora.setEstrategia(new DescuentoDiez());

        double precioFinal = calculadora.calcular(precioOriginal);

        System.out.println("Precio original: S/ " + precioOriginal);
        System.out.println("Precio con descuento: S/ " + precioFinal);

        // COMMAND
        CompraCommand compra = new CompraCommand(tienda, precioFinal);

        compra.ejecutar();

    }

}