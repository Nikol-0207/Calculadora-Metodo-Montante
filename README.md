[![Captura-de-pantalla-2025-06-19-172603.jpg](https://i.postimg.cc/1thnpXVD/Captura-de-pantalla-2025-06-19-172603.jpg)](https://postimg.cc/d76VFqB0)
Este proyecto implementa una interfaz web para resolver sistemas de ecuaciones lineales utilizando el **Método Montante**, un método matricial eficiente que evita fracciones y permite calcular la solución exacta, la inversa de una matriz y su determinante.
## Caracteristicas
- Interfaz intuitiva
- Permite ingresar matrices de hasta 4x4.
- Calcula:
  - Solución del sistema de ecuaciones.
  - Determinante de la matriz.
  - Matriz inversa.
- Explicación visual y breve del método Montante.
- Historia del matemático René Montante.

## 💻 Tecnologías utilizadas

- HTML5
- CSS3
- JavaScript (puro)
- JSP (Java Server Pages)
## 🚀 ¿Cómo usarlo?

1. Clona el repositorio o descarga los archivos.
2. Abre el archivo `index.jsp` desde un entorno que soporte JSP (por ejemplo: Apache Tomcat).
3. Selecciona el orden de la matriz (2x2, 3x3, 4x4).
4. Ingresa los coeficientes de las ecuaciones.
5. Elige una opción: resolver el sistema, calcular la determinante o hallar la inversa.
6. Presiona el botón **Resolver**.



## Funciones de la Calculadora del Método Montante
**-Función para encontrar la determinante de una matriz [2x2,3x3,4x4]**

[![Captura-de-pantalla-2025-06-19-174058.jpg](https://i.postimg.cc/Y9HNtbRc/Captura-de-pantalla-2025-06-19-174058.jpg)](https://postimg.cc/jWMnX6Bv)

```
public static double determinanteMontante(int[][] matrizOriginal) {
        int n = matrizOriginal.length;

        if (n < 2 || n > 4) {
            throw new IllegalArgumentException("Solo se permite orden 2, 3 o 4.");
        }

        // Convertir a double para permitir divisiones
        double[][] matriz = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = matrizOriginal[i][j];
            }
        }

        double pivoteAnterior = 1;

        for (int k = 0; k < n; k++) {
            // Paso 1: Asegurarse que el pivote no sea 0
            if (matriz[k][k] == 0) {
                boolean pivotado = false;
                for (int i = k + 1; i < n; i++) {
                    if (matriz[i][k] != 0) {
                        // Intercambiar filas
                        double[] temp = matriz[k];
                        matriz[k] = matriz[i];
                        matriz[i] = temp;
                        pivotado = true;
                        
                        break;
                    }
                }
                if (!pivotado) {
                  
                    return 0;
                }
            }

            double pivote = matriz[k][k];
            

            // Paso 2: Aplicar fórmula de Montante para cada fila i ≠ k
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k) continue;

                    matriz[i][j] = (pivote * matriz[i][j] - matriz[i][k] * matriz[k][j]) / pivoteAnterior;
                }
            }

            // Paso 3: Rellenar ceros en columna k y fila k, excepto en [k][k]
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    matriz[i][k] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (j != k) {
                    matriz[k][j] = 0;
                }
            }

            pivoteAnterior = pivote;
        }
        return matriz[n - 1][n - 1];
    }
```
**Funcion que resuelve un sistema de matrices de orden 2**

[![Captura-de-pantalla-2025-06-19-174726.jpg](https://i.postimg.cc/0rRP4KxC/Captura-de-pantalla-2025-06-19-174726.jpg)](https://postimg.cc/5Q3hY0XH)

```
public static double[] resolverSistema2x2(int[][] A, int[] B) {
        int n = 2;
        double[][] m = new double[n][n + 1];

        // Crear matriz aumentada [A | B]
        for (int i = 0; i < n; i++) {
            m[i][0] = A[i][0];
            m[i][1] = A[i][1];
            m[i][2] = B[i];
        }

        double pivoteAnterior = 1.0;

        for (int k = 0; k < n; k++) {
            double pivote = m[k][k];

            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = m[i][k];
                    for (int j = 0; j <= n; j++) {
                        m[i][j] = ((pivote * m[i][j]) - (factor * m[k][j])) / pivoteAnterior;
                    }
                }
            }

            pivoteAnterior = pivote;
        }

        // Normalización de la diagonal principal
        for (int i = 0; i < n; i++) {
            double divisor = m[i][i];
            for (int j = 0; j <= n; j++) {
                m[i][j] /= divisor;
            }
        }

        // Extraer las soluciones
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }

        return x;
    }
```
**Función para hallar la inversa de una matriz de orden 4**

[![Captura-de-pantalla-2025-06-19-174517.jpg](https://i.postimg.cc/dVRtz6hZ/Captura-de-pantalla-2025-06-19-174517.jpg)](https://postimg.cc/CR1g8jHw)

```
//matriz 4x4
      public static double[][] inversa4x4(int[][] A) {
        final int n = 4;
        double[][] m = new double[n][2 * n];          // 4 × 8

        /* ── 1.  Construir matriz aumentada [A | I] ────────────────────────── */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < n) {
                    m[i][j] = A[i][j];                // bloque A
                } else {
                    m[i][j] = (i == j - n) ? 1.0 : 0; // bloque I
                }
            }
        }

        /* ── 2.  Algoritmo de Montante ─────────────────────────────────────── */
        double pivoteAnterior = 1.0;

        for (int k = 0; k < n; k++) {                 // recorre las 4 columnas pivote
            double pivote = m[k][k];

            for (int i = 0; i < n; i++) {
                if (i == k) continue;                 // omitir fila pivote
                double factor = m[i][k];

                for (int j = 0; j < 2 * n; j++) {
                    m[i][j] = (pivote * m[i][j] - factor * m[k][j]) / pivoteAnterior;
                }
            }
            pivoteAnterior = pivote;                  // actualizar pₐₙₜ
        }

        /* ── 3.  Normalizar la diagonal a 1 ─────────────────────────────────── */
        for (int i = 0; i < n; i++) {
            double diag = m[i][i];
            for (int j = 0; j < 2 * n; j++) {
                m[i][j] /= diag;
            }
        }

        /* ── 4.  Extraer la inversa (bloque derecho) ───────────────────────── */
        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(m[i], n, inv[i], 0, n);
        }
        return inv;
      }
```

