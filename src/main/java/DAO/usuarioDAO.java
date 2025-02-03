/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package DAO;
//
// 
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import modelo.usuario;
//import conexion.Conexion;
//
//public class usuarioDAO {
//
//   public int registrarUsuario(usuario usuario) throws ClassNotFoundException, SQLException {
//    String query = "INSERT INTO usuarios (nam_us, ape_us, dni, correo, clave) VALUES (?, ?, ?, ?, ?)";
//    int result = 0;
//    
//    // Obtener la conexión usando la clase Conexion
//    Conexion conexion = new Conexion();
//    try (Connection connection = conexion.getConnection();
//         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//        
//        preparedStatement.setString(1, usuario.getNombre());
//        preparedStatement.setString(2, usuario.getApellido());
//        preparedStatement.setInt(3, usuario.getDni());
//        preparedStatement.setString(4, usuario.getCorreo());
//        preparedStatement.setString(5, usuario.getClave());
//
//        result = preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//        throw e;
//    }
//    return result;
//}
//
//}
