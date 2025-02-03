<%@page import="DAO.provDao"%>
<%@page import="DAO.catDao"%>
<%@page import="modelo.proveedor"%>
<%@page import="modelo.categoria"%>
<%@page import="modelo.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     <%
        producto p =(producto)request.getAttribute("dato");
        catDao obj1 = new catDao();
        provDao obj2 = new provDao();
      %>  
      <!-- Se crea un producto que recibe los datos de producto enviado para rellenar los casilleros
      al presionar submit redirige a controlProd-->
        <h1>Edicion de Producto</h1>
        <form action="controlProd" method="post">
            <table class="table table-bordered">
                <input type="hidden" name="opc" value="2">
                <tr><td>Id<td><input name="cod" value="<%=p.getIdProducto()%>" readonly>
                <tr><td>Nombre<td><input name="nom" value="<%=p.getNombre()%>">
                <tr><td>Direccion<td><input name="des" value="<%=p.getDescripcion()%>">
                <tr><td>Email<td><input name="pre" value="<%=p.getPrecio()%>">
                <tr><td>Telefono<td><input name="prc" value="<%=p.getPrecioCOM()%>">
                <tr><td>Contraseña<td><input name="prv" value="<%=p.getPrecioVEN()%>">
                <tr><td>Categoria<td><select name="cat" required>
                    <%
                        for(categoria c : obj1.LisCat()){
                            %>
                            <option value="<%=c.getId()%>" <%if(c.getId() == p.getCategoriaid()){out.print("selected");}%>><%=c.getNombre()%></option>
                    <%
                        }
                    %>
                </select>
                <tr><td>Proveedor<td><select name="pro" required>
                    <%
                        for(proveedor pv : obj2.LisProv()){
                            %>
                            <option value="<%=pv.getId()%>" <%if(pv.getId() == p.getIdProveedor()){out.print("selected");}%>><%=pv.getNombre()%></option>
                    <%
                        }
                    %>
                </select>
                <tr><td><input type="submit">
            </table>  
        </form>
    </body>
</html>
