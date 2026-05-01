public class GaussSeidel {
    public static void main(String[] args) {
        // Ejercicio 3x3 (Seidel converge más rápido que Jacobi)
        double x1 = 0, x2 = 0, x3 = 0;
        int iteraciones = 10;

        System.out.println("--- MÉTODO DE GAUSS-SEIDEL ---");
        System.out.println("Iter | x1 | x2 | x3");
        for (int i = 1; i <= iteraciones; i++) {
            // Despejes típicos
            x1 = (7.85 + 0.1 * x2 + 0.2 * x3) / 3.0;
            x2 = (-19.3 - 0.1 * x1 + 0.3 * x3) / 7.0;
            x3 = (71.4 - 0.3 * x1 + 0.2 * x2) / 10.0;

            System.out.printf("%d | %.4f | %.4f | %.4f\n", i, x1, x2, x3);
        }
    }
}G