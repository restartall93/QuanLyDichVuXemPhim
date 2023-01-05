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
}
