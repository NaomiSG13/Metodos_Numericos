public class FalsaPosicion {
    public static double f(double x) {
        return Math.pow(x, 3) - x - 1;
    }

    public static void main(String[] args) {
        double a = 1.0, b = 2.0, xr = 0;
        System.out.println("Iter | xr | f(xr)");
        for (int i = 1; i <= 6; i++) {
            // Fórmula: xr = b - (f(b)*(a-b))/(f(a)-f(b))
            xr = b - (f(b) * (a - b)) / (f(a) - f(b));
            System.out.printf("%d | %.6f | %.6f\n", i, xr, f(xr));
            if (f(a) * f(xr) < 0) b = xr;
            else a = xr;
        }
    }
}