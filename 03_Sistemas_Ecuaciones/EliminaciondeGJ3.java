public class EliminaciondeGJ3 {
    public static void main(String[] args) {
        // MATRIZ AUMENTADA DEL EJERCICIO 5x5
        double[][] A = {
            {1.0, 2.0, 1.0, 1.0, 1.0, 10.0},
            {2.0, 3.0, 1.0, 1.0, 1.0, 13.0},
            {1.0, 1.0, 2.0, 1.0, 1.0, 12.0},
            {1.0, 1.0, 1.0, 2.0, 1.0, 11.0},
            {1.0, 1.0, 1.0, 1.0, 2.0, 14.0}
        };

        double[][] resultado = gaussJordan(A);

        System.out.println("Matriz reducida:");
        for (double[] fila : resultado) {
            System.out.print("[");
            for (int j = 0; j < fila.length; j++) {
                System.out.print(fila[j] + (j == fila.length - 1 ? "" : ", "));
            }
            System.out.println("]");
        }

        System.out.println("\nSolución del sistema:");
        String[] variables = {"x", "y", "z", "w", "v"};
        for (int i = 0; i < resultado.length; i++) {
            System.out.println(variables[i] + " = " + resultado[i][resultado[i].length - 1]);
        }
    }

    public static double[][] gaussJordan(double[][] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            // PIVOTEO
            if (Math.abs(A[i][i]) < 1e-15) {
                for (int k = i + 1; k < n; k++) {
                    if (Math.abs(A[k][i]) > 1e-15) {
                        double[] temp = A[i];
                        A[i] = A[k];
                        A[k] = temp;
                        break;
                    }
                }
            }

            double pivote = A[i][i];

            // NORMALIZACIÓN
            for (int j = 0; j <= n; j++) {
                A[i][j] /= pivote;
            }

            // ELIMINACIÓN
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = A[k][i];
                    for (int j = 0; j <= n; j++) {
                        A[k][j] -= factor * A[i][j];
                    }
                }
            }
        }
        return A;
    }
}