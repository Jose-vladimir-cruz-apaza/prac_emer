<%@page import="com.emergentes2.practica.Materias"%>
<%
    Materias es = new Materias();
    es = (Materias)request.getAttribute("materia");
    String a[] = es.getMaterias(); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Materia inscrita</h1>
        <p>Nombre:   <%=es.getNombre()%></p>
        <p>Apellido: <%= es.getApellido()%></p>
        <p>Materia: <%= a[0]%>                 <p/>

    </body>
</html>
