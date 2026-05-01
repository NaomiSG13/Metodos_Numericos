public class PerdidaPrecision {
    public static void main(String[] args) {
        // Un double tiene aproximadamente 15-17 dígitos significativos
        double numeroGrande = 1.0e16; 
        double numeroPequeno = 1.0;

        double resultado = numeroGrande + numeroPequeno;

        System.out.println("--- Demostración de Pérdida de Precisión ---");
        System.out.println("Suma Resultante (double): " + resultado);
        
        // Verificación lógica del error de magnitud
        if (resultado == numeroGrande) {
            System.out.println("RESULTADO: El número pequeño 'desapareció' debido a la falta de bits en la mantisa.");
        }

        // SOLUCIÓN: Usar BigDecimal para precisión absoluta
        java.math.BigDecimal bdGrande = new java.math.BigDecimal("1.0e16");
        java.math.BigDecimal bdPequeno = new java.math.BigDecimal("1.0");
        java.math.BigDecimal bdResultado = bdGrande.add(bdPequeno);
        
        System.out.println("\n--- Solución con BigDecimal ---");
        System.out.println("Suma Exacta: " + bdResultado.toPlainString());
    }
}