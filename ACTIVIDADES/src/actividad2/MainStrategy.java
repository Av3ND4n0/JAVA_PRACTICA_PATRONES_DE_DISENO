package actividad2;
interface EstrategiaPromocion {
    double calcularPrecio(double precio);
}
class SinDescuento implements EstrategiaPromocion {
    public double calcularPrecio(double precio) {
        return precio;
    }
}
class DescuentoDiezPorciento implements EstrategiaPromocion {
    public double calcularPrecio(double precio) {
        return precio * 0.90;
    }
}
class DescuentoVeintePorciento implements EstrategiaPromocion {
    public double calcularPrecio(double precio) {
        return precio * 0.80;
    }
}
class CalculadoraPrecios {
    private EstrategiaPromocion estrategia;
    public void setEstrategia(EstrategiaPromocion estrategia) {
        this.estrategia = estrategia;
    }
    public double calcularPrecio(double precio) {
        return estrategia.calcularPrecio(precio);
    }
}
public class MainStrategy {
    public static void main(String[] args) {
        CalculadoraPrecios calculadora = new CalculadoraPrecios();
        double precio = 100.0;
        calculadora.setEstrategia(new SinDescuento());
        System.out.println("Precio sin descuento: "
                + calculadora.calcularPrecio(precio));
        calculadora.setEstrategia(new DescuentoDiezPorciento());
        System.out.println("Precio con 10% de descuento: "
                + calculadora.calcularPrecio(precio));
        calculadora.setEstrategia(new DescuentoVeintePorciento());
        System.out.println("Precio con 20% de descuento: "
                + calculadora.calcularPrecio(precio));
    }
}