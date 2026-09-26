package one;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {

    private JPanel panel;
    private JLabel lbl_Anuncio;
    private JButton btn;
    private int countClics;
    
    public Frame() {  
        countClics = 0;
        createFrame();
    }
    
    private void createFrame() {
        setSize(400, 500);
        setTitle("Ejercicio 1");
        setIconImage(new ImageIcon("one.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        createComponents();
    }
    
    private void createComponents() {
        createPanel();
        createLabel();
        createButon();
        addAction();
    }
    
    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.red);        
        add(panel);
    }
    
    private void createLabel() {
        lbl_Anuncio = new JLabel("Pulse el boton");
        lbl_Anuncio.setBounds(100, 50, 250, 30);
        lbl_Anuncio.setFont(new Font("cooper black", Font.ITALIC, 18));
        lbl_Anuncio.setForeground(Color.white);
        panel.add(lbl_Anuncio);
    }
    
    private void createButon() {
        btn = new JButton("Clic aqui");
        btn.setBounds(100, 100, 180, 30);
        btn.setFont(new Font("cooper black", Font.ITALIC, 18));
        btn.setBackground(Color.WHITE);
        panel.add(btn);
    }
    
    private void addAction() {        
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                  
                lbl_Anuncio.setText("Numero de clics: " + ++countClics);
            }
        });
    }
    
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
    
}
