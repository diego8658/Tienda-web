<%@page import="modelo.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     <%
         usuario u =(usuario)request.getAttribute("dato");
      %>  
      <!-- Se crea un usuario que recibe los datos de usuario enviado para rellenar los casilleros
      al presionar submit redirige a controlUsu-->
        <h1>Edicion de Usuario</h1>
        <form action="controlUsu" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="2">
                <tr><td>Id<td><input name="cod" value="<%=u.getIdUsuario()%>" readonly>
                <tr><td>Nombre<td><input name="nom" value="<%=u.getNombre()%>">
                <tr><td>Direccion<td><input name="ape" value="<%=u.getApellido()%>">
                <tr><td>Email<td><input name="dni" value="<%=u.getDni()%>">
                <tr><td>Telefono<td><input name="cor" value="<%=u.getCorreo()%>">
                <tr><td>Contraseña<td><input name="cla" value="<%=u.getClave()%>">
                <tr><td><input type="submit">
            </table>  
        </form>
    </body>
</html>
