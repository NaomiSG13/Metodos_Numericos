public class JacobiEjercicio3 {

    public static void main(String[] args) {
        // Datos del sistema del Ejercicio 3 (Matriz 3x3)
        double[][] A = {
            {5.0, 1.0, 1.0},
            {1.0, 4.0, 1.0},
            {1.0, 1.0, 3.0}
        };
        
        double[] b = {7.0, 6.0, 5.0};
        
        int n = b.length;
        double[] x = new double[n];      // Vector para valores nuevos (x_new)
        double[] x0 = new double[n];     // Vector para valores anteriores (x_old)
        
        // Número de iteraciones según tu captura de Python
        int nmax = 10; 
        
        System.out.println("MÉTODO DE JACOBI - EJERCICIO 3");
        System.out.println("--------------------------------");

        for (int k = 0; k < nmax; k++) {
            // Aplicación de las fórmulas de despeje del Ejercicio 3
            x[0] = (7.0 - x0[1] - x0[2]) / 5.0;
            x[1] = (6.0 - x0[0] - x0[2]) / 4.0;
            x[2] = (5.0 - x0[0] - x0[1]) / 3.0;
            
            // Mostrar los resultados de la iteración actual
            System.out.printf("Iteración %d: x=%.5f, y=%.5f, z=%.5f%n", 
                              (k + 1), x[0], x[1], x[2]);
            
            // Actualización de x0 para la siguiente iteración (Esencia de Jacobi)
            for (int i = 0; i < n; i++) {
                x0[i] = x[i];
            }
        }
        
        System.out.println("--------------------------------");
        System.out.println("SOLUCIÓN FINAL (Después de 10 iteraciones):");
        System.out.printf("x = %.6f%n", x[0]);
        System.out.printf("y = %.6f%n", x[1]);
        System.out.printf("z = %.6f%n", x[2]);
    }
}