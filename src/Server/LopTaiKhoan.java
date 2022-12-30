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
}
