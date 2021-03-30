<%@page import="com.emergentes.modelo.Notas"%>
<% 
    Notas no = (Notas)request.getAttribute("objagenda");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de notas</title>
    </head>
    <body>
        <h1>Registro de la agenda</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= no.getId() %>" size="2" readonly/></td>
                </tr>
                <tr>
                    <td>Hora</td>
                    <td><input type="time" name="hora" value="<%= no.getHora() %>"></td>
                </tr>    
                <tr>
                    <td>Actividad</td>
                    <td><textarea name="actividad" ><%= no.getActividad() %></textarea></td>
                </tr>    
                <tr>
                    <td>Completado</td>
                    <td></td>
                    <td></td>
                    <td><input type="radio" name="completado" value="si" <%if(no.getCompletado().equals("si")){ %> checked <% } %>/>SI</td>
                    <td></td>
                    <td><input type="radio" name="completado" value="no"  <%if(no.getCompletado().equals("no")){ %> checked <% } %> />NO</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Llenar"></td>
                </tr>              
            </table>
        </form>
    </body>
</html>
