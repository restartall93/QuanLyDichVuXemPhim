/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.io.Serializable;
public class Rap implements Serializable{
    private int idRap;
    private String tenRap;
    private String diaChi;

    public Rap() {
    }

    public Rap(int idRap, String tenRap, String diaChi) {
        this.idRap = idRap;
        this.tenRap = tenRap;
        this.diaChi = diaChi;
    }
    
    
    public int getIdRap() {
        return idRap;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
