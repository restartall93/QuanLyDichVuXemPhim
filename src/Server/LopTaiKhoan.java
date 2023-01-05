/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
import Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LopTaiKhoan {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;
    
    public boolean dangNhap(String user, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM taikhoan WHERE taikhoan = '"+ user +"' AND matkhau = '"+ password+ "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                return true;
            }
        }
        catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(LopTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean dangNhapAdmin(String user, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM taikhoan WHERE taikhoan = '"+ user +"' AND matkhau = '"+ password+ "' AND admin='1";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                return true;
            }
        }
        catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(LopTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public TaiKhoan thongTin(String taikhoan){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS); 
            stmt = conn.createStatement();
            String sql = "SELECT `taikhoan`, `ten`, `matkhau` FROM taikhoan WHERE taikhoan = '"+ taikhoan +"'";
            rs = stmt.executeQuery(sql);
            rs.next();
            return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new TaiKhoan();
    }

    public int dangKy(String taikhoan, String ten, String matkhau){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS); 
            stmt = conn.createStatement();
            String sql = "SELECT taikhoan FROM taikhoan WHERE taikhoan = '"+ taikhoan +"'";
            rs = stmt.executeQuery(sql);            
            if (rs.next()) {
                return 2;
            }

            sql = "INSERT INTO `taikhoan`(`taikhoan`, `ten`, `matkhau`) VALUES ('" +taikhoan+ "','" +ten+ "','" +matkhau+ "')";
            stmt.execute(sql);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    public int capNhat(String taikhoan, String ten, String matkhau){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS); 
            stmt = conn.createStatement();
            String sql = "UPDATE `taikhoan` SET `ten`='" +ten+ "',`matkhau`='" +matkhau+ "' WHERE `taikhoan` = '" +taikhoan+ "'";
            stmt.executeUpdate(sql);
            return 1;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;        
    }
}
