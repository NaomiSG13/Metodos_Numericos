public class EnfriamientoNewton {

    public static void main(String[] args) {
        // Datos del problema de aplicación
        double tempAmbiente = 20.0; // Tm (Habitación climatizada a 20°C)
        double k = 0.05;            // Constante de pérdida de calor del material por minuto
        
        double t = 0.0;             // Tiempo inicial (minutos)
        double T = 80.0;            // Temperatura inicial del café en °C
        double h = 2.0;             // Monitorear cada 2 minutos
        double tiempoTotal = 20.0;  // Simular por 20 minutos

        System.out.println("--- SIMULACIÓN DE INGENIERÍA: ENFRIAMIENTO DE CAFÉ ---");
        System.out.println("----------------------------------------");
        System.out.printf("%-15s | %-20s%n", "Tiempo (min)", "Temperatura (°C)");
        System.out.println("----------------------------------------");

        while (t <= tiempoTotal) {
            System.out.printf("%-15.1f | %-20.2f%n", t, T);

            // Cálculo del cambio térmico instantáneo dT/dt
            double dT = -k * (T - tempAmbiente);

            // Avance al paso siguiente empleando el método de Euler
            T = T + h * dT;
            t = t + h;
        }
        System.out.println("----------------------------------------");
    }
}