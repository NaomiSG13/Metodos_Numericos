public class RungeKutta4 {

    // Función f(x, y) = dy/dx
    public static double f(double x, double y) {
        return x * Math.sqrt(y);
    }

    public static void main(String[] args) {
        double x = 1.0; // Condición inicial x0
        double y = 1.0; // Condición inicial y0
        double h = 0.1; // Tamaño de paso
        double xObjetivo = 1.5;

        System.out.println("--- MÉTODO DE RUNGE-KUTTA DE 4º ORDEN (RK4) ---");
        System.out.printf("x = %.1f -> y = %.6f%n", x, y);

        while (x < xObjetivo - 0.0001) {
            // Calcular las 4 pendientes intermedias
            double k1 = f(x, y);
            double k2 = f(x + h/2.0, y + (h*k1)/2.0);
            double k3 = f(x + h/2.0, y + (h*k2)/2.0);
            double k4 = f(x + h, y + h*k3);

            // Actualizar y usando el promedio ponderado
            y = y + (h / 6.0) * (k1 + 2*k2 + 2*k3 + k4);
            x = x + h;

            System.out.printf("x = %.1f -> y = %.6f%n", x, y);
        }
    }
}