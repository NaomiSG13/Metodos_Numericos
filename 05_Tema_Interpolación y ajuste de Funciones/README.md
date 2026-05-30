# 📊 TEMA 5: Interpolación, Extrapolación y Ajuste de Funciones

Este módulo contiene la implementación de diferentes algoritmos numéricos enfocados en aproximar valores (intermedios y externos) y modelar el comportamiento de conjuntos de datos mediante interpolaciones, extrapolaciones y análisis de regresión.

## 🛠️ Tecnologías y Requisitos
* **Lenguaje:** Java (JDK 8 o superior)
* **Paradigma:** Orientado a Objetos / Funcional

## 🚀 Áreas y Métodos Implementados
El contenido de esta unidad se divide en tres grandes áreas estratégicas:
* **Interpolación de Funciones:** Estimación de valores intermedios de manera precisa dentro del rango de un conjunto de puntos conocidos.
* **Extrapolación de Datos:** Proyección de tendencias y estimación de valores fuera del rango de los puntos experimentales conocidos.
* **Ajuste de Curvas y Análisis Estadístico:** Búsqueda de la función matemática que mejor representa la tendencia general de un conjunto de datos dispersos.

---

## 🛠️ Catálogo de Métodos Desarrollados

### 1. Interpolación de Funciones

#### 🔬 Interpolación Lineal

* **🎯 Objetivo**
  Estimar un valor intermedio desconocido entre dos puntos de datos adyacentes conocidos mediante una aproximación lineal (línea recta).

* **📝 Descripción del Método**
  Es el método de interpolación más simple y directo. Une dos puntos contiguos mediante un segmento de recta. Asume que la tasa de cambio entre ambos nodos es constante, lo que lo hace ideal para cálculos rápidos donde el tamaño de paso es pequeño y la curvatura no es pronunciada.

* **🔢 Fórmula General**
  y = y_0 + ((y_1 - y_0) / (x_1 - x_0)) * (x - x_0)

* **👣 Pasos del Algoritmo**
  1. Ubicar los dos puntos [x_0, y_0] y [x_1, y_1] que encierran al valor x a evaluar (x_0 <= x <= x_1).
  2. Calcular la pendiente de la recta utilizando la razón de cambio.
  3. Sustituir los valores en la ecuación lineal para obtener la aproximación de y.

* **🏁 Conclusión**
  Aunque su costo computacional es extremadamente bajo, requiriendo un orden de complejidad constante una vez localizados los intervalos, su error de truncamiento puede ser considerable si la función original posee una concavidad o curvatura marcada entre los puntos evaluados.

---

#### 🔬 Interpolación Cuadrática

* **🎯 Objetivo**
  Aproximar valores intermedios aprovechando tres puntos conocidos simultáneamente para capturar de mejor manera la curvatura local de los datos.

* **📝 Descripción del Método**
  Ajusta un polinomio único de segundo grado (una parábola) a través de tres puntos de control distribuidos en la malla de datos. Al incorporar un término cuadrático, reduce significativamente el error de truncamiento en comparación con la aproximación lineal en funciones con cambios de pendiente sinuosos.

* **🔢 Fórmula General**
  y = b_0 + b_1 * (x - x_0) + b_2 * (x - x_0) * (x - x_1)
  *(Donde b_0 = y_0; b_1 = (y_1 - y_0) / (x_1 - x_0); b_2 = (((y_2 - y_1) / (x_2 - x_1)) - b_1) / (x_2 - x_0))*

* **👣 Pasos del Algoritmo**
  1. Seleccionar tres puntos consecutivos [x_0, y_0], [x_1, y_1] y [x_2, y_2] que rodeen el valor objetivo x.
  2. Calcular los coeficientes b_0, b_1 y b_2 mediante diferencias finitas algebraicas.
  3. Evaluar el polinomio resultante en la coordenada x especificada.

* **🏁 Conclusión**
  Representa una mejora drástica frente a la interpolación lineal clásica. Su limitante principal radica en que si los tres puntos elegidos presentan oscilaciones de ruido muy drásticas, la parábola resultante puede sobreajustarse y generar estimaciones inexactas.

---

#### 🔬 Interpolación Segmentaria (Splines)

* **🎯 Objetivo**
  Modelar un conjunto amplio de puntos adaptando polinomios de menor grado por tramos (segmentos) individuales para garantizar curvas suaves globales.

* **📝 Descripción del Método**
  En lugar de forzar a un único polinomio de alto grado a pasar por todos los puntos de la muestra (lo cual desata inestabilidades numéricas), los Splines ajustan ecuaciones independientes en cada par de nodos vecinos. Su gran ventaja matemática radica en imponer condiciones de continuidad estricta en las derivadas de las uniones de los tramos, logrando una curva suave y libre de picos.

