<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos</title>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <h1 class="titulo">Login</h1>
        <form action="ProcesaUsuario" method="post" class="login">
            <div> 
            <label>Usuario</label>
            <br>
            <input type="text" name="usuario"/>
            </div>
            <div>
            <label>Password</label>
            <br>
            <input type="password" name="password"/>
            </div>
            <div>
            <br>
            <input type="submit" value="Enviar"/>
            </div>
        </form>
    </body>
</html>
