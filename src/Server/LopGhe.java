/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
import Entity.Ghe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LopGhe {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;
    
    public LopGhe() {
        ketNoi();
    }
    
   private boolean ketNoi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
    public List<Ghe> DanhSachGhe(int idphong){
        String sql = "SELECT `idghe`, `tenghe`, `hang`, `cot` FROM `ghe` WHERE `idphong`='" + idphong + "' ORDER BY `hang` ASC, `cot` ASC";
        List<Ghe> DSGhe = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DSGhe.add(new Ghe(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), idphong));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSGhe;

    }
    
    public ArrayList<Integer> DanhSachGheDaDat(int idphong){
        String sql = "SELECT v.`idghe` FROM `ve` as v, `lichphim` as l WHERE v.`idlich`=l.idlichphim AND l.idphong='" + idphong + "'";
        ArrayList<Integer> DSGheDaDat = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DSGheDaDat.add(rs.getInt(1));
                System.out.println(rs.getInt(1));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSGheDaDat;

    }
    
    public int soHang(int idphong){
        int result = 0;
        String sql = "SELECT MAX(`hang`) FROM `ghe` WHERE `idphong`='" + idphong + "'";
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return result;
    }
    
    public int soCot(int idphong){
        int result = 0;
        String sql = "SELECT MAX(`cot`) FROM `ghe` WHERE `idphong`='" + idphong + "'";
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopGhe.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return result;
    }
}
