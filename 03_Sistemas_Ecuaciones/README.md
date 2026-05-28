# 📊 TEMA 4: Diferenciación e Integración Numérica

Este módulo comprende el estudio, diseño e implementación de algoritmos computacionales para aproximar derivadas puntuales e integrales definidas a partir de funciones continuas o tabuladas. Estas técnicas analizan el comportamiento geométrico de las curvas y minimizan el error de truncamiento mediante polinomios de interpolación avanzados.

## 🛠️ Catálogo de Métodos Desarrollados

| Recurso / Código | Descripción Técnica |
| :--- | :--- |
| **Diferenciación Numérica** | Fórmulas de aproximación por diferencias de 3 y 5 puntos (Adelante, Atrás y Centrales). |
| **Método del Trapecio Compuesto** | Integración aproximada mediante la partición lineal de subintervalos. |
| **Regula de Simpson 1/3 Compuesta** | Integración basada en la aproximación por parábolas (polinomios de 2do grado). |
| **Regla de Simpson 3/8 Compuesta** | Desarrollo analítico con polinomios cúbicos para segmentos múltiples de 3. |
| **Cuadratura Gaussiana (2 Puntos)** | Evaluación óptima no equiespaciada utilizando las raíces de polinomios de Legendre. |

---
---

## 1. Diferenciación Numérica (3 y 5 Puntos)

* **Estatus:** Documentación Técnica
* **Diferencia Clave:** A diferencia de la definición de límite analítico tradicional, la diferenciación numérica calcula la pendiente local de una función utilizando combinaciones algebraicas de nodos discretos separados por una distancia finita (h).

### 🎯 Objetivo
Aproximar el valor numérico de la primera derivada de una función continua f'(x) en un punto específico x_i, empleando esquemas de diferencias finitas centrales para reducir significativamente el error de truncamiento.

### 📝 Descripción del Método
El método sustituye la recta tangente exacta por una recta aproximada generada a partir de un conjunto de muestras distribuidas simétricamente alrededor del punto de interés x_i. La aproximación de 3 puntos emplea un polinomio interpolante de segundo grado y posee un error de orden O(h²). Por su parte, la aproximación central de 5 puntos utiliza un polinomio de cuarto grado, lo que expande la precisión a un orden de convergencia de O(h⁴), ideal para mitigar las desviaciones en curvas de alta oscilación.

### 🔢 Fórmula General Estructurada
Para un tamaño de paso constante (h), las ecuaciones se definen de la siguiente manera:

**A. Fórmula Central de 3 Puntos:**
f'(x_i) = [ f(x_i + h) - f(x_i - h) ] / (2h)

**B. Fórmula Central de 5 Puntos:**
f'(x_i) = [ -f(x_i + 2h) + 8f(x_i + h) - 8f(x_i - h) + f(x_i - 2h) ] / (12h)

### 👣 Pasos Principales
1. Definir el punto de interés x_i, el tamaño de paso infinitesimal h y la función objetivo f(x).
2. Calcular los valores correspondientes de los nodos vecinos: (x_i + h), (x_i - h), (x_i + 2h) y (x_i - 2h).
3. Evaluar la función matemática en cada uno de los nodos calculados.
4. Aplicar los pesos correspondientes en el numerador (para 5 puntos: -1, +8, -8, +1).
5. Dividir el total acumulado entre el factor del denominador (12 * h).

