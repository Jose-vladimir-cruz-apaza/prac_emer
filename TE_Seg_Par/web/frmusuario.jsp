<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
      <h1>Formulario Roles</h1>
      <form action="ProcesaUsuarios" method="post">
          <div class="mb-3 row">
              <label for="inputPassword" class="col-sm-2 col-form-label">Id</label>
              <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputPassword" value="${usuarios.id}" name="id">
              </div>
          </div>
          <div class="mb-3 row">
              <label for="inputPassword" class="col-sm-2 col-form-label">Usuario</label>
              <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputPassword" value="${usuarios.usuario}" name="usuario">
              </div>
          </div>          
          <div class="mb-3 row">
              <label for="staticEmail" class="col-sm-2 col-form-label">Correo</label>
              <div class="col-sm-10">
                  <input type="text" class="form-control-plaintext" id="staticEmail" value="${usuarios.correo}" name="correo">
              </div>
          </div>
          <div class="mb-3 row">
              <label for="inputPassword" class="col-sm-2 col-form-label">Clave</label>
              <div class="col-sm-10">
                  <input type="password" class="form-control" id="inputPassword" value="${usuarios.clave}" name="clave">
              </div>
          </div>
          <div class="col-12">
              <button type="submit" class="btn btn-primary">Enviar</button>
          </div>
      </form>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
  </body>
</html>