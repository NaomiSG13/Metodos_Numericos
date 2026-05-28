public class Ejercicio1EliminaciónGaussiana {
    public static void main(String[] args) {
        // Matriz aumentada [A|B] para el ejercicio 1
        double[][] matriz = {
            {2.0, 1.0, 5.0},
            {4.0, -6.0, -2.0}
        };
        
        resolverGaussJordan(matriz);
    }

    public static void resolverGaussJordan(double[][] m) {
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
        System.out.println("Solución Ejercicio 1:");
        System.out.printf("x1 = %.6f%nx2 = %.6f%n", m[0][2], m[1][2]);
    }
}