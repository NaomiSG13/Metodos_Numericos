public class JacobiEjercicio4 {

    public static void main(String[] args) {
        // Datos del sistema del Ejercicio 4 (Matriz 3x3)
        // Sistema original:
        // 3x + y + z = 5
        // x + 3y + z = 5
        // x + y + 3z = 5
        
        double[][] A = {
            {3.0, 1.0, 1.0},
            {1.0, 3.0, 1.0},
            {1.0, 1.0, 3.0}
        };
        
        double[] b = {5.0, 5.0, 5.0};
        
        int n = b.length;
        double[] x = new double[n];      // Vector para nuevos valores (x_new)
        double[] x0 = new double[n];     // Vector para valores anteriores (x_old)
        
        // Número de iteraciones según tu captura de Python para este ejercicio
        int nmax = 25; 
        
        System.out.println("MÉTODO DE JACOBI - EJERCICIO 4");
        System.out.println("--------------------------------");

        for (int k = 0; k < nmax; k++) {
            // Aplicación de las fórmulas de despeje del Ejercicio 4:
            // x = (5 - y - z) / 3
            // y = (5 - x - z) / 3
            // z = (5 - x - y) / 3
            
            x[0] = (5.0 - x0[1] - x0[2]) / 3.0;
            x[1] = (5.0 - x0[0] - x0[2]) / 3.0;
            x[2] = (5.0 - x0[0] - x0[1]) / 3.0;
            
            // Imprimir el progreso cada 5 iteraciones o la última para no saturar la consola
            if ((k + 1) % 5 == 0 || k == 0) {
                System.out.printf("Iteración %d: x=%.5f, y=%.5f, z=%.5f%n", 
                                  (k + 1), x[0], x[1], x[2]);
            }
            
            // Actualización de x0 para la siguiente iteración
            for (int i = 0; i < n; i++) {
                x0[i] = x[i];
            }
        }
        
        System.out.println("--------------------------------");
        System.out.println("SOLUCIÓN FINAL (Tras 25 iteraciones):");
        System.out.printf("x1 = %.6f%n", x[0]);
        System.out.printf("x2 = %.6f%n", x[1]);
        System.out.printf("x3 = %.6f%n", x[2]);
    }
}