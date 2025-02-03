<%@page import="modelo.usuario"%>
<%@page import="DAO.Proceso"%>
<%@page import="modelo.Cambio"%>
<%@page import="DAO.prodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gracias por su compra</title>
        <link href="dist/styles.css" rel="stylesheet">
    </head>
    <body class="bg-blue-100">
        <% 
            
            prodDao obj= new prodDao();
            Cambio cm = new Proceso().obtener();
            String mon = "PEN";
            String formato = "S/%.2f";
            double dif = 1;
            HttpSession ses = request.getSession();
            if(ses.getAttribute("mon")!= null){
                mon =(String) ses.getAttribute("mon");
            }
            if(mon.equals("USD")){
                formato = "$%.2f";
                dif = cm.getVenta();
            }else{
                formato = "S/%.2f";
                        dif = 1;
            }
    %>
    <header class="fixed w-full bg-blue-950 shadow-md py-4 z-10">
        <div class="container mx-auto flex justify-between items-center">
            <h1 class="text-2xl font-bold text-gray-100">Lantaqui Store</h1>
            <nav class="flex space-x-4">
                <a href="index.jsp" class="text-gray-100 hover:text-blue-500 transition-colors">Inicio</a>
                <a href="tiendaProductos.jsp" class="text-gray-100 hover:text-blue-500 transition-colors">Tienda</a>
                <a href="tiendaCarrito.jsp" class="text-gray-100 hover:text-blue-500 transition-colors">Carrito</a>
                <a href="#" class="text-gray-100 hover:text-blue-500 transition-colors">Contacto</a>
                <%
                    if(mon.equals("USD")){
                    %>
                    <a class="text-gray-100" href="ControlCambio?opc=1&mon=PEN&pag=Productos">Ver en Soles</a>
                <%
                    }else{
                %>
                <a class="text-gray-100" href="ControlCambio?opc=1&mon=USD&pag=Productos">Ver en Dolares</a>
                <%
                    }
                %>
                <%
                    if(ses.getAttribute("usuario")!=null){
                    usuario usu = (usuario)ses.getAttribute("usuario");
                    %>
                <p class="text-gray-100 font-bold">Bienvenido, <%=usu.getNombre()%></p>
                <%
                    }else{
                %>
                <a href="login.jsp" class="text-gray-100 hover:text-blue-500 transition-colors">Iniciar Sessión</a>
                <%
                    }
                %>
            </nav>
        </div>
    </header>
    <div class="flex items-center justify-center h-screen">
        <div class="bg-white p-10 rounded-lg shadow-lg text-center">
            <h1 class="text-2xl font-bold text-gray-800 mb-4">Gracias por tu compra</h1>
            <p class="text-gray-600 mb-8">Tu pedido ha sido procesado con éxito.</p>
            <a href="tiendaProductos.jsp" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600 transition duration-300">Volver a la tienda</a>
        </div>
    </div>
</body>
</html>
