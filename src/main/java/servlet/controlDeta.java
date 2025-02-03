package servlet;

import DAO.detaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.detalle;

public class controlDeta extends HttpServlet {

    detaDao obj = new detaDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adiDeta(request, response);
        if(op==2)actuDeta(request, response);
        if(op==3)ediDeta(request, response);
        if(op==4)anuDeta(request, response);
    }
    
    protected void adiDeta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        detalle p = new detalle();
        String pag = request.getParameter("pag");
        p.setIdPedido(Integer.parseInt(request.getParameter("ipd")));
        p.setIdProducto(Integer.parseInt(request.getParameter("ipr")));
        p.setCantidad(Integer.parseInt(request.getParameter("can")));
        obj.adiDeta(p);
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void actuDeta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        detalle p = new detalle();
        p.setId(Integer.parseInt(request.getParameter("cod")));
        p.setIdPedido(Integer.parseInt(request.getParameter("ipd")));
        p.setIdProducto(Integer.parseInt(request.getParameter("ipr")));
        p.setCantidad(Integer.parseInt(request.getParameter("can")));
        obj.modiDeta(p);
        String pag = "/LisProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void ediDeta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulDeta(nro));
        String pag = "/EditaProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void anuDeta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anuDeta(nro);
        String pag = "/LisProd.jsp";
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
