public class Regla5PuntosCasos {

    public static void main(String[] args) {
        System.out.println("----- REGLA DE DIFERENCIACION DE 5 PUNTOS -----");

        // --- CASO 1: IDEAL ---
        // f(x) = x^4. La derivada exacta es 4x^3.
        // En x = 1, f'(1) = 4(1)^3 = 4.0
        double x1 = 1.0;
        double h1 = 0.1;
        double resIdeal = (-f1(x1 + 2*h1) + 8*f1(x1 + h1) - 8*f1(x1 - h1) + f1(x1 - 2*h1)) / (12 * h1);
        
        System.out.println("\n1. CASO IDEAL (Polinomio de grado 4)");
        System.out.println("   f(x) = x^4 en x = 1");
        System.out.println("   Resultado: " + resIdeal);
        System.out.println("   Nota: El error es casi inexistente debido al orden del metodo.");

        // --- CASO 2: CON ERROR ---
        // Funcion: f(x) = 1/x en x = 0.5. 
        // Si usamos un h demasiado grande (h=0.2), los puntos x-2h llegan a 0.1
        // donde la curva es demasiado pronunciada para una aproximacion lineal.
        double x2 = 0.5;
        double h2 = 0.2; 
        double resError = (-f2(x2 + 2*h2) + 8*f2(x2 + h2) - 8*f2(x2 - h2) + f2(x2 - 2*h2)) / (12 * h2);
        
        System.out.println("\n2. CASO CON ERROR (Paso h inadecuado)");
        System.out.println("   f(x) = 1/x en x = 0.5 con h = 0.2");
        System.out.println("   Resultado: " + resError);

        // --- CASO 3: DECIDIDO (APLICACION) ---
        // Calcular la tasa de cambio de una funcion exponencial f(x) = e^x
        // En x = 0, f'(0) debe ser e^0 = 1.0
        double x3 = 0.0;
        double h3 = 0.01;
        double resDecidido = (-Math.exp(x3 + 2*h3) + 8*Math.exp(x3 + h3) - 8*Math.exp(x3 - h3) + Math.exp(x3 - 2*h3)) / (12 * h3);
        
        System.out.println("\n3. CASO DECIDIDO (Funcion Exponencial)");
        System.out.println("   f(x) = e^x en x = 0");
        System.out.println("   Resultado calculado: " + resDecidido);
        System.out.println("   Valor real: 1.0");
        System.out.println("-----------------------------------------------");
    }

    // Funciones auxiliares
    public static double f1(double x) {
        return Math.pow(x, 4);
    }

    public static double f2(double x) {
        return 1.0 / x;
    }
}