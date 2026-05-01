public class Simpson13Casos3 {
    public static void main(String[] args) {
        
        // --- CASO 1: IDEAL ---
        // f(x) = x^3 en [0, 2]. Simpson es exacto para grado <= 3.
        double a1 = 0, b1 = 2, m1 = (a1 + b1) / 2.0;
        double h1 = (b1 - a1) / 2.0;
        double resIdeal = (h1 / 3.0) * (Math.pow(a1, 3) + 4 * Math.pow(m1, 3) + Math.pow(b1, 3));
        System.out.println("Simpson 1/3 (Ideal): " + resIdeal); // Resultado: 4.0

        // --- CASO 2: CON ERROR ---
        // f(x) = 1/x en [0, 1]. Falla por la discontinuidad en x=0.
        double a2 = 0, b2 = 1, m2 = 0.5;
        double resError = (1.0 / 6.0) * ((1 / a2) + 4 * (1 / m2) + (1 / b2));
        System.out.println("Simpson 1/3 (Error): " + resError); // Resultado: Infinity

        // --- CASO 3: DECIDIDO (APLICACIÓN) ---
        // f(x) = e^(-x^2) en [0, 1]. Útil para estadística (Campana de Gauss).
        double a3 = 0, b3 = 1, m3 = 0.5;
        double resApp = (1.0 / 6.0) * (Math.exp(-a3*a3) + 4*Math.exp(-m3*m3) + Math.exp(-b3*b3));
        System.out.println("Simpson 1/3 (Aplicado): " + resApp); // Resultado: ~0.7471
    }
}