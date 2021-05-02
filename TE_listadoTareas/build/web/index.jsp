<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Tareas"%>
<%
    List<Tareas> lista = (List<Tareas>) request.getAttribute("tarea");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de tareas</title>
    </head>
    <body>
        <h1>Lista de tareas</h1>
        <p><a href="ProcesaTarea?op=nuevo">Nuevo</a></p>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Tarea</td>
                <td>Prioridad</td>
                <td>Completado</td>
                <td></td>
                <td></td>                   
            </tr>
            <c:forEach var="item" items="${tarea}">
            <tr>
                <td>${item.id}</td>
                <td>${item.tarea}</td>
                <td><c:choose>
                        <c:when test="${item.prioridad == 1}">alta</c:when>
                        <c:when test="${item.prioridad == 2}">media</c:when>
                        <c:when test="${item.prioridad == 3}">baja</c:when>
                    </c:choose>
                </td>
                <td>
                <c:choose>
                        <c:when test="${item.completado == 1}"><input type="checkbox" checked></c:when>
                        <c:when test="${item.completado == 2}"><input type="checkbox" ></c:when>
                </c:choose>
                </td>
                <td><a href="ProcesaTarea?op=editar&id=${item.id}&tarea=${item.tarea}&prioridad=${item.prioridad}&completado=${item.completado}">editar</a></td>
                <td><a href="ProcesaTarea?op=eliminar&id=${item.id}" onclick="return(confirm('¿Esta seguro de eliminar?'))">Eliminar</a></td>
            </tr> 
            </c:forEach>
        </table>
    </body>
</html>
