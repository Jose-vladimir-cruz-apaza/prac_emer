<%@page import="com.emergentes.modelo.Vacunas"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vacunas reg = (Vacunas)request.getAttribute("miobjvac");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de vacunas</title>
    </head>
    <body>
        <h1>Registro Vacunas</h1>
        <form action="ProcesaVacunas" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= reg.getNombre() %>" /></td>
                </tr>
                <tr>
                    <td>Peso</td>
                    <td><input type="text" name="peso" value="<%= reg.getPeso() %>"/></td>
                </tr>
                <tr>
                    <td>Talla</td>
                    <td><input type="text" name="talla" value="<%= reg.getTalla() %>" size="1"/></td>
                </tr>              
                <tr>
                    <td>Vacuna</td>
                    <td><input type="radio" name="vacuna" value="si" <% if(reg.getVacuna().equals("si")){ %> checked <%}%> size="3"/>Si</td>
                    <td><input type="radio" name="vacuna" value="no" <% if(reg.getVacuna().equals("no")){ %> checked <%}%> size="3"/>No</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>    
            </table>
        </form>
    </body>
</html>
