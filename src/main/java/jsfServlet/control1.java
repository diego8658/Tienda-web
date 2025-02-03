package jsfServlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import modelo.*;
import DAO.usuDao;
import DAO.pedDao;
import DAO.detaDao;
import DAO.prodDao;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped
public class control1 implements Serializable {
    List<usuario> liscli;
    List<pedido> lisped;
    List<detalle> lisdet;
    List<det2> lisdet2;
    String nombre;
    int facid;
    double total;
    @PostConstruct
    
    public void init(){
        liscli= new usuDao().LisUsu();
    } 
    
    public void consulta(usuario a){
        nombre = a.getNombre();
        lisped = new ArrayList<>();
        lisped = new pedDao().LisPedUsu(a.getIdUsuario());
    }
    
    public void consulta2(pedido a){
        facid = a.getId();
        lisdet = new ArrayList<>();
        lisdet = new detaDao().LisDetaPed(a.getId());
        lisdet2 = new ArrayList<>();
        prodDao prodDao = new prodDao();
        total = 0;
        for(detalle x:lisdet){
            det2 aux = new det2();
            aux.setCodigo(x.getId());
            aux.setDesc(prodDao.consulProd(x.getIdProducto()).getDescripcion());
            aux.setCantidad(x.getCantidad());
            aux.setPrecio(prodDao.consulProd(x.getIdProducto()).getPrecio());
            lisdet2.add(aux);
            total +=x.getCantidad()* prodDao.consulProd(x.getIdProducto()).getPrecio();
        }
    }
    public control1() {
        nombre = "";
        facid = 0;
    }
    
    public List<usuario> getLiscli() {
        return liscli;
    }

    public void setLiscli(List<usuario> liscli) {
        this.liscli = liscli;
    }

    public List<pedido> getLisped() {
        return lisped;
    }

    public void setLisped(List<pedido> lisped) {
        this.lisped = lisped;
    }

    public List<detalle> getLisdet() {
        return lisdet;
    }

    public void setLisdet(List<detalle> lisdet) {
        this.lisdet = lisdet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFacid() {
        return facid;
    }

    public void setFacid(int facid) {
        this.facid = facid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<det2> getLisdet2() {
        return lisdet2;
    }

    public void setLisdet2(List<det2> lisdet2) {
        this.lisdet2 = lisdet2;
    }
    
    
}
