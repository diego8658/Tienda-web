<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Usuarios</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!-- Se implementa un form donde se ingresan los datos del usuario que al presionar submit redirige a controlUsu-->
        <h1>Registro de Usuarios</h1>
        <form action="controlUsu" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="1">
                <input type="hidden" name="pag" value="LisUsu.jsp">
                <tr><td>Nombre<td><input name="nom" required>
                <tr><td>Apellido<td><input name="ape" required>
                <tr><td>Dni<td><input name="dni" required>
                <tr><td>Correo<td><input name="cor" required>
                <tr><td>Clave<td><input name="cla" required>
                <tr><td><input type="submit">
            </table>   
        </form>
    </body>
</html>
