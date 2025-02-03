package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.proveedor;

public class provDao {
    private Connection cn;
    
    public List<proveedor> LisProv(){
    List<proveedor> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select Proveedor_id, nombre, email, direccion, telefono from proveedores";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       proveedor p =new proveedor();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setEmail(rs.getString(3));
       p.setDireccion(rs.getString(4));
       p.setTelefono(rs.getString(5));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    public proveedor consulProv(int id){
    cn= Conexion.getConexion();
    proveedor p = null;
    String sql="select Proveedor_id, nombre, email, direccion, telefono from proveedores where Proveedor_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          p = new proveedor();
          p.setId(rs.getInt(1));
          p.setNombre(rs.getString(2));
          p.setEmail(rs.getString(3));
          p.setDireccion(rs.getString(4));
          p.setTelefono(rs.getString(5));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return p;
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
