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

A continuación se detallan los temas cubiertos durante el semestre. Puedes hacer clic sobre el título del tema para saltar directamente a su introducción y desglose de contenido, o bien, usar el enlace de la derecha para ir a la carpeta correspondiente de código:

| Unidad | Título del Tema | Enlace al Código |
| :---: | :--- | :---: |
| **01** | [Errores y Precisión Numérica](#-tema-1-errores-y-precisión-numérica) | [📂 Ver Carpeta](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/Unidad_1) |
| **02** | [Raíces de Ecuaciones (Solución de Ecuaciones)](#-tema-2-raíces-de-ecuaciones) | [📂 Ver Carpeta](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/Unidad_2) |
| **03** | [Sistemas de Ecuaciones Lineales](#-tema-3-sistemas-de-ecuaciones-lineales) | [📂 Ver Carpeta](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/Unidad_3) |
| **04** | [Diferenciación e Integración Numérica](#-tema-4-diferenciación-e-integración-numérica) | [📂 Ver Carpeta](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/Unidad_4) |
| **05** | [Interpolación y Ajuste de Funciones](#-tema-5-interpolación-y-ajuste-de-funciones) | [📂 Ver Carpeta](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/Unidad_5) |
| **06** | [Solución de Ecuaciones Diferenciales](#-tema-6-solución-de-ecuaciones-diferenciales) | [📂 Ver Carpeta](https://github.com/NaomiSG13/Metodos_Numericos/tree/main/Unidad_6) |

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
Construcción de funciones matemáticas que aproximen un conjunto de puntos de datos experimentales.

* **Interpolación:** Polinomios de Lagrange y diferencias divididas de Newton para pasar exactamente por todos los puntos.
* **Ajuste de Curvas:** Método de Mínimos Cuadrados para encontrar la tendencia general de los datos sin necesidad de cruzar estrictamente por cada uno.

### 🔹 Tema 6: Solución de Ecuaciones Diferenciales
Modelado y resolución numérica de Ecuaciones Diferenciales Ordinarias (EDO) con condiciones iniciales, utilizando aproximaciones de discretización temporal o espacial.

* **Método de Euler:** El algoritmo fundamental de paso único para aproximar soluciones lineales de primer orden.
* **Métodos de Runge-Kutta:** Implementaciones avanzadas (típicamente RK4) que reducen significativamente el error de truncamiento local acumulado.
* **Integración Conceptual:** Esta unidad unifica e integra los conceptos de todas las unidades anteriores (análisis de errores, interpolación de pendientes, solución de sistemas algebraicos y diferenciación computacional) para resolver problemas dinámicos complejos de ingeniería.

---

## 🚀 Tecnologías y Herramientas Utilizadas

* **Lenguaje principal:** Java (JDK 8+)
* **Entorno de Desarrollo:** Visual Studio Code
* **Control de Versiones:** Git & GitHub
