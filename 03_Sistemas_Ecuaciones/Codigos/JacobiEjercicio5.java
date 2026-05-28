public class JacobiEjercicio5 {

    public static void main(String[] args) {
        // Número de variables
        int n = 6;
        double[] x = new double[n];      // Vector para nuevos valores (x_new)
        double[] x0 = new double[n];     // Vector para valores anteriores (x_old)
        
        // Número de iteraciones
        int nmax = 15; 
        
        System.out.println("MÉTODO DE JACOBI - EJERCICIO 5 (6x6)");
        System.out.println("-------------------------------------");

        for (int k = 0; k < nmax; k++) {
            // Aplicación de las fórmulas de despeje del Ejercicio 5
            // x1
            x[0] = (15.0 - x0[1] - x0[2] - x0[3] - x0[4] - x0[5]) / 10.0;
            // x2
            x[1] = (16.0 - x0[0] - x0[2] - x0[3] - x0[4] - x0[5]) / 11.0;
            // x3
            x[2] = (17.0 - x0[0] - x0[1] - x0[3] - x0[4] - x0[5]) / 12.0;
            // x4
            x[3] = (18.0 - x0[0] - x0[1] - x0[2] - x0[4] - x0[5]) / 13.0;
            // x5
            x[4] = (19.0 - x0[0] - x0[1] - x0[2] - x0[3] - x0[5]) / 14.0;
            // x6
            x[5] = (20.0 - x0[0] - x0[1] - x0[2] - x0[3] - x0[4]) / 15.0;
            
            // Mostrar progreso de la iteración
            System.out.printf("Iteración %02d: ", (k + 1));
            for (int i = 0; i < n; i++) {
                System.out.printf("x%d=%.4f ", (i + 1), x[i]);
            }
            System.out.println();
            
            // Actualización de x0 para la siguiente iteración (Sello del método Jacobi)
            for (int i = 0; i < n; i++) {
                x0[i] = x[i];
            }
        }
        
        System.out.println("-------------------------------------");
        System.out.println("SOLUCIÓN FINAL:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.6f%n", (i + 1), x[i]);
        }
    }
}