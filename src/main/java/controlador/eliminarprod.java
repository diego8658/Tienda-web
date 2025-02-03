//package controlador;
//
//import DAO.productoDAO;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.RequestDispatcher;
//
//public class eliminarprod extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        // Lógica para eliminar el producto
//        String idProductoString = request.getParameter("idProducto");
//        String mensaje = null;
//
//        if (idProductoString != null && !idProductoString.isEmpty()) {
//            try {
//                int idProducto = Integer.parseInt(idProductoString);
//                productoDAO productoDAO = new productoDAO();
//                productoDAO.eliminarProducto(idProducto);
//                mensaje = "¡Producto eliminado exitosamente!";
//            } catch (NumberFormatException e) {
//                mensaje = "Error, el ID del producto no es válido.";
//            } catch (Exception e) {
//                mensaje = "Error al intentar eliminar el producto.";
//                e.printStackTrace();
//            }
//        } else {
//            mensaje = "Error, el ID del producto no fue proporcionado.";
//        }
//
//        // Colocar el mensaje en el atributo "mensaje" del request
//        request.setAttribute("mensaje", mensaje);
//
//        // Redirigir de vuelta a la página de productos
//        RequestDispatcher dispatcher = request.getRequestDispatcher("productos.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Servlet para eliminar un producto";
//    }
//}
