public class Correlacion {
    public static void main(String[] args) {
        double[] x = {1, 3, 5}; // Años de experiencia
        double[] y = {2, 4, 6}; // Sueldo
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0;
        double sumX2 = 0, sumY2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += Math.pow(x[i], 2);
            sumY2 += Math.pow(y[i], 2);
        }

        // Fórmula de Pearson
        double numerador = (n * sumXY) - (sumX * sumY);
        double denominador = Math.sqrt((n * sumX2 - Math.pow(sumX, 2)) * (n * sumY2 - Math.pow(sumY, 2)));

        double r = numerador / denominador;

        System.out.println("--- CALCULO DE CORRELACION ---");
        System.out.println("El coeficiente r es: " + r);
        System.out.println("Interpretacion: " + (r == 1 ? "Relacion Positiva Perfecta" : "Relacion Fuerte"));
    }
}