<%@page import="com.emergentes2.ejercicio2.Registro"%>
<%
    Registro re = new Registro();
    re = (Registro)request.getAttribute("registro");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio 2</title>
    </head>
    <body>
        <h1>Datos del Usuario</h1>
        <p>Nombre:<%= re.getNombre()%></p>
        <p>Apellido:<%=re.getApellido()%></p>
        <p>Correo:<%=re.getCorreo()%></p>
    </body>
</html>
