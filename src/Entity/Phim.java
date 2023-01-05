/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.io.Serializable;
public class Phim implements Serializable{
    private int idPhim;
    private String tenPhim;
    private int thoiLuong;
    private String moTa;
    private String anh;
    private String trailer;
    private int idLoai;
    private String loai;
    private String daoDien;
    private String dienVien;
    private String khoiChieu;
    private String doTuoi;
    public Phim() {
    }

    public Phim(int idPhim, String tenPhim, int thoiLuong, String moTa, String anh, String trailer, int idLoai, String loai, String daoDien, String dienVien, String khoiChieu, String doTuoi) {
        this.idPhim = idPhim;
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.anh = anh;
        this.trailer = trailer;
        this.idLoai = idLoai;
        this.loai = loai;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
        this.khoiChieu = khoiChieu;
        this.doTuoi = doTuoi;
    }

    public int getIdPhim() {
        return idPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getAnh() {
        return anh;
    }

    public String getTrailer() {
        return trailer;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public String getKhoiChieu() {
        return khoiChieu;
    }

    public String getDoTuoi() {
        return doTuoi;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public void setKhoiChieu(String khoiChieu) {
        this.khoiChieu = khoiChieu;
    }

    public void setDoTuoi(String doTuoi) {
        this.doTuoi = doTuoi;
    }
}
