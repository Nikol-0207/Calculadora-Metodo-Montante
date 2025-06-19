/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodosnumericos.metodomontante;

/**
 *
 * @author DATABYTES
 */
public class determinanteFind {
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
}
