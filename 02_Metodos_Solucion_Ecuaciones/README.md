# 📊 TEMA 2: Métodos Numéricos para Solución de Ecuaciones

Este módulo se enfoca en encontrar las raíces de funciones mediante diversos algoritmos. Cada método incluye su análisis de convergencia y el número de iteraciones necesarias para alcanzar la tolerancia deseada.

### 🔍 Métodos Incluidos:
* ✅ Bisección
* ✅ Falsa Posición
* ✅ Newton-Raphson
* ✅ Secante Cerrado
* ✅ Secante Abierto

---

## 📉 Análisis de Errores Base

La precisión es fundamental en el cálculo numérico. Para evaluar la aproximación en cada ejercicio, se detallan las siguientes expresiones matemáticas en texto plano:

* **Error Absoluto (Ea):** Ea = |V - A|

* **Error Relativo (Er):** Er = |V - A| / |V|

* **Error Porcentual (Ep):** Ep = (|V - A| / |V|) * 100%

> 💡 **Nota:** En las fórmulas anteriores, V representa el valor real esperado y A representa el valor aproximado obtenido por el método.

---

## 🛠️ Catálogo de Métodos Desarrollados

### 1. Método de Bisección
<details>
<summary>📐 Haz clic aquí para desplegar la información de Bisección</summary>

#### 🎯 Objetivo
Encontrar una raíz real de una función continua en un intervalo cerrado donde exista un cambio de signo.

#### 📝 Descripción del Método
Es un método de búsqueda incremental que divide repetidamente a la mitad el intervalo que contiene a la raíz. Si la función cambia de signo en un subintervalo, la raíz se encuentra ahí; de lo contrario, está en el otro extremo. Es un método robusto y de convergencia segura, aunque lenta.

#### 🔢 Fórmula General
c = (a + b) / 2

#### 👣 Pasos del Algoritmo
1. Definir un intervalo [a, b] tal que f(a) * f(b) < 0.
2. Calcular el punto medio c.
3. Evaluar el criterio de parada (si |f(c)| < tolerancia o el error es menor al permitido, terminar).
4. Si f(a) * f(c) < 0, la raíz está en [a, c], por lo que hacemos b = c.
5. Si f(a) * f(c) > 0, la raíz está en [c, b], por lo que hacemos a = c.
6. Repetir desde el paso 2 hasta cumplir el criterio de parada o alcanzar el límite de iteraciones.

#### 💻 Pseudocódigo
```text
INICIO Biseccion(f, a, b, tol, max_iter)
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
 ### ☕ Código en Java
Java
public static double biseccion(Function<Double, Double> f, double a, double b, double tol, int maxIter) {
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
📊 Resultado de Ejecución
Plaintext
--- Ejecución Método de Bisección ---
Función: x^2 - 4
Intervalo: [0, 3]
Raíz aproximada encontrada: 2.00000012
Iteraciones requeridas: 22
Error Absoluto estimado: 0.00000008

### 🏁 Conclusión
El método de Bisección es ideal como primera opción cuando no se conocen las derivadas de la función, ya que garantiza la convergencia. Sin embargo, su velocidad de convergencia es lineal, lo que lo hace ineficiente en términos de tiempo de cómputo comparado con métodos más avanzados.

---

## 2. Método de la Falsa Posición (Regula Falsi)

### 🎯 Objetivo
Acelerar la convergencia del método de bisección aprovechando los valores numéricos de los extremos del intervalo.

### 📝 Descripción del Método
A diferencia de bisección, que corta el intervalo estrictamente por la mitad, la Falsa Posición traza una línea recta (secante) entre los puntos de los extremos. La intersección de esta línea con el eje horizontal se convierte en la nueva aproximación de la raíz.

### 🔢 Fórmula General
c = b - (f(b) * (a - b)) / (f(a) - f(b))

### 👣 Pasos del Algoritmo
1. Definir un intervalo [a, b] tal que f(a) * f(b) < 0.
2. Calcular el punto de aproximación c usando la fórmula de la secante.
3. Evaluar el criterio de parada.
4. Si f(a) * f(c) < 0, la raíz está en [a, c], hacemos b = c.
5. Si no, la raíz está en [c, b], hacemos a = c.
6. Repetir hasta cumplir las condiciones de parada.

### 💻 Pseudocódigo
Plaintext
INICIO FalsaPosicion(f, a, b, tol, max_iter)
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
☕ Código en Java
Java
public static double falsaPosicion(Function<Double, Double> f, double a, double b, double tol, int maxIter) {
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
📊 Resultado de Ejecución
Plaintext
--- Ejecución Método de Falsa Posición ---
Raíz aproximada encontrada: 1.99999985
Iteraciones requeridas: 14
Error Porcentual: 0.0000075%
🏁 Conclusión
Generalmente converge más rápido que la bisección porque aprovecha la tendencia de la curva. Su única desventaja es que, en funciones con curvaturas pronunciadas, uno de los extremos del intervalo puede quedarse fijo, ralentizando la convergencia.

3. Método de Newton-Raphson
🎯 Objetivo
Encontrar la raíz de una ecuación a partir de un valor inicial estimado, utilizando la derivada local de la función.

📝 Descripción del Método
Es un método abierto (no requiere un intervalo cerrado). En cada iteración se traza una línea tangente a la curva en el punto actual; la intersección de esa tangente con el eje horizontal nos da la siguiente aproximación. Su velocidad de convergencia es cuadrática.

🔢 Fórmula General
x_(i+1) = x_i - f(x_i) / f'(x_i)

👣 Pasos del Algoritmo
Elegir una aproximación inicial x0.

Calcular la derivada de la función en ese punto: f'(xi).

Si la derivada es muy cercana a 0, detener (error de división por cero).

Calcular el siguiente punto usando la fórmula de recurrencia.

Repetir el proceso hasta que la diferencia entre pasos sucesivos o el valor de la función sea menor a la tolerancia.

💻 Pseudocódigo
Plaintext
INICIO NewtonRaphson(f, df, x0, tol, max_iter)
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
☕ Código en Java
Java
public static double newtonRaphson(Function<Double, Double> f, Function<Double, Double> df, double x0, double tol, int maxIter) {
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
📊 Resultado de Ejecución
Plaintext
--- Ejecución Método de Newton-Raphson ---
Valor Inicial x0: 1.5
Raíz aproximada encontrada: 2.00000000 
Iteraciones requeridas: 4
Error Absoluto estimado: 0.00000000
🏁 Conclusión
Es el método más rápido y eficiente (convergencia cuadrática), necesitando muy pocas iteraciones para alcanzar precisiones altas. Su gran desventaja es que requiere conocer explícitamente la función de la derivada y que, si el punto inicial está lejos de la raíz, el método puede divergir de forma abrupta.