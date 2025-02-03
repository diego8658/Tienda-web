/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.detaDao;
import DAO.pedDao;
import DAO.prodDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.detalle;
import modelo.pedido;
import modelo.producto;
import modelo.usuario;

public class controlProd extends HttpServlet {
    
    prodDao obj = new prodDao();
    pedDao obj2 = new pedDao();
    detaDao obj3 = new detaDao();
    //recibe las acciones enviadas y selecciona la opcion enviada
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adiProd(request, response);
        if(op==2)actuProd(request, response);
        if(op==3)ediProd(request, response);
        if(op==4)anuProd(request, response);
        if(op==5)carrito(request, response);
        if(op==6)restarcarrito(request, response);
        if(op==7)eliminarcarrito(request, response);
        if(op==8)registrarcarrito(request, response);
    }
    
    //añadir un producto con servlet
    protected void adiProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        producto p = new producto();
        String pag = request.getParameter("pag");
        p.setNombre(request.getParameter("nom"));
        p.setDescripcion(request.getParameter("des"));
        p.setPrecio(Double.parseDouble(request.getParameter("pre")));
        p.setPrecioCOM(Double.parseDouble(request.getParameter("prc")));
        p.setPrecioVEN(Double.parseDouble(request.getParameter("prv")));
        p.setIdProveedor(Integer.parseInt(request.getParameter("pro")));
        p.setCategoriaid(Integer.parseInt(request.getParameter("cat")));
        obj.adiProd(p);
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //actualizar un producto con servlet
    protected void actuProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        producto p = new producto();
        p.setIdProducto(Integer.parseInt(request.getParameter("cod")));
        p.setNombre(request.getParameter("nom"));
        p.setDescripcion(request.getParameter("des"));
        p.setPrecio(Double.parseDouble(request.getParameter("pre")));
        p.setPrecioCOM(Double.parseDouble(request.getParameter("prc")));
        p.setPrecioVEN(Double.parseDouble(request.getParameter("prv")));
        p.setIdProveedor(Integer.parseInt(request.getParameter("pro")));
        p.setCategoriaid(Integer.parseInt(request.getParameter("cat")));
        obj.modiProd(p);
        String pag = "/LisProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //editar un producto por servlet
    protected void ediProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("dato", obj.consulProd(nro));
        String pag = "/EditaProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //anular un producto por servlet
    protected void anuProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("cod"));
        obj.anuProd(nro);
        String pag = "/LisProd.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("coda"));
        int can=Integer.parseInt(request.getParameter("can"));
        detalle cp= new detalle();
        cp.setCantidad(can);
        cp.setId(0);
        cp.setIdProducto(id);
        List<detalle> lista;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("canasta")==null){
            lista=new ArrayList();
        } else {
            lista=(ArrayList<detalle>)ses.getAttribute("canasta");
        }
        boolean existe=false;
        for(detalle x:lista){
            if(x.getIdProducto() ==id){
                x.setCantidad(x.getCantidad() + can);
                existe=true; break;
            }
        }
          if(!existe) lista.add(cp);
            ses.setAttribute("canasta", lista);
            String pag="tiendaCarrito.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void restarcarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("coda"));
        List<detalle> lista;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("canasta")==null){
            lista=new ArrayList();
        } else {
            lista=(ArrayList<detalle>)ses.getAttribute("canasta");
        }
        for(detalle x:lista){
            if(x.getIdProducto() ==id){
                int ncan = x.getCantidad() - 1;
                if(ncan > 0){
                    x.setCantidad(ncan);
                }else{
                    lista.remove(x);
                }
                break;
            }
        }
            ses.setAttribute("canasta", lista);
            String pag="tiendaCarrito.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void eliminarcarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("coda"));
        List<detalle> lista;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("canasta")==null){
            lista=new ArrayList();
        } else {
            lista=(ArrayList<detalle>)ses.getAttribute("canasta");
        }
        for(detalle x:lista){
            if(x.getIdProducto() ==id){
                lista.remove(x);
                break;
            }
        }
            ses.setAttribute("canasta", lista);
            String pag="tiendaCarrito.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void registrarcarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double tot =Double.parseDouble(String.format("%.2f", Double.parseDouble(request.getParameter("tot"))));
        List<detalle> lista = null;
        int usuid = 0;
        String pag="compraRealizada.jsp";;
        boolean flag = true;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("canasta")==null){
            flag = false;
        } else {
            lista=(ArrayList<detalle>)ses.getAttribute("canasta");
        }
        if(ses.getAttribute("usuario")==null){
            flag = false;
            pag = "login.jsp";
        } else {
            usuario usu =(usuario)ses.getAttribute("usuario");
            usuid = usu.getIdUsuario();
        }
        if(flag){
            pedido p = new pedido();
            p.setIdUser(usuid);
            p.setTotal(tot);
            p.setEstado("Por Entregar");
            int pedid = obj2.adiPed(p);
            for(detalle d:lista){
                detalle aux = new detalle();
                aux.setIdPedido(pedid);
                aux.setIdProducto(d.getIdProducto());
                aux.setCantidad(d.getCantidad());
                obj3.adiDeta(aux);
            }
            ses.setAttribute("canasta", null);
            
        }
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
