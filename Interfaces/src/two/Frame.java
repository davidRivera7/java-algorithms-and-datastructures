
package two;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Frame extends JFrame {
    private JPanel panel;
    private JLabel lbl_message;
    private JLabel lbl_image;
    private JRadioButton rBtn_soccer;
    private JRadioButton rBtn_basq;
    private JRadioButton rBtn_natacion;
    private JRadioButton rBtn_tennis;
    private ImageIcon imageLbl;
    private ImageIcon imageSoccer;
    private ImageIcon imageBask;
    private ImageIcon imageNatacion;
    private ImageIcon imageTenis;   
    private ImageIcon imageNull;
    
    public Frame() {
        createFrame();        
        createComponents();
        addAction();
    }
    
    private void createFrame() {
        setSize(600, 600);       
        setTitle("Deportes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void createComponents() {
        createPanel();
        createLabel();        
        createRButton();
        createImages();
        panel.revalidate();
        panel.repaint();
    }
    
    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 105, 97));
        add(panel);
    }
    
    private void createLabel() {
        lbl_message = new JLabel("Seleccione su deporte favorito");
        lbl_message.setFont(new Font("cooper black", Font.BOLD, 20));
        lbl_message.setBounds(10, 10, 350, 30);
        lbl_message.setForeground(new Color(0, 0, 128));
        panel.add(lbl_message);
                
        imageLbl = new ImageIcon();        
        lbl_image = new JLabel(imageLbl);
        lbl_image.setBounds(150, 70, 430, 430);                
        panel.add(lbl_image);
    }
    
    private void createRButton() {
        rBtn_soccer = new JRadioButton("Futbol");
        rBtn_soccer.setBounds(10, 90, 100, 30);
        rBtn_soccer.setFont(new Font("cooper black", Font.BOLD, 17));        
        panel.add(rBtn_soccer);
        
        rBtn_basq = new JRadioButton("Basketball");
        rBtn_basq.setBounds(10, 150, 130, 30);
        rBtn_basq.setFont(new Font("cooper black", Font.BOLD, 17));        
        panel.add(rBtn_basq);
        
        rBtn_natacion = new JRadioButton("Natacion");
        rBtn_natacion.setBounds(10, 210, 130, 30);
        rBtn_natacion.setFont(new Font("cooper black", Font.BOLD, 17));        
        panel.add(rBtn_natacion);
        
        rBtn_tennis = new JRadioButton("Tenis");
        rBtn_tennis.setBounds(10, 270, 100, 30);
        rBtn_tennis.setFont(new Font("cooper black", Font.BOLD, 17));        
        panel.add(rBtn_tennis);
        
        ButtonGroup groupRButton = new ButtonGroup();
        groupRButton.add(rBtn_soccer);
        groupRButton.add(rBtn_basq);
        groupRButton.add(rBtn_natacion);
        groupRButton.add(rBtn_tennis);                   
    }
    
    private void createImages() {        
        imageSoccer = new ImageIcon("src/two/images/soccer.jpg");
        imageBask = new ImageIcon("src/two/images/basket.jpg");
        imageNatacion = new ImageIcon("src/two/images/natacion.jpg");
        imageTenis = new ImageIcon("src/two/images/tennis.jpg");
        
        imageNull = new ImageIcon();
    }
    
    private void addAction() {                
        ActionListener actionRButton = new ActionListener() {              
            @Override
            public void actionPerformed(ActionEvent e) {
                Image image;
                
                clearColorRButtons();
                
                if (e.getSource() == rBtn_soccer)                
                    image = imageSoccer.getImage().getScaledInstance(lbl_image.getWidth(),
                    lbl_image.getHeight(), 4);
                else if (e.getSource() == rBtn_basq)                
                    image = imageBask.getImage().getScaledInstance(lbl_image.getWidth(),
                    lbl_image.getHeight(), 4);
                else if (e.getSource() == rBtn_natacion) 
                    image = imageNatacion.getImage().getScaledInstance(lbl_image.getWidth(),
                    lbl_image.getHeight(), 4);
                else 
                    image = imageTenis.getImage().getScaledInstance(lbl_image.getWidth(),
                    lbl_image.getHeight(), 4);
                
                imageLbl.setImage(image); 
                ((JRadioButton)e.getSource()).setBackground(Color.YELLOW);
                panel.revalidate();
                panel.repaint();
            }
            
            private void clearColorRButtons() {
                rBtn_soccer.setBackground(Color.WHITE);
                rBtn_basq.setBackground(Color.WHITE);
                rBtn_natacion.setBackground(Color.WHITE);
                rBtn_tennis.setBackground(Color.WHITE);
            }
        };      
        
        rBtn_soccer.addActionListener(actionRButton);        
        rBtn_basq.addActionListener(actionRButton);        
        rBtn_natacion.addActionListener(actionRButton);        
        rBtn_tennis.addActionListener(actionRButton);        
    }
    
}
