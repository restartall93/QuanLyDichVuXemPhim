/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Entity.Rap;
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

public class LopRap {
    private final Config config = new Config();
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;

    private int idrap;
    private String tenrap;
    private String diachi;

    public LopRap() {
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
    
    public LopRap(int idrap, String tenrap, String diachi) {
        this.idrap = idrap;
        this.tenrap = tenrap;
        this.diachi = diachi;
        ketNoi();
    }

    public int getIdrap() {
        return idrap;
    }

    public String getTenrap() {
        return tenrap;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setIdrap(int idrap) {
        this.idrap = idrap;
    }

    public void setTenrap(String tenrap) {
        this.tenrap = tenrap;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean ThemRap(String tenRap, String diaChi){
        String sql = "INSERT INTO `rap`( `tenrap`, `diachi`) VALUES ('" + tenRap + "','" + diaChi + "')";
        try {
            stmt.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LopRap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Rap> DanhSachRap(){
        String sql = "SELECT `idrap`, `tenrap`, `diachi` FROM `rap` WHERE 1 LIMIT 100;";
        List<Rap> DSRap = new ArrayList();
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DSRap.add(new Rap(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopRap.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(LopRap.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        }
        return DSRap;
    }
    
    public void LuuRap(TableModel model){
        String sql = "";
        for (int i = 0; i < model.getRowCount(); i++) {
            sql += "UPDATE `rap` SET `tenrap`=\"" + model.getValueAt(i, 1) + "\",`diachi`=\"" + model.getValueAt(i, 2) + "\" WHERE `idrap` = \"" + model.getValueAt(i, 0) + "\";";
        }
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LopRap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void XoaRap(JTable table){
        String sql = "";
        int[] selectedRows = table.getSelectedRows();
        for (int i = 0; i < selectedRows.length; i++) {
            sql += "DELETE FROM `rap` WHERE `idrap`='" + table.getModel().getValueAt(selectedRows[i], 0) + "';";            
        }
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LopRap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
