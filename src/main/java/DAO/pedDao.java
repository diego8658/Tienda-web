package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.pedido;

public class pedDao {
    private Connection cn;
    
    public int adiPed(pedido p){
    cn= Conexion.getConexion();
    String sql="call sp_addPed(?,?,?,@nuevoId)";
    int id = 1;
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, p.getIdUser());
       st.setDouble(2, p.getTotal());
       st.setString(3, p.getEstado());
       st.executeUpdate();
       sql = "select @nuevoId as nuevoId";
       st=cn.prepareStatement(sql);
       ResultSet rs=st.executeQuery();
       if(rs.next()){
          id = rs.getInt(1);
      }
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
        return id;
  }
    
    public void anuPed(int id){
    cn= Conexion.getConexion();
    String sql="delete from pedido where idPedido=?";
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
    public void modiPed(pedido p){
    cn= Conexion.getConexion();
    String sql="update pedidos set idUser=?,fechaPedido=?,total=?,estado=? where idPedido=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setInt(1, p.getIdUser());
       st.setDate(2,Date.valueOf(p.getFecha()));
       st.setDouble(3, p.getTotal());
       st.setString(4, p.getEstado());
       st.setInt(5, p.getId());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    public pedido consulPed(int id){
    cn= Conexion.getConexion();
    pedido p = null;
    String sql="select idPedido, idUser, fechaPedido, total, estado from pedidos where idPedido=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          p = new pedido();
          p.setId(rs.getInt(1));
          p.setIdUser(rs.getInt(2));
          p.setFecha(rs.getString(3));
          p.setTotal(rs.getDouble(4));
          p.setEstado(rs.getString(5));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return p;
  }
    
    public List<pedido> LisPed(){
    List<pedido> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idPedido, idUser, fechaPedido, total, estado from pedidos";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       pedido p=new pedido();
       p.setId(rs.getInt(1));
       p.setIdUser(rs.getInt(2));
       p.setFecha(rs.getString(3));
       p.setTotal(rs.getDouble(4));
       p.setEstado(rs.getString(5));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    public List<pedido> LisPedUsu(int id){
    List<pedido> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idPedido, idUser, fechaPedido, total, estado from pedidos where idUser=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       pedido p=new pedido();
       p.setId(rs.getInt(1));
       p.setIdUser(rs.getInt(2));
       p.setFecha(rs.getString(3));
       p.setTotal(rs.getDouble(4));
       p.setEstado(rs.getString(5));
       lis.add(p);
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
