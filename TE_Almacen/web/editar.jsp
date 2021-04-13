<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Productos</title>
    </head>
    <body>
        <jsp:useBean id="miobjpro" scope="request" class="com.emergentes.modelo.Productos" />
        <h1>Registro Productos</h1>
        <form action="ProcesaProductos" method="post">
            <label>ID</label>
            <input type="text" name="id" value="<jsp:getProperty name="miobjpro" property="id" />" size="2" readonly/>
            <br>
            <br>
            <label>Producto</label>
            <input type="text" name="productos" value="<jsp:getProperty name="miobjpro" property="producto" />">
            <br>
            <br>
            <label>Precio</label>
            <input type="text" name="precio" value="<jsp:getProperty name="miobjpro" property="precio" />"/>
            <br>
            <br>
            <label>Cantidad</label>
            <input type="number" name="cantidad" value="<jsp:getProperty name="miobjpro" property="cantidad" />"/>
            <br>
            <br>
            <input type="submit" value="Ingresar"/>
        </form>
    </body>
</html>
