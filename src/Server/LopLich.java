/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Entity.Lich;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LopLich {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;

    private int idlich;
    private String tenlich;
    private String diachi;
    private int giaVe;
    
    public LopLich() {
        ketNoi();
    }
    
    private boolean ketNoi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopLich.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int getIdlich() {
        return idlich;
    }

    public void setIdlich(int idlich) {
        this.idlich = idlich;
    }

    public String getTenlich() {
        return tenlich;
    }

    public void setTenlich(String tenlich) {
        this.tenlich = tenlich;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    
    public List<Lich> DanhSachLich(int idPhim, int idRap){
        String sql = "SELECT l.`idlichphim`, l.`ngay`, l.`giobatdau`, l.`giave` , l.`idphong` FROM `lichphim` AS l, `phong` AS p WHERE l.`idphong` = p.`idphong` AND `idphim`='"+ idPhim +"' AND  p.`idrap`='"+ idRap +"' LIMIT 10;";
        List<Lich> DSLich = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DSLich.add(new Lich(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopLich.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopLich.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSLich;
    }
}
