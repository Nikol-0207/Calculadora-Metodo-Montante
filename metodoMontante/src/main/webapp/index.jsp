<%-- 
    Document   : index
    Created on : 11 jun de 2025, 10:21:35 a. m.
    Author     : Wendy Nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Método Montante</title>
  <style>
    .titulo {
     text-align: center;
     margin-top: 20px;
     font-size: 45px;
     margin-bottom: 20px;
     margin-top: 0;
    }

    .matrix-input {
      margin-top: 20px;
    }
    .row {
      margin-bottom: 5px;
    }
    input[type="number"] {
      width: 40px;
      text-align: center;
    }
      * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body, html {
      height: 100%;
    }

    .contenedor {
      display: flex;
      flex-wrap: wrap;
      min-height: 100%;     /* ✅ que crezca según el contenido */
      align-items: stretch; /* ✅ que las columnas se estiren */
    }

    .columna {
      padding: 20px;
      color: white;
      
    }

    .izquierda {
      background-color: #a7c1d0;
      width: 20%;
      color: black;
      flex: 1 1 250px;
      overflow-wrap: break-word;
    }
    .izquierda img {
      width: 90%;
      border-radius: 5px;
      margin-bottom: 10px;
    }
     .bioTexto {
      font-size: 14px;
      line-height: 1.4;
    }
    .centro {
      background-color: #252932;
      flex: 2 1 500px;
      width: 60%;
    }
    .button-generar{
        border-radius: 5px;
       border-color: white; 
    }
    .button-resuelve{
       border-radius: 5px;
       border-color: white;
       height: 20px;
    }
    .derecha {
      background-color: #a7c1d0;
      width: 20%;
      color: black;
      flex: 1 1 250px;
      overflow-wrap: break-word;
    }
    .derecha img {
       max-width: 100%;
       height: auto;
       display: block;
      }
    .result{
        width: 16rem;
        height: 12rem;
    }
      footer {
       background-color: #111;
       height: 70px;
       
        color: white;
      text-align: center;
      padding: 40px 0;
       font-size: 1.2rem;
      display: flex;
      align-items: center;
    
      justify-content: center;
      }
    
  </style>
  <script>
   function actualizarMatriz() {
  const n = parseInt(document.getElementById("orderInput").value);

  // Deshabilitar inputs de la matriz A
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < 4; j++) {
      const input = document.querySelector(`input[name="a${i}${j}"]`);
      if (input) input.disabled = (i >= n || j >= n);
    }
    const inputB = document.querySelector(`input[name="b${i}"]`);
    if (inputB) inputB.disabled = (i >= n);
  }
}

// Ejecutar al cargar la página
window.addEventListener("DOMContentLoaded", actualizarMatriz);
  </script>
</head>
<body>

  
   <div class="contenedor">
    <div class="columna izquierda">
      <h2>Réne Mario Montante Pardo</h2>
       <img src="https://matematicos.matem.unam.mx/images/M/ReneMontante/042.jpg" alt="Foto del autor">
       <p class="bioTexto">René Mario Montante Pardo nació el 14 de septiembre de 1933 en Monterrey. Curiosamente, su conexión con la universidad comenzó desde que era un bebé, cuando su madre lo llevaba a clases en la Facultad de Ciencias Químicas. Un dato interesante es que el ingeniero Montante nació el mismo año que la UANL, que fue fundada oficialmente el 25 de septiembre de 1933.</p>
    </div>
      
    <div class="columna centro">
        <form action="Svmatrices" method="POST" id="metodoM" > 
      <h2 class="titulo">Método Montante</h2>
     <label>Orden de la matriz: </label>
<input type="number" id="orderInput" name="orderInput" min="2" max="4" value="2" onchange="actualizarMatriz()">

<div id="matrixContainer">
  <div class="row">
    <input type="number" name="a00"> + <input type="number" name="a01"> + <input type="number" name="a02"> + <input type="number" name="a03"> = <input type="number" name="b0">
  </div>
  <div class="row">
    <input type="number" name="a10"> + <input type="number" name="a11"> + <input type="number" name="a12"> + <input type="number" name="a13"> = <input type="number" name="b1">
  </div>
  <div class="row">
    <input type="number" name="a20"> + <input type="number" name="a21"> + <input type="number" name="a22"> + <input type="number" name="a23"> = <input type="number" name="b2">
  </div>
  <div class="row">
    <input type="number" name="a30"> + <input type="number" name="a31"> + <input type="number" name="a32"> + <input type="number" name="a33"> = <input type="number" name="b3">
  </div>
</div>
    
     <div id="matrixContainer" class="matrix-input"></div>
      <label for="opcion">Elija una opcion a resolver:</label>
      <select id="opcion" name="opcion">
       <option value="resuelve" ${opcion == "resuelve" ? "selected" : ""}>Resolver matriz</option>
       <option value="determinante" ${opcion == "determinante" ? "selected" : ""}>Calcular la Determinante</option>
       <option value="inversa" ${opcion == "inversa" ? "selected" : ""}>Hallar la matriz inversa</option>
        </select>
        <button type="submit" class="button-resuelve">Resolver</button> <br>
        <label for="resultado">Resultado:</label><br>
        <textarea id="resultado" class="result" name="resultado" rows="6" cols="50" readonly>
          <%= request.getAttribute("resultado") != null ? request.getAttribute("resultado") : "" %>
         </textarea>
          </form>
        </div>
    <div class="columna derecha">
      <h2>Explicación del método</h2>
      <p class="bioTexto"><strong>Resolver un sistema de ecuaciones (Ax = B)</strong></p> 
      <p class="bioTexto">El método consiste en ir "pivoteando" en la diagonal principal. Se comienza en el extremo superior izquierdo, el renglón donde está el pivote va a ser el renglón base de todo el sistema y la columna donde esta el pivote va a ser la columna base. Con respecto a ese renglón y esa columna, donde está el pivote, se forman determinantes de dos por dos, y siempre se trabaja con números enteros, si apareciera alguna fracción hay un error.</p>
      <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/a8c34e2613fc7529b4008fd96f9b517f77179cae" alt="formula" >
      <p class="bioTexto"><strong> Calcular la inversa de una matriz A</strong></p> 
      <p class="bioTexto">-Se construye una matriz aumentada [A | I], donde I es la matriz identidad.</p>
      <p class="bioTexto">-Se aplica el mismo proceso de Montante (pivotamiento).</p>
      <p class="bioTexto">-Se construye una matriz aumentada [A | I], donde I es la matriz identidad.</p>
      <p class="bioTexto"><strong> Calcular el Determinante</strong></p> 
      <p class="bioTexto">Al aplicar Montante para triangular la matriz (sin modificarla como en Gauss), el último pivote calculado en la diagonal principal será el determinante.</p>
      <p class="bioTexto">El proceso conserva el valor del determinante sin dividir por pivotes hasta el final (ideal para matrices con enteros).</p>


    </div>
  </div>
  
  <footer>
    © Proyecto de Métodos Numéricos 1-2025
  </footer>
        
</body>
</html>

