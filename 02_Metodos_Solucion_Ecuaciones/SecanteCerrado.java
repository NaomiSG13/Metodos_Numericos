public class SecanteCerrado {
    public static double f(double x) { return Math.pow(x, 3) - 9 * x + 3; }

    public static void main(String[] args) {
        double a = 0.0, b = 1.0, xr;
        for (int i = 1; i <= 4; i++) {
            xr = b - (f(b) * (a - b)) / (f(a) - f(b));
            System.out.printf("Iter %d: xr = %.4f\n", i, xr);
            if (f(a) * f(xr) < 0) b = xr;
            else a = xr;
        }
    }
}