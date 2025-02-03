package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.categoria;

public class catDao {
    private Connection cn;
    
    public List<categoria> LisCat(){
    List<categoria> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select id, nombre from categoria";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       categoria c =new categoria();
       c.setId(rs.getInt(1));
       c.setNombre(rs.getString(2));
       lis.add(c);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    public categoria consulCat(int id){
    cn= Conexion.getConexion();
    categoria c = null;
    String sql="select id, nombre from categoria where id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          c = new categoria();
          c.setId(rs.getInt(1));
          c.setNombre(rs.getString(2));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return c;
  }
    
    private void close() {

        try {
           if(cn!=null)cn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar :"+e.getMessage());
            e.printStackTrace();
        }

    }
}
