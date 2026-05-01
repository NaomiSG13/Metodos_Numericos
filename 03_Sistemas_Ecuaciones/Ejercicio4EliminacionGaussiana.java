public class Ejercicio4EliminacionGaussiana {
    public static void main(String[] args) {
        // Matriz aumentada 10x11 extraída de la imagen
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

        int n = matriz.length;

        // Método de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Normalizar la fila del pivote
            double pivote = matriz[i][i];
            for (int j = 0; j <= n; j++) {
                matriz[i][j] /= pivote;
            }

            // Eliminar las demás entradas en la columna actual
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j <= n; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }

        // Mostrar los resultados
        System.out.println("Solución Ejercicio 4 (10x10):");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.6f%n", (i + 1), matriz[i][n]);
        }
    }
}