public class RedondeoBinario {
    public static void main(String[] args) {
        // El Problema: Error de redondeo en aritmética de punto flotante
        double sumaSimple = 0.1 + 0.2;
        System.out.println("Resultado estándar (double) de 0.1 + 0.2: " + sumaSimple); 

        // La Solución: Usar BigDecimal para precisión exacta
        java.math.BigDecimal a = new java.math.BigDecimal("0.1");
        java.math.BigDecimal b = new java.math.BigDecimal("0.2");
        System.out.println("Solución exacta con BigDecimal: " + a.add(b));
    }
}