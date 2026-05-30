public class PenduloSistema {

    public static void main(String[] args) {
        double t = 0.0;
        double h = 0.05; // Paso de tiempo en segundos
        double tMax = 1.0;

        // Parámetros físicos
        double g = 9.81; // Gravedad
        double L = 1.0;  // Longitud de la cuerda (1 metro)

        // Condiciones iniciales
        double theta = 0.5; // Ángulo inicial en radianes (~28 grados)
        double omega = 0.0; // Velocidad angular inicial (se suelta desde el reposo)

        System.out.println("--- SIMULACIÓN DE PÉNDULO (SISTEMA DE EDO DE 2DO ORDEN) ---");
        System.out.printf("Tiempo: %.2fs -> Ángulo: %.4f rad | Vel. Angular: %.4f rad/s%n", t, theta, omega);

        while (t < tMax - 0.001) {
            // Calcular derivadas simultáneas
            double dTheta = omega;
            double dOmega = -(g / L) * Math.sin(theta);

            // Actualización simultánea por el método de Euler
            theta = theta + h * dTheta;
            omega = omega + h * dOmega;
            t = t + h;

            System.out.printf("Tiempo: %.2fs -> Ángulo: %.4f rad | Vel. Angular: %.4f rad/s%n", t, theta, omega);
        }
    }
}