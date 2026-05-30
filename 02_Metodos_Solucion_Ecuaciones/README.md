# 📊 TEMA 2: Métodos Numéricos para Solución de Ecuaciones

Este módulo se enfoca en encontrar las raíces de funciones mediante diversos algoritmos. Cada método incluye su análisis de convergencia y el número de iteraciones necesarias para alcanzar la tolerancia deseada.

## 🔍 Métodos Incluidos
* ✅ Bisección
* ✅ Falsa Posición
* ✅ Newton-Raphson
* ✅ Secante Cerrado
* ✅ Secante Abierto

---

## 📉 Análisis de Errores Base

La precisión es fundamental en el cálculo numérico. Para evaluar la aproximación en cada ejercicio, se detallan las siguientes expresiones matemáticas:

* **Error Absoluto (Ea):** Ea = |V - A|
* **Error Relativo (Er):** Er = |V - A| / |V|
* **Error Porcentual (Ep):** Ep = (|V - A| / |V|) * 100%

> 💡 **Nota:** En las fórmulas anteriores, V representa el valor real esperado y A representa el valor aproximado obtenido por el método.

---

## 🛠️ Catálogo de Métodos Desarrollados

### 1. Método de Bisección

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

#### 🏁 Conclusión
El método de Bisección es ideal como primera opción cuando no se conocen las derivadas de la función, ya que garantiza la convergencia. Sin embargo, su velocidad de convergencia es lineal, lo que lo hace ineficiente en términos de tiempo de cómputo comparado con métodos más avanzados.

---

### 2. Método de la Falsa Posición (Regula Falsi)

#### 🎯 Objetivo
Acelerar la convergencia del método de bisección aprovechando los valores numéricos de los extremos del intervalo.

#### 📝 Descripción del Método
A diferencia de bisección, que corta el intervalo estrictamente por la mitad, la Falsa Posición traza una línea recta (secante) entre los puntos de los extremos. La intersección de esta línea con el eje horizontal se convierte en la nueva aproximación de la raíz.

#### 🔢 Fórmula General
c = b - (f(b) * (a - b)) / (f(a) - f(b))

#### 👣 Pasos del Algoritmo
1. Definir un intervalo [a, b] tal que f(a) * f(b) < 0.
2. Calcular el punto de aproximación c usando la fórmula de la secante.
3. Evaluar el criterio de parada.
4. Si f(a) * f(c) < 0, la raíz está en [a, c], hacemos b = c.
5. Si no, la raíz está en [c, b], hacemos a = c.
6. Repetir hasta cumplir las condiciones de parada.

#### 🏁 Conclusión
Generalmente converge más rápido que la bisección porque aprovecha la tendencia de la curva. Su única desventaja es que, en funciones con curvaturas pronunciadas, uno de los extremos del intervalo puede quedarse fijo, ralentizando la convergencia.

---

### 3. Método de Newton-Raphson

#### 🎯 Objetivo
Encontrar la raíz de una ecuación a partir de un valor inicial estimado, utilizando la derivada local de la función.

#### 📝 Descripción del Método
Es un método abierto (no requiere un intervalo cerrado). En cada iteración se traza una línea tangente a la curva en el punto actual; la intersección de esa tangente con el eje horizontal nos da la siguiente aproximación. Su velocidad de convergencia es cuadrática.

#### 🔢 Fórmula General
x_(i+1) = x_i - f(x_i) / f'(x_i)

#### 👣 Pasos del Algoritmo
1. Elegir una aproximación inicial x0.
2. Calcular la derivada de la función en ese punto: f'(xi).
3. Si la derivada es muy cercana a 0, detener (error de división por cero).
4. Calcular el siguiente punto usando la fórmula de recur
