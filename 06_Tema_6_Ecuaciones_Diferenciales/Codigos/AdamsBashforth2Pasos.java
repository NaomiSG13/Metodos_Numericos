public class AdamsBashforth2Pasos {

    public static double f(double x, double y) {
        return x + (2 * y);
    }

    public static void main(String[] args) {
        double h = 0.1;
        int numPasos = 5;
        
        // Arreglos para almacenar los puntos x e y
        double[] x = new double[numPasos + 1];
        double[] y = new double[numPasos + 1];

        // Paso 0: Condición inicial
        x[0] = 0.0;
        y[0] = 1.0;

        // Paso 1: Usamos Euler simple para obtener el segundo punto necesario
        x[1] = x[0] + h;
        y[1] = y[0] + h * f(x[0], y[0]);

        System.out.println("--- MÉTODO DE ADAMS-BASHFORTH (2 PASOS) ---");
        System.out.printf("Paso 0: x = %.1f -> y = %.5f (Inicial)%n", x[0], y[0]);
        System.out.printf("Paso 1: x = %.1f -> y = %.5f (Por Euler)%n", x[1], y[1]);

        // Pasos del 2 en adelante usando Adams-Bashforth de 2 pasos
        for (int n = 1; n < numPasos; n++) {
            x[n+1] = x[n] + h;
            
            // Fórmula: y_{n+1} = y_n + (h/2) * [3*f(x_n, y_n) - f(x_{n-1}, y_{n-1})]
            y[n+1] = y[n] + (h / 2.0) * (3 * f(x[n], y[n]) - f(x[n-1], y[n-1]));

            System.out.printf("Paso %d: x = %.1f -> y = %.5f (Por Adams-Bashforth)%n", n+1, x[n+1], y[n+1]);
        }
    }
}