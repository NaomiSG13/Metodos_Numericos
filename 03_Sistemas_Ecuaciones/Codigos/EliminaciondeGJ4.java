public class EliminaciondeGJ4 {
    public static void main(String[] args) {
        // MATRIZ AUMENTADA INICIAL 4x4 (Ejercicio 4)
        double[][] matriz = {
            {1.0, 1.0, 1.0, 1.0, 10.0},
            {2.0, 3.0, 1.0, 5.0, 31.0},
            {-1.0, 1.0, -1.0, 1.0, -2.0},
            {3.0, 1.0, 2.0, 4.0, 28.0}
        };

        resolverGaussJordan4x4(matriz);
    }

    public static void resolverGaussJordan4x4(double[][] Ab) {
        int n = Ab.length;

        System.out.println("--- MATRIZ AUMENTADA INICIAL 4x4 ---");
        imprimirMatrizSimple(Ab);

        for (int i = 0; i < n; i++) {
            // Pivoteo
            if (Math.abs(Ab[i][i]) < 1e-10) {
                for (int k = i + 1; k < n; k++) {
                    if (Math.abs(Ab[k][i]) > 1e-10) {
                        double[] temp = Ab[i];
                        Ab[i] = Ab[k];
                        Ab[k] = temp;
                        break;
                    }
                }
            }

            // Normalización
            double pivote = Ab[i][i];
            for (int j = 0; j <= n; j++) {
                Ab[i][j] /= pivote;
            }

            // Eliminación
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = Ab[k][i];
                    for (int j = 0; j <= n; j++) {
                        Ab[k][j] -= factor * Ab[i][j];
                    }
                }
            }

            // Mensaje de columna procesada según la imagen
            System.out.println("Columna " + (i + 1) + " procesada:");
            imprimirMatrizSimple(Ab);
        }

        // SALIDA FINAL
        System.out.println("--- SOLUCIONES DIRECTAS ---");
        String[] vars = {"x", "y", "z", "w"};
        for (int i = 0; i < n; i++) {
            // Redondeo a 2 decimales para que coincida con la salida de tu imagen
            double valorRedondeado = Math.round(Ab[i][n] * 100.0) / 100.0;
            System.out.println(vars[i] + " = " + valorRedondeado);
        }
    }

    // Método para imprimir la matriz tal como sale en tu consola de ejemplo
    public static void imprimirMatrizSimple(double[][] m) {
        System.out.println("[");
        for (double[] fila : m) {
            System.out.print(" [ ");
            for (int j = 0; j < fila.length; j++) {
                // Formato simple para que se parezca a la salida de Python de tu imagen
                System.out.print(fila[j] + (j == fila.length - 1 ? "" : ", "));
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }
}