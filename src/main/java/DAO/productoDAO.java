//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import conexion.Conexion;
//import modelo.producto;
//
//public class productoDAO {
//
//    PreparedStatement ps;
//    ResultSet rs;
//    Connection con;
//    Conexion conec = new Conexion();
//
//   public List<producto> listarPRO() {
//    ArrayList<producto> Listar = new ArrayList<>();
//    String sql = "SELECT * FROM productos";
//    try {
//        con = conec.getConnection();
//        ps = con.prepareStatement(sql);
//        rs = ps.executeQuery();
//        while (rs.next()) {
//            producto p = new producto(
//                rs.getInt("idProducto"),
//                rs.getString("nombre"),
//                rs.getString("descripcion"),
//                rs.getDouble("precio"),
//                rs.getDouble("precioCOM"),
//                rs.getDouble("precioVEN"),
//                rs.getInt("idProveedor")
//                //rs.getBytes("imagen")
//            );
//            Listar.add(p);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        // Cerrar recursos (ps, rs y con) aquí si es necesario
//    }
//    return Listar;
//}
//
//    public int registrarProducto(producto producto) throws ClassNotFoundException, SQLException {
//    String query = "INSERT INTO productos (nombre, descripcion, precio, precioCOM, precioVEN) VALUES (?, ?, ?, ?, ?)";
//    int result = 0;
//    
//    // Obtener la conexión usando la clase Conexion
//    Conexion conexion = new Conexion();
//    try (Connection connection = conexion.getConnection();
//         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//        
//        preparedStatement.setString(1, producto.getNombre());
//        preparedStatement.setString(2, producto.getDescripcion());
//        preparedStatement.setDouble(3, producto.getPrecio());
//        preparedStatement.setDouble(4, producto.getPrecioCOM());
//        preparedStatement.setDouble(5, producto.getPrecioVEN());
//
//        result = preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//        throw e;
//    }
//    return result;
//}
//    
//    public void eliminarProducto(int idProducto) throws SQLException {
//    String sql = "DELETE FROM productos WHERE idProducto = ?";
//    try (Connection con = conec.getConnection();
//         PreparedStatement ps = con.prepareStatement(sql)) {
//        ps.setInt(1, idProducto);
//        ps.executeUpdate();
//    } catch (SQLException e) {
//        // Manejar errores de SQL
//        e.printStackTrace();
//        throw e;
//    }
//    
//    
//}
//
//
//}
