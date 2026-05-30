public class MetodoEulerBasico {

    // Definimos la función f(x, y) = dy/dx
    public static double f(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        // Condiciones iniciales
        double x0 = 0.0;
        double y0 = 1.0;
        
        double h = 0.1;       // Tamaño del paso
        double xObjetivo = 1.0; // Punto donde queremos aproximar y
        
        double x = x0;
        double y = y0;

        System.out.println("--- METODO DE EULER ---");
        System.out.printf("x = %.2f -> y = %.4f%n", x, y);

        // Bucle para iterar desde x0 hasta xObjetivo
        while (x < xObjetivo) {
            // Fórmula de Euler: y_next = y + h * f(x, y)
            y = y + h * f(x, y);
            x = x + h; // Avanzamos el paso

            System.out.printf("x = %.2f -> y = %.4f%n", x, y);
        }
        
        System.out.println("-----------------------");
        System.out.printf("Resultado aproximado: y(%.1f) = %.4f%n", xObjetivo, y);
    }
}