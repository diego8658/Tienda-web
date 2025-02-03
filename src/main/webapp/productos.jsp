<%@page import="java.util.Iterator"%>
<%@page import="DAO.productoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.producto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.7/css/dataTables.bootstrap5.css">
   
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
         .product-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .btn-buy {
            background-color: #007bff;
            color: #fff;
            border: none;
        }

        .btn-cart {
            background-color: #28a745;
            color: #fff;
            border: none;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 10px;
        }
        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .navbar-left {
            display: flex;
        }
        .navbar-right {
            display: flex;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="navbar-left">
            <a href="index.jsp">Home</a>
            <a href="productos.jsp">Productos</a>
            <a href="cesta.jsp">Cesta</a>
        </div>
        <div class="navbar-right">
            <a href="login.jsp">Iniciar sesión</a>
        </div>
    </div>
<body>
    <div class="container">
        <div class="row">
            <% 
            productoDAO dao= new productoDAO();
            List<producto> list=dao.listarPRO();
            Iterator<producto> iter=list.iterator();
            producto per=null;
            while(iter.hasNext()){
                per=iter.next();
            %>
            <div class="col-md-4">
                <div class="product-card">
                    <h5><%=per.getNombre()%></h5>
                    <p><%=per.getDescripcion()%></p>
                    <p><strong>Precio: </strong>$<%=per.getPrecio()%></p>
                    <div class="d-grid gap-2">
                        <button class="btn btn-buy" type="button">Comprar</button>
                        <button class="btn btn-cart" type="button">Agregar al carrito</button>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.datatables.net/2.0.7/js/dataTables.js"></script>
<script src="https://cdn.datatables.net/2.0.7/js/dataTables.bootstrap5.js"></script>
<script>new DataTable('#example');</script>
</html>
