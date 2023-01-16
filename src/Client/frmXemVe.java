/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Server.InterfaceXuLy;
import Entity.Ve;
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


public class frmXemVe {
    private final Config config = new Config();
    private JFrame frame;
    private JPanel DSVePanel;
    private static int idPhim;
    private static int idRap;
    private static String idKH;
    private List<Ve> DSVe = new ArrayList();


    public frmXemVe(String idkh) {
        idKH = idkh;
        LayDSVe();
        khoitao();
    }
    
    private void khoitao(){
        frame = createFrame();

        GridLayout g=new GridLayout(3, 5, 8, 15);
        DSVePanel = new JPanel();
        DSVePanel.setLayout(g);
        DSVePanel.setBorder(new EmptyBorder(30, 10, 10, 10));
        DSVePanel.setBackground(Color.decode("0x130f40"));
        
        for (int i = 0; i < DSVe.size(); i++) {
            Ve v = DSVe.get(i);
            JPanel jpnlVe = new JPanel(new BorderLayout());
            jpnlVe.setBackground(Color.decode("0x30336B"));
            JButton b;
            try {
                b = new JButton(new ImageIcon(new URL("https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Ffastandfurious.fandom.com%2Fwiki%2FFast_%2526_Furious_6&psig=AOvVaw0XgJG2byaLe7oZl1cfSyhH&ust=1673928440412000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCfm8Oby_wCFQAAAAAdAAAAABAE"+v.getMa())));
                b.setBorder(new EmptyBorder(3, 3, 3, 3));
                b.setForeground(Color.decode("0xffffff"));
                b.setPreferredSize(new Dimension(100,100 ));
                b.setBackground(Color.decode("0x30336B"));
                jpnlVe.add(b, BorderLayout.WEST);
            } catch (MalformedURLException ex) {
                Logger.getLogger(frmXemVe.class.getName()).log(Level.SEVERE, null, ex);
            }

            Label lbl1 = new Label(v.getGio() + " " + v.getNgay());
            lbl1.setAlignment(Label.CENTER);
            lbl1.setForeground(Color.WHITE);
            lbl1.setFont(new Font("Tahoma", 1, 12));
            lbl1.setBackground(Color.decode("0x30336B"));
            jpnlVe.add(lbl1, BorderLayout.NORTH);

            Label lbl2 = new Label(v.getTenPhim());
            lbl2.setAlignment(Label.CENTER);
            lbl2.setForeground(Color.WHITE);
            lbl2.setFont(new Font("Tahoma", 1, 12));
            lbl2.setBackground(Color.decode("0x30336B"));
            jpnlVe.add(lbl2, BorderLayout.CENTER);            

            Label lbl3 = new Label(v.getTenRap() + " - " + v.getTenPhong() + " - Ghế " + v.getTenGhe());
            lbl3.setAlignment(Label.CENTER);
            lbl3.setForeground(Color.WHITE);
            lbl3.setFont(new Font("Tahoma", 1, 12));
            lbl3.setBackground(Color.decode("0x30336B"));
            jpnlVe.add(lbl3, BorderLayout.SOUTH);            

            DSVePanel.add(jpnlVe);
        }
        frame.add(DSVePanel, BorderLayout.NORTH);

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
        JFrame frame = new JFrame("Vé đã mua");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    private void LayDSVe(){
        try {
            LocateRegistry.getRegistry(config.rmihost);
            InterfaceXuLy xuly = (InterfaceXuLy) Naming.lookup(config.rmihost);
            DSVe = xuly.DanhSachVe(idKH);
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(frmChonGhe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        frmXemVe frmChonVe = new frmXemVe(idKH);
    }
}
