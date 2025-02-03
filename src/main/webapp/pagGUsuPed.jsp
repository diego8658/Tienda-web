<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
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
    <center>
        <!-- Se llama a la pagina GUsuPed.jsp mandandole el tipo de grafico que se quiere-->
        <h2>Grafico de Usuario por Cantidad de pedidos</h2>
        <form action="GUsuPed.jsp" target="zona">
            <br><input type="radio" name="tipo" value="bar" onclick="submit()">barra
            <input type="radio" name="tipo" value="line" onclick="submit()">linear
            <input type="radio" name="tipo" value="pie" onclick="submit()">circular
        </form>
        <iframe name="zona" width="100%" height="1000"></iframe>
    </center>
    </body>
</html>