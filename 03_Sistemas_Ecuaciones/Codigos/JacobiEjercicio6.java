public class JacobiEjercicio6 {

    public static void main(String[] args) {
        // Número de variables (x1 a x8)
        int n = 8;
        double[] x = new double[n];      // Vector para nuevos valores (x_new)
        double[] x0 = new double[n];     // Vector para valores anteriores (x_old)
        
        // Número de iteraciones (ajustable según convergencia deseada)
        int nmax = 15; 
        
        System.out.println("MÉTODO DE JACOBI - EJERCICIO 6 (8x8)");
        System.out.println("-------------------------------------");

        for (int k = 0; k < nmax; k++) {
            // Aplicación de las fórmulas de despeje del Ejercicio 6 
            x[0] = (20.0 - x0[1] - x0[2] - x0[3] - x0[4] - x0[5] - x0[6] - x0[7]) / 16.0;
            x[1] = (25.0 - x0[0] - x0[2] - x0[3] - x0[4] - x0[5] - x0[6] - x0[7]) / 17.0;
            x[2] = (30.0 - x0[0] - x0[1] - x0[3] - x0[4] - x0[5] - x0[6] - x0[7]) / 18.0;
            x[3] = (22.0 - x0[0] - x0[1] - x0[2] - x0[4] - x0[5] - x0[6] - x0[7]) / 19.0;
            x[4] = (27.0 - x0[0] - x0[1] - x0[2] - x0[3] - x0[5] - x0[6] - x0[7]) / 20.0;
            x[5] = (24.0 - x0[0] - x0[1] - x0[2] - x0[3] - x0[4] - x0[6] - x0[7]) / 21.0;
            x[6] = (28.0 - x0[0] - x0[1] - x0[2] - x0[3] - x0[4] - x0[5] - x0[7]) / 22.0;
            x[7] = (26.0 - x0[0] - x0[1] - x0[2] - x0[3] - x0[4] - x0[5] - x0[6]) / 23.0;
            
            // Mostrar resultados de la iteración actual
            System.out.printf("Iteración %02d: ", (k + 1));
            System.out.printf("x1=%.4f, x8=%.4f%n", x[0], x[7]); // Resumen por espacio
            
            // ACTUALIZACIÓN CRÍTICA PARA JACOBI: 
            // Se pasan los valores nuevos al vector de "anteriores" solo después de calcular toda la tanda
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