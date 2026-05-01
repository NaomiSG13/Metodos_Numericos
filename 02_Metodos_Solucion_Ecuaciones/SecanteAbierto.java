public class SecanteAbierto {
    public static double f(double x) { return Math.pow(x, 2) + 4; }

    public static void main(String[] args) {
        double x0 = 1.0, x1 = 0.8, x2;
        System.out.println("Iter | xn");
        for (int i = 1; i <= 5; i++) {
            x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
            System.out.printf("%d | %.6f\n", i, x2);
            x0 = x1;
            x1 = x2;
        }
        System.out.println("Nota: Diverge porque f(x)=x^2+4 no toca el eje X.");
    }
}G