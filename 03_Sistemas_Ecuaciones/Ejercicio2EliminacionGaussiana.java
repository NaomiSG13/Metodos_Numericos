public class Ejercicio2EliminacionGaussiana {
    public static void main(String[] args) {
        double[][] matriz = {
            {2.0, 1.0, -1.0, 8.0},
            {-3.0, -1.0, 2.0, -11.0},
            {-2.0, 1.0, 2.0, -3.0}
        };
        
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            double pivote = matriz[i][i];
            for (int j = 0; j <= n; j++) matriz[i][j] /= pivote;
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j <= n; j++) matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
        System.out.println("Solución Ejercicio 2:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.6f%n", (i + 1), matriz[i][n]);
        }
    }
}