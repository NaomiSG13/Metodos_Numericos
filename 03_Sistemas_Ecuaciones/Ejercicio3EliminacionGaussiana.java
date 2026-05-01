Ejercicio3EliminacionGaussiana {
    public static void main(String[] args) {
        double[][] matriz = {
            {1, 2, -1, 3, 9},
            {2, -1, 1, 1, 8},
            {3, 1, -2, 2, 3},
            {1, 3, 2, -1, 10}
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
        System.out.println("Solución Ejercicio 3:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.6f%n", (i + 1), matriz[i][n]);
        }
    }
}