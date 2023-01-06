/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
import Entity.Ve;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LopVe {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;
    
    private int idVe;
    private int idlich;
    private int idGhe;
    private String idKH;
    private String ma;
    private String tenRap;
    private String tenGhe;
    private String tenPhong;
    private String ngay;
    private String gio;
    private String tenPhim;
    private int giaVe;
    
    public LopVe() {
        ketNoi();
    }
    public LopVe(String idKH) {
        this.idKH = idKH;
        ketNoi();
    }
    
    public LopVe(int idVe, int idlich, int idGhe, String idKH, String ma, String tenPhim, String tenRap, String tenGhe, String tenPhong, String ngay, String gio, int giaVe) {
        this.idVe = idVe;
        this.idlich = idlich;
        this.idGhe = idGhe;
        this.idKH = idKH;
        this.ma = ma;
        this.tenRap = tenRap;
        this.tenGhe = tenGhe;
        this.tenPhong = tenPhong;
        this.ngay = ngay;
        this.gio = gio;
        this.tenPhim = tenPhim;
        this.giaVe = giaVe;
        ketNoi();
    }
    
    public int getIdVe() {
        return idVe;
    }

    public void setIdVe(int idVe) {
        this.idVe = idVe;
    }
    
    public int getIdlich() {
        return idlich;
    }

    public void setIdlich(int idlich) {
        this.idlich = idlich;
    }

    public int getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(int idGhe) {
        this.idGhe = idGhe;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    
    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }
    
    private boolean ketNoi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopVe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Ve> DanhSachVe(String idKH){
        String sql = "SELECT v.`idve`, v.`idlich`, v.`idghe`, v.`idKH`, v.`ma`, p.`tenphim`, r.`tenrap`, g.`tenghe`, phg.`tenphong`, l.ngay, l.giobatdau, l.giave FROM `ve` AS v, `lichphim` AS l, `phong` AS phg, `phim` AS p, `rap` AS r, `ghe` AS g WHERE `idKH`='"+idKH+"' AND l.`idlichphim`=v.`idlich`  AND l.`ngay` >= CURDATE() AND l.idphim = p.idphim  AND l.idphong = phg.idphong AND g.idghe = v.idghe AND r.idrap = phg.idrap";
        List<Ve> DSVe = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DSVe.add(new Ve(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getString(5),  rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9),  rs.getString(10),  rs.getString(11),  rs.getInt(12))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopVe.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopVe.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSVe;
    }

    public String DatVe(String idKH, int idVe, int idGhe){
        String code = randomstr();
        String sql = "INSERT INTO `ve`(`idlich`, `idghe`, `idKH`,`ma`) VALUES ('"+ idVe +"','"+ idGhe +"','"+ idKH +"','"+ code +"');";
        try {
            stmt.execute(sql);
            return code;
        } catch (SQLException ex) {
            Logger.getLogger(LopVe.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopVe.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return "";
    }
    public String randomstr() { 
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 16;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }
}
