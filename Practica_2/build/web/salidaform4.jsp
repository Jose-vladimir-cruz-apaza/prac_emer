<%@page import="com.emergentes2.ejercicio4.Libros"%>
<%
    Libros li= new Libros();
    li=(Libros)request.getAttribute("libros");
    String medio[]=li.getMedio();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de libros</h1>
        <p>Titulo:<%=li.getTitulo()%></p>
        <p>Autor:<%=li.getAutor()%></p>
        <p>Resumen:<%=li.getResumen()%></p>
        <p>Medio:<%=medio[0]%></p>
    </body>
</html>
