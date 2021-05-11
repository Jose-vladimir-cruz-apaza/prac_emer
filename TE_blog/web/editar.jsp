<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${post.id == 0}" var="item">Nuevo</c:if>
            <c:if test="${post.id != 0}" var="item">Editar</c:if>
        </h1>
        <form action="ProcesaPosts" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <label>Fecha</label>
            <input type="date" name="fecha" value="${post.fecha}"/>
            <br>
            <br>
            <label>Titulo</label>
            <input type="text" name="titulo" value="${post.titulo}"/>
            <br>
            <br>
            <label>Contenido</label>
            <br>
            <textarea name="contenido" placeholder="Ingrese nuevo posts" cols="40" rows="5">${post.contenido}</textarea>
            <br>
            <br>
            <input type="submit" value="Ingresar"/>
        </form>
    </body>
</html>
