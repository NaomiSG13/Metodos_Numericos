public class MetodoHeun {
    
    public static double f(double x, double y) {
        return (x * x) - y;
    }

    public static void main(String[] args) {
        double x = 0.0;
        double y = 1.0;
        double h = 0.1;
        double xObjetivo = 0.5;

        System.out.println("--- MÉTODO DE HEUN (EULER MEJORADO) ---");
        System.out.printf("x = %.1f -> y = %.5f%n", x, y);

        while (x < xObjetivo - 0.0001) {
            // 1. Predictor (Euler estándar)
            double yPredictor = y + h * f(x, y);
            
            // 2. Corrector (Promedio de pendientes)
            double pendienteInicial = f(x, y);
            double pendienteSiguiente = f(x + h, yPredictor);
            
            y = y + (h / 2.0) * (pendienteInicial + pendienteSiguiente);
            x = x + h;

            System.out.printf("x = %.1f -> y = %.5f%n", x, y);
        }
    }
}