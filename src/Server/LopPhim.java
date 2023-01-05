/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Entity.Phim;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LopPhim {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;

    private int idPhim;
    private String tenPhim;
    private int thoiLuong;
    private String moTa;
    private String anh;
    private String trailler;
    private int idLoai;
    private String loai;
    private String daoDien;
    private String dienVien;
    private String khoiChieu;
    private String doTuoi;
    
    public LopPhim() {
        ketNoi();
    }
    private boolean ketNoi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopRap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Phim> DanhSachPhim(){
        String sql = "SELECT p.`idphim`, p.`tenphim`, p.`thoiluong`, p.`mota`, p.`anh`, p.`trailer`, p.`idloai`, l.tenloai, p.`daodien`, p.`dienvien`, p.`khoichieu`, p.`dotuoi` FROM `phim` AS p, loai AS l WHERE p.`idloai` = l.`idloai`;";
        List<Phim> DSPhim = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {  
                DSPhim.add(new Phim(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),  rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopPhim.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopPhim.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSPhim;

    }
    
    public boolean ThemPhim(Phim p){
        String sql = "INSERT INTO `phim`(`tenphim`, `thoiluong`, `mota`, `anh`, `trailer`, `idloai`, `daodien`, `dienvien`, `khoichieu`, `dotuoi`) VALUES ('"+p.getTenPhim()+"', '"+p.getThoiLuong()+"', '"+p.getMoTa()+"', '"+p.getAnh()+"', '"+p.getTrailer()+"', '"+p.getIdLoai()+"', '"+p.getDaoDien()+"', '"+p.getDaoDien()+"', '"+p.getKhoiChieu()+"', '"+p.getDoTuoi()+"')";
        try {
            System.out.println(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LopPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
