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
    
    //Rap
    public List<Rap> DanhSachRap() throws RemoteException;
    public boolean ThemRap() throws RemoteException;
    public boolean XoaRap() throws RemoteException;
    public boolean SuaRap() throws RemoteException;

    //Phong
    public List<Phong> DanhSachPhong() throws RemoteException;
    public boolean ThemPhong() throws RemoteException;
    public boolean XoaPhong() throws RemoteException;
    public boolean SuaPhong() throws RemoteException;

    //Phim
    public List<Phim> DanhSachPhim() throws RemoteException;
    public boolean ThemPhim(Phim p) throws RemoteException;
    public boolean XoaPhim() throws RemoteException;
    public boolean SuaPhim() throws RemoteException;

    //Ghe
    public List<Ghe> DanhSachGhe(int idPhong) throws RemoteException;
    public ArrayList<Integer> DanhSachGheDaDat(int idPhong) throws RemoteException;
    public int soHang(int idPhong) throws RemoteException;
    public int soCot(int idPhong) throws RemoteException;
    
    //Lịch
    public List<Lich> DanhSachLich(int idPhim, int idPhong) throws RemoteException;

    //Vé
    public List<Ve> DanhSachVe(String idKH) throws RemoteException;
    public void DatVe(String idKH, int idLich, int idGhe) throws RemoteException;
    
    //Loại
    public List<Loai> DanhSachTheLoai() throws RemoteException;
}
