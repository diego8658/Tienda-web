/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.GUsuPed;
import modelo.usuario;

public class usuDao {
    
    private Connection cn;
    
    public usuDao(){
    }
    
    //funcion para añadir usuario por procedimiento
    public void adiUsu(usuario u){
    cn= Conexion.getConexion();
    String sql="call sp_addUsu(?,?,?,?,?)";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, u.getNombre());
       st.setString(2, u.getApellido());
       st.setInt(3, u.getDni());
       st.setString(4, u.getCorreo());
       st.setString(5, u.getClave());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    //funcion para eliminar usuario por id
    public void anuUsu(int id){
    cn= Conexion.getConexion();
    String sql="delete from usuarios where idUsuario=?";
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
    
    //funcion para modificar usuario por un objeto usuario
    public void modiUsu(usuario u){
    cn= Conexion.getConexion();
    String sql="update usuarios set nam_us=?,ape_us=?,dni=?,correo=?,clave=? where idUsuario=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setString(1, u.getNombre());
       st.setString(2, u.getApellido());
       st.setInt(3, u.getDni());
       st.setString(4, u.getCorreo());
       st.setString(5, u.getClave());
       st.setInt(6, u.getIdUsuario());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
  }
    
    //funcion para consultar usuario por id
    public usuario consulUsu(int id){
    cn= Conexion.getConexion();
    usuario u = null;
    String sql="select idUsuario, nam_us, ape_us, dni, correo, clave from usuarios where idUsuario=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          u = new usuario();
          u.setIdUsuario(rs.getInt(1));
          u.setNombre(rs.getString(2));
          u.setApellido(rs.getString(3));
          u.setDni(rs.getInt(4));
          u.setCorreo(rs.getString(5));
          u.setClave(rs.getString(6));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return u;
  }
    
    //funcion para listar todos los usuarios
    public List<usuario> LisUsu(){
    List<usuario> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select idUsuario, nam_us, ape_us, dni, correo, clave from usuarios";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       usuario u=new usuario();
       u.setIdUsuario(rs.getInt(1));
       u.setNombre(rs.getString(2));
       u.setApellido(rs.getString(3));
       u.setDni(rs.getInt(4));
       u.setCorreo(rs.getString(5));
       u.setClave(rs.getString(6));
       lis.add(u);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    //funcion para listar los numeros de pedidos que realizan los clientes en orden descendente
    public List<GUsuPed> LisUsuPed(){
    List<GUsuPed> lis=new ArrayList();
    cn= Conexion.getConexion();
    try{
     String sql="select u.nam_us, COUNT(*) as nropedidos FROM usuarios u inner join pedidos p WHERE u.idUsuario = p.idUser GROUP BY u.idUsuario ORDER BY nropedidos DESC";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       GUsuPed p=new GUsuPed();
       p.setPedidos(rs.getInt(2));
       p.setNombre(rs.getString(1));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
            close();
        }
    return lis;   
   }
    
    public usuario obtenerUsu(String correo,String contra){
    cn= Conexion.getConexion();
    usuario u = null;
    String sql="select idUsuario, nam_us, ape_us, dni, correo, clave from usuarios where correo=? and clave=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, correo);
       st.setString(2, contra);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          u = new usuario();
          u.setIdUsuario(rs.getInt(1));
          u.setNombre(rs.getString(2));
          u.setApellido(rs.getString(3));
          u.setDni(rs.getInt(4));
          u.setCorreo(rs.getString(5));
          u.setClave(rs.getString(6));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }finally{
            close();
        }
    return u;
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
