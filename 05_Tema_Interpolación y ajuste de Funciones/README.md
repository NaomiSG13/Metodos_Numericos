Aquí tienes el contenido completo del Tema 5 adaptado de manera estricta al formato formal, limpio y estructurado que hemos venido utilizando para tu repositorio.

He ordenado las áreas principales, limpiado los nombres de los archivos, quitado las etiquetas innecesarias y estructurado cada método con sus secciones separadas mediante títulos independientes y líneas divisorias (---). Queda listo para que lo agregues a tu archivo README.md desde Visual Studio Code.

Markdown
# 📊 TEMA 5: Interpolación, Extrapolación y Ajuste de Funciones

Este módulo contiene la implementación de diferentes algoritmos numéricos desarrollados en Java enfocados en aproximar valores (intermedios y externos) y modelar el comportamiento de conjuntos de datos mediante interpolaciones, extrapolaciones y análisis de regresión.

### 🛠️ Tecnologías y Requisitos
* **Lenguaje:** Java (JDK 8 o superior)
* **Paradigma:** Orientado a Objetos / Funcional

---

## 🚀 Áreas y Métodos Implementados

El contenido de esta unidad se divide en tres grandes áreas estratégicas:

1. **Interpolación de Funciones:** Estimación de valores intermedios de manera precisa dentro del rango de un conjunto de puntos conocidos.
2. **Extrapolación de Datos:** Proyección de tendencias y estimación de valores fuera del rango de los puntos experimentales conocidos.
3. **Aujste de Curvas y Análisis Estadístico:** Búsqueda de la función matemática que mejor representa la tendencia general de un conjunto de datos dispersos.

---
---

## 🛠️ Catálogo de Métodos Desarrollados

## 1. Interpolación de Funciones

### 🔬 Interpolación Lineal
* **Archivo Fuente:** `Interpolacion.java`

#### 🎯 Objetivo
Estimar un valor intermedio desconocido entre dos puntos de datos adyacentes conocidos mediante una aproximación lineal (línea recta).

#### 📝 Descripción del Método
Es el método de interpolación más simple y directo. Une dos puntos contiguos mediante un segmento de recta. Asume que la tasa de cambio entre ambos nodos es constante, lo que lo hace ideal para cálculos rápidos donde el tamaño de paso es pequeño y la curvatura no es pronunciada.

#### 🔢 Fórmula General
y = y_0 + [ (y_1 - y_0) / (x_1 - x_0) ] * (x - x_0)

#### 👣 Pasos del Algoritmo
1. Ubicar los dos puntos [x_0, y_0] y [x_1, y_1] que encierran al valor x a evaluar (x_0 <= x <= x_1).
2. Calcular la pendiente de la recta utilizando la razón de cambio.
3. Sustituir los valores en la ecuación lineal para obtener la aproximación de y.

