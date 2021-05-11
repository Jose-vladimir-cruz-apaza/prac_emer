<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blogs</title>
    </head>
    <body>
        <h1>Blogs de salud</h1>
        <a href="ProcesaPosts?action=add">Nueva Entrada</a>
        <a href="index">Salir</a>         
                <c:forEach var="item" items="${blogs}">                      
                <p>${item.fecha}</p>
                <h2>${item.titulo}</h2>
                <p>${item.contenido}</p> 
                <a href="ProcesaPosts?action=edit&id=${item.id}">Editar</a>
                <a href="ProcesaPosts?action=delete&id=${item.id}" onclick="return(confirm('Esta de acuerdo'))">Eliminar</a>
                <hr>
                </c:forEach>
    </body>
</html>
