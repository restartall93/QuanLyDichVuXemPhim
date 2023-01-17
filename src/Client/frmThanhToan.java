/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Server.InterfaceXuLy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frmThanhToan {
    private final Config config = new Config();
    private JFrame frame;
    private JPanel pnlThanhToan;
    private static int idPhim;
    private static int idRap;
    private static int idPhong;
    private static int giaVe;
    private static String idKH;
    private static int idLich;
    private static ArrayList<Integer> listGheChon = new ArrayList();


    frmThanhToan(String idkh, int idp, int idr, int idphg, int idl, int giave, ArrayList<Integer> listGhe) {
        idKH = idkh;
        idPhim = idp;
        idRap = idr;
        idPhong = idphg;
        idLich = idl;
        giaVe = giave;
        listGheChon = listGhe;
        khoitao();
    }
    
    private void khoitao(){
        frame = createFrame();

        pnlThanhToan = new JPanel(new BorderLayout());
        pnlThanhToan.setBorder(new EmptyBorder(30, 10, 10, 10));
        pnlThanhToan.setBackground(Color.decode("0x130f40"));
        Label lbl1 = new Label("Giá Vé \t x \t Số Lượng \t = \t Thành tiền: ");
        lbl1.setAlignment(Label.CENTER);
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(new Font("Tahoma", 1, 12));
        lbl1.setBackground(Color.decode("0x22a6b3"));
        pnlThanhToan.add(lbl1, BorderLayout.NORTH);
        
        Label lbl2 = new Label(giaVe + " \t x \t "+listGheChon.size() + " \t = \t "+ (giaVe*listGheChon.size()) + " VND");
        lbl2.setAlignment(Label.CENTER);
        lbl2.setForeground(Color.WHITE);
        lbl2.setFont(new Font("Tahoma", 1, 12));
        lbl2.setBackground(Color.decode("0x22a6b3"));
        pnlThanhToan.add(lbl2, BorderLayout.SOUTH);
        
        frame.add(pnlThanhToan, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));        
        bottomPanel.setBackground(Color.decode("0x130f40"));

        JButton prev = new JButton("Quay lại");
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left-arrow.png")));
        prev.setPreferredSize(new Dimension(150, 30));
        prev.setBackground(new java.awt.Color(0, 102, 153));
        prev.setFont(new java.awt.Font("Tahoma", 1, 14));
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.addActionListener((ActionEvent e) -> {
            frmChonGhe chonGhe = new frmChonGhe(idKH, idPhim, idRap, idPhong, idLich, giaVe);
            frame.setVisible(false);
        });
        bottomPanel.add(prev, BorderLayout.WEST);
        
        JButton btnThanhToan = new JButton("Thanh Toán");
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buying.png")));

        btnThanhToan.setPreferredSize(new Dimension(150, 30));
        btnThanhToan.setBackground(new java.awt.Color(0, 102, 153));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.addActionListener((ActionEvent e) -> {
            for (int i = 0; i < listGheChon.size(); i++) {
                DatVe(idKH, idLich, listGheChon.get(i));
            }
            frmTrangChu trangChu = new frmTrangChu(idKH);
            trangChu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            trangChu.setVisible(true);
            frame.setVisible(false);
        });
        bottomPanel.add(btnThanhToan, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Thanh Toán");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    public void DatVe(String KH, int Lich, int Ghe){
        try {
            LocateRegistry.getRegistry(config.rmihost);
            InterfaceXuLy xuly = (InterfaceXuLy) Naming.lookup(config.rmihost);
            xuly.DatVe(idKH, Lich, Ghe);
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(frmChonGhe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        frmThanhToan frmThanhToan = new frmThanhToan(idKH, idPhim, idRap, idPhong, idLich, giaVe, listGheChon);
    }
}
