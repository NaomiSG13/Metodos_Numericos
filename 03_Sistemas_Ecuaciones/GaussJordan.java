public class GaussJordan {
    public static void main(String[] args) {
        // Ejercicio 3x3 con pivoteo
        double[][] a = {
            {2, 1, -1, 8},
            {-3, -1, 2, -11},
            {-2, 1, 2, -3}
        };
        int n = a.length;

        for (int i = 0; i < n; i++) {
            double divisor = a[i][i];
            for (int j = i; j <= n; j++) a[i][j] /= divisor;

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = a[k][i];
                    for (int j = i; j <= n; j++) a[k][j] -= factor * a[i][j];
                }
            }
        }

        System.out.println("--- RESULTADOS GAUSS-JORDAN ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", (i + 1), a[i][n]);
        }
    }
}