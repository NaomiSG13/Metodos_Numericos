public class ComparacionDouble {
    public static void main(String[] args) {
        // El Problema: Error de redondeo en aritmética de punto flotante
        double a = 0.1 + 0.1 + 0.1;
        double b = 0.3;

        System.out.println("Valor de a (0.1 * 3): " + a);
        System.out.println("Valor de b: " + b);

        // Intento de comparación directa (FALLARÁ)
        System.out.println("\n--- Comparación con '==' ---");
        if (a == b) {
            System.out.println("Resultado: Son iguales");
        } else {
            System.out.println("Resultado: SON DIFERENTES (Error esperado)");
        }

        // La Solución: Uso de un margen de error (Épsilon)
        double epsilon = 0.00001; // Definimos la tolerancia
        System.out.println("\n--- Comparación con Épsilon (" + epsilon + ") ---");
        if (Math.abs(a - b) < epsilon) {
            System.out.println("Resultado: Son iguales (dentro del margen de error)");
        } else {
            System.out.println("Resultado: Son diferentes");
        }
    }
}