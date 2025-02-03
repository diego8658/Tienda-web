<%@page import="modelo.usuario"%>
<%@page import="DAO.usuDao"%>
<%@page import="modelo.producto"%>
<%@page import="DAO.prodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <%
            usuDao obj = new usuDao();
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
        <h1>Lista de Usuarios</h1>
        <a href="AdiUsu.jsp">Registra Usuario</a>
        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black"><th>IdUsuario<th>Nombre<th>Apellido<th>Dni<th>Correo<th>Contraseña<th>Edita<th>Anula
            </thead>
            <%
                for (usuario x : obj.LisUsu()) {
                    out.print("<tr><td>" + x.getIdUsuario()+ "<td>" + x.getNombre()+ "<td>" + x.getApellido()+ "<td>" + x.getDni()+ "<td>" + x.getCorreo()+ "<td>" + x.getClave());
                    %>
                    <td><a href="controlUsu?opc=3&cod=<%=x.getIdUsuario()%>">Edita</a><td><a href="controlUsu?opc=4&cod=<%=x.getIdUsuario()%>">Anula</a>
            <%
                }
            %>
        </table>
    </body>
</html>
