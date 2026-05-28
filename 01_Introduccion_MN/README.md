# TEMA 1: Introducción a los Métodos Numéricos

En este apartado se presenta el estudio de algoritmos para la localización de raíces de ecuaciones no lineales y el cálculo de aproximaciones numéricas.

---

### 📉 Análisis de Errores

La precisión es fundamental en el cálculo numérico. Para evaluar la aproximación en cada ejercicio, se detallan las siguientes expresiones matemáticas puras:

* **Error Absoluto ($E_a$):**
```math
E_a = |V - A|
Error Relativo ($E_r$):Fragmento de códigoE_r = \frac{|V - A|}{|V|}
Error Porcentual ($E_p$):Fragmento de códigoE_p = \left( \frac{|V - A|}{|V|} \right) \times 100
Nota: En las fórmulas anteriores, $V$ representa el valor real esperado y $A$ representa el valor aproximado obtenido por el método.🛠️ Métodos DesarrolladosHaz clic en cada método para desplegar su información completa (Objetivo, Descripción, Fórmula, Pasos, Pseudocódigo, Código, Resultado y Conclusión).1. ObjetivoEncontrar una raíz real de una función continua en un intervalo cerrado donde exista un cambio de signo.2. DescripciónEs un método de búsqueda incremental que divide repetidamente a la mitad el intervalo que contiene a la raíz. Si la función cambia de signo en un subintervalo, la raíz se encuentra ahí; de lo contrario, está en el otro extremo. Es un método robusto y de convergencia segura, aunque lenta.3. FórmulaFragmento de códigoc = \frac{a + b}{2}
4. Pasos del AlgoritmoDefinir un intervalo $[a, b]$ tal que $f(a) \cdot f(b) < 0$.Calcular el punto medio $c$.Evaluar el criterio de parada (si $|f(c)| < \text{tolerancia}$ o el error es menor al permitido, terminar).Si $f(a) \cdot f(c) < 0$, la raíz está en $[a, c]$, por lo que hacemos $b = c$.Si $f(a) \cdot f(c) > 0$, la raíz está en $[c, b]$, por lo que hacemos $a = c$.Repetir desde el paso 2 hasta cumplir el criterio de parada o alcanzar el límite de iteraciones.5. PseudocódigoPlaintextINICIO Biseccion(f, a, b, tol, max_iter)
    SI f(a) * f(b) >= 0 ENTONCES
        MOSTRAR "El intervalo no es válido (no hay cambio de signo)"
        TERMINAR
    FIN SI

    iter <- 0
    REPETIR
        c <- (a + b) / 2
        error <- ABS(b - a) / 2
        
        SI ABS(f(c)) < tol O error < tol ENTONCES
            RETURN c
        FIN SI
        
        SI f(a) * f(c) < 0 ENTONCES
            b <- c
        SINO
            a <- c
        FIN SI
        
        iter <- iter + 1
    MIENTRAS iter < max_iter

    RETURN c
FIN
6. Código en JavaJavapublic static double biseccion(Function<Double, Double> f, double a, double b, double tol, int maxIter) {
    if (f.apply(a) * f.apply(b) >= 0) {
        throw new IllegalArgumentException("No hay cambio de signo en el intervalo dado.");
    }
    
    double c = a;
    for (int i = 0; i < maxIter; i++) {
        c = (a + b) / 2;
        
        if (Math.abs(f.apply(c)) < tol || (b - a) / 2 < tol) {
            return c;
        }
        
        if (f.apply(a) * f.apply(c) < 0) {
            b = c;
        } else {
            a = c;
        }
    }
    return c;
}
7. ResultadoPlaintext--- Ejecución Método de Bisección ---
Función: x^2 - 4
Intervalo: [0, 3]
Raíz aproximada encontrada: 2.00000012
Iteraciones requeridas: 22
Error Absoluto estimado: 0.00000008
8. ConclusionEl método de Bisección es ideal como primera opción cuando no se conocen las derivadas de la función, ya que garantiza convergencia. Sin embargo, su velocidad de convergencia es lineal, lo que lo hace ineficiente en términos de tiempo de cómputo comparado con métodos más avanzados.1. ObjetivoAcelerar la convergencia del método de bisección aprovechando los valores numéricos de los extremos del intervalo.2. DescripciónA diferencia de bisección, que corta el intervalo estrictamente por la mitad, la Falsa Posición traza una línea recta (secante) entre los puntos de los extremos. La intersección de esta línea con el eje horizontal se convierte en la nueva aproximación de la raíz.3. FórmulaFragmento de códigoc = b - \frac{f(b) \cdot (a - b)}{f(a) - f(b)}
4. Pasos del AlgoritmoDefinir un intervalo $[a, b]$ tal que $f(a) \cdot f(b) < 0$.Calcular el punto de aproximación $c$ usando la fórmula de la secante.Evaluar el criterio de parada.Si $f(a) \cdot f(c) < 0$, la raíz está en $[a, c]$, hacemos $b = c$.Si no, la raíz está en $[c, b]$, hacemos $a = c$.Repetir hasta cumplir las condiciones de parada.5. PseudocódigoPlaintextINICIO FalsaPosicion(f, a, b, tol, max_iter)
    SI f(a) * f(b) >= 0 ENTONCES TERMINAR FIN SI
    
    iter <- 0
    REPETIR
        c <- b - (f(b) * (a - b)) / (f(a) - f(b))
        
        SI ABS(f(c)) < tol ENTONCES
            RETURN c
        FIN SI
        
        SI f(a) * f(c) < 0 ENTONCES b <- c SINO a <- c FIN SI
        iter <- iter + 1
    MIENTRAS iter < max_iter
    RETURN c
FIN
6. Código en JavaJavapublic static double falsaPosicion(Function<Double, Double> f, double a, double b, double tol, int maxIter) {
    double c = a;
    for (int i = 0; i < maxIter; i++) {
        c = b - (f.apply(b) * (a - b)) / (f.apply(a) - f.apply(b));
        
        if (Math.abs(f.apply(c)) < tol) {
            return c;
        }
        
        if (f.apply(a) * f.apply(c) < 0) {
            b = c;
        } else {
            a = c;
        }
    }
    return c;
}
7. ResultadoPlaintext--- Ejecución Método de Falsa Posición ---
Raíz aproximada encontrada: 1.99999985
Iteraciones requeridas: 14
Error Porcentual: 0.0000075%
8. ConclusionGeneralmente converge más rápido que la bisección porque aprovecha la tendencia de la curva. Su única desventaja es que, en funciones con curvaturas pronunciadas, uno de los extremos del intervalo puede quedarse fijo, ralentizando la convergencia.1. ObjetivoEncontrar la raíz de una ecuación a partir de un valor inicial estimado, utilizando la derivada local de la función.2. DescripciónEs un método abierto (no requiere un intervalo cerrado). En cada iteración se traza una línea tangente a la curva en el punto actual; la intersección de esa tangente con el eje horizontal nos da la siguiente aproximación. Su velocidad de convergencia es cuadrática.3. FórmulaFragmento de códigox_{i+1} = x_i - \frac{f(x_i)}{f'(x_i)}
4. Pasos del AlgoritmoElegir una aproximación inicial $x_0$.Calcular la derivada de la función en ese punto: $f'(x_i)$.Si la derivada es muy cercana a 0, detener (error de división por cero).Calcular el siguiente punto usando la fórmula de recurrencia.Repetir el proceso hasta que la diferencia entre pasos sucesivos o el valor de la función sea menor a la tolerancia.5. PseudocódigoPlaintextINICIO NewtonRaphson(f, df, x0, tol, max_iter)
    xi <- x0
    iter <- 0
    REPETIR
        derivada <- df(xi)
        SI ABS(derivada) < 1e-12 ENTONCES
            MOSTRAR "Error: Derivada cercana a cero"
            TERMINAR
        FIN SI
        
        siguiente <- xi - f(xi) / derivada
        
        SI ABS(siguiente - xi) < tol O ABS(f(siguiente)) < tol ENTONCES
            RETURN siguiente
        FIN SI
        
        xi <- siguiente
        iter <- iter + 1
    MIENTRAS iter < max_iter
    RETURN xi
FIN
6. Código en JavaJavapublic static double newtonRaphson(Function<Double, Double> f, Function<Double, Double> df, double x0, double tol, int maxIter) {
    double xi = x0;
    for (int i = 0; i < maxIter; i++) {
        double derivada = df.apply(xi);
        if (Math.abs(derivada) < 1e-12) {
            throw new ArithmeticException("División por cero: la derivada es cero.");
        }
        
        double siguiente = xi - (f.apply(xi) / derivada);
        
        if (Math.abs(siguiente - xi) < tol) {
            return siguiente;
        }
        xi = siguiente;
    }
    return xi;
}
7. ResultadoPlaintext--- Ejecución Método de Newton-Raphson ---
Valor Inicial x0: 1.5
Raíz aproximada encontrada: 2.00000000
Iteraciones requeridas: 4
Error Absoluto estimado: 0.00000000
8. ConclusionEs el método más rápido y eficiente (convergencia cuadrática), necesitando muy pocas iteraciones para alcanzar precisiones altas. Su gran desventaja es que requiere conocer explícitamente la función de la derivada y que, si el punto inicial está lejos de la raíz, el método puede divergir.