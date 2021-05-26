<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Roles</title>
  </head>
  <body>
      <h1>Roles</h1>
      <a href="ProcesaRoles?action=add" class="link-success">Nuevo Rol</a>
      <table class="table">
          <thead>
              <tr>
                  <th scope="col">ID</th>
                  <th scope="col">DESCRIPCION</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
              </tr>
          </thead>
          <c:forEach var="item" items="${roles}">
              <tbody>
                  <tr>
                      <th scope="row">${item.id}</th>
                      <td>${item.descripcion}</td>
                      <td><a href="ProcesaRoles?action=edit&id=${item.id}"><i class="fas fa-newspaper"></i></a></td>
                      <td><a href="ProcesaRoles?action=delete&id=${item.id}"onclick="return(confirm('Esta seguro ???'))"><i class="fas fa-trash"></i>
                        </a>
                    </td>
                  </tr>
              </tbody>
          </c:forEach>
      </table>
      <a class="btn btn-primary" href="ProcesaUsuarios" role="button">Usuarios</a>
      <br>
      <a class="btn btn-primary" href="ProcesaPermisos" role="button">Permisos</a>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
  </body>
</html>