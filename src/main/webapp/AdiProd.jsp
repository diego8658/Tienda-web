<%@page import="modelo.proveedor"%>
<%@page import="modelo.categoria"%>
<%@page import="DAO.provDao"%>
<%@page import="DAO.catDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Productos</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            catDao obj1 = new catDao();
            provDao obj2 = new provDao();
        %>
       <!-- Se implementa un form donde se ingresan los datos del producto que al presionar submit redirige a controlProd-->
        <h1>Registro de Productos</h1>
        <form action="controlProd" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="1">
                <input type="hidden" name="pag" value="LisProd.jsp">
                <tr><td>Nombre<td><input name="nom" required>
                <tr><td>Descripcion<td><input name="des" required>
                <tr><td>Precio<td><input name="pre" required>
                <tr><td>Precio Compra<td><input name="prc" required>
                <tr><td>Precio Venta<td><input name="prv" required>
                <tr><td>Categoria<td><select name="cat" required>
                    <%
                        for(categoria c : obj1.LisCat()){
                            %>
                            <option value="<%=c.getId()%>"><%=c.getNombre()%></option>
                    <%
                        }
                    %>
                </select>
                <tr><td>Proveedor<td><select name="pro" required>
                    <%
                        for(proveedor p : obj2.LisProv()){
                            %>
                            <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
                    <%
                        }
                    %>
                </select>
                <tr><td><input type="submit">
            </table>   
        </form>
    </body>
</html>
