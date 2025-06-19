/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodosnumericos.metodomontante;

/**
 *
 * @author DATABYTES
 */
public class matrizInversa {
   public static double[][] inversa2x2(int[][] A) {
        int n = 2;
        double[][] m = new double[n][2 * n];

        // Crear matriz aumentada [A | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < n) {
                    m[i][j] = A[i][j];
                } else {
                    m[i][j] = (i == j - n) ? 1.0 : 0.0;
                }
            }
        }

        double pivoteAnterior = 1.0;

        for (int k = 0; k < n; k++) {
            double pivote = m[k][k];

            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = m[i][k];
                    for (int j = 0; j < 2 * n; j++) {
                        m[i][j] = ((pivote * m[i][j]) - (factor * m[k][j])) / pivoteAnterior;
                    }
                }
            }

            pivoteAnterior = pivote;
        }

        // Normalización de la diagonal principal
        for (int i = 0; i < n; i++) {
            double divisor = m[i][i];
            for (int j = 0; j < 2 * n; j++) {
                m[i][j] /= divisor;
            }
        }

        // Extraer la inversa
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = m[i][j + n];
            }
        }

        return inversa;
    }
   //matriz 3x3
   public static double[][] inversa3x3(int[][] A) {
        int n = 3;
        double[][] m = new double[n][2 * n];

        // Crear matriz aumentada [A | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < n) {
                    m[i][j] = A[i][j];
                } else {
                    m[i][j] = (i == j - n) ? 1.0 : 0.0;
                }
            }
        }

        double pivoteAnterior = 1.0;

        for (int k = 0; k < n; k++) {
            double pivote = m[k][k];

            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = m[i][k];
                    for (int j = 0; j < 2 * n; j++) {
                        m[i][j] = ((pivote * m[i][j]) - (factor * m[k][j])) / pivoteAnterior;
                    }
                }
            }

            pivoteAnterior = pivote;
        }

        // Normalizar las filas (hacer la diagonal principal igual a 1)
        for (int i = 0; i < n; i++) {
            double divisor = m[i][i];
            for (int j = 0; j < 2 * n; j++) {
                m[i][j] /= divisor;
            }
        }

        // Extraer la inversa de la parte derecha
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = m[i][j + n];
            }
        }

        return inversa;
    }
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
}
   
    

