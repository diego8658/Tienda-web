//package controlador;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.RequestDispatcher;
//import modelo.usuario;
//import DAO.usuarioDAO;
//
//public class registro extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
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
//            String apellido = request.getParameter("apellido");
//            String dniString = request.getParameter("dni");
//            String correo = request.getParameter("correo");
//            String clave = request.getParameter("clave");
//
//            // Validar que los campos no estén vacíos
//            if (nombre.isEmpty() || apellido.isEmpty() || dniString.isEmpty() || correo.isEmpty() || clave.isEmpty()) {
//                mensaje = "Error, todos los campos son obligatorios. Por favor, complete el formulario.";
//            } else {
//                // Convertir el DNI a entero
//                int dni = Integer.parseInt(dniString);
//
//                // Crear el objeto usuario
//                usuario usuario = new usuario(nombre, apellido, dni, correo, clave);
//                usuarioDAO usuarioDAO = new usuarioDAO();
//                usuarioDAO.registrarUsuario(usuario);
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
//        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Servlet de registro de usuarios";
//    }
//}
