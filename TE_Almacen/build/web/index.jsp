<%@page import="com.emergentes.modelo.Productos"%>
<%@page import="java.util.ArrayList"%>
<%
    if(session.getAttribute("producto") == null){
        System.out.println("llega la lista es nula");
        ArrayList<Productos> pro = new ArrayList<Productos>();
        session.setAttribute("producto", pro);
    }
    System.out.println("llega la lista");
    ArrayList<Productos> pr = (ArrayList<Productos>) session.getAttribute("producto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
    </head>
    <body>
        <h1>Productos</h1>
        <a href="ProcesaProductos?op=nuevo">Nuevo producto</a>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Producto</td>
                <td>Precio</td>
                <td>Cantidad</td>
            </tr>
            <%  
            if (pr != null) {
                  for (Productos item:pr) {
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getProducto() %></td>
                <td><%= item.getPrecio() %></td>
                <td><%= item.getCantidad() %></td>
                <td><a href="ProcesaProductos?op=modificar&id=<%= item.getId() %>">Modificar</a></td>
                <td><a href="ProcesaProductos?op=eliminar&id=<%= item.getId() %>" onclick="return(confirm(''))">Eliminar</a></td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
