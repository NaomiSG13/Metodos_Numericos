public class Regresion {
    public static void main(String[] args) {
        double[] x = {2, 4, 6};  // Inversión en Publicidad
        double[] y = {10, 20, 30}; // Ventas
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        // 1. Calcular Pendiente (m)
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - Math.pow(sumX, 2));

        // 2. Calcular Intercepto (b)
        double b = (sumY - m * sumX) / n;

        System.out.println("--- CÁLCULO DE REGRESIÓN ---");
        System.out.println("Ecuación: y = " + m + "x + " + b);
        
        // 3. Predicción: ¿Cuánto venderé si invierto $10?
        double inversion = 10;
        double prediccion = (m * inversion) + b;
        
        System.out.println("Para una inversión de $" + inversion + ", la venta estimada es: $" + prediccion);
    }
}