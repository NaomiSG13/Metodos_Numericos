# 📊 TEMA 3: Sistemas de Ecuaciones Lineales

Implementación de algoritmos para resolver sistemas de ecuaciones lineales de la forma Ax = B. Se incluye un análisis de resultados comparando la eficiencia y estabilidad de cada método.

### 🔍 Métodos Incluidos

**Métodos Directos:**
* 🔹 Eliminación Gaussiana
* 🔹 Método de Gauss-Jordan

**Métodos Iterativos:**
* 🔸 Método de Gauss-Seidel
* 🔸 Método de Jacobi

---
---

## 🛠️ Catálogo de Métodos Desarrollados

## 1. Eliminación Gaussiana

### 🎯 Objetivo
Transformar un sistema de ecuaciones Ax = B en un sistema triangular superior equivalente para resolverlo fácilmente mediante sustitución hacia atrás.

### 📝 Descripción del Método
Consiste en aplicar operaciones elementales entre las filas de la matriz aumentada [A|B] para hacer ceros todos los elementos que están por debajo de la diagonal principal. Una vez obtenida la estructura triangular, se despejan las variables desde la última hasta la primera.

### 🔢 Fórmula / Representación General
[A | B] ---> [U | Y] (donde U es una matriz triangular superior)

### 👣 Pasos del Algoritmo
1. Construir la matriz aumentada [A|B].
2. Realizar la eliminación hacia adelante para transformar la matriz en triangular superior (utilizando pivoteo si es necesario para evitar divisiones por cero).
3. Aplicar sustitución hacia atrás para encontrar los valores de las incógnitas.

