package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MenuInicio extends JFrame {
    
    private final int ANCHO, ALTO;
    
    private JPanel backGround;
    private JButton btnIniciar, btnRegistrarse, btnAbonar;
    
    public MenuInicio() {
        ANCHO = 600;
        ALTO = 500;
    }
    
    private void setImagen(JLabel label, String nombreImg) {
        String rutaBase = "src/resources/" + nombreImg;
        ImageIcon instr = new ImageIcon(rutaBase);
        Image imginstr = instr.getImage();
        Image nuevaimagen = imginstr.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(nuevaimagen);
        label.setIcon(imagen);
    }
    
    private void initComponents() {
        backGround = new JPanel(null);
        backGround.setSize(new Dimension(ANCHO, ALTO));
        backGround.setLocation(0, 0);
        add(backGround);
        
        JLabel title = new JLabel("Craps");
        title.setSize(new Dimension(200, 40));
        title.setLocation((this.getWidth() - title.getWidth()) / 2, 20);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        backGround.add(title);
        
        JLabel image = new JLabel();
        image.setSize(new Dimension(200, 200));
        image.setLocation((this.getWidth() - image.getWidth()) / 2, 70);
        setImagen(image, "3850.jpg");
        backGround.add(image);
        
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setSize(200, 30);
        btnIniciar.setLocation((this.getWidth() - btnIniciar.getWidth()) / 2, 300);
        btnIniciar.setFocusable(false);
        btnIniciar.setBackground(new Color(51,157,179));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFont(new Font("Arial", Font.PLAIN, 20));
        backGround.add(btnIniciar);
        
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setSize(200, 30);
        btnRegistrarse.setLocation((this.getWidth() - btnRegistrarse.getWidth()) / 2, 350);
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 20));
        backGround.add(btnRegistrarse);
        
        btnAbonar = new JButton("Abonar usuario");
        btnAbonar.setSize(200, 30);
        btnAbonar.setLocation((this.getWidth() - btnAbonar.getWidth()) / 2, 400);
        btnAbonar.setFocusable(false);
        btnAbonar.setFont(new Font("Arial", Font.PLAIN, 20));
        backGround.add(btnAbonar);
    }
    
    private void initListeners() {
        //btnIniciar
        btnIniciar.addActionListener((event) -> {
            MenuLogin menu = new MenuLogin();
            menu.initTemplate();
        });
        
        btnIniciar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnIniciar.setBackground(Color.WHITE);
                btnIniciar.setForeground(Color.BLACK);
                btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent evt) {
                btnIniciar.setBackground(new Color(51,157,179));
                btnIniciar.setForeground(Color.WHITE);
            }
        });
        
        //btnRegistrar
        btnRegistrarse.addActionListener((event) -> {
            
        });
        
        btnRegistrarse.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnRegistrarse.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent evt) {
                btnRegistrarse.setBackground(Color.WHITE);
            }
        });
        
        //btnAbonar
        btnAbonar.addActionListener((event) -> {
            
        });
        
        btnAbonar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnAbonar.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent evt) {
                btnAbonar.setBackground(Color.WHITE);
            }
        });
        
    }
    
    public void initTemplate() {
        setLayout(null);
        setTitle("Craps");
        setSize(new Dimension(ANCHO, ALTO));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        initListeners();
        setVisible(true);
    }
    
}
