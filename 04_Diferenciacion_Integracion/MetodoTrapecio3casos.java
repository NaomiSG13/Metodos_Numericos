public class MetodoTrapecio3casos {
    public static void main(String[] args) {
        // Caso Ideal: f(x)=5x+2 en [0, 2]
        double a = 0, b = 2;
        double resIdeal = ((b - a) / 2.0) * ((5 * a + 2) + (5 * b + 2));
        System.out.println("Trapecio (Ideal): " + resIdeal);

        // Caso con Error: f(x)=sin(x^2) en [0, 2]
        double fa = Math.sin(a * a), fb = Math.sin(b * b);
        double resError = ((b - a) / 2.0) * (fa + fb);
        System.out.println("Trapecio (Error): " + resError);

        // Caso Aplicado: f(x)=sqrt(1+x^2) en [0, 1]
        double aa = 0, bb = 1;
        double faa = Math.sqrt(1 + aa * aa), fbb = Math.sqrt(1 + bb * bb);
        double resApp = ((bb - aa) / 2.0) * (faa + fbb);
        System.out.println("Trapecio (Aplicado): " + resApp);
    }
}