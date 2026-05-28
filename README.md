# 💻 Métodos Numéricos — ITESA

Este repositorio alberga el portafolio de evidencias y las prácticas de código desarrolladas para la materia de **Métodos Numéricos**. Cada unidad incluye la teoría, algoritmos implementados (principalmente en **Java**) y problemarios resueltos.

---

## 👤 Información del Estudiante 

* **Nombre:** Sandoval Godinez Naomi Anais
* **Matrícula:** `24030253`
* **Carrera:** Ingeniería en Sistemas Computacionales
* **Institución:** Instituto Tecnológico Superior del Oriente del Estado de Hidalgo (ITESA)

---

## 📂 Estructura y Contenido del Repositorio

A continuación se detallan los temas cubiertos durante el semestre. Haz clic directamente sobre el nombre del tema para abrir su carpeta de código correspondiente en GitHub:

| Unidad | Título del Tema |
| :---: | :--- |
| **01** | [01_Introduccion_MN](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/01_Introduccion_MN) |
| **02** | [02_Metodos_Solucion_Ecuaciones](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/02_Metodos_Solucion_Ecuaciones) |
| **03** | [03_Sistemas_Ecuaciones](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/03_Sistemas_Ecuaciones) |
| **04** | [04_Diferenciacion_Integracion](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/04_Diferenciacion_Integracion) |
| **05** | [05_Tema_5 (Interpolación y Ajuste de Funciones)](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/05_Tema_5) |
| **06** | [06_Solucion_Ecuaciones_Diferenciales](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/06_Solucion_Ecuaciones_Diferenciales) |

