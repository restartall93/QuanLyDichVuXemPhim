/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;

public class TaiKhoan implements Serializable{
    private String taiKhoan;
    private String ten;
    private String matKhau;
    private boolean admin;

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan, String ten, boolean admin) {
        this.taiKhoan = taiKhoan;
        this.ten = ten;
        this.admin = admin;
    }
    public TaiKhoan(String taiKhoan, String ten, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.ten = ten;
        this.matKhau = matKhau;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
