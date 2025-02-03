package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.GProdPre;
import modelo.producto;

public class prodDao {
    private Connection cn;
    
    //funcion para añadir productos con un procedimiento
    public void adiProd(producto p){
    cn= Conexion.getConexion();
    String sql="call sp_addProd(?,?,?,?,?,?,?)";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, p.getNombre());
       st.setString(2, p.getDescripcion());
       st.setDouble(3, p.getPrecio());
       st.setDouble(4, p.getPrecioCOM());
       st.setDouble(5, p.getPrecioVEN());
       st.setInt(6, p.getIdProveedor());
       st.setInt(7, p.getCategoriaid());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    //funcion para elminar producto con id
    public void anuProd(int id){
    cn= Conexion.getConexion();
    String sql="delete from productos where idProducto=?";
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
    
    //funcion para modificar producto recibiendo un objeto producto
    public void modiProd(producto p){
    cn= Conexion.getConexion();
    String sql="update productos set nombre=?,descripcion=?,precio=?,precioCOM=?,precioVEN=?,idproveedor=?,categoriaid=? where idProducto=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setString(1, p.getNombre());
       st.setString(2, p.getDescripcion());
       st.setDouble(3, p.getPrecio());
       st.setDouble(4, p.getPrecioCOM());
       st.setDouble(5, p.getPrecioVEN());
       st.setInt(6, p.getIdProveedor());
       st.setInt(7, p.getCategoriaid());
       st.setInt(8, p.getIdProducto());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    //funcion para consultar producto por id
    public producto consulProd(int id){
    cn= Conexion.getConexion();
    producto p = null;
    String sql="select idProducto, nombre, descripcion, precio, precioCOM, precioVEN,idproveedor,categoriaid from productos where idProducto=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          p = new producto();
          p.setIdProducto(rs.getInt(1));
          p.setNombre(rs.getString(2));
          p.setDescripcion(rs.getString(3));
          p.setPrecio(rs.getDouble(4));
          p.setPrecioCOM(rs.getDouble(5));
          p.setPrecioVEN(rs.getDouble(6));
          p.setIdProveedor(rs.getInt(7));
          p.setCategoriaid(rs.getInt(8));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return p;
  }
    
    //funcion para listar todos los productos
    public List<producto> LisProd(){
    List<producto> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idProducto, nombre, descripcion, precio, precioCOM, precioVEN,idproveedor,categoriaid from productos";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       producto p=new producto();
       p.setIdProducto(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setDescripcion(rs.getString(3));
       p.setPrecio(rs.getDouble(4));
       p.setPrecioCOM(rs.getDouble(5));
       p.setPrecioVEN(rs.getDouble(6));
       p.setIdProveedor(rs.getInt(7));
       p.setCategoriaid(rs.getInt(8));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    public List<producto> LisProdCat(int id){
    List<producto> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idProducto, nombre, descripcion, precio, precioCOM, precioVEN,idproveedor,categoriaid from productos where categoriaid=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       producto p=new producto();
       p.setIdProducto(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setDescripcion(rs.getString(3));
       p.setPrecio(rs.getDouble(4));
       p.setPrecioCOM(rs.getDouble(5));
       p.setPrecioVEN(rs.getDouble(6));
       p.setIdProveedor(rs.getInt(7));
       p.setCategoriaid(rs.getInt(8));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    //funcion para listar los precios y nombres de los productos y por orden
    public List<GProdPre> LisProdPre(){
    List<GProdPre> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="SELECT precio, nombre from productos ORDER BY precio asc";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       GProdPre p=new GProdPre();
       p.setPrecio(rs.getInt(1));
       p.setNombre(rs.getString(2));
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
