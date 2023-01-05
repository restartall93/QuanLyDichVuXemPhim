/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.io.Serializable;
public class Ve implements Serializable{
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
    

    public Ve() {
    }

    public Ve(int idVe, int idlich, int idGhe, String idKH, String ma, String tenPhim, String tenRap, String tenGhe, String tenPhong, String ngay, String gio, int giaVe) {
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

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    
    public int getIdVe() {
        return idVe;
    }

    public void setIdVe(int idVe) {
        this.idVe = idVe;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
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

    public String getTenGhe() {
        return tenGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
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
}
