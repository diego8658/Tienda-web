<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tienda Online</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            overflow-x: hidden; /* Para ocultar la barra de desplazamiento horizontal */
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #343a40;
            padding: 10px;
        }
        .navbar a {
            color: #fff;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
        }
        .navbar a:hover {
            background-color: #495057;
        }
        .navbar-left {
            display: flex;
        }
        .navbar-right {
            display: flex;
        }
        .content {
            padding: 50px;
            text-align: center;
        }
        .title {
            font-size: 48px;
            color: #343a40;
            margin-bottom: 20px;
            animation: moveUpDown 4s ease infinite;
        }
        @keyframes moveUpDown {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }
        .tagline {
            font-size: 24px;
            color: #6c757d;
            margin-bottom: 40px;
        }
        .features {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 20px;
            margin-bottom: 50px;
        }
        .feature {
            width: 300px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
            position: relative;
        }
        .feature:hover {
            transform: translate(0, -5px);
        }
        .feature:hover .info {
            animation: moveSlightly 2s ease-in-out infinite alternate;
        }
        @keyframes moveSlightly {
            0% {
                transform: translateY(0) translateX(0);
            }
            25% {
                transform: translateY(-5px) translateX(5px);
            }
            50% {
                transform: translateY(0) translateX(0);
            }
            75% {
                transform: translateY(5px) translateX(-5px);
            }
            100% {
                transform: translateY(0) translateX(0);
            }
        }
        .feature h3 {
            font-size: 24px;
            color: #343a40;
            margin-bottom: 10px;
        }
        .feature p {
            color: #6c757d;
            margin-bottom: 20px;
        }
        .cta-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .cta-button:hover {
            background-color: #0056b3;
        }
        .wave {
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            height: auto;
            z-index: -1;
            opacity: 0.5;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="navbar-left">
            <a href="">Home</a>
            <a href="tiendaProductos.jsp">Productos</a>
            <a href="tiendaCarrito.jsp">Carrito</a>
        </div>
        <div class="navbar-right">
            <a href="login.jsp">Iniciar sesión</a>
        </div>
    </div>

    <div class="content">
        <h1 class="title">¡Bienvenido a Lantaqui Store!<br>Descubre una experiencia de compra como ninguna otra.</h1>
        
        <div class="features">
            <div class="feature">
                <h3>Variedad de Productos</h3>
                <p>Encuentra una amplia selección de productos de calidad para todas tus necesidades.</p>
                <div class="info"></div>
            </div>
            <div class="feature">
                <h3>Envío Rápido</h3>
                <p>Entrega rápida y confiable directamente a tu puerta.</p>
                <div class="info"></div>
            </div>
            <div class="feature">
                <h3>Atención al Cliente</h3>
                <p>Nuestro equipo de atención al cliente está aquí para ayudarte en todo momento.</p>
                <div class="info"></div>
            </div>
        </div>
        
        <a href="tiendaProductos.jsp" class="cta-button">Explora Nuestros Productos</a>
    </div>

    <img src="https://images.unsplash.com/photo-1569785287311-2a555a9d6c" alt="Fondo" class="wave">
    
    <script>
        // Agrega la clase 'moveSlightly' cuando se pasa el cursor sobre un cuadro de características
        const features = document.querySelectorAll('.feature');
        features.forEach(feature => {
            feature.addEventListener('mouseover', () => {
                feature.querySelector('.info').classList.add('moveSlightly');
            });
            feature.addEventListener('mouseout', () => {
                feature.querySelector('.info').classList.remove('moveSlightly');
            });
        });
    </script>
</body>
</html>
