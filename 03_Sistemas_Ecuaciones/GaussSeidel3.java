public class GaussSidel3 {
    public static void main(String[] args) {
        // Sistema: x+y+z+w=10 | 2x+3y+z+5w=31 | -x+y-z+w=-2 | 3x+y+2z+4w=28
        double[][] matriz = {
            {1, 1, 1, 1, 10},
            {2, 3, 1, 5, 31},
            {-1, 1, -1, 1, -2},
            {3, 1, 2, 4, 28}
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
        System.out.println("Resultados Ejercicio 4 (GJ):");
        String[] v = {"x", "y", "z", "w"};
        for (int i = 0; i < n; i++) System.out.printf("%s = %.2f%n", v[i], m[i][n]);
    }
}