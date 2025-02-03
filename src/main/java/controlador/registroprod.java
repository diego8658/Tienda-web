//package controlador;
//
//import DAO.productoDAO;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.RequestDispatcher;
//import modelo.usuario;
//import DAO.usuarioDAO;
//import modelo.producto;
//
//public class registroprod extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("registrarprod.jsp");
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
//        String mensaje = null; // Variable para almacenar el mensaje
//
//        try {
//            // Obtener los parámetros del formulario
//            String nombre = request.getParameter("nombre");
//            String descripcion = request.getParameter("descripcion");
//            String precioString = request.getParameter("precio");
//            String precioCOMS = request.getParameter("precioCOM");
//            String precioVENS = request.getParameter("precioVEN");
//
//            // Validar que los campos no estén vacíos
//            if (nombre.isEmpty() || descripcion.isEmpty() || precioString.isEmpty() || precioCOMS.isEmpty() || precioVENS.isEmpty()) {
//                mensaje = "Error, todos los campos son obligatorios. Por favor, complete el formulario.";
//            } else {
//                // Convertir el DNI a entero
//                double precio = Double.parseDouble(precioString);
//                double precioCOM = Double.parseDouble(precioCOMS);
//                double precioVEN = Double.parseDouble(precioVENS);
//
//                // Crear el objeto usuario
//             producto producto = new producto(nombre, descripcion, precio, precioCOM, precioVEN);
//
//                productoDAO productoDAO = new productoDAO();
//                productoDAO.registrarProducto(producto);
//
//                mensaje = "¡Registro exitoso!";
//            }
//        } catch (NumberFormatException e) {
//            mensaje = "Error, el campo DNI debe ser un número válido.";
//        } catch (Exception e) {
//            mensaje = "Error, intente nuevamente.";
//            e.printStackTrace(); // Imprimir la pila de llamadas en la consola del servidor
//        }
//
//        // Colocar el mensaje en el atributo "mensaje" del request
//        request.setAttribute("mensaje", mensaje);
//
//        // Enviar la solicitud al register.jsp
//        RequestDispatcher dispatcher = request.getRequestDispatcher("registrarprod.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Servlet de registro de productos";
//    }
//}
