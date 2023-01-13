/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Server.InterfaceXuLy;
import Entity.Lich;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;

public class frmChonLich {
    private final Config config = new Config();
    private JFrame frame;
    private JPanel DSLichPanel;
    private final int sizex = 100;
    private final int sizey = 50;
    private List<Lich> DSLich = new ArrayList();
    private static int idPhim;
    private static int idRap;
    private static String idKH;
    

    public frmChonLich(String idkh, int idp, int idr) {
        idKH = idkh;
        idPhim = idp;
        idRap = idr;
        LayDSLich();
        khoitao();
    }
    
    private void khoitao(){
        frame = createFrame();

        GridLayout g=new GridLayout(2, 5, 8, 10);
        DSLichPanel = new JPanel();
        DSLichPanel.setLayout(g);
        DSLichPanel.setBorder(new EmptyBorder(30, 10, 10, 10));
        DSLichPanel.setBackground(Color.decode("0x130f40"));
        
        for (int i = 0; i < DSLich.size(); i++) {
            Lich l = DSLich.get(i);
            JPanel jpnlLich = new JPanel(new BorderLayout());
            JButton b = new JButton(l.getGio());
            b.setForeground(Color.decode("0xffffff"));
            b.setPreferredSize(new Dimension(sizex, sizey));
            b.setBackground(Color.decode("0x30336b"));
            b.setFont(new Font("Tahoma", 1, 16));
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frmChonGhe chonGhe = new frmChonGhe(idKH, idPhim, idRap, l.getIdPhong(), l.getIdLich(), l.getGiaVe());
                    frame.setVisible(false);
                }
            });
            jpnlLich.add(b, BorderLayout.NORTH);

            Label lblTenLich = new Label(l.getNgay());
            lblTenLich.setAlignment(Label.CENTER);
            lblTenLich.setForeground(Color.WHITE);
            lblTenLich.setFont(new Font("Tahoma", 1, 12));
            lblTenLich.setBackground(Color.decode("0x22a6b3"));
            jpnlLich.add(lblTenLich, BorderLayout.SOUTH);
            
            DSLichPanel.add(jpnlLich);
        }
        frame.add(DSLichPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));        
        bottomPanel.setBackground(Color.decode("0x130f40"));
        JButton prev = new JButton("Quay lại");
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left-arrow.png")));

        prev.setPreferredSize(new Dimension(150, 30));
        prev.setBackground(new java.awt.Color(0, 102, 153));
        prev.setFont(new java.awt.Font("Tahoma", 1, 14));
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frmChonRap chonRap = new frmChonRap(idKH, idPhim);
//                frame.setVisible(false);
            }
        });
        bottomPanel.add(prev, BorderLayout.WEST);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Chọn Giờ Xem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    private void LayDSLich(){
        try {
            LocateRegistry.getRegistry(config.rmihost);
            InterfaceXuLy xuly = (InterfaceXuLy) Naming.lookup(config.rmihost);
            DSLich = xuly.DanhSachLich(idPhim, idRap);
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(frmChonGhe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        frmChonLich frmChonLich = new frmChonLich(idKH, idPhim, idRap);
    }
}
