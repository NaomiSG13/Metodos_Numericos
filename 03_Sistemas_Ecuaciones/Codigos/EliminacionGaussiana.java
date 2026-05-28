public class EliminacionGaussiana {
    public static void main(String[] args) {
        // Ejercicio: Sistema 3x3 (Pág. 30-35 del PDF)
        double[][] a = {
            {3.0, -0.1, -0.2, 7.85},
            {0.1, 7.0, -0.3, -19.3},
            {0.3, -0.2, 10.0, 71.4}
        };

        int n = a.length;

        // Fase de eliminación
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = a[k][i] / a[i][i];
                for (int j = i; j <= n; j++) {
                    a[k][j] -= factor * a[i][j];
                }
            }
        }

        // Sustitución hacia atrás
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = a[i][n];
            for (int j = i + 1; j < n; j++) {
                x[i] -= a[i][j] * x[j];
            }
            x[i] /= a[i][i];
        }

        System.out.println("--- RESULTADOS ELIMINACIÓN GAUSSIANA ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", (i + 1), x[i]);
        }
    }
}