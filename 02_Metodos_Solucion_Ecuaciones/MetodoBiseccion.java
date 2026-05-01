public class MetodoBiseccion {
    // Función de la página 3 del problemario: x^3 - 4x - 9
    public static double f(double x) {
        return Math.pow(x, 3) - (4 * x) - 9;
    }

    public static void main(String[] args) {
        double a = 2.0; // Valor inicial a 
        double b = 3.0; // Valor inicial b 
        double tol = 0.0001; 
        double xr = 0;
        int iter = 1;

        System.out.println("Iter | xr | f(xr)");
        while (Math.abs(b - a) > tol) {
            xr = (a + b) / 2;
            System.out.printf("%d | %.4f | %.4f\n", iter, xr, f(xr));
            
            if (f(a) * f(xr) < 0) {
                b = xr;
            } else {
                a = xr;
            }
            iter++;
            if(iter > 20) break; // Seguridad
        }
        System.out.println("Raíz aproximada: " + xr);
    }
}