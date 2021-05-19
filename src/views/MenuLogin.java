package views;

import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuLogin extends JFrame {
    
    private final int ANCHO,ALTO;
    
    public MenuLogin(){
        ANCHO = 600;
        ALTO = 500;
    }
    
    private void initComponents(){
        
    }
    
    public void initTemplate(){
        setLayout(null);
        setTitle("Craps");
        setSize(new Dimension(ANCHO,ALTO));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }
    
}
