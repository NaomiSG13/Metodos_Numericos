public class GaussSeidel4 {
    public static void main(String[] args) {
        double[][] A = {
            {27.288, -2.597, 8.818, 8.692, 0.136},
            {8.327, 36.291, -0.224, 5.941, -9.358},
            {-3.848, 1.307, 23.573, 5.358, -3.476},
            {4.138, 5.616, -8.938, 32.832, 3.606},
            {-0.581, 1.386, 6.884, 5.738, 23.818}
        };
        double[] B = {-8.965, 3.285, -1.751, -8.487, 1.458};
        
        double[] x = new double[5];
        for (int iter = 0; iter < 8; iter++) { // 8 iteraciones según la captura
            for (int i = 0; i < 5; i++) {
                double suma = 0;
                for (int j = 0; j < 5; j++) {
                    if (i != j) suma += A[i][j] * x[j];
                }
                x[i] = (B[i] - suma) / A[i][i];
            }
        }
        System.out.println("Resultados Ejercicio 3 (GS):");
        for (int i = 0; i < 5; i++) System.out.printf("x%d = %.6f%n", (i+1), x[i]);
    }
}