### 💻 Pseudocódigo
```text
INICIO Diferenciacion5Puntos(f, x, h)
    x_menos2 <- x - 2 * h
    x_menos1 <- x - h
    x_mas1   <- x + h
    x_mas2   <- x + 2 * h
    
    numerador <- -f(x_mas2) + 8 * f(x_mas1) - 8 * f(x_menos1) + f(x_menos2)
    denominador <- 12 * h
    
    derivada <- numerador / denominador
    RETURN derivada
FIN
☕ Código en Java
Java
package unidad4;

import java.util.function.Function;

public class MetodoDiferenciacion {
    public static void main(String[] args) {
        double x = Math.PI / 3; // Punto de evaluación (60 grados)
        double h = 0.01;        // Tamaño de paso
        
        double resultado = derivadaCentral5Puntos(Math::sin, x, h);
        System.out.printf("Aproximación de la derivada: %.8f\n", resultado);
        System.out.printf("Valor real esperado (cos(pi/3)): %.8f\n", Math.cos(x));
    }

    public static double derivadaCentral5Puntos(Function<Double, Double> f, double x, double h) {
        double f_menos2 = f.apply(x - 2 * h);
        double f_menos1 = f.apply(x - h);
        double f_mas1   = f.apply(x + h);
        double f_mas2   = f.apply(x + 2 * h);
        
        return (-f_mas2 + 8 * f_mas1 - 8 * f_menos1 + f_menos2) / (12 * h);
    }
}
🏁 Conclusión
La diferenciación numérica central de 5 puntos provee una excelente aproximación analítica sin requerir el álgebra formal de la derivada. No obstante, se debe tener extremo cuidado con la elección de h: un valor extremadamente pequeño inducirá un error severo de cancelación por redondeo numérico en la memoria del computador.

2. Método del Trapecio Compuesto
Estatus: Documentación Técnica

Diferencia Clave: A diferencia de los esquemas parabólicos o cúbicos, el método del Trapecio aproxima el área de cada subintervalo mediante líneas rectas, adaptándose de forma robusta e intuitiva a cualquier cantidad de segmentos.

🎯 Objetivo
Aproximar el valor de la integral definida de una función f(x) desde un límite "a" hasta "b" dividiendo la región bajo la curva en "n" subintervalos de ancho constante y modelando el área de cada sección mediante figuras trapezoidales contiguas.

📝 Descripción del Método
El intervalo general [a, b] se fragmenta homogéneamente. En cada uno de estos pequeños segmentos se traza una cuerda recta que une los valores de la función en los extremos. Esto da origen a un trapecio matemático cuya área se calcula fácilmente de forma lineal. Al sumar las contribuciones individuales, los nodos intermedios se comparten entre trapecios consecutivos, lo que da como resultado una ecuación compacta donde las alturas intermedias se duplican en peso, dejando los límites absolutos de la integral con peso de uno.

🔢 Fórmula General Estructurada
Para una división de n segmentos:

Cálculo del ancho de paso (h): h = (b - a) / n

Ecuación unificada del área acumulada: Área = (h / 2) * [ f(a) + 2 * ( f(x_1) + f(x_2) + ... + f(x_n-1) ) + f(b) ]

Nodos internos: x_i = a + i * h

👣 Pasos Principales
Definir los límites de integración a y b, el número total de subintervalos n y la función f(x).

Calcular el ancho de cada trapecio mediante la expresión h = (b - a) / n.

Evaluar la función en los dos extremos libres y acumularlos en una variable inicializada: Suma = f(a) + f(b).

Recorrer mediante un bucle todos los puntos internos desde i = 1 hasta n - 1.

Multiplicar por 2 cada evaluación intermedia e incorporarla a la suma.

Multiplicar el gran acumulado por el factor externo (h / 2) para obtener el resultado definitivo.

💻 Pseudocódigo
Plaintext
INICIO TrapecioCompuesto(f, a, b, n)
    h <- (b - a) / n
    suma <- f(a) + f(b)
    
    PARA i <- 1 HASTA n - 1:
        x <- a + i * h
        suma <- suma + 2 * f(x)
    FIN_PARA
    
    integral <- (h / 2) * suma
    RETURN integral
FIN
☕ Código en Java
Java
package unidad4;

import java.util.function.Function;

public class MetodoTrapecio {
    public static void main(String[] args) {
        double a = 1.0;
        double b = 3.0;
        int n = 50; // Cantidad de subintervalos
        
        double resultado = trapecioCompuesto(Math::log, a, b, n);
        System.out.printf("Resultado de la integración (ln(x)): %.8f\n", resultado);
    }

    public static double trapecioCompuesto(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        double suma = f.apply(a) + f.apply(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += 2 * f.apply(x);
        }
        
        return (h / 2) * suma;
    }
}
🏁 Conclusión
El método del Trapecio Compuesto es el algoritmo de integración más elemental y versátil. Aunque posee una tasa de error global de O(h²), la cual es más lenta de mitigar que en los métodos basados en polinomios de mayor grado, su total carencia de restricciones en el valor de n lo convierte en un algoritmo sumamente confiable para datos tabulados experimentales.

3. Regla de Simpson 1/3 Compuesta
Estatus: Documentación Técnica

Diferencia Clave: A diferencia del Trapecio que usa rectas, la regla de Simpson 1/3 ajusta parábolas uniendo grupos de tres puntos contiguos, lo que impone la restricción de requerir un número estrictamente par de subintervalos.

🎯 Objetivo
Calcular el área aproximada bajo una curva ajustando segmentos de ecuaciones cuadráticas (parábolas) a lo largo de un intervalo particionado de forma simétrica.

📝 Descripción del Método
La regla de Simpson 1/3 aproxima la función original mediante polinomios de Lagrange de segundo grado. Para trazar una parábola se necesitan obligatoriamente tres puntos (un subintervalo doble). Al encadenar múltiples segmentos parabólicos para cubrir el intervalo global [a, b], los subintervalos individuales se fusionan dando lugar a una distribución de coeficientes alternada. Los puntos mapeados con índices impares reciben un peso de factor 4, los puntos mapeados con índices pares reciben un peso de factor 2, y los extremos de frontera conservan su peso neutro de 1.

🔢 Fórmula General Estructurada
Para n subintervalos (donde n debe ser número par):

Cálculo de h: h = (b - a) / n

Ecuación desglosada: Área = (h / 3) * [ f(a) + 4 * (S_impares) + 2 * (S_pares) + f(b) ]

S_impares: f(x_1) + f(x_3) + f(x_5) + ... + f(x_n-1)

S_pares: f(x_2) + f(x_4) + f(x_6) + ... + f(x_n-2)

👣 Pasos Principales
Verificar que el parámetro n sea un número par. Si no cumple esta condición, sumarle una unidad para forzar la compatibilidad geométrica.

Determinar la distancia fija entre nodos: h = (b - a) / n.

Evaluar la función en los extremos libres iniciales: Suma = f(a) + f(b).

Iterar a través de los nodos interiores con un contador i que va desde 1 hasta n - 1.

Validar la paridad del índice en cada paso:

Si el índice es impar, incorporar el nodo a la suma multiplicado por 4.

Si el índice es par, incorporar el nodo a la suma multiplicado por 2.

Efectuar la multiplicación del acumulado por el coeficiente externo (h / 3).

💻 Pseudocódigo
Plaintext
INICIO Simpson1TercioCompuesto(f, a, b, n)
    SI (n mod 2 != 0) ENTONCES:
        n <- n + 1
    FIN_SI
    
    h <- (b - a) / n
    suma <- f(a) + f(b)
    
    PARA i <- 1 HASTA n - 1:
        x <- a + i * h
        SI (i mod 2 != 0) ENTONCES:
            suma <- suma + 4 * f(x)
        SINO:
            suma <- suma + 2 * f(x)
        FIN_SI
    FIN_PARA
    
    integral <- (h / 3) * suma
    RETURN integral
FIN
☕ Código en Java
Java
package unidad4;

import java.util.function.Function;

public class MetodoSimpson13 {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 1.0;
        int n = 20; // Debe ser par
        
        double resultado = simpson13Compuesto(x -> Math.exp(x), a, b, n);
        System.out.printf("Resultado de la integración (Simpson 1/3): %.8f\n", resultado);
    }

    public static double simpson13Compuesto(Function<Double, Double> f, double a, double b, int n) {
        if (n % 2 != 0) {
            n++; // Forzar que sea par
        }
        
        double h = (b - a) / n;
        double suma = f.apply(a) + f.apply(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 != 0) {
                suma += 4 * f.apply(x);
            } else {
                suma += 2 * f.apply(x);
            }
        }
        
        return (h / 3) * suma;
    }
}
📊 Conclusión
La regla de Simpson 1/3 incrementa de manera notable el orden de precisión a un nivel de convergencia O(h⁴). Es una opción predilecta en cómputo científico gracias a su balance óptimo entre velocidad algorítmica y tasa de cancelación de error, siempre que las subdivisiones de la cuadrícula puedan estructurarse en conjuntos pares.

4. Regla de Simpson 3/8 Compuesta
Estatus: Documentación Técnica

Diferencia Clave: A diferencia de Simpson 1/3 (que usa un polinomio cuadrático), Simpson 3/8 aproxima la función con un polinomio cúbico, lo que permite integrar con mayor precisión y manejar casos donde n es múltiplo de 3.

🎯 Objetivo
Aproximar el valor de una integral definida utilizando polinomios de tercer grado (cúbicos) en cada subintervalo, proporcionando una aproximación de alta fidelidad adaptada a mallas con segmentos múltiplos de tres.

📝 Descripción del Método
La regla de Simpson 3/8 se basa en aproximar la función f(x) por un polinomio cúbico que pasa por cuatro puntos igualmente espaciados de forma secuencial. Cuando se aplica sobre una partición extendida de intervalos (Forma Compuesta), los polinomios cúbicos contiguos se entrelazan en sus fronteras. Esta superposición genera un patrón de coeficientes sumamente estructurado y periódico, alternando multiplicadores específicos (3, 3 y 2) para evitar redundancias de cálculo en los extremos compartidos.

🔢 Fórmula General Estructurada
Para n subintervalos (donde n debe ser múltiplo de 3):

Cálculo de h: h = (b - a) / n

Ecuación unificada: Área = (3 * h / 8) * [ f(x_0) + 3*(S1) + 3*(S2) + 2*(S3) + f(x_n) ]

S1 (Posiciones 1, 4, 7...): f(x_1) + f(x_4) + f(x_7) + ... + f(x_n-2)

S2 (Posiciones 2, 5, 8...): f(x_2) + f(x_5) + f(x_8) + ... + f(x_n-1)

S3 (Múltiplos de 3): f(x_3) + f(x_6) + f(x_9) + ... + f(x_n-3)

Secuencia de Coeficientes: 1, 3, 3, 2, 3, 3, 2, 3, 3, 2, ..., 3, 3, 1

👣 Pasos Principales
Verificar que n sea múltiplo de 3. Si no lo es, ajustar al siguiente múltiplo adecuado mediante un bucle de control.

Calcular el ancho del paso: h = (b - a) / n.

Evaluar los extremos fijos absolutos: f(x_0) y f(x_n).

Recorrer todos los puntos interiores de la cuadrícula aplicando coeficientes según su posición:

Si el índice es divisible de manera exacta entre 3 (i mod 3 == 0), aplicar multiplicador de peso 2.

De lo contrario, aplicar multiplicador de peso 3.

Multiplicar el gran total acumulado por la constante del factor externo (3 * h / 8).

💻 Pseudocódigo
Plaintext
INICIO Simpson38(f, a, b, n)
    MIENTRAS n % 3 != 0:
        n = n + 1
    FIN_MIENTRAS
    
    h = (b - a) / n
    suma = f(a) + f(b)
    
    PARA i = 1 HASTA n - 1:
        x = a + i * h
        SI i % 3 == 0 ENTONCES:
            suma = suma + 2 * f(x)
        SINO:
            suma = suma + 3 * f(x)
        FIN_SI
    FIN_PARA
    
    integral = (3 * h / 8) * suma
    RETURN integral
FIN
☕ Código en Java
Java
package unidad4;

import java.util.function.Function;

public class MetodoSimpson38 {
    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 9; // Debe ser múltiplo de 3
        
        double resultado = simpson38(Math::sin, a, b, n);
        System.out.printf("Aproximación de la integral = %.8f\n", resultado);
        System.out.printf("Valor exacto esperado: %.1f\n", 2.0);
    }

    public static double simpson38(Function<Double, Double> f, double a, double b, int n) {
        while (n % 3 != 0) {
            n++;
        }
        
        double h = (b - a) / n;
        double suma = f.apply(a) + f.apply(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                suma += 2 * f.apply(x);
            } else {
                suma += 3 * f.apply(x);
            }
        }
        
        return (3 * h / 8) * suma;
    }
}
📊 Conclusión
El Método de Simpson 3/8 es una extensión natural del método de Simpson 1/3 que utiliza interpolación cúbica en lugar de cuadrática. Aunque comparte el mismo orden de error global O(h⁴), ofrece una flexibilidad de segmentación clave cuando las restricciones físicas del muestreo o de la ingeniería exigen agrupaciones estrictas en múltiplos de tres.

5. Cuadratura Gaussiana (De Dos Puntos)
Estatus: Documentación Técnica

Diferencia Clave: A diferencia de las fórmulas de Newton-Cotes que ocupan una base equiespaciada rígida, la Cuadratura Gaussiana elimina las restricciones de frontera, seleccionando de forma libre y óptima puntos y pesos simétricos para conseguir la máxima precisión analítica.

🎯 Objetivo
Calcular de forma exacta la integral definida de polinomios de grado 3 o inferior, y aproximar con altísima eficiencia funciones complejas empleando únicamente dos evaluaciones funcionales estratégicas.

📝 Descripción del Método
El método de Cuadratura Gaussiana rompe con el esquema clásico de espaciado uniforme. En su lugar, realiza primero una transformación de intervalo para mapear los límites originales [a, b] al dominio simétrico estandarizado [-1, 1]. Para el caso específico de 2 puntos de control, la teoría demuestra que los lugares idóneos para evaluar la función corresponden a las raíces simétricas del polinomio de Legendre de segundo grado, dadas por la constante 1 / Raíz(3). Al evaluar la función exclusivamente en estas dos coordenadas mapeadas y multiplicar ambas por un peso idéntico (w = 1), se alcanza una precisión formidable.

🔢 Fórmula General Estructurada
Mapeo de variables (Cambio de intervalo lineal): x_i = [ (b - a) * t_i + (b + a) ] / 2

Fórmula de aproximación de 2 puntos: Integral = [ (b - a) / 2 ] * [ f(x_1) + f(x_2) ]

Puntos en el espacio transformado (t):
t_1 = -1 / Raíz(3) = -0.57735027
t_2 =  1 / Raíz(3) =  0.57735027

👣 Pasos Principales
Definir la función a integrar f(x) junto con sus fronteras absolutas de entrada a y b.

Establecer la constante matemática del punto de Gauss: c = 1 / Raíz(3).

Calcular la coordenada real del primer punto muestreado x_1 aplicando la constante negativa.

Calcular la coordenada real del segundo punto muestreado x_2 aplicando la constante positiva.

Evaluar la función en x_1 y x_2, y posteriormente sumar ambos resultados obtenidos.

Multiplicar el total por el factor de escala externo (b - a) / 2.

💻 Pseudocódigo
Plaintext
INICIO CuadraturaGaussiana2Puntos(f, a, b)
    c <- 1.0 / Raiz(3.0)
    
    x1 <- ((b - a) * -c + (b + a)) / 2.0
    x2 <- ((b - a) * c + (b + a)) / 2.0
    
    suma_evaluaciones <- f(x1) + f(x2)
    integral <- ((b - a) / 2.0) * suma_evaluaciones
    
    RETURN integral
FIN
☕ Código en Java
Java
package unidad4;

import java.util.function.Function;

public class MetodoCuadraturaGaussiana {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 2.0;
        
        // f(x) = x^3 + 2x
        double resultado = cuadraturaGauss2Puntos(x -> Math.pow(x, 3) + 2 * x, a, b);
        System.out.printf("Resultado de la integración por Cuadratura: %.8f\n", resultado);
    }

    public static double cuadraturaGauss2Puntos(Function<Double, Double> f, double a, double b) {
        double c = 1.0 / Math.sqrt(3.0);
        
        double x1 = ((b - a) * -c + (b + a)) / 2.0;
        double x2 = ((b - a) * c + (b + a)) / 2.0;
        
        return ((b - a) / 2.0) * (f.apply(x1) + f.apply(x2));
    }
}
📊 Conclusión
La Cuadratura Gaussiana de dos puntos revoluciona el costo computacional. Mientras que los algoritmos de Newton-Cotes requieren dividir la función en docenas de segmentos para aproximarse al valor real, este método matemático computa la respuesta perfecta para cualquier función polinomial cúbica realizando únicamente dos evaluaciones funcionales.

🖥️ Guía de Compilación y Ejecución General
Todos los métodos incluidos en esta unidad han sido escritos en lenguaje Java puro sin dependencias externas. Para compilar y correr cualquiera de los programas desde la terminal de comandos de tu sistema o Visual Studio Code, ejecuta las siguientes instrucciones:

Bash
# 1. Posicionarse dentro de la carpeta del Tema 4
cd 04_Diferenciacion_Integracion

# 2. Compilar el archivo de origen deseado (Ejemplo: MetodoSimpson38.java)
javac MetodoSimpson38.java

# 3. Ejecutar la clase compilada en la Máquina Virtual de Java
java MetodoSimpson38