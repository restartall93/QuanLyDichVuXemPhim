/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XuLy extends  UnicastRemoteObject implements InterfaceXuLy {
    
    static final Config config = new Config();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs;

    public XuLy() throws RemoteException{        
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(config.port);
            XuLy xuLy = new XuLy();
            Naming.rebind(config.rmihost, xuLy);
            System.out.println("Server Ready");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    //TaiKhoan
    @Override
    public boolean DangNhap(String user, String pass){
        return new LopTaiKhoan().dangNhap(user, pass);
    }
    
    @Override
    public int DangKy(String taikhoan, String ten, String matkhau) throws RemoteException {
        return new LopTaiKhoan().dangKy(taikhoan, ten, matkhau);
    }

    @Override
    public int CapNhat(String taikhoan, String ten, String matkhau) throws RemoteException {
        return new LopTaiKhoan().capNhat(taikhoan, ten, matkhau);
    }

    @Override
    public TaiKhoan ThongTin(String taikhoan) throws RemoteException {
        return new LopTaiKhoan().thongTin(taikhoan);
    }
    
    //Rap
    @Override
    public List<Rap> DanhSachRap() throws RemoteException {
        return new LopRap().DanhSachRap();
    }

    @Override
    public boolean ThemRap() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean XoaRap() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SuaRap() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Phong
    @Override
    public List<Phong> DanhSachPhong() throws RemoteException {
        return new LopPhong().DanhSachPhong();
    }

    @Override
    public boolean ThemPhong() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean XoaPhong() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SuaPhong() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Phim
    @Override
    public List<Phim> DanhSachPhim() throws RemoteException {
        return new LopPhim().DanhSachPhim();
    }

    @Override
    public boolean ThemPhim(Phim p) throws RemoteException {
        return new LopPhim().ThemPhim(p);
    }

    @Override
    public boolean XoaPhim() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SuaPhim() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Ghe

    @Override
    public List<Ghe> DanhSachGhe(int idPhong) throws RemoteException {
        return new LopGhe().DanhSachGhe(idPhong);
    }

    @Override
    public ArrayList<Integer> DanhSachGheDaDat(int idPhong) throws RemoteException {
        return new LopGhe().DanhSachGheDaDat(idPhong);
    }

    @Override
    public int soHang(int idPhong) throws RemoteException {
        return new LopGhe().soHang(idPhong);
    }

    @Override
    public int soCot(int idPhong) throws RemoteException {
        return new LopGhe().soCot(idPhong);
    }

    @Override
    public List<Lich> DanhSachLich(int idPhim, int idRap) throws RemoteException {
        return new LopLich().DanhSachLich(idPhim, idRap);
    }


    //Vé
    @Override
    public List<Ve> DanhSachVe(String idKH) throws RemoteException {
        return new LopVe().DanhSachVe(idKH);
    }

    @Override
    public void DatVe(String idKH, int idLich, int idGhe) throws RemoteException {
        new LopVe().DatVe(idKH, idLich, idGhe);
    }

    @Override
    public List<Loai> DanhSachTheLoai() throws RemoteException {
       return new LopLoaiPhim().DanhSachTheLoai();
   }
    
}
