# 📊 TEMA 1: Introducción a los Métodos Numéricos

En este apartado se presenta el estudio de algoritmos para la localización de raíces de ecuaciones no lineales y el cálculo de aproximaciones numéricas.

---

## 1.1 Importancia de los Métodos Numéricos

Los métodos numéricos transforman problemas formulados mediante cálculo, álgebra lineal o ecuaciones diferenciales en operaciones aritméticas simples. 

Mientras que la matemática analítica busca una función exacta **y = f(x)**, los métodos numéricos buscan una colección de puntos numéricos **(x_i, y_i)** que aproximen el comportamiento real con un margen de error controlado. Su importancia radica en que permiten resolver sistemas no lineales o geometrías complejas que no tienen solución exacta por métodos tradicionales.

---

## 1.2 Conceptos Básicos

* **Cifra Significativa:** Es el número de dígitos que se usan con confianza. Para determinar el número de cifras significativas de un resultado basado en su error, se utiliza el **Criterio de Cómputo de Scarborough**. Si se garantiza que el error numérico es menor que un límite preestablecido, el resultado es correcto hasta **n** cifras significativas si el error aproximado porcentual cumple con:
  `Es = (0.5 * 10^(2 - n))%`

* **Exactitud:** Proximidad de un valor calculado al valor verdadero.
* **Precisión:** Proximidad de los valores calculados entre sí al repetir el método.

* **Incertidumbre:** Intervalo en el que se asume que se encuentra el valor verdadero:
  `Valor = Media ± U` (donde U es la incertidumbre).
* **Sesgo:** Error sistemático medido como la diferencia entre la media de los datos calculados y el valor real.

---

## 1.3 Fórmulas Analíticas de los Tipos de Errores

En métodos numéricos, los errores se cuantifican de manera absoluta y relativa para evaluar la calidad de la aproximación:

### Error Absoluto (E_t)
Es la diferencia numérica directa entre el valor verdadero (V) y el valor aproximado (A):
`E_t = |V - A|`

### Error Relativo Porcentual Verdadero (E_v)
Para que el error no dependa de la escala o magnitud de la variable, se normaliza respecto al valor verdadero:
`E_v = (|V - A| / |V|) * 100%`

### Error Relativo Porcentual Aproximado (E_a)
En problemas reales de ingeniería no conocemos el valor verdadero. Por lo tanto, el error se calcula comparando la aproximación actual con la aproximación obtenida en el paso anterior (esencial en métodos iterativos):
`E_a = (|Aproximación_Actual - Aproximación_Anterior| / |Aproximación_Actual|) * 100%`

### Error de Truncamiento (Serie de Taylor)
Ocurre al interrumpir un proceso matemático infinito. La fórmula para modelar cualquier función suave mediante una aproximación polinomial es la Serie de Taylor:
`f(x) = f(a) + f'(a)*(x-a) + (f''(a)/2!)*(x-a)^2 + ... + (f^n(a)/n!)*(x-a)^n + R_n`

---

## 1.4 Software de Cómputo Numérico

Las operaciones numéricas se ejecutan mediante vectores y matrices usando software que implementa librerías de alto rendimiento:

* **MATLAB / Octave:** Diseñados nativamente para el manejo de arreglos multidimensionales.
* **Python:** Utiliza la librería **NumPy**, la cual está escrita en C y permite vectorizar operaciones aritméticas, evitando los lentos ciclos `for` nativos de Python.

---

## 1.5 Métodos Iterativos y Criterios de Convergencia

Un método iterativo calcula una secuencia de valores `{x_1, x_2, x_3, ..., x_k}` que busca aproximarse a la raíz o solución analítica. La ecuación general de recurrencia de un sistema iterativo unidimensional se expresa como:
`x_(k+1) = g(x_k)`

### Condición de Convergencia (Teorema del Punto Fijo)
Para asegurar que un método iterativo va a aproximarse al resultado correcto en lugar de fallar (divergir), la derivada de la función iterativa `g(x)` evaluada en la vecindad de la solución debe cumplir con:
`|g'(x)| < 1`

---

## 🛠️ Algoritmos de Solución

