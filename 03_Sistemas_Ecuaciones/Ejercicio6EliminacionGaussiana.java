public class Ejercicio6EliminacionGaussiana {
    public static void main(String[] args) {
        int n = 20;
        double[][] matriz = new double[n][n + 1];

        // Llenado de la matriz según el patrón de la imagen
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = (i + 1) + j;
            }
            matriz[i][n] = 210 + (i * 20);
        }
        
        // Última fila especial
        for (int j = 0; j < n; j++) matriz[n-1][j] = (j + 2);
        matriz[n-1][n] = 210;

        // Proceso con verificación de singularidad
        if (resolverGaussJordan(matriz, n)) {
            System.out.println("Solución encontrada:");
            for (int i = 0; i < n; i++) {
                System.out.printf("x%d = %.6f%n", (i + 1), matriz[i][n]);
            }
        } else {
            System.out.println("Error: La matriz es singular o casi singular.");
            System.out.println("Esto significa que el sistema no tiene una solución única.");
        }
    }

    public static boolean resolverGaussJordan(double[][] m, int n) {
        for (int i = 0; i < n; i++) {
            // Buscamos el mejor pivote (Pivoteo Parcial)
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(m[k][i]) > Math.abs(m[max][i])) max = k;
            }

            // Intercambio de filas
            double[] temp = m[i];
            m[i] = m[max];
            m[max] = temp;

            // Si el valor más grande sigue siendo casi cero, es singular
            if (Math.abs(m[i][i]) < 1e-12) {
                return false; 
            }

            // Normalización y eliminación
            double p = m[i][i];
            for (int j = i; j <= n; j++) m[i][j] /= p;

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = m[k][i];
                    for (int j = i; j <= n; j++) m[k][j] -= factor * m[i][j];
                }
            }
        }
        return true;
    }
}