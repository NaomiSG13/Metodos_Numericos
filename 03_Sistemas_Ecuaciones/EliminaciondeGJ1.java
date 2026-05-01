public class EliminaciondeGJ1 {
    public static void main(String[] args) {
        // Sistema: 2x + 1y = 5 | 1x + 3y = 10
        double[][] matriz = {
            {2.0, 1.0, 5.0},
            {1.0, 3.0, 10.0}
        };

        resolverPasoAPaso(matriz);
    }

    public static void resolverPasoAPaso(double[][] Ab) {
        int n = Ab.length;

        System.out.println("--- PASO 1: Matriz Aumentada Inicial ---");
        imprimirMatriz(Ab);

        for (int i = 0; i < n; i++) {
            // PASO 2: Pivoteo
            if (Math.abs(Ab[i][i]) < 1e-10) {
                System.out.println("Pivote en [" + i + "," + i + "] es cero. Buscando intercambio...");
                // Lógica de intercambio simple
                for (int k = i + 1; k < n; k++) {
                    if (Math.abs(Ab[k][i]) > Math.abs(Ab[i][i])) {
                        double[] temp = Ab[i];
                        Ab[i] = Ab[k];
                        Ab[k] = temp;
                        break;
                    }
                }
                System.out.println("Matriz después del intercambio:");
                imprimirMatriz(Ab);
            }

            // PASO 3: Normalización
            double pivote = Ab[i][i];
            for (int j = 0; j <= n; j++) {
                Ab[i][j] /= pivote;
            }
            System.out.printf("PASO 3: Fila %d normalizada (Pivote = %.2f):%n", (i + 1), pivote);
            imprimirMatriz(Ab);

            // PASO 4: Eliminación
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double factor = Ab[j][i];
                    for (int k = 0; k <= n; k++) {
                        Ab[j][k] -= factor * Ab[i][k];
                    }
                    System.out.printf("PASO 4: Eliminando elemento en [%d,%d] usando factor %.2f:%n", j, i, factor);
                    imprimirMatriz(Ab);
                }
            }
        }

        System.out.println("\n--- SOLUCIONES DIRECTAS ---");
        System.out.printf("x = %.6f%n", Ab[0][n]);
        System.out.printf("y = %.6f%n", Ab[1][n]);
    }

    public static void imprimirMatriz(double[][] m) {
        for (double[] fila : m) {
            for (double val : fila) {
                System.out.printf("%8.2f ", val);
            }
            System.out.println();
        }
        System.out.println();
    }
}