* **🔢 Fórmula / Representación General**
  S_i(x) = a_i * (x - x_i)^3 + b_i * (x - x_i)^2 + c_i * (x - x_i) + d_i  (Para un subintervalo i)

* **👣 Pasos del Algoritmo**
  1. Recibir la matriz completa de coordenadas ordenadas en el eje X y eje Y.
  2. Formular un sistema de ecuaciones lineales combinando las restricciones de continuidad de los tramos y sus respectivas derivadas.
  3. Resolver el sistema para obtener el conjunto de coeficientes correspondientes a cada segmento.
  4. Identificar a qué tramo pertenece el punto x solicitado y evaluarlo en su polinomio particular.

* **🏁 Conclusión**
  Los Splines (especialmente los cúbicos) son el estándar de oro en gráficos por computadora y modelado de datos experimentales gracias a su versatilidad para seguir trayectorias complejas sin caer en oscilaciones salvajes de interpolación.

---

### 2. Extrapolación de Datos

#### 🔬 Extrapolación Lineal y Polinomial

* **🎯 Objetivo**
  Proyectar tendencias cuantitativas y predecir valores numéricos localizados fuera del intervalo acotado por los puntos experimentales recolectados.

* **📝 Descripción del Método**
  Consiste en extender analíticamente el comportamiento de la función de ajuste (lineal o polinomial) calculada en la frontera más cercana hacia zonas externas de datos no muestreados. Se asume que las condiciones e inercias físicas que gobiernan el fenómeno dentro del rango de estudio se mantendrán vigentes fuera de él.

* **🔢 Fórmula General**
  y = y_k + ((y_k - y_{k-1}) / (x_k - x_{k-1})) * (x - x_k)  (Proyección basada en los últimos nodos fronterizos)

* **👣 Pasos del Algoritmo**
  1. Determinar si el valor objetivo x se encuentra a la izquierda del límite inferior o a la derecha del límite superior.
  2. Extraer los coeficientes del modelo matemático calculados en las fronteras de los datos base.
  3. Proyectar la función evaluando la coordenada x externa.

* **🏁 Conclusión**
  La extrapolación es inherentemente arriesgada en ciencia de datos e ingeniería. Mientras más alejado se encuentre el punto x del rango real conocido, mayor será la probabilidad de incurrir en un error de predicción catastrófico si las tendencias subyacentes cambian drásticamente.

---

### 3. Ajuste de Curvas y Análisis Estadístico

#### 🔬 Regresión Lineal (Mínimos Cuadrados)

* **🎯 Objetivo**
  Encontrar la línea recta matemática ideal que minimice la dispersión global y represente la tendencia central de una nube de datos experimentales.

* **📝 Descripción del Método**
  El método de mínimos cuadrados busca la ecuación de una línea recta de la forma y = m * x + b de manera que la suma de los cuadrados de los residuos (las distancias verticales entre los puntos reales y la línea recta calculada) sea la menor posible. Es el pilar fundamental del modelado estadístico predictivo.

* **🔢 Fórmulas Generales de Coeficientes**
  * Pendiente: m = (n * Suma(x * y) - Suma(x) * Suma(y)) / (n * Suma(x^2) - (Suma(x))^2)
  * Intersección: b = (Suma(y) - m * Suma(x)) / n

* **👣 Pasos del Algoritmo**
  1. Recibir dos arreglos de tamaño n que representan las coordenadas x e y de todos los puntos distribuidos.
  2. Calcular de forma acumulativa las sumatorias requeridas por las expresiones: suma de x, suma de y, suma del producto x por y, y suma de x al cuadrado.
  3. Resolver las fórmulas de los coeficientes para obtener los parámetros m y b de la recta ajustada.

* **🏁 Conclusión**
  Este método permite filtrar de forma elegante el ruido de medición aleatorio en datos empíricos, entregando un modelo matemático de primer orden robusto y con gran capacidad explicativa del fenómeno bajo estudio.

---

#### 🔬 Correlación (Coeficiente de Pearson)

* **🎯 Objetivo**
  Cuantificar de forma matemática e independiente la fuerza y la dirección de la relación lineal existente entre dos variables numéricas aleatorias.

* **📝 Descripción del Método**
  Calcula el Coeficiente de Correlación Lineal de Pearson (r). Este indicador adimensional genera valores restringidos de manera estricta en el rango cerrado desde -1.0 hasta +1.0. Un resultado de +1 denota una correlación positiva perfecta, -1 una correlación negativa perfecta y un valor cercano a 0 establece una ausencia total de vinculación lineal entre ambas variables.

* **🔢 Fórmula General**
  r = (n * Suma(x * y) - Suma(x) * Suma(y)) / Raiz((n * Suma(x^2) - (Suma(x))^2) * (n * Suma(y^2) - (Suma(y))^2))

