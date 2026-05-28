public class Extrapolacion {
    public static void main(String[] args) {
        // Datos conocidos (x = % CPU, y = Watts)
        double x1 = 20.0, y1 = 150.0;
        double x2 = 80.0, y2 = 350.0;
        
        // Punto a extrapolar (fuera del rango 20-80)
        double xTarget = 110.0;
        
        // Fórmula de la recta (sirve para interpolar y extrapolar)
        double yTarget = y1 + ((y2 - y1) / (x2 - x1)) * (xTarget - x1);
        
        System.out.println("--- EJERCICIO DE EXTRAPOLACIÓN ---");
        System.out.printf("Para un uso de CPU del %.1f%% (fuera de rango)%n", xTarget);
        System.out.printf("El consumo estimado de energia es de: %.2f Watts.%n", yTarget);
    }
}