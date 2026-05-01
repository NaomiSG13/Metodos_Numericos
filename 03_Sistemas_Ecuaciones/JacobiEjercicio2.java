public class JacobiEjercicio2 {

    public static void main(String[] args) {
        // Datos del sistema del Ejercicio 2 (Matriz 3x3)
        // Basado en el despeje:
        // x = (9 - 2y - z) / 10
        // y = (13 - 2x - 3z) / 10
        // z = (14 - x - 3y) / 10
        
        double[][] A = {
            {10.0, 2.0, 1.0},
            {2.0, 10.0, 3.0},
            {1.0, 3.0, 10.0}
        };
        
        double[] b = {9.0, 13.0, 14.0};
        
        int n = b.length;
        double[] x = new double[n];      // Vector x_new
        double[] x0 = new double[n];     // Vector x_old (inicializado en 0)
        
        int nmax = 10; // Número de iteraciones según tu captura de Python
        
        System.out.println("MÉTODO DE JACOBI - EJERCICIO 2");
        System.out.println("--------------------------------");

        for (int k = 0; k < nmax; k++) {
            // Cálculo de la nueva iteración
            x[0] = (9.0 - 2.0 * x0[1] - x0[2]) / 10.0;
            x[1] = (13.0 - 2.0 * x0[0] - 3.0 * x0[2]) / 10.0;
            x[2] = (14.0 - x0[0] - 3.0 * x0[1]) / 10.0;
            
            // Imprimir estado de la iteración
            System.out.printf("Iteración %d: x=%.5f, y=%.5f, z=%.5f%n", 
                              (k + 1), x[0], x[1], x[2]);
            
            // Actualizar x0 para la siguiente iteración (Esencia de Jacobi)
            for (int i = 0; i < n; i++) {
                x0[i] = x[i];
            }
        }
        
        // Resultados finales
        System.out.println("--------------------------------");
        System.out.println("SOLUCIÓN FINAL:");
        System.out.printf("x = %.6f%n", x[0]);
        System.out.printf("y = %.6f%n", x[1]);
        System.out.printf("z = %.6f%n", x[2]);
    }
}