public class DesbordamientoEntero {
    public static void main(String[] args) {
        // Valor máximo que puede almacenar un 'int' (32 bits)
        int max = Integer.MAX_VALUE; // Es 2,147,483,647
        
        // Al sumar 1, ocurre el "Overflow" (vuelve al valor mínimo)
        int resultado = max + 1; 

        System.out.println("Máximo valor int: " + max);
        System.out.println("Máximo + 1 (Overflow): " + resultado); // Imprimirá -2,147,483,648

        // SOLUCIÓN: Usar Math.addExact para detectar el error en lugar de ignorarlo
        try {
            System.out.println("\nIntentando sumar con protección...");
            Math.addExact(max, 1); 
        } catch (ArithmeticException e) {
            System.out.println("Error detectado por el sistema: ¡Desbordamiento de memoria!");
        }
    }
}