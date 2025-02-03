
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.detalle;

public class detaDao {
    private Connection cn;
    
    public void adiDeta(detalle d){
    cn= Conexion.getConexion();
    String sql="call sp_addDeta(?,?,?)";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, d.getIdPedido());
       st.setInt(2, d.getIdProducto());
       st.setInt(3, d.getCantidad());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    public void anuDeta(int id){
    cn= Conexion.getConexion();
    String sql="delete from detallepedidos where idDetalle=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setInt(1, id);
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    public void modiDeta(detalle d){
    cn= Conexion.getConexion();
    String sql="update detallepedidos set idPedido=?,idProducto=?,cantidad=? where idDetalle=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setInt(1, d.getIdPedido());
       st.setInt(2, d.getIdProducto());
       st.setInt(3, d.getCantidad());
       st.setInt(4, d.getId());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    public detalle consulDeta(int id){
    cn= Conexion.getConexion();
    detalle d = null;
    String sql="select idDetalle, idPedido, idProducto, cantidad from detallepedidos where idDetalle=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          d = new detalle();
          d.setId(rs.getInt(1));
          d.setIdPedido(rs.getInt(2));
          d.setIdProducto(rs.getInt(3));
          d.setCantidad(rs.getInt(4));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return d;
  }
    
    public List<detalle> LisDeta(){
    List<detalle> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idDetalle, idPedido, idProducto, cantidad from detallepedidos";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       detalle d=new detalle();
       d.setId(rs.getInt(1));
       d.setIdPedido(rs.getInt(2));
       d.setIdProducto(rs.getInt(3));
       d.setCantidad(rs.getInt(4));
       lis.add(d);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    public List<detalle> LisDetaPed(int id){
    List<detalle> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idDetalle, idPedido, idProducto, cantidad from detallepedidos where idPedido=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       detalle d=new detalle();
       d.setId(rs.getInt(1));
       d.setIdPedido(rs.getInt(2));
       d.setIdProducto(rs.getInt(3));
       d.setCantidad(rs.getInt(4));
       lis.add(d);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
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
