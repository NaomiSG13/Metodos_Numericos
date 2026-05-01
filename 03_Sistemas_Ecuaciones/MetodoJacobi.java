import java.util.Arrays;

public class MetodoJacobi {
    public static void main(String[] args) {
        // Sistema 6x6 de la página 43 del PDF
        double[] x = new double[6]; // Valores iniciales [0,0,0,0,0,0]
        int iteraciones = 20;

        System.out.println("--- MÉTODO DE JACOBI (Sistema 6x6) ---");
        for (int k = 1; k <= iteraciones; k++) {
            double[] xNuevo = new double[6];
            
            // Fórmulas despejadas del PDF
            xNuevo[0] = (18 - x[1] - x[2] - x[3] - x[4] - x[5]) / 10;
            xNuevo[1] = (20 - x[0] - x[2] - x[3] - x[4] - x[5]) / 11;
            xNuevo[2] = (16 - x[0] - x[1] - x[3] - x[4] - x[5]) / 12;
            xNuevo[3] = (19 - x[0] - x[1] - x[2] - x[4] - x[5]) / 13;
            xNuevo[4] = (17 - x[0] - x[1] - x[2] - x[3] - x[5]) / 14;
            xNuevo[5] = (21 - x[0] - x[1] - x[2] - x[3] - x[4]) / 15;

            x = xNuevo;
            System.out.print("Iteración " + k + ": ");
            for (double val : x) System.out.printf("%.4f ", val);
            System.out.println();
        }
    }
}