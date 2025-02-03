<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.producto" %>
<%@ page import="DAO.productoDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Producto</title>
        <style>
            /* Estilos CSS */
            /* Estilos de la barra de navegación */
            .navbar {
                overflow: hidden;
                background-color: #333;
            }
            .navbar a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
            .navbar a:hover {
                background-color: #ddd;
                color: black;
            }
            .navbar-right {
                float: right;
            }
            /* Estilos del contenido */
            .content {
                padding: 20px;
                display: flex;
            }
            /* Estilos del formulario de registro */
            .form-container {
                flex: 1;
                max-width: 600px;
                margin-right: 20px;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;
            }
            /* Estilos del contenedor de productos */
            .products-container {
                flex: 1;
            }
            .product {
                margin-bottom: 20px;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            .product h3 {
                margin-top: 0;
            }
            .product-actions {
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <!-- Barra de navegación -->
        <div class="navbar">
            <div class="navbar-left">
                <a href="index.jsp">Home</a>
                <a href="productos.jsp">Productos</a>
                <a href="cesta.jsp">Cesta</a>
            </div>
            <div class="navbar-right">
                <a href="register.jsp">Registro</a>
            </div>
        </div>

        <!-- Contenido -->
        <div class="content">
            <!-- Formulario de registro de productos -->
            <!-- Formulario de registro de productos -->
            <!-- Formulario de registro de productos -->
            <!-- Formulario de registro de productos -->
            <div class="form-container">
                <h1>Registro de Producto</h1>
                <form action="registroprod" method="post">
                    <!-- Campo: Nombre del Producto -->
                    <label for="nombre">Nombre del Producto</label>
                    <br>
                    <input type="text" id="nombre" name="nombre" required>
                    <br>

                    <!-- Campo: Descripción del producto -->
                    <label for="descripcion">Descripción del producto</label>
                    <br>
                    <input type="text" id="descripcion" name="descripcion" required>
                    <br>

                    <!-- Campo: Precio -->
                    <label for="precio">Precio</label>
                    <br>
                    <input type="text" id="precio" name="precio" required>
                    <br>

                    <!-- Campo: Precio de compra del producto -->
                    <label for="precioCOM">Precio de compra del producto</label>
                    <br>
                    <input type="text" id="precioCOM" name="precioCOM" required>
                    <br>

                    <!-- Campo: Precio de venta del producto -->
                    <label for="precioVEN">Precio de venta del producto</label>
                    <br>
                    <input type="text" id="precioVEN" name="precioVEN" required>
                    <br>

                    <!-- Botón para registrar el producto -->
                    <input type="submit" value="Registrar producto">
                </form>
                <!-- Mensaje de éxito o error -->
                <%
                    String mensaje = (String) request.getAttribute("mensaje");
                    if (mensaje != null) {
                        String claseMensaje = mensaje.startsWith("¡Registro exitoso!") ? "success" : "error";
                %>
                <div class="message <%= claseMensaje%>">
                    <%= mensaje%>
                </div>
                <% } %>
            </div>




            <!-- Lista de productos -->
            <div class="products-container">
                <h2>Productos Registrados</h2>
                <%
                    // Obtener la lista de productos desde la base de datos
                    productoDAO productoDAO = new productoDAO();
                    List<producto> productos = productoDAO.listarPRO();
                    // Iterar sobre la lista de productos y mostrar cada uno
                    for (producto p : productos) {
                %>
                <div class="product">
                    <h3><%= p.getNombre()%></h3>
                    <p><strong>Descripción:</strong> <%= p.getDescripcion()%></p>
                    <p><strong>Precio:</strong> <%= p.getPrecio()%></p>
                    <p><strong>Precio de compra:</strong> <%= p.getPrecioCOM()%></p>
                    <p><strong>Precio de venta:</strong><%= p.getPrecioVEN()%></p>
                    <!-- Formulario para eliminar el producto -->
                    <form action="eliminarprod" method="post">
                        <input type="hidden" name="idProducto" value="<%= p.getIdProducto()%>">
                        <input type="submit" value="Eliminar">
                    </form>
                </div>
                <% }%>
            </div>
        </div>
    </body>
</html>
