/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.io.Serializable;
public class Phong implements Serializable{
    private int idPhong;
    private String tenPhong;
    private int idRap;

    public Phong() {
    }

    public Phong(int idPhong, String tenPhong, int idRap) {
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
        this.idRap = idRap;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public int getIdRap() {
        return idRap;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }
}