### 📖 Índice de Introducciones Teóricas
Si prefieres leer la introducción técnica y el desglose de los algoritmos dentro de este mismo documento, haz clic en cualquiera de los siguientes enlaces:
* [Ir a Introducción: Tema 1](#-tema-1-errores-y-precisión-numérica)
* [Ir a Introducción: Tema 2](#-tema-2-raíces-de-ecuaciones)
* [Ir a Introducción: Tema 3](#-tema-3-sistemas-de-ecuaciones-lineales)
* [Ir a Introducción: Tema 4](#-tema-4-diferenciación-e-integración-numérica)
* [Ir a Introducción: Tema 5](#-tema-5-interpolación-y-ajuste-de-funciones)
* [Ir a Introducción: Tema 6](#-tema-6-solución-de-ecuaciones-diferenciales)

---

## 📝 Detalles de las Unidades e Introducción

### 🔹 Tema 1: Errores y Precisión Numérica
En esta unidad se analiza por qué las computadoras no son "exactas" y cómo la representación binaria afecta los cálculos científicos.

* **Tipos de Errores:** Documentación sobre error absoluto, relativo y de truncamiento.
* **Error de Redondeo Binario:** Demostración de cómo números decimales simples (como $0.1$) no tienen representación exacta en base 2.
* **Cancelación por Resta:** Ejemplo de la pérdida masiva de dígitos significativos al restar dos números muy cercanos entre sí.
* **Pérdida por Magnitud:** Ilustración de lo que sucede cuando sumamos un número muy grande con uno muy pequeño (el pequeño desaparece).
* **Acumulación en Bucles:** Muestra cómo un pequeño error se magnifica al realizar miles de iteraciones.
* **Comparación con `==`:** Explicación práctica de por qué usar `==` con datos de tipo `double` devuelve `false` inesperadamente.
* **Conversión Estrecha:** Riesgos de pérdida de datos al realizar "casting" de `double` a `float` o `int`.
* **Desbordamiento Silencioso:** Qué ocurre cuando un cálculo supera el valor máximo permitido por el tipo de dato (*Overflow*).
* **Problemario MN EJ26:** Solución detallada a los ejercicios prácticos de la unidad 1.

### 🔹 Tema 2: Raíces de Ecuaciones
Implementación de métodos numéricos para hallar el valor de $x$ que satisface la ecuación $f(x) = 0$.

* **Método de Bisección:** Basado en el teorema de Bolzano. Divide el intervalo a la mitad sucesivamente. Es lento pero siempre converge de manera segura.
* **Otros Métodos Comunes:** Desarrollo de algoritmos iterativos (como *Newton-Raphson*, *Secante* o *Punto Fijo*) para acelerar la convergencia matemática en la búsqueda de raíces.

### 🔹 Tema 3: Sistemas de Ecuaciones Lineales
Solución de sistemas matriciales de la forma $Ax = B$. Se exploran tanto aproximaciones analíticas adaptadas a la computación como métodos iterativos de convergencia.

* **Métodos Directos:** Eliminación Gaussiana, Gauss-Jordan y Factorización LU.
* **Métodos Iterativos:** Métodos de Jacobi y Gauss-Seidel para sistemas dispersos o de gran escala.

### 🔹 Tema 4: Diferenciación e Integración Numérica
Técnicas computacionales para aproximar los valores de derivadas e integrales definidas cuando no se dispone de una solución analítica exacta.

* **Diferenciación:** Fórmulas de diferencias hacia adelante, hacia atrás y centrales.
* **Integración:** Regla del Trapecio y Reglas de Simpson ($1/3$ y $3/8$).

### 🔹 Tema 5: Interpolación y Ajuste de Funciones
Esta unidad se enfoca en la construcción de funciones matemáticas que aproximen un conjunto de puntos de datos experimentales u observados mediante dos enfoques fundamentales:

* **Interpolación Polinomial:** Utilizada cuando los datos son precisos y la función debe pasar exactamente por cada uno de los puntos conocidos.
    * **Polinomios de Lagrange:** Cálculo del polinomio interceptor a través de combinaciones de productos basados en las coordenadas de los nodos.
    * **Polinomios de Newton (Diferencias Divididas):** Método iterativo eficiente para Java que permite añadir nuevos puntos de datos sin reiniciar todo el algoritmo.
* **Ajuste de Curvas (Regresión):** Empleado cuando los datos contienen ruido o errores experimentales, buscando capturar la tendencia general.
    * **Regresión Lineal por Mínimos Cuadrados:** Técnica que minimiza la suma de los cuadrados de los residuos entre los puntos experimentales y la recta propuesta ($y = ax + b$).
    * **Ajuste Polinomial y No Lineal:** Extensión del método para curvas cuadráticas o linealización de funciones exponenciales.

### 🔹 Tema 6: Solución de Ecuaciones Diferenciales
Modelado y resolución numérica de Ecuaciones Diferenciales Ordinarias (EDO) con condiciones iniciales, dividiendo las estrategias según su método de avance para aproximar la curva solución. Esta unidad integra los conceptos del resto del semestre para resolver problemas dinámicos de ingeniería.

* **Métodos de Un Paso:** Calculan el punto siguiente $y_{i+1}$ utilizando de forma exclusiva la información del punto inmediato anterior.
    * **Método de Euler (Hacia adelante, hacia atrás y modificado):** Algoritmo base de proyección lineal mediante la pendiente inicial del intervalo.
    * **Métodos de Runge-Kutta (RK):** Logran precisión de alto orden sin cálculo explícito de derivadas superiores. Implementación del clásico **RK4** empleando un promedio ponderado de cuatro pendientes intermedias.
* **Métodos de Pasos Múltiples:** Aprovechan la información de varios puntos previos ya calculados para predecir valores futuros de manera más eficiente.
    * **Esquemas Predictor-Corrector:** Uso acoplado de métodos como *Adams-Bashforth* (explícito) y *Adams-Moulton* (implícito) para refinar soluciones.
* **Sistemas de Ecuaciones Diferenciales Ordinarias:** Extensión de los algoritmos mediante vectores y arreglos en Java para solucionar múltiples EDOs acopladas simultáneamente.
* **Aplicaciones Prácticas:** Modelado de sistemas dinámicos como dinámicas de poblaciones (Lotka-Volterra), circuitos eléctricos (RLC) y sistemas mecánicos de masa-resorte-amortiguador.

---

## 🚀 Tecnologías y Herramientas Utilizadas

* **Lenguaje principal:** Java (JDK 8+)
* **Entorno de Desarrollo:** Visual Studio Code
* **Control de Versiones:** Git & GitHub
