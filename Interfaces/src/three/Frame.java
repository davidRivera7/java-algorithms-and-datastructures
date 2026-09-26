
package three;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private JPanel panel;
    private JLabel lbl_rgb;
    private JButton btn_rojo;
    private JButton btn_verde;
    private JButton btn_azul;
    private String selecText;
    private int r;
    private int g;
    private int b;
    
    
    public Frame() {
        createFrame();
        addComponents();
        addAction();
    }
    
    private void createFrame() {
        setTitle("Ejercicio 3");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void addComponents() {
        createPanel();
        createLabel();
        createButton();
    }
    
    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
    }
    
    private void createLabel() {
        lbl_rgb = new JLabel("Color (Rojo, Verde, Azul)");
        lbl_rgb.setBounds(100, 20, 250, 30);
        lbl_rgb.setFont(new Font("cooper black", Font.BOLD, 16));
        panel.add(lbl_rgb);
    }
    
    private void createButton() {
        btn_rojo = new JButton("Rojo");
        btn_rojo.setBounds(30, 200, 100, 30);
        btn_rojo.setFont(new Font("cooper black", Font.BOLD, 16));
        btn_rojo.setForeground(Color.red);
        panel.add(btn_rojo);
        
        btn_verde = new JButton("Verde");
        btn_verde.setBounds(150, 200, 100, 30);
        btn_verde.setFont(new Font("cooper black", Font.BOLD, 16));
        btn_verde.setForeground(Color.green);
        panel.add(btn_verde);
        
        btn_azul = new JButton("Azul");
        btn_azul.setBounds(270, 200, 100, 30);
        btn_azul.setFont(new Font("cooper black", Font.BOLD, 16));
        btn_azul.setForeground(Color.blue);
        panel.add(btn_azul);
        
    }
    
    private void addAction() {                
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanColorsButton();
                
                ((JButton) e.getSource()).setBackground(Color.yellow);
                
                if (e.getSource() == btn_rojo) 
                    selecText = "rojo";
                else if (e.getSource() == btn_verde) 
                    selecText = "verde";
                else 
                    selecText = "azul";
            }
            
            private void cleanColorsButton() {
                btn_rojo.setBackground(null);
                btn_verde.setBackground(null);
                btn_azul.setBackground(null);
            }
        };
        
        btn_rojo.addActionListener(al);
        btn_verde.addActionListener(al);
        btn_azul.addActionListener(al);
        
        panel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {                                
                if (selecText == null)
                    return;
                                             
                final int sum = (e.getWheelRotation() > 0) ? -1 : 1;                
                        
                if (selecText.equals("rojo") && (r + sum) >= 0 && (r + sum) <= 255) r += sum;
                
                else if (selecText.equals("verde") && (g + sum) >= 0 && (g + sum) <= 255) g += sum;
                
                else if (selecText.equals("azul") && (b + sum) >= 0 && (b + sum) <= 255) b += sum;                                                                 
                
                lbl_rgb.setText("Color (" + r + ", " + g + ", " + b + ")");
                panel.setBackground(new Color(r, g, b));                
            }                                    
        });
    }
    
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
    
}