* **👣 Pasos del Algoritmo**
  1. Computar las sumatorias de los vectores de entrada: suma de x, suma de y, suma de x al cuadrado, suma de y al cuadrado y suma del producto x por y.
  2. Introducir los valores resultantes en la ecuación analítica del coeficiente de Pearson.
  3. Evaluar e interpretar el valor r obtenido para determinar el grado de dependencia estadística.

* **🏁 Conclusión**
  El coeficiente de Pearson constituye una métrica fundamental antes de realizar cualquier ajuste de curvas, ya que valida si una aproximación lineal es matemáticamente justificable o si se requiere recurrir a modelos de orden superior.
---

### 4. Método de Adams-Bashforth de 2 Pasos

* **Diferencia Clave:** A diferencia de los métodos de Euler o Runge-Kutta (que son de un solo paso y solo miran el punto actual), Adams-Bashforth es un método de pasos múltiples que utiliza la información del punto actual y del punto inmediato anterior para proyectar la solución.

#### 🎯 Objetivo
Resolver ecuaciones diferenciales ordinarias aproximando el área bajo la curva de la derivada mediante un polinomio de interpolación que utiliza dos puntos previos conocidos.

#### 🔢 Fórmula General
y_(i+1) = y_i + (h / 2) * [ 3 * f(x_i, y_i) - f(x_{i-1}, y_{i-1}) ]

#### 🏁 Conclusión
Al aprovechar la historia previa del cálculo, ofrece una mayor precisión que el método de Euler sin necesidad de realizar múltiples evaluaciones de la función en cada paso como lo hace Runge-Kutta. Requiere de un método de un solo paso (como Euler o RK4) para calcular el primer punto de arranque (x_1, y_1).

---

### 5. Métodos Generalizados de Predicciones y Correcciones

* **Diferencia Clave:** Combina las ventajas de los métodos abiertos (explícitos), que son fáciles de calcular, con la estabilidad superior de los métodos cerrados (implícitos).

#### 🎯 Objetivo
Optimizar la aproximación de un problema de valor inicial calculando una primera estimación de la altura (predicción) para luego refinarla iterativamente utilizando la pendiente calculada en ese nuevo punto (corrección).

#### 🔢 Representación del Proceso
1. **Predicador (Paso Explícito):** Se calcula un valor tentativo de la solución para el paso siguiente.
2. **Corrector (Paso Implícito):** Se utiliza el valor tentativo para recalcular la pendiente final y ajustar el resultado mediante un promedio ponderado.

#### 🏁 Conclusión
Esta estrategia reduce drásticamente el error de truncamiento local y es la base de los algoritmos modernos de paso variable para resolver ecuaciones diferenciales de alta complejidad o sistemas de ecuaciones "rígidos" (stiff).

---

### 6. Aplicación: Ley de Enfriamiento de Newton

* **Diferencia Clave:** Es un modelo físico real de primer orden que describe cómo la velocidad de cambio de la temperatura de un cuerpo es proporcional a la diferencia entre su propia temperatura y la del medio ambiente.

#### 🎯 Objetivo
Simular analítica y numéricamente la pérdida o ganancia de calor de un objeto a lo largo del tiempo dentro de un entorno con temperatura constante.

#### 🔢 Fórmula del Modelo (EDO)
dT / dt = -k * (T - T_ambiente)
*(Donde T es la temperatura del objeto, t es el tiempo, k es la constante de enfriamiento del material y T_ambiente es la temperatura del entorno)*

#### 🏁 Conclusión
Esta aplicación sirve como el escenario perfecto para validar la precisión de los métodos de Euler y Heun, demostrando cómo el tamaño de paso (h) afecta directamente la velocidad con la que el modelo computacional converge hacia el equilibrio térmico real.

---

### 7. Aplicación: Sistema del Péndulo Simple

* **Diferencia Clave:** Representa un sistema de ecuaciones diferenciales acopladas. Una ecuación diferencial de segundo orden (que involucra la aceleración angular) se transforma en dos ecuaciones de primer orden interdependientes.

#### 🎯 Objetivo
Modelar y simular las oscilaciones de un péndulo considerando el ángulo de desplazamiento y la velocidad angular en función del tiempo.

#### 🔢 Representación del Sistema (EDOs de 1er Orden)
* d(Angulo) / dt = Velocidad_angular
* d(Velocidad_angular) / dt = -(g / L) * Seno(Angulo)
*(Donde g es la aceleración de la gravedad y L es la longitud de la cuerda del péndulo)*

#### 🏁 Conclusión
Debido a la naturaleza no lineal del término con la función Seno, este sistema carece de una solución analítica exacta para ángulos grandes. Su resolución mediante Runge-Kutta de 4to Orden (RK4) es indispensable en la física computacional para garantizar la conservación de la energía y evitar que la simulación del movimiento se desfase de la realidad física.
