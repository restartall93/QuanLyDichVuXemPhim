/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Server;
import Entity.Ghe;
import Entity.Lich;
import Entity.Loai;
import Entity.Phim;
import Entity.Phong;
import Entity.Rap;
import Entity.TaiKhoan;
import Entity.Ve;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface InterfaceXuLy extends Remote{
    //TaiKhoan
    public  boolean DangNhap(String user, String pass) throws RemoteException;
    public int DangKy(String taikhoan, String ten, String matkhau) throws RemoteException;
    public int CapNhat(String taikhoan, String ten, String matkhau) throws RemoteException;
    public TaiKhoan ThongTin(String taikhoan) throws RemoteException;
    
    
}
