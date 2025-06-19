/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodosnumericos.metodomontante;

/**
 *
 * @author DATABYTES
 */
public class resolverMatrices {
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
     public static double[] resolverSistema3x3(int[][] A, int[] B) {
        int n = 3;
        double[][] m = new double[n][n + 1];

        // Crear matriz aumentada [A | B]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = A[i][j];
            }
            m[i][n] = B[i];
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

        // Normalizar la diagonal
        for (int i = 0; i < n; i++) {
            double divisor = m[i][i];
            for (int j = 0; j <= n; j++) {
                m[i][j] /= divisor;
            }
        }

        // Extraer solución
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }

        return x;
    }
        public static double[] resolverSistema4x4(int[][] A, int[] B) {
        int n = 4;
        double[][] m = new double[n][n + 1];

        // Crear matriz aumentada [A | B]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = A[i][j];
            }
            m[i][n] = B[i];
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

        // Normalizar la diagonal
        for (int i = 0; i < n; i++) {
            double divisor = m[i][i];
            for (int j = 0; j <= n; j++) {
                m[i][j] /= divisor;
            }
        }

        // Extraer solución
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }

        return x;
    }
  

}
