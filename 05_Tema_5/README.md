# 📈 Tema 5: Interpolación, Extrapolación y Ajuste de Funciones

Este módulo contiene la implementación de diferentes algoritmos numéricos desarrollados en **Java** enfocados en aproximar valores (intermedios y externos) y modelar el comportamiento de conjuntos de datos mediante interpolaciones, extrapolaciones y análisis de regresión.

---

## 🚀 Métodos Implementados

El contenido de esta unidad se divide en tres g áreas:

### 1. Interpolación de Funciones
Permite estimar valores intermedios de manera precisa dentro del rango de un conjunto de puntos conocidos:
* **Interpolación Lineal (`Interpolacion.java`):** Conexión directa entre dos puntos adyacentes mediante una línea recta. Es el método más simple para estimaciones rápidas.
* **Interpolación Cuadrática (`InterpolacionCu...`):** Utiliza polinomios de segundo grado (parábolas) aprovechando tres puntos conocidos para capturar la curvatura de los datos.
* **Interpolación Segmentaria / Splines (`InterpolacionSe...`):** Ajusta polinomios de grado menor por tramos o segmentos, asegurando que las uniones entre curvas sean suaves y continuas.

### 2. Extrapolación de Datos
Permite proyectar tendencias y estimar valores **fuera** del rango de los puntos experimentales conocidos:
* **Extrapolación (`Extrapolacion.java` / `ExtrapolacionLineal.java`):** Extensión de las funciones polinomiales o lineales más allá del intervalo de datos original para predecir comportamientos futuros o anteriores.

### 3. Ajuste de Curvas y Análisis Estadístico
Encuentra la función matemática que mejor representa la tendencia general de un conjunto de datos dispersos:
* **Regresión (`Regresion.java`):** Modelado de la estructura de los datos a través del método de mínimos cuadrados para trazar una línea o curva de mejor ajuste.
* **Correlación (`Correlacion.java`):** Análisis matemático para medir la fuerza y dirección de la relación lineal entre las variables (Coeficiente de Correlación de Pearson).

---

## 🛠️ Tecnologías y Datos

* **Lenguaje:** Java (JDK 8 o superior)
  
---
