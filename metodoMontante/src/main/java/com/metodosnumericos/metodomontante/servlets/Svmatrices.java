/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.metodosnumericos.metodomontante.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.metodosnumericos.metodomontante.determinanteFind;
import com.metodosnumericos.metodomontante.matrizInversa;
import com.metodosnumericos.metodomontante.resolverMatrices;

/**
 *
 * @author DATABYTES
 */
@WebServlet(name = "Svmatrices", urlPatterns = {"/Svmatrices"})
public class Svmatrices extends HttpServlet {

     public static String matrizToString(int[][] matriz) {
     StringBuilder sb = new StringBuilder();
      for (int[] fila : matriz) {
          for (int val : fila) {
            sb.append(String.format("%5d", val)); // formato con espacio
        }
        sb.append("\n");
    }
    return sb.toString();
     }
     //matrices double
     public static String matrizToStringDouble(double[][] matriz) {
    StringBuilder sb = new StringBuilder();
    for (double[] fila : matriz) {
        for (double val : fila) {
            sb.append(String.format("%7.2f", val)); // 2 decimales y espacio
        }
        sb.append("\n");
     }
        return sb.toString();
    }
     public static String arrayToString(double[] solucion) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < solucion.length; i++) {
        sb.append(String.format("x%d = %.4f", i + 1, solucion[i]));
        if (i < solucion.length - 1) {
            sb.append("\n");
        }
    }
    return sb.toString();
}


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String opcion = request.getParameter("opcion");
          String ordenMatrix=request.getParameter("orderInput");
          String pos00=request.getParameter("a00");
          int a00=0;
          if (pos00 != null && !pos00.isEmpty()) {
               a00 = Integer.parseInt(pos00);
           }
          String pos01=request.getParameter("a01");
          int a01=0;
          if (pos01 != null && !pos01.isEmpty()) {
               a01 = Integer.parseInt(pos01);
           }
          String pos02=request.getParameter("a02");
          int a02=0;
          if (pos02 != null && !pos02.isEmpty()) {
               a02 = Integer.parseInt(pos02);
           }        
          String pos03=request.getParameter("a03");
          int a03=0;
          if (pos03 != null && !pos03.isEmpty()) {
               a03 = Integer.parseInt(pos03);
           }
          String pos10=request.getParameter("a10");
          int a10=0;
          if (pos10 != null && !pos10.isEmpty()) {
               a10 = Integer.parseInt(pos10);
           }
          String pos11=request.getParameter("a11");
          int a11=0;
          if (pos11 != null && !pos11.isEmpty()) {
               a11 = Integer.parseInt(pos11);
           }
          String pos12=request.getParameter("a12");
          int a12=0;
          if (pos12 != null && !pos12.isEmpty()) {
               a12 = Integer.parseInt(pos12);
           }
          String pos13=request.getParameter("a13");
          int a13=0;
          if (pos13 != null && !pos13.isEmpty()) {
               a13 = Integer.parseInt(pos13);
           }
          String pos20=request.getParameter("a20");
          int a20=0;
          if (pos20 != null && !pos20.isEmpty()) {
               a20 = Integer.parseInt(pos20);
           }
          String pos21=request.getParameter("a21");
          int a21=0;
          if (pos21 != null && !pos21.isEmpty()) {
               a21 = Integer.parseInt(pos21);
           }
          String pos22=request.getParameter("a22");
          int a22=0;
          if (pos22 != null && !pos22.isEmpty()) {
               a22 = Integer.parseInt(pos22);
           }
          String pos23=request.getParameter("a23");
          int a23=0;
          if (pos23 != null && !pos23.isEmpty()) {
               a23 = Integer.parseInt(pos23);
           }
          String pos30=request.getParameter("a30");
          int a30=0;
          if (pos30 != null && !pos30.isEmpty()) {
               a30 = Integer.parseInt(pos30);
           }
          String pos31=request.getParameter("a31");
          int a31=0;
          if (pos31 != null && !pos31.isEmpty()) {
               a31 = Integer.parseInt(pos31);
           }
          String pos32=request.getParameter("a32");
          int a32=0;
          if (pos32 != null && !pos32.isEmpty()) {
               a32 = Integer.parseInt(pos32);
           }
          String pos33=request.getParameter("a33");
          int a33=0;
          if (pos33 != null && !pos33.isEmpty()) {
               a33 = Integer.parseInt(pos33);
           }
          // valor b
          String posb0=request.getParameter("b0");
          int b0=0;
          if (posb0 != null && !posb0.isEmpty()) {
               b0 = Integer.parseInt(posb0);
           }
          String posb1=request.getParameter("b1");
          int b1=0;
          if (posb1 != null && !posb1.isEmpty()) {
               b1 = Integer.parseInt(posb1);
           }
          String posb2=request.getParameter("b2");
          int b2=0;
          if (posb2 != null && !posb2.isEmpty()) {
               b2 = Integer.parseInt(posb2);
           }
          String posb3=request.getParameter("b3");
          int b3=0;
          if (posb3 != null && !posb3.isEmpty()) {
               b3 = Integer.parseInt(posb3);
           }
          
        String resultado = "";
        String matrizText="";
        String matrizTextInversa="";
        String solucion="";
        double determina=0.0;
        double[][] inverso;
        double[] valorX;
        if (ordenMatrix!=null){
             
              switch (ordenMatrix) {
                  case "2":
                  int[][] matrizDos = {
                    {a00, a01},
                    {a10, a11}
                    };
                  int[] BTwo={b0,b1};
                  //determinante
                   determina= determinanteFind.determinanteMontante(matrizDos);
                   matrizText=matrizToString(matrizDos);
                   //inversa
                   inverso=matrizInversa.inversa2x2(matrizDos);
                   matrizTextInversa=matrizToStringDouble(inverso);
                   //resuelve matriz
                   valorX=resolverMatrices.resolverSistema2x2(matrizDos, BTwo);
                   solucion=arrayToString(valorX);
                  break;
                  case "3":
                    
                  int[][] matrizTres = {
                    {a00, a01, a02},
                    {a10, a11, a12},
                    {a20, a21, a22}
                    }; 
                  int [] BThree={b0,b1,b2};
                  determina= determinanteFind.determinanteMontante(matrizTres);
                  matrizText=matrizToString(matrizTres);
                  //inversa
                   inverso=matrizInversa.inversa3x3(matrizTres);
                   matrizTextInversa=matrizToStringDouble(inverso);
                   //resuelve matriz
                   valorX=resolverMatrices.resolverSistema3x3(matrizTres, BThree);
                   solucion=arrayToString(valorX);
                  break;
                  case "4":
                  int[][] matrizCuatro = {
                    {a00, a01, a02, a03},
                    {a10, a11, a12, a13},
                    {a20, a21, a22, a23},
                    {a30, a31, a32, a33},
                    }; 
                  int[] BFour={b0,b1,b2,b3};
                  //determinante opcion
                  determina= determinanteFind.determinanteMontante(matrizCuatro);
                  matrizText=matrizToString(matrizCuatro);
                  //inversa
                   inverso=matrizInversa.inversa4x4(matrizCuatro);
                   matrizTextInversa=matrizToStringDouble(inverso);
                   //resuelve matriz
                   valorX=resolverMatrices.resolverSistema4x4(matrizCuatro, BFour);
                   solucion=arrayToString(valorX);
                  break;
                }
        }
        if (opcion != null) {
            switch (opcion) {
                case "determinante":
                    resultado = "Matriz ingresada:\n" + matrizText + "\nDeterminante = " + determina;
                    break;
                case "resuelve":
                      resultado = "Matriz ingresada:\n" + matrizText+"\nSolución General:\n"+solucion;
                    break;
                case "inversa":
                     resultado = "Matriz ingresada:\n"+matrizText+"\nA^-1=\n"+matrizTextInversa;
                 
                    break;
                default:
                    resultado = "Opción no reconocida.";
            }
        }

        // Enviar el resultado de vuelta al JSP
        
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
