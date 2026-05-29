public class SistemaEDO {

    // Cambios en la población de Presas (x)
    public static double dX_dt(double x, double y) {
        return x - (0.1 * x * y);
    }

    // Cambios en la población de Depredadores (y)
    public static double dY_dt(double x, double y) {
        return -0.5 * y + (0.02 * x * y);
    }

    public static void main(String[] args) {
        double t = 0.0;
        double h = 0.2; // Paso de tiempo
        double tMax = 2.0;

        // Poblaciones iniciales
        double x = 40.0; // Ejemplo: 40 conejos
        double y = 9.0;  // Ejemplo: 9 zorros

        System.out.println("--- SIMULACIÓN SISTEMA DE EDOS (Depredador-Presa) ---");
        System.out.printf("Tiempo: %.1f -> Presas: %.2f | Depredadores: %.2f%n", t, x, y);

        while (t < tMax - 0.001) {
            // CRUCIAL: Calcular los cambios usando los valores del paso actual
            double cambioX = dX_dt(x, y);
            double cambioY = dY_dt(x, y);

            // Actualizar simultáneamente
            x = x + h * cambioX;
            y = y + h * cambioY;
            t = t + h;

            System.out.printf("Tiempo: %.1f -> Presas: %.2f | Depredadores: %.2f%n", t, x, y);
        }
    }
}