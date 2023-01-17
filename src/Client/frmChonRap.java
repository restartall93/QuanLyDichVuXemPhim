/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;
import Server.InterfaceXuLy;
import Entity.Rap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class frmChonRap {
    private final Config config = new Config();
    private JFrame frame;
    private JPanel DSRapPanel;
    private final int sizex = 150;
    private final int sizey = 50;
    private List<Rap> DSRap = new ArrayList();
    private static int idPhim;
    private static String idKH;

    public frmChonRap(String idkh, int idp) {
        idKH = idkh;
        idPhim = idp;
        LayDSRap();
        khoitao();
    }
    
    private void khoitao(){
        frame = createFrame();

        GridLayout g=new GridLayout(2, 4, 8, 10);
        DSRapPanel = new JPanel();
        DSRapPanel.setLayout(g);
        DSRapPanel.setBorder(new EmptyBorder(30, 10, 10, 10));
        DSRapPanel.setBackground(Color.decode("0x130f40"));
        
        for (int i = 0; i < DSRap.size(); i++) {
            Rap r = DSRap.get(i);
            JPanel jpnlRap = new JPanel(new BorderLayout());
            jpnlRap.setBackground(Color.decode("0x22a6b3"));
            JButton b = new JButton(r.getTenRap());
            b.setForeground(Color.decode("0xffffff"));
            b.setPreferredSize(new Dimension(sizex, sizey));
            b.setBackground(Color.decode("0x30336b"));
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frmChonLich chonLich = new frmChonLich(idKH, idPhim, r.getIdRap());
                    frame.setVisible(false);
                }
            });
            jpnlRap.add(b, BorderLayout.NORTH);

            JLabel lblTenRap = new JLabel();
            lblTenRap.setText("<html>"+r.getDiaChi()+"</html>");
            lblTenRap.setForeground(Color.WHITE);
            lblTenRap.setFont(new Font("Tahoma", 1, 12));
            lblTenRap.setBackground(Color.decode("0x22a6b3"));
            lblTenRap.setOpaque(true);
            lblTenRap.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
            jpnlRap.add(lblTenRap, BorderLayout.SOUTH);
            
            DSRapPanel.add(jpnlRap);
        }
        frame.add(DSRapPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));        
        bottomPanel.setBackground(Color.decode("0x130f40"));
        JButton prev = new JButton("Quay lại");
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left-arrow.png")));
        prev.setPreferredSize(new Dimension(150, 30));
        prev.setBackground(new java.awt.Color(48,51,107));
        prev.setFont(new java.awt.Font("Tahoma", 1, 14));
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmChonPhim chonPhim = new frmChonPhim(idKH);
                frame.setVisible(false);
            }
        });
        bottomPanel.add(prev, BorderLayout.WEST);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Chọn Rap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.decode("0x130f40"));
        return frame;
    }
    
    private void LayDSRap(){
        try {
            LocateRegistry.getRegistry(config.rmihost);
            InterfaceXuLy xuly = (InterfaceXuLy) Naming.lookup(config.rmihost);
            DSRap = xuly.DanhSachRap();
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(frmChonGhe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        frmChonRap frmChonRap = new frmChonRap(idKH, idPhim);
    }
}
