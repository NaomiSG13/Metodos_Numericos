public class EliminaciondeGJ6 {
    public static void main(String[] args) {
        // Matriz aumentada 10x11 basada en el Ejercicio 4 de tu problemario
        double[][] matriz = {
            {10, 2, 3, 4, 5, 1, 0, 2, 3, 1, 31},
            {1, 11, 2, 3, 4, 2, 1, 0, 1, 2, 27},
            {2, 1, 12, 2, 3, 1, 2, 1, 0, 1, 25},
            {3, 2, 1, 13, 2, 0, 1, 2, 1, 1, 26},
            {1, 3, 2, 1, 14, 2, 1, 0, 2, 1, 27},
            {2, 1, 3, 2, 1, 15, 2, 1, 0, 1, 28},
            {1, 2, 1, 3, 2, 1, 16, 2, 1, 0, 29},
            {2, 1, 2, 1, 3, 2, 1, 17, 2, 1, 32},
            {1, 2, 1, 2, 1, 3, 2, 1, 18, 2, 33},
            {2, 1, 2, 1, 2, 1, 3, 2, 1, 19, 34}
        };

        resolverGaussJordan(matriz);
    }

    public static void resolverGaussJordan(double[][] m) {
        int n = m.length;

        for (int i = 0; i < n; i++) {
            // Normalización del pivote
            double pivote = m[i][i];
            for (int j = 0; j <= n; j++) {
                m[i][j] /= pivote;
            }

            // Eliminación de las demás celdas en la columna
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = m[k][i];
                    for (int j = 0; j <= n; j++) {
                        m[k][j] -= factor * m[i][j];
                    }
                }
            }

            // Mostrar estado intermedio (ejemplo en columna 5 como en tu imagen)
            if (i == 4) {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("ESTADO INTERMEDIO: COLUMNA " + (i + 1) + " PROCESADA");
                imprimirMatriz(m);
            }
        }

        // Salida final idéntica a tu captura de pantalla
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("ESTADO FINAL: MATRIZ EN FORMA ESCALONADA REDUCIDA (IDENTIDAD)");
        imprimirMatriz(m);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("RESULTADOS FINALES (Valores de x1 a x10)");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%02d = %9.4f%n", (i + 1), m[i][n]);
        }
    }

    public static void imprimirMatriz(double[][] m) {
        System.out.println("[[");
        for (double[] fila : m) {
            System.out.print(" [");
            for (int j = 0; j < fila.length; j++) {
                System.out.printf("%6.2f", fila[j]);
            }
            System.out.println(" ]");
        }
        System.out.println("]]");
    }
}