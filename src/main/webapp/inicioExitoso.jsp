<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        /* Estilos CSS */
        /* ... */
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">¡Bienvenido!</h2>
        <div class="alert alert-success mt-3" role="alert">
            Has iniciado sesión correctamente como <%= session.getAttribute("nombreUsuario") %>.
        </div>
        <!-- Aquí puedes agregar cualquier contenido adicional que desees mostrar al usuario después de iniciar sesión -->
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</html>
