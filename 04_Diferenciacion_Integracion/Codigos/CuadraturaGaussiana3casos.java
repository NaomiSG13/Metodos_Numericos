import java.util.Scanner;

public class CuadraturaGaussiana3casos {

    public static void main(String[] args) {
        // Constantes para la Cuadratura Gaussiana de 2 puntos en [-1, 1]
        double x1 = -0.5773502692;
        double x2 = 0.5773502692;
        double w1 = 1.0;
        double w2 = 1.0;

        System.out.println("=== REGLA DE CUADRATURA GAUSSIANA (2 PUNTOS) ===");

        // --- CASO 1: IDEAL ---
        // f(x) = x^3 + x^2 + x + 1 en el intervalo [-1, 1]
        // La Cuadratura Gaussiana es exacta para polinomios de grado 2n-1 (grado 3)
        double resIdeal = w1 * fIdeal(x1) + w2 * fIdeal(x2);
        System.out.println("\n1. CASO IDEAL (Polinomio Grado 3)");
        System.out.println("   Funcion: f(x) = x^3 + x^2 + x + 1");
        System.out.println("   Resultado: " + resIdeal + " (Exacto)");

        // --- CASO 2: CON ERROR ---
        // f(x) = 1 / (x + 1.1) en el intervalo [-1, 1]
        // El error ocurre por la proximidad a una asintota en x = -1.1
        double resError = w1 * fError(x1) + w2 * fError(x2);
        System.out.println("\n2. CASO CON ERROR (Asintota cercana)");
        System.out.println("   Funcion: f(x) = 1 / (x + 1.1)");
        System.out.println("   Resultado aproximado: " + resError);
        System.out.println("   Nota: Presenta error porque la funcion no es polinomica suave.");

        // --- CASO 3: DECIDIDO (APLICACION) ---
        // f(x) = e^x * cos(x) en el intervalo [-1, 1]
        // Aplicacion en ingenieria para funciones trascendentes
        double resDecidido = w1 * fDecidido(x1) + w2 * fDecidido(x2);
        System.out.println("\n3. CASO DECIDIDO (Aplicacion Fisica/Ingenieria)");
        System.out.println("   Funcion: f(x) = e^x * cos(x)");
        System.out.println("   Resultado aproximado: " + resDecidido);
        System.out.println("================================================");
    }

    // Funciones para cada caso
    public static double fIdeal(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) + x + 1;
    }

    public static double fError(double x) {
        return 1.0 / (x + 1.1);
    }

    public static double fDecidido(double x) {
        return Math.exp(x) * Math.cos(x);
    }
}