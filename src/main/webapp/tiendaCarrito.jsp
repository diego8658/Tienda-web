<%@page import="DAO.Proceso"%>
<%@page import="modelo.Cambio"%>
<%@page import="modelo.usuario"%>
<%@page import="modelo.producto"%>
<%@page import="DAO.prodDao"%>
<%@page import="modelo.detalle"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito</title>
    <link href="dist/styles.css" rel="stylesheet">
    <link rel="icon" href="">
</head>

<body class="bg-blue-100 text-gray-800">
    <% 
            HttpSession ses = request.getSession();
            List<detalle> lista = new ArrayList<detalle>();
            lista = (ArrayList<detalle>) ses.getAttribute("canasta");
            prodDao obj= new prodDao();
            Cambio cm = new Proceso().obtener();
            String mon = "PEN";
            String formato = "S/%.2f";
            double dif = 1;
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
                    <a class="text-gray-100" href="ControlCambio?opc=1&mon=PEN&pag=Carrito">Ver en Soles</a>
                <%
                    }else{
                %>
                <a class="text-gray-100" href="ControlCambio?opc=1&mon=USD&pag=Carrito">Ver en Dolares</a>
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
        <div class="bg-blue-50 p-8 rounded-lg shadow-lg">
            <h1 class="text-center font-bold text-4xl pb-7">Carrito de Compras</h1>
            <table class="min-w-full bg-blue-50 text-center">
                <thead class="bg-gray-200">
                    <tr>
                        <th class="w-1/6 px-4 py-2">Cantidad</th>
                        <th class="w-1/6 px-4 py-2">Imagen</th>
                        <th class="w-2/6 px-4 py-2">Descripción</th>
                        <th class="w-1/6 px-4 py-2">Precio</th>
                        <th class="w-1/6 px-4 py-2">IGV</th>
                        <th class="w-1/6 px-4 py-2">Precio Unitario</th>
                        <th class="w-1/6 px-4 py-2">Total</th>
                        <th class="w-1/6 px-4 py-2">Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        producto p = new producto();
                        double total = 0;
                        if(lista!=null){
                        for(detalle cp:lista){
                        p= obj.consulProd(cp.getIdProducto());
                        double precio = p.getPrecio()*0.82;
                        double igv = p.getPrecio()*0.18;
                        double tot = cp.getCantidad()*p.getPrecio();
                    %>
                    <tr class="border-b">
                        <td class="px-4 py-2 text-center">
                            <div class="flex justify-around">
                                <a class="w-min h-min bg-blue-500 px-1.5 rounded text-white font-bold" href="controlProd?opc=5&coda=<%=cp.getIdProducto()%>&can=1">+</a>
                                <%=cp.getCantidad()%>
                                <a class="w-min h-min bg-blue-500 px-1.5 rounded text-white font-bold" href="controlProd?opc=6&coda=<%=cp.getIdProducto()%>">-</a>
                            </div>
                        </td>
                        <td><div class="flex justify-center"><img src="img/<%=cp.getIdProducto()%>.webp" class="w-20 h-20"></div></td>
                        <td class="px-4 py-2"><%=p.getDescripcion()%></td>
                        <td class="px-4 py-2 text-center"><%=String.format(formato, precio/dif)%></td>
                        <td class="px-4 py-2 text-center"><%=String.format(formato, igv/dif)%></td>
                        <td class="px-4 py-2 text-center"><%=String.format(formato, p.getPrecio()/dif)%></td>
                        <td class="px-4 py-2 text-center"><%=String.format(formato, tot/dif)%></td>
                        <td><a href="controlProd?coda=<%=cp.getIdProducto()%>&opc=7" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Eliminar</a></td>
                    </tr>
                    <%
                        total = total + tot;
                        }
                        }
                    %>
                </tbody>
                <tfoot class="bg-gray-200">
                    <tr>
                        <td colspan="4"></td>
                        <td class="px-4 py-2 font-semibold text-right" colspan="2">Total a pagar:</td>
                        <td class="px-4 py-2 font-bold"><%=String.format(formato, total/dif)%></td>
                        <td class="px-4 py-2 font-semibold"></td>
                    </tr>
                </tfoot>
            </table>
            <div class="mt-4 flex justify-between">
                <a href="tiendaProductos.jsp" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Seguir Comprando</a>
                <a href="controlProd?opc=8&tot=<%=total%>" class="px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600">Comprar</a>
            </div>
        </div>
    </div>
</body>

</html>