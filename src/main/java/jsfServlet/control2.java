package jsfServlet;

import DAO.catDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import modelo.*;
import DAO.pedDao;
import DAO.detaDao;
import DAO.prodDao;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped
public class control2 implements Serializable {
    List<categoria> liscat;
    List<producto> lisprod;
    String nombre;
    @PostConstruct
    
    public void init(){
        liscat= new catDao().LisCat();
    } 
    
    public void consulta(categoria c){
        nombre = c.getNombre();
        lisprod = new ArrayList<>();
        lisprod = new prodDao().LisProdCat(c.getId());
    }
    
    public control2() {
        nombre = "";
    }

    public List<categoria> getLiscat() {
        return liscat;
    }

    public void setLiscat(List<categoria> liscat) {
        this.liscat = liscat;
    }

    public List<producto> getLisprod() {
        return lisprod;
    }

    public void setLisprod(List<producto> lisprod) {
        this.lisprod = lisprod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
}
