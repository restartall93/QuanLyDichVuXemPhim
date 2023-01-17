/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Server.InterfaceXuLy;
import Entity.Phim;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frmChonPhim {
    private final Config config = new Config();
    private JFrame frame;
    private JPanel DSPhimPanel;
    private final int sizex = 100;
    private final int sizey = 200;
    private List<Phim> DSPhim = new ArrayList();
    private static String idKH;

    public frmChonPhim(String idkh) {
        idKH = idkh;
        LayDSPhim();
        khoitao();
    }
    
    
    private void khoitao(){
        frame = createFrame();
        
        GridLayout g=new GridLayout(2, 5, 8, 10);
        DSPhimPanel = new JPanel();
        DSPhimPanel.setLayout(g);
        DSPhimPanel.setBorder(new EmptyBorder(30, 10, 10, 10));
        DSPhimPanel.setBackground(Color.decode("0x130f40"));
        
        for (int i = 0; i < DSPhim.size(); i++) {
            Phim p = DSPhim.get(i);
            JPanel jpnlPhim = new JPanel(new BorderLayout());
            Label lblDoTuoi = new Label(p.getDoTuoi());
            lblDoTuoi.setAlignment(Label.RIGHT);
            lblDoTuoi.setForeground(Color.decode("0xf9ca24"));
            lblDoTuoi.setFont(new Font("Tahoma", 1, 12));
            lblDoTuoi.setBackground(Color.decode("0xeb4d4b"));
            jpnlPhim.add(lblDoTuoi, BorderLayout.NORTH);
            try{
                JButton b = new JButton(new ImageIcon(new URL(p.getAnh())));
                b.setForeground(Color.decode("0xffffff"));
                b.setPreferredSize(new Dimension(sizex, sizey));
                b.setBackground(Color.decode("0x30336b"));
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frmXemThongTinPhim thongTinPhim = new frmXemThongTinPhim(idKH, p);
                        thongTinPhim.setExtendedState(MAXIMIZED_BOTH);
                        thongTinPhim.setVisible(true);                        
                        frame.setVisible(false);
                    }
                });
                jpnlPhim.add(b, BorderLayout.CENTER);
            } catch (MalformedURLException ex) {
                Logger.getLogger(frmChonPhim.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            Label lblTenPhim = new Label(p.getTenPhim());
            lblTenPhim.setAlignment(Label.LEFT);
            lblTenPhim.setForeground(Color.WHITE);
            lblTenPhim.setFont(new Font("Tahoma", 1, 14));
            lblTenPhim.setBackground(Color.decode("0x22a6b3"));
            jpnlPhim.add(lblTenPhim, BorderLayout.SOUTH);
            
            DSPhimPanel.add(jpnlPhim);
        }
        frame.add(DSPhimPanel, BorderLayout.NORTH);

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
                frmTrangChu trangChu = new frmTrangChu(idKH);
                trangChu.setExtendedState(MAXIMIZED_BOTH);
                trangChu.setVisible(true);
                frame.setVisible(false);
            }
        });
        bottomPanel.add(prev, BorderLayout.WEST);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Chọn Phim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    private void LayDSPhim(){
        try {
            LocateRegistry.getRegistry(config.rmihost);
            InterfaceXuLy xuly = (InterfaceXuLy) Naming.lookup(config.rmihost);
            DSPhim = xuly.DanhSachPhim();
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(frmChonGhe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        frmChonPhim frmChonPhim = new frmChonPhim(idKH);
    }

    
    
    
}
