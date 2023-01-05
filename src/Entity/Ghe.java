/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
public class Ghe implements Serializable{
    private int idGhe;
    private String tenGhe;
    private int hang;
    private int cot;
    private int idPhong;
    
    public Ghe(){
    }
    
    public Ghe(int idGhe, String tenGhe, int hang, int cot, int idPhong) {
        this.idGhe = idGhe;
        this.tenGhe = tenGhe;
        this.hang = hang;
        this.cot = cot;
        this.idPhong = idPhong;
    }
    
    public int getIdGhe() {
        return idGhe;
    }

    public String getTenGhe() {
        return tenGhe;
    }

    public int getHang() {
        return hang;
    }

    public int getCot() {
        return cot;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdGhe(int idGhe) {
        this.idGhe = idGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public void setCot(int cot) {
        this.cot = cot;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }
}

    
