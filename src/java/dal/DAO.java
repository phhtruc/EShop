/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Category;
import model.Customer;
/**
 *
 * @author t
 */
public class DAO extends DBContext {
    
    // lấy tất cả sản phẩm
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                                    rs.getString(2),
                                   rs.getDouble(3),
                                 rs.getInt(4),
                                 rs.getString(5),
                                   rs.getString(6),
                                     rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    //Lấy sản phẩm có cid = 
    public List<Product> getProductCid(String n) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where cid = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,n);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Product(rs.getInt(1),
                       rs.getString(2),
                       rs.getDouble(3),
                       rs.getInt(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getInt(7)));
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    //lấy tất cả tên danh mục
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        }catch(SQLException e){
            
        }
        return list;
    }
    
    //Lấy sản phẩm được chọn có id =
    public Product getProductId(String id){
        String sql = "select * from Product where id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                       rs.getString(2),
                       rs.getDouble(3),
                       rs.getInt(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getInt(7));
            }
        }catch(SQLException e){
            
        }
        return null;
    }
    
    //Tìm sản phẩm theo tên
    public List<Product> searchProduct(String txt) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where [name] like ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%"+txt+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Product(rs.getInt(1),
                       rs.getString(2),
                       rs.getDouble(3),
                       rs.getInt(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getInt(7)));
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    // Đăng nhập
    public Customer loGinCus(String user, String pass){
        String sql="select * from Customer where username=? and password=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        }catch(SQLException e){
            
        }
        return null;
    }
    
    //Check tài khoản có tồn tại
    public Customer checkCustomer(String user){
        String sql="select * from Customer where username=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        }catch(SQLException e){
            
        }
        return null;
    }
    
    // Đăng kí
    public void addCustomer(Customer cs){
        String sql="insert into Customer(name,username,password,email,address,phone) values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cs.getName());
            ps.setString(2,cs.getUsername());
            ps.setString(3,cs.getPassword());
            ps.setString(4,cs.getEmail());
            ps.setString(5,cs.getAddress());
            ps.setString(6,cs.getPhone());
            ps.executeUpdate();
        }catch(SQLException e){
        }
    }
    
    // Xóa sản phẩm
    public void deleteProduct(String id){
       String sql = "delete from Product where id = ?";
       try{
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, id);
           ps.executeUpdate();
       }catch(SQLException e){
       }
    }
    
    // add product
    public void addProduct(Product p){
        String sql="insert into Product (name, price, quantity, describe, image, cid) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,p.getName());
            ps.setDouble(2,p.getPrice());
            ps.setInt(3,p.getQuantity());
            ps.setString(4,p.getDescribe());
            ps.setString(5,p.getImage());
            ps.setInt(6,p.getCid());
            ps.executeUpdate();
        }catch(SQLException e){
        }
    }
    
    // Edit product manager
    public int EditProMana(Product p){
        int k = 0;
        String sql = "UPDATE dbo.Product SET name = ?, price = ?, quantity = ?, describe =  ?, image = ?, cid= ? WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, p.getDescribe());
            ps.setString(5, p.getImage());
            ps.setInt(6, p.getCid());
            ps.setInt(7, p.getId());
            k = ps.executeUpdate();
        }catch(SQLException e){
            
        }
        return k;
    }
    
    public static void main(String[] args) {
        DAO d = new DAO();
        d.deleteProduct("5");
    }
   
}
