public class EliminaciondeGJ2 {

    public static void main(String[] args) {
        // Datos de la matriz 3x3 del ejercicio de la imagen
        // Sistema:
        // 3x + 2y - z = 1
        // 2x - 2y + 4z = -2
        // -x + 0.5y - z = 0
        double[][] matriz = {
            {3.0, 2.0, -1.0, 1.0},
            {2.0, -2.0, 4.0, -2.0},
            {-1.0, 0.5, -1.0, 0.0}
        };

        resolverPasoAPaso(matriz);
    }

    public static void resolverPasoAPaso(double[][] Ab) {
        int n = Ab.length;

        System.out.println("--- PASO 1: Matriz Aumentada Inicial ---");
        imprimirMatriz(Ab);

        for (int i = 0; i < n; i++) {
            System.out.println("=== PROCESANDO COLUMNA " + (i + 1) + " ===");

            // PASO 2: Pivoteo (Intercambio de filas si el pivote es cercano a cero)
            if (Math.abs(Ab[i][i]) < 1e-10) {
                System.out.println("Pivote en [" + i + "," + i + "] es cero. Buscando intercambio...");
                for (int k = i + 1; k < n; k++) {
                    if (Math.abs(Ab[k][i]) > Math.abs(Ab[i][i])) {
                        double[] temp = Ab[i];
                        Ab[i] = Ab[k];
                        Ab[k] = temp;
                        System.out.println("PASO 2: Intercambio de fila " + (i + 1) + " con fila " + (k + 1));
                        break;
                    }
                }
                imprimirMatriz(Ab);
            }

            // PASO 3: Normalización (Hacer que el pivote sea 1)
            double pivote = Ab[i][i];
            for (int j = 0; j <= n; j++) {
                Ab[i][j] /= pivote;
            }
            System.out.printf("PASO 3: Fila %d normalizada (Pivote = 1):%n", (i + 1));
            imprimirMatriz(Ab);

            // PASO 4: Eliminación (Hacer ceros arriba y abajo del pivote)
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double factor = Ab[j][i];
                    for (int k = 0; k <= n; k++) {
                        Ab[j][k] -= factor * Ab[i][k];
                    }
                    System.out.printf("PASO 4: Eliminando elemento en [%d,%d] usando factor %.2f:%n", j, i, factor);
                }
            }
            System.out.println("Estado tras columna " + (i + 1) + ":");
            imprimirMatriz(Ab);
        }

        // Mostrar resultados finales
        System.out.println("--- SOLUCIONES ---");
        char[] variables = {'x', 'y', 'z'};
        for (int i = 0; i < n; i++) {
            System.out.printf("%c = %.6f%n", variables[i], Ab[i][n]);
        }
    }

    // Método auxiliar para imprimir la matriz de forma legible
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