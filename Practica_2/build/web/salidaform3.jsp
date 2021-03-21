<%@page import="com.emergentes2.ejercicio3.Productos"%>
<%    
    Productos po = new Productos();
    po = (Productos)request.getAttribute("productos");
    String producto[] = po.getProductos();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos registrados</h1>
        <p>Nombre: <%=po.getNombre()%></p>
        <p>Categoria: <%=producto[0]%> </p>
        <p>Existencia <%=po.getExistencia()%></p>
        <p>Precio <%=po.getPrecio()%></p>
    </body>
</html>
