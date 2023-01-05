/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Entity.Loai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LopLoaiPhim {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;

    public LopLoaiPhim() {
        ketNoi();
    }
    private boolean ketNoi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopLoaiPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Loai> DanhSachTheLoai(){
        String sql = "SELECT `idloai`, `tenloai` FROM `loai`";
        List<Loai> DS = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DS.add(new Loai(rs.getInt(1), rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LopLoaiPhim.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopLoaiPhim.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DS;

    }
}
