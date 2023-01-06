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
}