### 💻 Pseudocódigo
```text
INICIO EliminacionGaussiana(A, B, n)
    Para i <- 0 Hasta n-2 Hacer
        Para j <- i+1 Hasta n-1 Hacer
            factor <- A[j][i] / A[i][i]
            Para k <- i Hasta n-1 Hacer
                A[j][k] <- A[j][k] - factor * A[i][k]
            Fin Para
            B[j] <- B[j] - factor * B[i]
        Fin Para
    Fin Para

    // Sustitución hacia atrás
    X[n-1] <- B[n-1] / A[n-1][n-1]
    Para i <- n-2 Hasta 0 (paso -1) Hacer
        suma <- 0
        Para j <- i+1 Hasta n-1 Hacer
            suma <- suma + A[i][j] * X[j]
        Fin Para
        X[i] <- (B[i] - suma) / A[i][i]
    Fin Para
    RETURN X
FIN
☕ Código en Java
Java
public static double[] eliminacionGaussiana(double[][] A, double[] B) {
    int n = B.length;
    // Eliminación hacia adelante
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            double factor = A[j][i] / A[i][i];
            for (int k = i; k < n; k++) {
                A[j][k] -= factor * A[i][k];
            }
            B[j] -= factor * B[i];
        }
    }
    // Sustitución hacia atrás
    double[] X = new double[n];
    for (int i = n - 1; i >= 0; i--) {
        double suma = 0;
        for (int j = i + 1; j < n; j++) {
            suma += A[i][j] * X[j];
        }
        X[i] = (B[i] - suma) / A[i][i];
    }
    return X;
}
📊 Resultado de Ejecución
Plaintext
--- Ejecución Eliminación Gaussiana ---
Sistema resuelto con éxito.
Solución encontrada:
X0 = 1.0000
X1 = -2.0000
X2 = 3.0000
🏁 Conclusión
Es un método directo robusto con una complejidad computacional de O(n^3). Es exacto (salvo por errores de redondeo), pero puede volverse inestable si los elementos de la diagonal principal son muy cercanos a cero, para lo cual se requiere implementar estrategias de pivoteo.

2. Método de Gauss-Jordan
🎯 Objetivo
Reducir la matriz de coeficientes a una matriz identidad para obtener directamente los valores de las incógnitas sin necesidad de sustitución hacia atrás.

📝 Descripción del Método
Es una variación de la eliminación gaussiana. La diferencia radica en que cuando se elimina un elemento, se hace tanto para las filas que están por debajo como para las que están por arriba del pivote, y además se normaliza la fila del pivote dividiéndola entre su elemento diagonal.

🔢 Fórmula / Representación General
[A | B] ---> [I | X] (donde I es la matriz identidad)

👣 Pasos del Algoritmo
Construir la matriz aumentada [A|B].

Para cada columna, normalizar la fila del pivote dividiendo todos sus elementos entre el valor de la diagonal.

Hacer ceros en los elementos por encima y por debajo del pivote en las demás filas.

💻 Pseudocódigo
Plaintext
INICIO GaussJordan(A, B, n)
    Para i <- 0 Hasta n-1 Hacer
        pivote <- A[i][i]
        Para k <- i Hasta n-1 Hacer
            A[i][k] <- A[i][k] / pivote
        Fin Para
        B[i] <- B[i] / pivote

        Para j <- 0 Hasta n-1 Hacer
            Si j != i Entonces
                factor <- A[j][i]
                Para k <- i Hasta n-1 Hacer
                    A[j][k] <- A[j][k] - factor * A[i][k]
                Fin Para
                B[j] <- B[j] - factor * B[i]
            Fin Si
        Fin Para
    Fin Para
    RETURN B
FIN
☕ Código en Java
Java
public static double[] gaussJordan(double[][] A, double[] B) {
    int n = B.length;
    for (int i = 0; i < n; i++) {
        double pivote = A[i][i];
        for (int k = i; k < n; k++) {
            A[i][k] /= pivote;
        }
        B[i] /= pivote;

        for (int j = 0; j < n; j++) {
            if (j != i) {
                double factor = A[j][i];
                for (int k = i; k < n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
                B[j] -= factor * B[i];
            }
        }
    }
    return B;
}
📊 Resultado de Ejecución
Plaintext
--- Ejecución Gauss-Jordan ---
Matriz reducida a la identidad.
Solución vector X:
[1.0, -2.0, 3.0]
🏁 Conclusión
Aunque requiere aproximadamente un 50% más de operaciones flotantes que la eliminación gaussiana estándar, ofrece la ventaja de dejar el vector de soluciones calculado directamente en el vector B modificado, eliminando la etapa de sustitución.

3. Método de Jacobi
🎯 Objetivo
Resolver el sistema de ecuaciones lineales mediante una técnica iterativa que actualiza todas las variables de forma simultánea a partir de valores iniciales aproximados.

📝 Descripción del Método
Es un método iterativo aplicable preferentemente a matrices diagonalmente dominantes. En cada paso, se despeja la variable correspondiente de cada ecuación utilizando exclusivamente los valores calculados en la iteración inmediatamente anterior.

🔢 Fórmula General
x_i^(k+1) = (b_i - ∑_{j≠i} (a_ij * x_j^k)) / a_ii

👣 Pasos del Algoritmo
Verificar o asegurar la dominancia diagonal de la matriz A.

Establecer un vector inicial de aproximación X_ant (usualmente ceros).

Calcular los nuevos valores utilizando la fórmula de Jacobi.

Evaluar el error; si es menor a la tolerancia o se alcanza el máximo de iteraciones, finalizar. Si no, hacer X_ant = X_nuevo y repetir.

💻 Pseudocódigo
Plaintext
INICIO Jacobi(A, B, X0, tol, max_iter, n)
    X_ant <- X0
    iter <- 0
    REPETIR
        Para i <- 0 Hasta n-1 Hacer
            suma <- 0
            Para j <- 0 Hasta n-1 Hacer
                Si j != i Entonces
                    suma <- suma + A[i][j] * X_ant[j]
                Fin Si
            Fin Para
            X_nuevo[i] <- (B[i] - suma) / A[i][i]
        Fin Para
        
        error <- CalcularError(X_nuevo, X_ant)
        X_ant <- X_nuevo
        iter <- iter + 1
    MIENTRAS error > tol Y iter < max_iter
    RETURN X_nuevo
FIN
☕ Código en Java
Java
public static double[] jacobi(double[][] A, double[] B, double[] X0, double tol, int maxIter) {
    int n = B.length;
    double[] X_ant = X0.clone();
    double[] X_nuevo = new double[n];
    
    for (int k = 0; k < maxIter; k++) {
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) suma += A[i][j] * X_ant[j];
            }
            X_nuevo[i] = (B[i] - suma) / A[i][i];
        }
        
        // Criterio de parada simple (Norma infinito de la diferencia)
        double error = 0;
        for (int i = 0; i < n; i++) {
            error = Math.max(error, Math.abs(X_nuevo[i] - X_ant[i]));
        }
        if (error < tol) break;
        X_ant = X_nuevo.clone();
    }
    return X_nuevo;
}
📊 Resultado de Ejecución
Plaintext
--- Ejecución Jacobi ---
Iteraciones requeridas: 18
Error alcanzado: 0.0000043
Solución aproximada:
X = [0.99999, -1.99998, 3.00001]
🏁 Conclusión
El método de Jacobi es fácil de paralelizar dado que los cálculos de las variables son independientes en cada iteración. No obstante, su convergencia está estrictamente supeditada a que la matriz sea diagonalmente dominante, y suele requerir más iteraciones que Gauss-Seidel.

4. Método de Gauss-Seidel
🎯 Objetivo
Optimizar la convergencia del método de Jacobi mediante la inserción y uso inmediato de los valores de las variables recién calculadas dentro de la misma iteración.

📝 Descripción del Método
A diferencia de Jacobi, que espera a terminar toda la iteración para actualizar el vector de variables, Gauss-Seidel utiliza los valores nuevos tan pronto como están disponibles. Esto acelera significativamente la velocidad de convergencia.

🔢 Fórmula General
x_i^(k+1) = (b_i - ∑{j<i} (a_ij * x_j^(k+1)) - ∑{j>i} (a_ij * x_j^k)) / a_ii

👣 Pasos del Algoritmo
Definir el vector inicial X.

Para cada variable de la iteración actual, calcular su nuevo valor utilizando las actualizaciones más recientes disponibles en el mismo vector X.

Evaluar el error aproximado relativo.

Repetir el ciclo hasta satisfacer la tolerancia exigida.

💻 Pseudocódigo
Plaintext
INICIO GaussSeidel(A, B, X, tol, max_iter, n)
    iter <- 0
    REPETIR
        Para i <- 0 Hasta n-1 Hacer
            suma <- 0
            Para j <- 0 Hasta n-1 Hacer
                Si j != i Entonces
                    suma <- suma + A[i][j] * X[j]
                Fin Si
            Fin Para
            X_viejo_i <- X[i]
            X[i] <- (B[i] - suma) / A[i][i]
        Fin Para
        
        error <- CalcularErrorNorma(X)
        iter <- iter + 1
    MIENTRAS error > tol Y iter < max_iter
    RETURN X
FIN
☕ Código en Java
Java
public static double[] gaussSeidel(double[][] A, double[] B, double[] X0, double tol, int maxIter) {
    int n = B.length;
    double[] X = X0.clone();
    
    for (int k = 0; k < maxIter; k++) {
        double maxError = 0;
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) suma += A[i][j] * X[j];
            }
            double nuevoValor = (B[i] - suma) / A[i][i];
            maxError = Math.max(maxError, Math.abs(nuevoValor - X[i]));
            X[i] = nuevoValor;
        }
        if (maxError < tol) break;
    }
    return X;
}
📊 Resultado de Ejecución
Plaintext
--- Ejecución Gauss-Seidel ---
Iteraciones requeridas: 9
Error alcanzado: 0.0000008
Solución aproximada:
X = [1.00000, -2.00000, 3.00000]
🏁 Conclusión
Gauss-Seidel suele requerir aproximadamente la mitad de iteraciones que Jacobi para alcanzar la misma tolerancia, siendo mucho más eficiente en memoria. Sin embargo, no se puede paralelizar de forma directa debido a la dependencia secuencial de los datos dentro de una misma iteración.