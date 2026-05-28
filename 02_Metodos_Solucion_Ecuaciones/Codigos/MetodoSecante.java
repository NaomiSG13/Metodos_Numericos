public class MetodoSecante {
    // f(x) = x^2 + 4 
    public static double f(double x) {
        return Math.pow(x, 2) + 4;
    }

    public static void main(String[] args) {
        double x0 = 1.0; // Del problemario 
        double x1 = 0.8; // Del problemario 
        
        System.out.println("Iter | xn | f(xn)");
        for (int i = 1; i <= 4; i++) {
            double temp = x1;
            // Fórmula de la secante
            x1 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
            x0 = temp;
            System.out.printf("%d | %.4f | %.4f\n", i, x1, f(x1));
        }
        System.out.println("Nota: No converge a cero porque no tiene raíces reales.");
    }
}