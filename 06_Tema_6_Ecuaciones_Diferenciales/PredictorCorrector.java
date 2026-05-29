public class PredictorCorrector {

    public static double f(double x, double y) {
        return y - (x * x) + 1;
    }

    public static void main(String[] args) {
        double h = 0.1;
        int pasos = 4;
        double[] x = new double[pasos + 1];
        double[] y = new double[pasos + 1];

        // Paso 0: Iniciales
        x[0] = 0.0; y[0] = 0.5;

        // Paso 1: Arrancamos con Runge-Kutta 2 (Heun) para inicializar el historial
        x[1] = x[0] + h;
        double k1 = f(x[0], y[0]);
        double k2 = f(x[1], y[0] + h*k1);
        y[1] = y[0] + (h/2.0) * (k1 + k2);

        System.out.println("--- MÉTODO PREDICTOR-CORRECTOR ---");
        System.out.printf("Paso 0: x = %.1f -> y = %.5f%n", x[0], y[0]);
        System.out.printf("Paso 1: x = %.1f -> y = %.5f (Por RK2)%n", x[1], y[1]);

        // Ciclo Predictor-Corrector para los siguientes pasos
        for (int n = 1; n < pasos; n++) {
            x[n+1] = x[n] + h;

            // 1. PREDICTOR: Adams-Bashforth 2 pasos
            double yPredicho = y[n] + (h / 2.0) * (3 * f(x[n], y[n]) - f(x[n-1], y[n-1]));

            // 2. CORRECTOR: Adams-Moulton 2 pasos (usa el valor predicho en x_{n+1})
            y[n+1] = y[n] + (h / 2.0) * (f(x[n+1], yPredicho) + f(x[n], y[n]));

            System.out.printf("Paso %d: x = %.1f -> y = %.5f%n", n+1, x[n+1], y[n+1]);
        }
    }
}