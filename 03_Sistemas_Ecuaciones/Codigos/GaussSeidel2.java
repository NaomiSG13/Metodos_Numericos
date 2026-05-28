public class GaussSeidel2 {
    public static void main(String[] args) {
        // Sistema: 3x + 2y - z = 1 | 2x - 2y + 4z = -2 | -x + 0.5y - z = 0
        double[][] matriz = {
            {3.0, 2.0, -1.0, 1.0},
            {2.0, -2.0, 4.0, -2.0},
            {-1.0, 0.5, -1.0, 0.0}
        };
        resolver(matriz);
    }

    public static void resolver(double[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            double pivote = m[i][i];
            for (int j = 0; j <= n; j++) m[i][j] /= pivote;
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = m[k][i];
                    for (int j = 0; j <= n; j++) m[k][j] -= factor * m[i][j];
                }
            }
        }
        System.out.println("Resultados Ejercicio 2 (GJ):");
        System.out.printf("x = %.4f, y = %.4f, z = %.4f%n", m[0][n], m[1][n], m[2][n]);
    }
}