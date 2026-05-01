public class GaussSeidel1 {
    public static void main(String[] args) {
        // Sistema de ecuaciones del Ejercicio 1 de tu guía (3x3)
        // ec1: 12.350x + 1.836y + 5.481z = -6.152
        // ec2: -7.937x + 18.398y - 0.896z = -9.457
        // ec3: -5.117x + 9.478y + 26.752z = -8.622
        
        double[][] A = {
            {12.350, 1.836, 5.481},
            {-7.937, 18.398, -0.896},
            {-5.117, 9.478, 26.752}
        };
        double[] B = {-6.152, -9.457, -8.622};
        
        // Parámetros de control
        double tolerancia = 0.0001;
        int maxIteraciones = 100;

        resolverGaussSeidel(A, B, tolerancia, maxIteraciones);
    }

    public static void resolverGaussSeidel(double[][] A, double[] B, double tol, int maxIter) {
        int n = B.length;
        double[] x = new double[n]; // Valores iniciales (por defecto 0)
        double[] xAnterior = new double[n];
        int iteracion = 0;
        double error = 1.0;

        System.out.println("=================================================");
        System.out.println("      MÉTODO DE GAUSS-SEIDEL - RESULTADOS");
        System.out.println("=================================================");

        while (error > tol && iteracion < maxIter) {
            error = 0;
            for (int i = 0; i < n; i++) {
                xAnterior[i] = x[i];
            }

            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j];
                    }
                }
                x[i] = (B[i] - suma) / A[i][i];
            }

            // Cálculo del error (Norma infinita)
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(x[i] - xAnterior[i]));
            }
            
            iteracion++;
        }

        // Salida formateada como en tu imagen
        System.out.println("RESULTADOS:");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("x %d = %.6f%n", (i + 1), x[i]);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Iteraciones: " + iteracion);
        System.out.println("Error final: " + error);
        System.out.println("=================================================");
    }
}