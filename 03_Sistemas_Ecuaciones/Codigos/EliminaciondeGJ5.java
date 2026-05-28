public class EliminaciondeGJ5 {

    public static void main(String[] args) {
        // Matriz aumentada 6x7 extraída de la imagen
        double[][] matriz = {
            {3, 6, 3, 4, 1, 6, 3},
            {3, 7, 4, 5, 3, 5, 9},
            {7, 4, 3, 3, 6, 9, 1},
            {2, 7, 5, 8, 8, 7, 5},
            {6, 8, 8, 3, 1, 7, 6},
            {3, 5, 2, 7, 6, 5, 6}
        };

        resolverGaussJordan(matriz);
    }

    public static void resolverGaussJordan(double[][] m) {
        int n = m.length;

        System.out.println("============================================================");
        System.out.println("      MÉTODO DE GAUSS-JORDAN - RESOLUCIÓN PASO A PASO");
        System.out.println("============================================================");
        
        imprimirMatriz(m, "Matriz inicial aumentada");

        for (int i = 0; i < n; i++) {
            // 1. Búsqueda de pivote máximo (Pivoteo Parcial para mayor precisión)
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(m[k][i]) > Math.abs(m[max][i])) {
                    max = k;
                }
            }

            // Intercambio de filas
            double[] temp = m[i];
            m[i] = m[max];
            m[max] = temp;

            // 2. Normalización de la fila del pivote
            double pivote = m[i][i];
            for (int j = i; j <= n; j++) {
                m[i][j] /= pivote;
            }

            // 3. Eliminación en las demás filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = m[k][i];
                    for (int j = i; j <= n; j++) {
                        m[k][j] -= factor * m[i][j];
                    }
                }
            }
            
            imprimirMatriz(m, "Iteración " + (i + 1) + " (Columna " + (i + 1) + " procesada)");
        }

        // Mostrar Resultados Finales
        System.out.println("--- SOLUCIONES ---");
        String[] vars = {"x1", "x2", "x3", "x4", "x5", "x6"};
        for (int i = 0; i < n; i++) {
            System.out.printf("%s = %.10f%n", vars[i], m[i][n]);
        }
    }

    public static void imprimirMatriz(double[][] m, String titulo) {
        System.out.println("\n[" + titulo + "]");
        for (double[] fila : m) {
            System.out.print("| ");
            for (int j = 0; j < fila.length; j++) {
                if (j == fila.length - 1) System.out.print(" : ");
                System.out.printf("%10.4f ", fila[j]);
            }
            System.out.println(" |");
        }
    }
}