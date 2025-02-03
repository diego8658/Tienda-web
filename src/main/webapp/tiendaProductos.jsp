<%@page import="modelo.usuario"%>
<%@page import="DAO.Proceso"%>
<%@page import="modelo.Cambio"%>
<%@page import="java.util.List"%>
<%@page import="modelo.producto"%>
<%@page import="DAO.prodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda</title>
    <link href="dist/styles.css" rel="stylesheet">
    <link rel="icon" href="">
</head>

<body class="bg-blue-100 text-gray-800">
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
    <div class="container mx-auto py-24">
        <h1 class="pb-10 text-4xl font-bold text-center">Tienda de productos</h1>
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-20">
            <%
                for(producto p:obj.LisProd()){
            %>
                <div
                    class="bg-white shadow-lg rounded-xl p-6 flex flex-col items-center justify-center transform transition duration-300 hover:scale-105">
                    <img src="img/<%=p.getIdProducto()%>.webp" class="pb-5">
                    <h1 class="text-xl font-semibold mb-2"><%=p.getDescripcion()%></h1>
                    <p class="text-lg text-green-600 font-bold mb-4"><%=String.format(formato, p.getPrecio()/dif)%></p>
                    <form class="w-full flex justify-around items-center pb-4" action="controlProd">
                        <button type="submit" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600 h-min transition-colors">Añadir al
                            carrito</button>
                        <div class="flex items-center">
                            <input type="number" value="<%=p.getIdProducto()%>" name="coda" hidden>
                            <input type="number" value="5" name="opc" hidden>
                            <input type="number" id="cantidad-1" name="can" min="1" step="1" value="1"
                                class="p-2 border border-gray-300 rounded w-16">
                        </div>

                    </form>
                </div>
                <%
                    }
                %>
        </div>
    </div>
</body>

</html>