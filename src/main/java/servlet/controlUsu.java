package servlet;

import DAO.usuDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.usuario;


public class controlUsu extends HttpServlet {

    usuDao obj = new usuDao();
    //recibe las acciones enviadas y selecciona la opcion enviada
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adiUsu(request, response);
        if(op==2)actuUsu(request, response);
        if(op==3)ediUsu(request, response);
        if(op==4)anuUsu(request, response);
        if(op==5)login(request, response);
        if(op==6)register(request, response);
    }
    
    //añade usuario por servlet
    protected void adiUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuario u = new usuario();
        String pag = request.getParameter("pag");
        u.setNombre(request.getParameter("nom"));
        u.setApellido(request.getParameter("ape"));
        u.setDni(Integer.parseInt(request.getParameter("dni")));
        u.setCorreo(request.getParameter("cor"));
        u.setClave(request.getParameter("cla"));
        obj.adiUsu(u);
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //actualiza usuario por servlet
    protected void actuUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuario u = new usuario();
        u.setIdUsuario(Integer.parseInt(request.getParameter("cod")));
        u.setNombre(request.getParameter("nom"));
        u.setApellido(request.getParameter("ape"));
        u.setDni(Integer.parseInt(request.getParameter("dni")));
        u.setCorreo(request.getParameter("cor"));
        u.setClave(request.getParameter("cla"));
        obj.modiUsu(u);
        String pag = "/LisUsu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //edita usuario por servlet
    protected void ediUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulUsu(nro));
        String pag = "/EditaUsu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //elimina usuario por servlet
    protected void anuUsu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anuUsu(nro);
        String pag = "/LisUsu.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");
        usuario aux = obj.obtenerUsu(correo, contra);
        String pag;
        if(aux == null){
            pag = "/login.jsp";
            request.setAttribute("msg", "usuario o contraseña incorrectos");
        }else{
            HttpSession ses =request.getSession();
            ses.setAttribute("usuario", aux);
            pag = "/tiendaProductos.jsp";
            
        }
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        int dni = Integer.parseInt(request.getParameter("dni"));
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");
        usuario aux = new usuario();
        aux.setNombre(nombre);
        aux.setApellido(apellido);
        aux.setDni(dni);
        aux.setCorreo(correo);
        aux.setClave(contra);
        obj.adiUsu(aux);
        HttpSession ses =request.getSession();
        ses.setAttribute("usuario", aux);
        String pag = "/tiendaProductos.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
