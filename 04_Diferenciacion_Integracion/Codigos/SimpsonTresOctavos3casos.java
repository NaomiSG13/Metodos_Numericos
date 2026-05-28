public class SimpsonTresOctavos3casos {
    public static void main(String[] args) {
        // --- CASO 1: IDEAL (Polinomio grado 3) ---
        // f(x) = x^3 + 1 en [0, 1]
        double a1 = 0, b1 = 1;
        double h1 = (b1 - a1) / 3.0;
        double ideal = (3 * h1 / 8.0) * (f1(a1) + 3*f1(a1+h1) + 3*f1(a1+2*h1) + f1(b1));
        System.out.println("1. Caso Ideal (Exacto): " + ideal);

        // --- CASO 2: CON ERROR (Función con pico/discontinuidad) ---
        // f(x) = |x - 0.5| en [0, 1] -> El pico rompe la suavidad de la curva
        double a2 = 0, b2 = 1;
        double h2 = (b2 - a2) / 3.0;
        double error = (3 * h2 / 8.0) * (f2(a2) + 3*f2(a2+h2) + 3*f2(a2+2*h2) + f2(b2));
        System.out.println("2. Caso con Error (Aproximado): " + error);

        // --- CASO 3: DECIDIDO (Aplicación Ingeniería) ---
        // f(x) = sin(x)/x (Sinc) en [1, 2]
        double a3 = 1, b3 = 2;
        double h3 = (b3 - a3) / 3.0;
        double decidido = (3 * h3 / 8.0) * (f3(a3) + 3*f3(a3+h3) + 3*f3(a3+2*h3) + f3(b3));
        System.out.println("3. Caso Decidido (Sinc): " + decidido);
    }

    public static double f1(double x) { return Math.pow(x, 3) + 1; }
    public static double f2(double x) { return Math.abs(x - 0.5); }
    public static double f3(double x) { return Math.sin(x) / x; }
}