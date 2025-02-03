package servlet;

import DAO.pedDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.pedido;

public class controlPed extends HttpServlet {

    pedDao obj = new pedDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adiPed(request, response);
        if(op==2)actuPed(request, response);
        if(op==3)ediPed(request, response);
        if(op==4)anuPed(request, response);
    }
    
    protected void adiPed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pedido p = new pedido();
        String pag = request.getParameter("pag");
        p.setIdUser(Integer.parseInt(request.getParameter("ius")));
        p.setFecha(request.getParameter("fec"));
        p.setTotal(Double.parseDouble(request.getParameter("tot")));
        p.setEstado(request.getParameter("est"));
        obj.adiPed(p);
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void actuPed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pedido p = new pedido();
        p.setId(Integer.parseInt(request.getParameter("cod")));
        p.setIdUser(Integer.parseInt(request.getParameter("ius")));
        p.setFecha(request.getParameter("fec"));
        p.setTotal(Double.parseDouble(request.getParameter("tot")));
        p.setEstado(request.getParameter("est"));
        obj.modiPed(p);
        String pag = "/LisProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void ediPed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulPed(nro));
        String pag = "/EditaProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void anuPed(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anuPed(nro);
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
