<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario 3</title>
    </head>
    <body>
        <h1 align="center">Registro de productos</h1>
        <form action="procform3" method="post" align="center">
            <label>Nombre</label>
            <input input="text" name="nombre"/>
            <br>
            <br>
            <label>Categoria</label>
            <select name="productos">
                <option value="Refrescos">Refrescos</option>
                <option value="Cafe">Cafe</option>
                <option value="Pollo">Pollo</option>
                <option value="Arroz">Arroz</option>
                <option value="Fideo">Fideo</option>
            </select>
            <br>
            <br>
            <label>Existencia</label>
            <input type="text" name="existencia"/>
            <br>
            <br>
            <label>Precio</label>
            <input type="text" name="precio"/>
            <br>
            <br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
