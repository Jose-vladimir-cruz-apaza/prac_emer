<%@page import="com.emergentes.modelo.Productos"%>
<%
    Productos pro = (Productos) request.getAttribute("miobjpro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Productos</title>
    </head>
    <body>
        <h1>Registro Productos</h1>
        <form action="ProcesaProductos" method="post">
            <label>ID</label>
            <input type="text" name="id" value="<%= pro.getId() %>" size="2" readonly/>
            <br>
            <br>
            <label>Producto</label>
            <input type="text" name="productos" value="<%= pro.getProducto() %>">
            <br>
            <br>
            <label>Precio</label>
            <input type="text" name="precio" value="<%= pro.getPrecio() %>"/>
            <br>
            <br>
            <label>Cantidad</label>
            <input type="number" name="cantidad" value="<%= pro.getCantidad() %>"/>
            <br>
            <br>
            <input type="submit" value="Ingresar"/>
        </form>
    </body>
</html>
