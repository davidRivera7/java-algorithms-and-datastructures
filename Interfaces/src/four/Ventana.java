
package four;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame {
    
    private JPanel panel;
    private JLabel lblPersona;
    
    public Ventana() {
        createFrame();
        initComponents();
    }
    
    private void createFrame() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initComponents() {
        createPanel();
        createLabel();
    }
    
    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
    }
    
    private void createLabel() {
        lblPersona = new JLabel("Persona");
        lblPersona.setBounds(0, 0, 200, 30);
        lblPersona.setOpaque(true);
        lblPersona.setBackground(Color.green);
        panel.add(lblPersona);
    }
    
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
