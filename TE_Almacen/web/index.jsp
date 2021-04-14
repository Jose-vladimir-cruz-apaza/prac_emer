<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    request.setAttribute("listados", pr);
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
            %>
                <c:forEach var="list" items="${listados}"> 
            <tr>
                <td>${list.id}</td>
                <td>${list.producto}</td>
                <td>${list.precio}</td>
                <td>${list.cantidad}</td>
                <td><a href="ProcesaProductos?op=modificar&id=${list.id}">Modificar</a></td>
                <td><a href="ProcesaProductos?op=eliminar&id=${list.id}" onclick="return(confirm('Desea Eliminar?'))">Eliminar</a></td>

             </tr>
                </c:forEach>

            <%
                }
            %>
        </table>
    </body>
</html>
