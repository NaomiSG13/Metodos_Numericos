# 📈 Tema 6: Solución Numérica de Ecuaciones Diferenciales

Este módulo comprende el análisis, diseño y aplicación de algoritmos numéricos paso a paso para resolver Problemas de Valor Inicial (PVI) asociados a Ecuaciones Diferenciales Ordinarias (EDOs). Estas herramientas permiten modelar fenómenos dinámicos donde las soluciones analíticas directas resultan sumamente complejas o imposibles de obtener.

---

## 🛠️ Catálogo de Métodos Desarrollados

| Recurso / Código | Descripción Técnica | 
| :--- | :--- | :---: |
| **Método de Euler** | Aproximación lineal de primer orden utilizando la pendiente de la frontera inicial. |
| **Método de Euler Modificado (Heun)** | Esquema de predicción-corrección que promedia las pendientes extremas del intervalo. | 
| **Runge-Kutta de 4to Orden (RK4)** | Algoritmo de alta precisión basado en cuatro evaluaciones ponderadas por paso. | 

---

## 1. Método de Euler

### 🎯 Objetivo
Aproximar los valores de la función solución $y(x)$ en un conjunto discretizado de puntos, asumiendo que la curva se comporta de forma lineal en pasos muy pequeños ($h$).

### 🔢 Fórmula General
```text
y_(i+1) = y_i + h * f(x_i, y_i)
💻 Código en JavaJavapackage unidad6;

import java.util.function.BiFunction;

public class MetodoEuler {
    public static void main(String[] args) {
        // EDO: dy/dx = x + y  |  PVI: y(0) = 1
        BiFunction<Double, Double, Double> f = (x, y) -> x + y;
        double x0 = 0.0, y0 = 1.0, h = 0.1, xEnd = 1.0;

        System.out.println("--- Método de Euler Simple ---");
        resolverEuler(f, x0, y0, h, xEnd);
    }

    public static void resolverEuler(BiFunction<Double, Double, Double> f, double x, double y, double h, double xEnd) {
        while (x <= xEnd + 1e-9) {
            System.out.printf("x = %.2f -> y = %.5f\n", x, y);
            y = y + h * f.apply(x, y);
            x += h;
        }
    }
}
2. Método de Euler Modificado (Heun)🎯 ObjetivoMitigar el error de truncamiento acumulativo del método simple mediante un proceso iterativo de dos fases: predecir una altura mediante la pendiente inicial y corregirla promediándola con la pendiente final estimada.🔢 Fórmula GeneralPlaintextPrediccion:   y*_(i+1) = y_i + h * f(x_i, y_i)
Correccion:   y_(i+1)  = y_i + (h / 2) * [ f(x_i, y_i) + f(x_(i+1), y*_(i+1)) ]
💻 Código en JavaJavapackage unidad6;

import java.util.function.BiFunction;

public class MetodoEulerModificado {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> f = (x, y) -> x + y;
        double x0 = 0.0, y0 = 1.0, h = 0.1, xEnd = 1.0;

        System.out.println("--- Método de Euler Modificado ---");
        resolverHeun(f, x0, y0, h, xEnd);
    }

    public static void resolverHeun(BiFunction<Double, Double, Double> f, double x, double y, double h, double xEnd) {
        while (x <= xEnd + 1e-9) {
            System.out.printf("x = %.2f -> y = %.5f\n", x, y);
            double pendienteInicial = f.apply(x, y);
            double yPredicho = y + h * pendienteInicial;
            double pendienteFinal = f.apply(x + h, yPredicho);
            
            y = y + (h / 2.0) * (pendienteInicial + pendienteFinal);
            x += h;
        }
    }
}
3. Método de Runge-Kutta de 4to Orden (RK4)🎯 ObjetivoProveer una solución de precisión extrema con un orden de convergencia $O(h^4)$ mediante el muestreo balanceado de cuatro pendientes distintas distribuidas simétricamente a lo largo de cada incremento de paso.🔢 Fórmula GeneralPlaintextk1 = f(x_i, y_i)
k2 = f(x_i + h/2, y_i + (h*k1)/2)
k3 = f(x_i + h/2, y_i + (h*k2)/2)
k4 = f(x_i + h, y_i + h*k3)

y_(i+1) = y_i + (h / 6) * (k1 + 2*k2 + 2*k3 + k4)
💻 Código en JavaJavapackage unidad6;

import java.util.function.BiFunction;

public class MetodoRK4 {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> f = (x, y) -> x + y;
        double x0 = 0.0, y0 = 1.0, h = 0.1, xEnd = 1.0;

        System.out.println("--- Método de Runge-Kutta 4to Orden ---");
        resolverRK4(f, x0, y0, h, xEnd);
    }

    public static void resolverRK4(BiFunction<Double, Double, Double> f, double x, double y, double h, double xEnd) {
        while (x <= xEnd + 1e-9) {
            System.out.printf("x = %.2f -> y = %.6f\n", x, y);
            
            double k1 = f.apply(x, y);
            double k2 = f.apply(x + h / 2.0, y + (h * k1) / 2.0);
            double k3 = f.apply(x + h / 2.0, y + (h * k2) / 2.0);
            double k4 = f.apply(x + h, y + h * k3);
            
            y = y + (h / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
            x += h;
        }
    }
}
🖥️ Guía de EjecuciónPuedes ejecutar cualquiera de las clases directamente desde tu terminal utilizando el SDK de Java instalado en tu computadora:Bash# Compilar el programa deseado
javac MetodoRK4.java

# Lanzar la ejecución
java MetodoRK4

---

### 🚀 ¿Cómo subirlo todo a tu GitHub ahora mismo?
Cuando ya tengas guardados tus archivos en esa carpeta dentro de tu computadora, ejecuta esta secuencia limpia en tu consola para subir el Tema 6 a internet de un solo golpe:

```bash
git add .
git commit -m "Añadir estructura y códigos del Tema 6"
git push origin main