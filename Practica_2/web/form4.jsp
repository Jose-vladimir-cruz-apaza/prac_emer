<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>formulario 4</title>
    </head>
    <body>
        <h1 align="center">Registro de libros</h1>
        <form action="ProclLibros" method="post" align="center">
            <label>Titulo</label>
            <input type="text" name="titulo"/>
            <br>
            <br>
            <label>Autor</label>
            <input type="text" name="autor"/>
            <br>
            <br>
            <label>Resumen</label>
            <textarea name="resumen" rows="5" cols="20">
                Introduzca su resumen
            </textarea>
            <br>
            <br>
            <label>Medio</label>
            <br>
            <input type="radio" name="medio" value="fisico">
            <label>Fisico</label><br>
            <input type="radio" name="medio" value="magnetico">
            <label for="female">Magnetico</label><br>
            <br>
            <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
