<%@page import="com.emergentes.modelo.Tareas"%>
<%  
    Tareas tarea = (Tareas)request.getAttribute("tarea1");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1>Nueva Tarea</h1>
        <form action="ProcesaTarea" method="post">
            <table>
                <tr>   
                <td><input type="hidden" name="id" value="${tarea1.id}"/></td>
                </tr>
                <tr>
                    <td>Nueva Tarea</td>
                </tr>
                <tr>
                <td><input type="text" name="tarea" value="${tarea1.tarea}"/></td>
                </tr>
                <tr>
                    <td>Prioridad</td>
                </tr>
                <tr>
                <td>    
                    <input type="radio" name="prioridad" value="1"  <% if(tarea.getPrioridad() == 1){ %> checked <%} %>/>Alta
                <input type="radio" name="prioridad" value="2" <% if(tarea.getPrioridad() == 2){ %> checked <%} %> />Media
                <input type="radio" name="prioridad" value="3" <% if(tarea.getPrioridad() == 3){ %> checked <%} %> />Baja
                </td>
                </tr>
                <tr>
                    <td>Completado</td>
                </tr>
                <tr>
                <td>    
                <input type="radio" name="completado" value="1"  <% if(tarea.getPrioridad() == 1){ %> checked <%} %>/>Concluido
                <input type="radio" name="completado" value="2"  <% if(tarea.getPrioridad() == 2){ %> checked <%} %>/>Pendiente
                </td>
                </tr>
                <tr>
                <td>    
                <input type="submit" value="enviar"/>
                </td>
                </tr>
            </table>
        </form>
    </body>
</html>
