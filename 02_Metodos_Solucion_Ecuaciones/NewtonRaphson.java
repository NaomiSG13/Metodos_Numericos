public class NewtonRaphson {
    // f(x) = x^2 - 5 
    public static double f(double x) {
        return Math.pow(x, 2) - 5;
    }

    // Derivada f'(x) = 2x 
    public static double df(double x) {
        return 2 * x;
    }

    public static void main(String[] args) {
        double xn = 1.0; // x0 = 1 
        int iteraciones = 5;

        System.out.println("Iter | xn | f(xn)");
        for (int i = 1; i <= iteraciones; i++) {
            System.out.printf("%d | %.6f | %.6f\n", i, xn, f(xn));
            // Fórmula: x_n+1 = xn - f(xn)/f'(xn)
            xn = xn - (f(xn) / df(xn));
        }
        System.out.println("Raíz aproximada: " + xn);
    }
}