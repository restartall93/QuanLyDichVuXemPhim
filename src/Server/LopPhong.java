/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Entity.Phong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class LopPhong {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;

    public LopPhong() {
        ketNoi();
    }


    public boolean ThemPhong(String tenPhong, int soghe, int idphong){
        String sql = "INSERT INTO  `phong`(`tenphong`, `soghe`, `idphong`) VALUES ('" + tenPhong + "','" + soghe + "','" + idphong + "')";
        try {
            stmt.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LopPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean ketNoi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(config.DB_URL, config.DB_USER, config.DB_PASS);
            stmt = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Phong> DanhSachPhong(){
        String sql = "SELECT p.`idphong`, p.`tenphong`, p.`soghe`, p.`idrap`, r.`tenrap` FROM `phong` AS p, `rap` AS r  WHERE r.`idrap` =  p.`idrap` LIMIT 100;";
        List<Phong> DSPhong = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DSPhong.add(new Phong(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopPhong.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopPhong.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSPhong;
    }
    
    public void LuuPhong(TableModel model){
        String sql = "";
        for (int i = 0; i < model.getRowCount(); i++) {
            sql += "UPDATE `phong` SET `tenphong`=\"" + model.getValueAt(i, 1) + "\",`soghe`=\"" + model.getValueAt(i, 2) + "\",`idrap`=\"" + model.getValueAt(i, 3) + "\" WHERE `idphong` = \"" + model.getValueAt(i, 0) + "\";";
        }
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LopPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void XoaPhong(JTable table){
        String sql = "";
        int[] selectedRows = table.getSelectedRows();
        for (int i = 0; i < selectedRows.length; i++) {
            sql += "DELETE FROM `phong` WHERE `idphong`='" + table.getModel().getValueAt(selectedRows[i], 0) + "';";            
        }
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LopPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
