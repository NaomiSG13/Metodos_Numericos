public class Ejercicio5EliminacionGaussiana 
{
    public static void main(String[] args) {
        double[][] matriz = {
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,120},
            {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,140},
            {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,160},
            {4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,180},
            {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,200},
            {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,220},
            {7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,240},
            {8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,260},
            {9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,280},
            {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,300},
            {11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,320},
            {12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,340},
            {13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,360},
            {14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,380},
            {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,240}
        };

        int n = 15;

        for (int i = 0; i < n; i++) {
            // --- NUEVO: PIVOTEO PARCIAL ---
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[max][i])) {
                    max = k;
                }
            }
            // Intercambiar filas
            double[] temp = matriz[i];
            matriz[i] = matriz[max];
            matriz[max] = temp;

            // Verificar si sigue siendo cero después del intercambio
            if (Math.abs(matriz[i][i]) < 1e-10) {
                System.out.println("El sistema no tiene solución única (Matriz Singular)");
                return;
            }
            // ------------------------------

            double p = matriz[i][i];
            for (int j = 0; j <= n; j++) matriz[i][j] /= p;
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double f = matriz[k][i];
                    for (int j = 0; j <= n; j++) matriz[k][j] -= f * matriz[i][j];
                }
            }
        }

        System.out.println("Solución:");
        for (int i = 0; i < n; i++) System.out.printf("x%d = %.6f%n", (i+1), matriz[i][n]);
    }
}