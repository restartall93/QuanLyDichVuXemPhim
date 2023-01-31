/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Server.InterfaceXuLy;
import Entity.Ghe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
 
/**
 *
 * @author DELL
 */
public class frmChonGhe {
    private ArrayList<Integer> listGheChon = new ArrayList<>();
    private ArrayList<Integer> DSGheDaDat = new ArrayList<>();
    private final Config config = new Config();
    private List<Ghe> DSGhe ;
    private int soHang = 0;
    private int soCot = 0;
    private JFrame frame;
    private final int sizex = 70;
    private final int sizey = 35;
    private JPanel buttonPanel;
    private static int idPhim;
    private static int idPhong;
    private static int idRap;
    private static int idLich;
    private static int giaVe;
    private static String idKH;
    
    public frmChonGhe(String idkh, int idp, int idr, int idphg, int idl, int giave) {
        idKH = idkh;
        idPhim = idp;
        idRap = idr;
        idPhong = idphg;
        idLich = idl;
        giaVe = giave;
        LayDuLieu(idPhong);
        khoitao();
    }
    private void khoitao(){
        frame = createFrame();
        Label lbl = new Label("Chọn ghế ngồi", 1);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        frame.add(lbl, BorderLayout.NORTH);        
        UIManager.put("ToggleButton.select", new Color(34, 166, 179));
        GridLayout g=new GridLayout(soHang+1, soCot+1, 8, 4);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(g);
        buttonPanel.setBorder(new EmptyBorder(30, 10, 10, 10));
        buttonPanel.setBackground(Color.decode("0x130f40"));
        if (soCot > 0 && soHang > 0) {
            int sc = soCot+1;
            for (int r = 0; r <= soHang; r++) {
                for (int c = 1; c <= sc; c++) {
                    Ghe ghe = DSGhe.get(r*sc+c-1);
                    JToggleButton b = new JToggleButton();
                    b.setForeground(Color.decode("0xffffff"));
                    b.setPreferredSize(new Dimension(sizex, sizey));

                    if (!ghe.getTenGhe().isEmpty()) {

                        b.setText(ghe.getTenGhe());
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (listGheChon.contains(ghe.getIdGhe())) {
                                    listGheChon.remove(new Integer(ghe.getIdGhe()));
                                }
                                else{
                                    listGheChon.add(ghe.getIdGhe());
                                }

                            }
                        });
                        b.setBackground(Color.decode("0x30336b"));
                        if (kiemTraGheDaDat(ghe.getIdGhe(), DSGheDaDat)) {
                            b.setBackground(Color.decode("0x50536b"));
                            b.setEnabled(false);
                        }
                    }
                    else{
                        b.setBackground(Color.decode("0x130f40"));
                        b.setBorder(new EmptyBorder(0,0,0,0));
                        b.setEnabled(false);
                    }
                    buttonPanel.add(b);
                }
            }
        }
        frame.add(buttonPanel, BorderLayout.NORTH);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));        
        bottomPanel.setBackground(Color.decode("0x130f40"));
        JButton prev = new JButton("Quay lại");
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left-arrow.png")));

        JButton next = new JButton("Tiếp tục");
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/right-arrow.png")));

        prev.setPreferredSize(new Dimension(150, 30));
        next.setPreferredSize(new Dimension(150, 30));

        
        next.setBackground(new java.awt.Color(34, 166, 179));
        next.setFont(new java.awt.Font("Tahoma", 1, 14));
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmThanhToan thanhToan = new frmThanhToan(idKH, idPhim, idRap, idPhong, idLich, giaVe, listGheChon);
                frame.setVisible(false);

            }
        });
        

        prev.setBackground(new java.awt.Color(0, 102, 153));
        prev.setFont(new java.awt.Font("Tahoma", 1, 14));
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmChonLich chonLich = new frmChonLich(idKH, idPhim, idRap);
                frame.setVisible(false);

            }
        });

        bottomPanel.add(prev, BorderLayout.WEST);
        bottomPanel.add(next, BorderLayout.EAST);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Chọn ghế");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
        
    private boolean kiemTraGheDaDat(int s, ArrayList<Integer> DaDat){
        for (int i = 0; i < DaDat.size(); i++) {
            if (s == DaDat.get(i)) {
                return true;
            }
        }
        return false;
    }
    private void LayDuLieu(int idPhong){
        try {
            LocateRegistry.getRegistry(config.rmihost);
            InterfaceXuLy xuly = (InterfaceXuLy) Naming.lookup(config.rmihost);
            DSGhe = xuly.DanhSachGhe(idPhong);
            DSGheDaDat = xuly.DanhSachGheDaDat(idPhong);
            soHang = xuly.soHang(idPhong);
            soCot = xuly.soCot(idPhong);            
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(frmChonGhe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void taoMangGhe(){
    }
    public static void main(String[] args) {
        frmChonGhe frmChonGhe = new frmChonGhe(idKH, idPhim, idRap, idPhong, idLich, giaVe);
    }   
}