### Métodos Cerrados (Bracketing Methods)
Requieren de dos valores iniciales (`x_l` inferior y `x_u` superior) que encierren a la raíz. Se basan en el **Teorema del Valor Intermedio**, el cual matemáticamente dice que si una función continua cambia de signo en un intervalo, existe al menos una raíz en ese intervalo:
`f(x_l) * f(x_u) < 0`

### Métodos Abiertos (Open Methods)
No necesitan encerrar la raíz, solo requieren uno o dos valores iniciales de arranque. Son algoritmos mucho más rápidos (convergencia veloz), pero corren el riesgo de divergir.

* **Algoritmo de Newton-Raphson:** Utiliza la recta tangente a la curva en el punto actual para proyectar el siguiente valor sobre el eje x. Es el algoritmo más eficiente si se conoce la derivada.
  `x_(i+1) = x_i - f(x_i) / f'(x_i)`

---

## 📝 Caso Práctico: Control de Calidad en Manufactura

### Enunciado del Problema
Un ingeniero de control de calidad está calibrando una máquina automatizada que corta ejes de transmisión para motores. El plano de diseño exige que el diámetro exacto de cada eje sea de **25.00 mm** (Valor Verdadero, V).

Para evaluar el estado de la máquina, se toma una muestra aleatoria de 5 ejes cortados consecutivamente y se miden con un micrómetro láser de alta precisión. Las lecturas obtenidas son: `[25.12, 25.15, 25.10, 25.14, 25.14]`.

**Se solicita:**
1. Calcular el Sesgo de la máquina de corte.
2. Calcular la Incertidumbre de las mediciones utilizando la desviación estándar de la muestra.
3. Determinar si el problema de la máquina es de Exactitud o de Precisión.

### 💻 Código en Python para Automatizar el Análisis
```python
import numpy as np

def analizar_mediciones(datos, valor_verdadero):
    """
    Calcula el sesgo, la media y la incertidumbre (desviación estándar) 
    de un conjunto de datos experimentales.
    """
    datos = np.array(datos, dtype=float)
    n = len(datos)

    # 1. Calcular la media aritmética
    media = np.mean(datos)

    # 2. Calcular el Sesgo (Error Sistemático)
    sesgo = media - valor_verdadero

    # 3. Calcular la Incertidumbre basada en la Desviación Estándar Muestral (ddof=1 para n-1)
    incertidumbre = np.std(datos, ddof=1)

    # Imprimir Reporte Técnico
    print("=" * 50)
    print("        REPORTE DE INCERTIDUMBRE Y SESGO")
    print("=" * 50)
    print(f"Número de muestras analizadas : {n}")
    print(f"Valor Nominal (Verdadero)     : {valor_verdadero:.2f} mm")
    print(f"Media de las lecturas         : {media:.2f} mm")
    print("-" * 50)
    print(f"SESGO DETECTADO               : {sesgo:+.2f} mm")
    print(f"INCERTIDUMBRE (Dispersión)    : ±{incertidumbre:.2f} mm")
    print("-" * 50)

    # Diagnóstico automatizado de Calidad
    print("DIAGNÓSTICO DEL PROCESO:")
    if abs(sesgo) > 0.05 and incertidumbre <= 0.03:
        print("-> El sistema es PRECISO pero INEXACTO (Alto Sesgo, Baja Incertidumbre).")
        print("   Acción: Calibrar el punto cero / offset de la máquina.")
    elif abs(sesgo) <= 0.05 and incertidumbre > 0.05:
        print("-> El sistema es EXACTO pero IMPRECISO (Bajo Sesgo, Alta Incertidumbre).")
        print("   Acción: Revisar vibraciones o rigidez estructural del equipo.")
    elif abs(sesgo) <= 0.05 and incertidumbre <= 0.03:
        print("-> El sistema es EXACTO Y PRECISO. Operación óptima.")
    else:
        print("-> El sistema es INEXACTO E IMPRECISO. Requiere mantenimiento general.")
    print("=" * 50)

# --- Datos del Problema ---
lecturas_ejes = [25.12, 25.15, 25.10, 25.14, 25.14]
valor_diseno = 25.00

# Ejecución del programa
analizar_mediciones(lecturas_ejes, valor_diseno)
