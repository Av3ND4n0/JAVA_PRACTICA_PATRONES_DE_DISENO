package actividad3;
interface Command {
    void execute();
}
class Televisor {
    public void encender() {
        System.out.println("Televisor encendido");
    }
    public void apagar() {
        System.out.println("Televisor apagado");
    }
    public void subirVolumen() {
        System.out.println("Volumen aumentado");
    }
    public void bajarVolumen() {
        System.out.println("Volumen disminuido");
    }
    public void cambiarCanal() {
        System.out.println("Canal cambiado");
    }
}
class EncenderCommand implements Command {
    private Televisor televisor;
    public EncenderCommand(Televisor televisor) {
        this.televisor = televisor;
    }
    public void execute() {
        televisor.encender();
    }
}
class ApagarCommand implements Command {
    private Televisor televisor;
    public ApagarCommand(Televisor televisor) {
        this.televisor = televisor;
    }
    public void execute() {
        televisor.apagar();
    }
}
class SubirVolumenCommand implements Command {
    private Televisor televisor;
    public SubirVolumenCommand(Televisor televisor) {
        this.televisor = televisor;
    }
    public void execute() {
        televisor.subirVolumen();
    }
}
class BajarVolumenCommand implements Command {
    private Televisor televisor;
    public BajarVolumenCommand(Televisor televisor) {
        this.televisor = televisor;
    }
    public void execute() {
        televisor.bajarVolumen();
    }
}
class CambiarCanalCommand implements Command {
    private Televisor televisor;
    public CambiarCanalCommand(Televisor televisor) {
        this.televisor = televisor;
    }
    public void execute() {
        televisor.cambiarCanal();
    }
}
class ControlRemoto {
    private Command comando;
    public void setCommand(Command comando) {
        this.comando = comando;
    }
    public void presionarBoton() {
        comando.execute();
    }
}
public class MainCommand {
    public static void main(String[] args) {
        Televisor televisor = new Televisor();
        ControlRemoto control = new ControlRemoto();
        Command encender = new EncenderCommand(televisor);
        Command apagar = new ApagarCommand(televisor);
        Command subir = new SubirVolumenCommand(televisor);
        Command bajar = new BajarVolumenCommand(televisor);
        Command canal = new CambiarCanalCommand(televisor);
        control.setCommand(encender);
        control.presionarBoton();
        control.setCommand(subir);
        control.presionarBoton();
        control.setCommand(bajar);
        control.presionarBoton();
        control.setCommand(canal);
        control.presionarBoton();
        control.setCommand(apagar);
        control.presionarBoton();
    }
}
