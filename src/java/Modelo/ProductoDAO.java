
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    
    public Producto buscar(int id){
        Producto p=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setIdProducto(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    public int actualizarstock(int id, int stock){
        String sql = "update producto set Stock=? where IdProducto=?";
        try {
           con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate(); 
        } catch (Exception e) {
        }
        return r;
    }
    //Operaciones CRUD
    
    public List listar(){
       String sql="select * from producto";
       List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int agregar(Producto p){
        String sql="INSERT INTO `producto` (`Nombres`, `Precio`, `Stock`, `Estado`) VALUES (?,?,?,?) ";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    public int actualizar(Producto p){
        String sql="update producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getIdProducto());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    public Producto listarId(int id){
        Producto prod = new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getInt(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));

            }
        } catch (SQLException e) {
        }
        return prod;
    }
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