#### 💻 Pseudocódigo
```text
INICIO InterpolacionLineal(x0, y0, x1, y1, x)
    SI x1 == x0 ENTONCES
        MOSTRAR "Error: División por cero (puntos en la misma coordenada X)"
        TERMINAR
    FIN SI
    
    pendiente <- (y1 - y0) / (x1 - x0)
    y <- y0 + pendiente * (x - x0)
    RETURN y
FIN
☕ Código en Java
Java
public static double interpolarLineal(double x0, double y0, double x1, double y1, double x) {
    if (x1 == x0) {
        throw new ArithmeticException("Los puntos de control no pueden tener la misma coordenada X.");
    }
    return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
}
📊 Resultado de Ejecución
Plaintext
--- Ejecución Interpolación Lineal ---
Punto evaluado x = 2.5
Valor estimado y = 5.25000000
🏁 Conclusión
Aunque su costo computacional es extremadamente bajo O(1) una vez localizados los intervalos, su error de truncamiento puede ser considerable si la función original posee una concavidad o curvatura marcada entre los puntos evaluados.

🔬 Interpolación Cuadrática
Archivo Fuente: InterpolacionCuadratica.java

🎯 Objetivo
Aproximar valores intermedios aprovechando tres puntos conocidos simultáneamente para capturar de mejor manera la curvatura local de los datos.

📝 Descripción del Método
Ajusta un polinomio único de segundo grado (una parábola) a través de tres puntos de control distribuidos en la mallas de datos. Al incorporar un término cuadrático, reduce significativamente el error de truncamiento en comparación con la aproximación lineal en funciones con cambios de pendiente sinuosos.

🔢 Fórmula General
y = b_0 + b_1 * (x - x_0) + b_2 * (x - x_0) * (x - x_1)
Donde los coeficientes de diferencias divididas se calculan como:

b_0 = y_0

b_1 = (y_1 - y_0) / (x_1 - x_0)

b_2 = [ ( (y_2 - y_1)/(x_2 - x_1) ) - b_1 ] / (x_2 - x_0)

👣 Pasos del Algoritmo
Seleccionar tres puntos consecutivos [x_0, y_0], [x_1, y_1] y [x_2, y_2] que rodeen el valor objetivo x.

Calcular los coeficientes b_0, b_1 y b_2 mediante diferencias finitas algebraicas.

Evaluar el polinomio resultante en la coordenada x especificada.

💻 Pseudocódigo
Plaintext
INICIO InterpolacionCuadratica(x0, y0, x1, y1, x2, y2, x)
    b0 <- y0
    b1 <- (y1 - y0) / (x1 - x0)
    b2 <- (((y2 - y1) / (x2 - x1)) - b1) / (x2 - x0)
    
    y <- b0 + b1 * (x - x0) + b2 * (x - x0) * (x - x1)
    RETURN y
FIN
☕ Código en Java
Java
public static double interpolarCuadratica(double x0, double y0, double x1, double y1, double x2, double y2, double x) {
    double b0 = y0;
    double b1 = (y1 - y0) / (x1 - x0);
    double b2 = (((y2 - y1) / (x2 - x1)) - b1) / (x2 - x0);
    
    return b0 + b1 * (x - x0) + b2 * (x - x0) * (x - x1);
}
📊 Resultado de Ejecución
Plaintext
--- Ejecución Interpolación Cuadrática ---
Parábola ajustada con éxito.
Punto evaluado x = 1.75
Valor estimado y = 3.46875000
🏁 Conclusión
Representa una mejora drástica frente a la interpolación lineal clásica. Su limitante principal radica en que si los tres puntos elegidos presentan oscilaciones de ruido muy drásticas, la parábola resultante puede sobreajustarse y generar estimaciones inexactas.

🔬 Interpolación Segmentaria (Splines)
Archivo Fuente: InterpolacionSegmentaria.java

🎯 Objetivo
Modelar un conjunto amplio de puntos adaptando polinomios de menor grado por tramos (segmentos) individuales para garantizar curvas suaves globales.

📝 Descripción del Método
En lugar de forzar a un único polinomio de alto grado a pasar por todos los puntos de la muestra (lo cual desata inestabilidades numéricas), los Splines ajustan ecuaciones independientes en cada par de nodos vecinos. Su gran ventaja matemática radica en imponer condiciones de continuidad estricta en las derivadas de las uniones de los tramos, logrando una curva suave y libre de picos.

🔢 Fórmula / Representación General
Para un subintervalo i: S_i(x) = a_i * (x - x_i)^3 + b_i * (x - x_i)^2 + c_i * (x - x_i) + d_i

👣 Pasos del Algoritmo
Recibir la matriz completa de coordenadas ordenadas en el eje X y eje Y.

Formular un sistema de ecuaciones lineales combinando las restricciones de continuidad de los tramos y sus respectivas derivadas.

Resolver el sistema para obtener el conjunto de coeficientes correspondientes a cada segmento.

Identificar a qué tramo pertenece el punto x solicitado y evaluarlo en su polinomio particular.

💻 Pseudocódigo
Plaintext
INICIO SplinesCubicos(X_datos, Y_datos, x_evaluar)
    n <- Longitud(X_datos)
    ConstruirSistemaEcuacionesContinuidad(A_matriz, B_vector)
    Coeficientes <- ResolverSistemaLineal(A_matriz, B_vector)
    
    tramo <- LocalizarTramoCorrespondiente(X_datos, x_evaluar)
    y_estimado <- EvaluarPolinomioTramo(Coeficientes[tramo], x_evaluar)
    RETURN y_estimado
FIN
🏁 Conclusión
Los Splines (especialmente los cúbicos) son el estándar de oro en gráficos por computadora y modelado de datos experimentales gracias a su versatilidad para seguir trayectorias complejas sin caer en oscilaciones salvajes de interpolación.

2. Extrapolación de Datos
🔬 Extrapolación Lineal y Polinomial
Archivo Fuente: Extrapolacion.java / ExtrapolacionLineal.java

🎯 Objetivo
Proyectar tendencias cuantitativas y predecir valores numéricos localizados fuera del intervalo acotado por los puntos experimentales recolectados.

📝 Descripción del Método
Consiste en extender analíticamente el comportamiento de la función de ajuste (lineal o polinomial) calculada en la frontera más cercana hacia zonas externas de datos no muestreados. Se asume que las condiciones e inercias físicas que gobiernan el fenómeno dentro del rango de estudio se mantendrán vigentes fuera de él.

🔢 Fórmula General
Proyección basada en los últimos nodos fronterizos k y k-1:
y_extrapolado = y_k + [ (y_k - y_{k-1}) / (x_k - x_{k-1}) ] * (x - x_k)

👣 Pasos del Algoritmo
Determinar si el valor objetivo x se encuentra a la izquierda del límite inferior o a la derecha del límite superior.

Extraer los coeficientes del modelo matemático calculados en las fronteras de los datos base.

Proyectar la función evaluando la coordenada x externa.

💻 Pseudocódigo
Plaintext
INICIO ExtrapolacionLinealFrontera(X_datos, Y_datos, x_externo)
    n <- Longitud(X_datos)
    Si x_externo > X_datos[n-1] Entonces
        // Proyección hacia adelante usando los últimos 2 puntos
        y_ext <- Y_datos[n-1] + ((Y_datos[n-1] - Y_datos[n-2]) / (X_datos[n-1] - X_datos[n-2])) * (x_externo - X_datos[n-1])
    Sino
        // Proyección hacia atrás usando los primeros 2 puntos
        y_ext <- Y_datos[0] + ((Y_datos[1] - Y_datos[0]) / (X_datos[1] - X_datos[0])) * (x_externo - X_datos[0])
    Fin Si
    RETURN y_ext
FIN
📊 Resultado de Ejecución
Plaintext
--- Ejecución Extrapolación ---
Frontera de datos original: [1.0, 5.0]
Evaluando punto externo x = 6.5
Valor proyectado y = 14.85000000
🏁 Conclusión
La extrapolación es inherentemente arriesgada en ciencia de datos e ingeniería. Mientras más alejado se encuentre el punto x del rango real conocido, mayor será la probabilidad de incurrir en un error de predicción catastrófico si las tendencias subyacentes cambian drásticamente.

3. Ajuste de Curvas y Análisis Estadístico
🔬 Regresión Lineal (Mínimos Cuadrados)
Archivo Fuente: Regresion.java

🎯 Objetivo
Encontrar la línea recta matemática ideal que minimice la dispersión global y represente la tendencia central de una nube de datos experimentales.

📝 Descripción del Método
El método de mínimos cuadrados busca la ecuación de una línea recta de la forma y = m*x + b de manera que la suma de los cuadrados de los residuos (las distancias verticales entre los puntos reales y la línea recta calculada) sea la menor posible. Es el pilar fundamental del modelado estadístico predictivo.

🔢 Fórmulas Generales de Coeficientes
Pendiente (m): m = [ n * ∑(x*y) - ∑x * ∑y ] / [ n * ∑(x²) - (∑x)² ]

Intersección (b): b = [ ∑y - m * ∑x ] / n

👣 Pasos del Algoritmo
Recibir dos arreglos de tamaño n que representan las coordenadas x e y de todos los puntos distribuidos.

Calcular de forma acumulativa las sumatorias requeridas por las expresiones: ∑x, ∑y, ∑(x*y), y ∑(x²).

Resolver las fórmulas de los coeficientes para obtener los parámetros m y b de la recta ajustada.

💻 Pseudocódigo
Plaintext
INICIO RegresionMinimosCuadrados(X, Y, n)
    sumX <- 0, sumY <- 0, sumXY <- 0, sumX2 <- 0
    Para i <- 0 Hasta n-1 Hacer
        sumX  <- sumX + X[i]
        sumY  <- sumY + Y[i]
        sumXY <- sumXY + (X[i] * Y[i])
        sumX2 <- sumX2 + (X[i] * X[i])
    Fin Para
    
    denominador <- (n * sumX2) - (sumX * sumX)
    SI denominador == 0 ENTONCES TERMINAR FIN SI
    
    m <- (n * sumXY - sumX * sumY) / denominador
    b <- (sumY - m * sumX) / n
    
    RETURN m, b
FIN
☕ Código en Java
Java
public static double[] calcularRegresionLineal(double[] X, double[] Y) {
    int n = X.length;
    double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
    
    for (int i = 0; i < n; i++) {
        sumX += X[i];
        sumY += Y[i];
        sumXY += X[i] * Y[i];
        sumX2 += X[i] * X[i];
    }
    
    double denominador = (n * sumX2) - (sumX * sumX);
    if (denominador == 0) {
        throw new ArithmeticException("Imposible ajustar regresión lineal: denominador es cero.");
    }
    
    double m = (n * sumXY - sumX * sumY) / denominador;
    double b = (sumY - m * sumX) / n;
    
    return new double[]{m, b}; // Retorna los parámetros de la recta
}
🏁 Conclusión
Este método permite filtrar de forma elegante el ruido de medición aleatorio en datos empíricos, entregando un modelo matemático de primer orden robusto y con gran capacidad explicativa del fenómeno bajo estudio.

🔬 Correlación (Coeficiente de Pearson)
Archivo Fuente: Correlacion.java

🎯 Objetivo
Cuantificar de forma matemática e independiente la fuerza y la dirección de la relación lineal existente entre dos variables numéricas aleatorias.

📝 Descripción del Método
Calcula el Coeficiente de Correlación Lineal de Pearson (r). Este indicador adimensional genera valores restringidos de manera estricta en el rango cerrado desde -1.0 hasta +1.0. Un resultado de +1 denota una correlación positiva perfecta, -1 una correlación negativa perfecta y un valor cercano a 0 establece una ausencia total de vinculación lineal entre ambas variables.

🔢 Fórmula General
r = [ n * ∑(xy) - ∑x * ∑y ] / Raíz( [ n∑(x²) - (∑x)² ] * [ n*∑(y²) - (∑y)² ] )

👣 Pasos del Algoritmo
Computar las sumatorias complejas de los vectores de entrada: ∑x, ∑y, ∑(x²), ∑(y²), y ∑(x*y).

Introducir los valores resultantes en la ecuación analítica del coeficiente de Pearson.

Evaluar e interpretar el valor r obtenido para determinar el grado de dependencia estadística.

💻 Pseudocódigo
Plaintext
INICIO CoeficientePearson(X, Y, n)
    sumX <- 0, sumY <- 0, sumXY <- 0, sumX2 <- 0, sumY2 <- 0
    Para i <- 0 Hasta n-1 Hacer
        sumX  <- sumX + X[i]
        sumY  <- sumY + Y[i]
        sumXY <- sumXY + (X[i] * Y[i])
        sumX2 <- sumX2 + (X[i] * X[i])
        sumY2 <- sumY2 + (Y[i] * Y[i])
    Fin Para
    
    numerador <- n * sumXY - sumX * sumY
    denominador <- Raiz(((n * sumX2) - (sumX * sumX)) * ((n * sumY2) - (sumY * sumY)))
    
    Si denominador == 0 Entonces RETURN 0 Fin Si
    RETURN numerador / denominador
FIN
📊 Resultado de Ejecución
Plaintext
--- Análisis de Correlación ---
Coeficiente de Pearson calculado r = 0.94821400
Interpretación: Correlación positiva fuerte entre las variables analizadas.
🏁 Conclusión
El coeficiente de Pearson constituye el paso de validación obligatorio antes de dar por buena cualquier ecuación de regresión. Permite validar estadísticamente si el modelo matemático lineal propuesto posee un sustento real o si las variables se comportan de manera inconexa.