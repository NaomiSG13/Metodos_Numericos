public class Ejercicio3EliminacionGaussiana {

    public static void main(String[] args) {
        // Datos del Ejercicio 3 (Asegúrate de que estos sean los de tu PDF)
        double[][] a = {
            {4.0, 1.0, -1.0, 1.0, -2.0},
            {1.0, 4.0, -1.0, -1.0, -1.0},
            {-1.0, -1.0, 4.0, 1.0, 4.0},
            {1.0, -1.0, 1.0, 4.0, 2.0}
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

        System.out.println("--- RESULTADOS EJERCICIO 3 ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", (i + 1), x[i]);
        }
    }
}