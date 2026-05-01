public class Regla3puntosCasos {

    public static void main(String[] args) {
        System.out.println("----- REGLA DE DIFERENCIACION DE 3 PUNTOS -----");

        // --- CASO 1: IDEAL ---
        // Funcion: f(x) = x^2 + x + 1 en x = 2
        // Derivada exacta f'(x) = 2x + 1 -> f'(2) = 5
        double x1 = 2.0;
        double h1 = 0.01;
        double resIdeal = (f1(x1 + h1) - f1(x1 - h1)) / (2 * h1);
        System.out.println("\n1. CASO IDEAL (Polinomio de grado 2)");
        System.out.println("   f(x) = x^2 + x + 1 en x = 2");
        System.out.println("   Resultado: " + resIdeal);

        // --- CASO 2: CON ERROR ---
        // Funcion: f(x) = sqrt(x) en x = 0.1 (Cerca del origen la pendiente cambia bruscamente)
        // El error aumenta si el paso h no es lo suficientemente pequeño para la curvatura
        double x2 = 0.1;
        double h2 = 0.1; 
        double resError = (f2(x2 + h2) - f2(x2 - h2)) / (2 * h2);
        System.out.println("\n2. CASO CON ERROR (Curvatura pronunciada)");
        System.out.println("   f(x) = sqrt(x) en x = 0.1 con h = 0.1");
        System.out.println("   Resultado: " + resError);

        // --- CASO 3: DECIDIDO (APLICACION) ---
        // Funcion: f(x) = sin(x) para encontrar la pendiente en un punto trigonometrico
        double x3 = Math.PI / 3; // 60 grados
        double h3 = 0.001;
        double resDecidido = (Math.sin(x3 + h3) - Math.sin(x3 - h3)) / (2 * h3);
        System.out.println("\n3. CASO DECIDIDO (Trigonometria)");
        System.out.println("   f(x) = sin(x) en x = PI/3");
        System.out.println("   Resultado aproximado: " + resDecidido);
        System.out.println("   Valor real (cos(PI/3)): 0.5");
        System.out.println("-----------------------------------------------");
    }

    // Funciones auxiliares
    public static double f1(double x) {
        return Math.pow(x, 2) + x + 1;
    }

    public static double f2(double x) {
        return Math.sqrt(x);
    }
}