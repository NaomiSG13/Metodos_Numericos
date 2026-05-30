# 📊 TEMA 3: Sistemas de Ecuaciones Lineales

Implementación de algoritmos para resolver sistemas de ecuaciones lineales de la forma Ax = B. Se incluye un análisis de resultados comparando la eficiencia y estabilidad de cada método.

## 🔍 Métodos Incluidos

### Métodos Directos:
* 🔹 Eliminación Gaussiana
* 🔹 Método de Gauss-Jordan

### Métodos Iterativos:
* 🔸 Método de Jacobi
* 🔸 Método de Gauss-Seidel

---

## 🛠️ Catálogo de Métodos Desarrollados

### 1. Eliminación Gaussiana

#### 🎯 Objetivo
Transformar un sistema de ecuaciones Ax = B en un sistema triangular superior equivalente para resolverlo fácilmente mediante sustitución hacia atrás.

#### 📝 Descripción del Método
Consiste en aplicar operaciones elementales entre las filas de la matriz aumentada [A|B] para hacer ceros todos los elementos que están por debajo de la diagonal principal. Una vez obtenida la estructura triangular, se despejan las variables desde la última hasta la primera.

#### 🔢 Fórmula / Representación General
[A | B] ---> [U | Y] (donde U es una matriz triangular superior)

#### 👣 Pasos del Algoritmo
1. Construir la matriz aumentada [A|B].
2. Realizar la eliminación hacia adelante para transformar la matriz en triangular superior (utilizando pivoteo si es necesario para evitar divisiones por cero).
3. Aplicar sustitución hacia atrás para encontrar los valores de las incógnitas.

#### 🏁 Conclusión
Es un método directo robusto con una complejidad computacional de O(n^3). Es exacto (salvo por errores de redondeo), pero puede volverse inestable si los elementos de la diagonal principal son muy cercanos a cero, para lo cual se requiere implementar estrategias de pivoteo.

---

### 2. Método de Gauss-Jordan

#### 🎯 Objetivo
Reducir la matriz de coeficientes a una matriz identidad para obtener directamente los valores de las incógnitas sin necesidad de sustitución hacia atrás.

#### 📝 Descripción del Método
Es una variación de la eliminación gaussiana. La diferencia radica en que cuando se elimina un elemento, se hace tanto para las filas que están por debajo como para las que están por arriba del pivote, y además se normaliza la fila del pivote dividiéndola entre su elemento diagonal.

#### 🔢 Fórmula / Representación General
[A | B] ---> [I | X] (donde I es la matriz identidad)

#### 👣 Pasos del Algoritmo
1. Construir la matriz aumentada [A|B].
2. Para cada columna, normalizar la fila del pivote dividiendo todos sus elementos entre el valor de la diagonal.
3. Hacer ceros en los elementos por encima y por debajo del pivote en las demás filas.

#### 🏁 Conclusión
Aunque requiere aproximadamente un 50% más de operaciones flotantes que la eliminación gaussiana estándar, ofrece la ventaja de dejar el vector de soluciones calculado directamente en el vector B modificado, eliminando la etapa de sustitución.

---

### 3. Método de Jacobi

#### 🎯 Objetivo
Resolver el sistema de ecuaciones lineales mediante una técnica iterativa que actualiza todas las variables de forma simultánea a partir de valores iniciales aproximados.

#### 📝 Descripción del Método
Es un método iterativo aplicable preferentemente a matrices diagonalmente dominantes. En cada paso, se despeja la variable correspondiente de cada ecuación utilizando exclusivamente los valores calculados en la iteración inmediatamente anterior.

#### 🔢 Fórmula General
x_i^(k+1) = (b_i - Suma(a_ij * x_j^k)) / a_ii  (para j diferente de i)

#### 👣 Pasos del Algoritmo
1. Verificar o asegurar la dominancia diagonal de la matriz A.
2. Establecer un vector inicial de aproximación X_ant (usualmente ceros).
3. Calcular los nuevos valores utilizando la fórmula de Jacobi.
4. Evaluar el error; si es menor a la tolerancia o se alcanza el máximo de iteraciones, finalizar. Si no, hacer X_ant = X_nuevo y repetir.

#### 🏁 Conclusión
El método de Jacobi es fácil de paralelizar dado que los cálculos de las variables son independientes en cada iteración. No obstante, su convergencia está estrictamente supeditada a que la matriz sea diagonalmente dominante, y suele requerir más iteraciones que Gauss-Seidel.

---

### 4. Método de Gauss-Seidel

#### 🎯 Objetivo
Optimizar la convergencia del método de Jacobi mediante la inserción y uso inmediato de los valores de las variables recién calculadas dentro de la misma iteración.

#### 📝 Descripción del Método
A diferencia de Jacobi, que espera a terminar toda la iteración para actualizar el vector de variables, Gauss-Seidel utiliza los valores nuevos tan pronto como están disponibles. Esto acelera significativamente la velocidad de convergencia.

#### 🔢 Fórmula General
x_i^(k+1) = (b_i - Suma(a_ij * x_j)) / a_ii (usando los valores más recientes de x)

#### 👣 Pasos del Algoritmo
1. Definir el vector inicial X.
2. Para cada variable de la iteración actual, calcular su nuevo valor utilizando las actualizaciones más recientes disponibles en el mismo vector X.
3. Evaluar el error aproximado relativo.
4. Repetir el ciclo hasta satisfacer la tolerancia exigida.

#### 🏁 Conclusión
Gauss-Seidel suele requerir aproximadamente la mitad de iteraciones que el método de Jacobi para converger bajo las miasmas condiciones de tolerancia, debido al aprovechamiento inmediato de los datos actualizados dentro del mismo ciclo.
