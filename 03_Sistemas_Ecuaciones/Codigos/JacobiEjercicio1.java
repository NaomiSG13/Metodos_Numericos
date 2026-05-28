import java.util.Arrays;

public class JacobiEjercicio1 {

    public static void main(String[] args) {
        // --- DATOS DEL EJERCICIO 1 ---
        double[][] A = {
            {5.0, 2.0, -3.0},
            {2.0, 10.0, -8.0},
            {3.0, 8.0, 13.0}
        };
        double[] b = {1.0, 4.0, 7.0};
        
        int n = A.length;
        double[] x0 = {1.0, 1.0, 1.0}; // Vector inicial
        double[] x = {1.0, 1.0, 1.0};  // Vector de nuevas aproximaciones
        
        int nmax = 100;
        double eps = 1e-10;
        int k = 1;
        boolean convergio = false;

        // --- INICIO DEL CRONÓMETRO ---
        long inicio = System.nanoTime();

        while (k <= nmax) {
            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x0[j];
                    }
                }
                x[i] = (b[i] - suma) / A[i][i];
            }

            // --- CÁLCULO DEL ERROR (Norma infinita / Max absoluto) ---
            double error = 0.0;
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(x[i] - x0[i]));
            }

            if (error < eps) {
                long fin = System.nanoTime();
                double tiempo = (fin - inicio) / 1e9; // Convertir a segundos

                System.out.println("MÉTODO DE JACOBI");
                System.out.print(" 1) La solución es = [");
                for (int i = 0; i < n; i++) {
                    System.out.printf("%.4f%s", x[i], (i == n - 1 ? "" : ", "));
                }
                System.out.println("]");
                System.out.println(" 2) Iteraciones = " + k);
                System.out.printf(" 3) Error final = %.4e%n", error);
                System.out.printf(" 4) Tiempo de ejecución = %.6f segundos%n", tiempo);
                
                convergio = true;
                break;
            }

            // --- ACTUALIZACIÓN DE x0 PARA LA SIGUIENTE ITERACIÓN ---
            System.arraycopy(x, 0, x0, 0, n);
            k++;
        }

        if (!convergio) {
            System.out.println("No converge");
        }
    }
}