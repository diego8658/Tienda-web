<%@page import="modelo.proveedor"%>
<%@page import="modelo.categoria"%>
<%@page import="DAO.provDao"%>
<%@page import="DAO.catDao"%>
<%@page import="modelo.producto"%>
<%@page import="DAO.prodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            prodDao obj = new prodDao();
            catDao obj2 = new catDao();
            provDao obj3 = new provDao();
        %>
        <!--Se Crea Menu-->
        <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <a class="navbar-brand" href="#">Pagina Principal</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="LisUsu.jsp">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="LisProd.jsp">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="jsfClixPed.xhtml">Jsf1</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="jsfProdxCat.xhtml">Jsf2</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="pagGProdPre.jsp">Grafico1</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="pagGUsuPed.jsp">Grafico2</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
        <!-- Se rellena la tabla con los productos-->
        <h1>Lista de Productos</h1>
        <a href="AdiProd.jsp">Registra Producto</a>
        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black"><th>IdProducto<th>Nombre<th>Descripcion<th>Precio<th>PrecioCOM<th>PrecioVEN<th>Proveedor<th>Categoria<th>Edita<th>Anula
            </thead>
            <%
                for (producto x : obj.LisProd()) {
                    categoria c = obj2.consulCat(x.getCategoriaid());
                    proveedor p = obj3.consulProv(x.getIdProveedor());
                    out.print("<tr><td>" + x.getIdProducto()+ "<td>" + x.getNombre()+ "<td>" + x.getDescripcion()+ "<td>" + x.getPrecio()+ "<td>" + x.getPrecioCOM()+ "<td>" + x.getPrecioVEN()+"<td>"+p.getNombre()+"<td>"+c.getNombre());
                    %>
                    <td><a href="controlProd?opc=3&cod=<%=x.getIdProducto()%>">Edita</a><td><a href="controlProd?opc=4&cod=<%=x.getIdProducto()%>">Anula</a>
            <%
                }
            %>
        </table>
    </body>
</html>
