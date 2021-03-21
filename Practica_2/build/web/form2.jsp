<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio 2</title>
    </head>
    <body>
        <h1 align="center">Registro de usuarios</h1>
        <form action="procform2" method="post" align="center">
            <label>Nombre</label>
            <input type="text" name="nombre" required />
            <br>
            <br>
            <label>Apellido</label>
            <input type="text" name="apellido" required />
            <br>
            <br>
            <label>Correo Electronico</label>
            <input type="email" name="correo" required />
            <br>
            <br>
            <label>Contraseña</label>
            <input type="password" name="contraseña"/>
            <br>
            <br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
