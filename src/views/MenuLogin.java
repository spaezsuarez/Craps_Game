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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuLogin extends JFrame {

    private final int ANCHO, ALTO;

    private JTextField inputName;
    private JPasswordField inputPass;
    private JButton btnIniciar, btnVolver;

    public MenuLogin() {
        ANCHO = 600;
        ALTO = 400;
    }
    
    private void setImagen(JLabel label, String nombreImg) {
        String rutaBase = "src/resources/menus/" + nombreImg;
        ImageIcon instr = new ImageIcon(rutaBase);
        Image imginstr = instr.getImage();
        Image nuevaimagen = imginstr.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(nuevaimagen);
        label.setIcon(imagen);
    }

    private void initComponents() {
        JLabel image = new JLabel();
        image.setSize(new Dimension(150,150));
        image.setLocation((this.getWidth()-image.getWidth())/2, 20);
        setImagen(image, "user.png");
        add(image);
        
        inputName = new JTextField();
        inputName.setSize(200, 30);
        inputName.setLocation((this.getWidth() - inputName.getWidth()) / 2, 200);
        inputName.setHorizontalAlignment(JTextField.CENTER);
        inputName.setFont(new Font("Arial", Font.PLAIN, 20));
        add(inputName);

        inputPass = new JPasswordField();
        inputPass.setSize(200, 30);
        inputPass.setLocation((this.getWidth() - inputPass.getWidth()) / 2, 250);
        inputPass.setHorizontalAlignment(JTextField.CENTER);
        inputPass.setFont(new Font("Arial", Font.PLAIN, 20));
        add(inputPass);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setSize(100, 30);
        btnIniciar.setBackground(new Color(51, 157, 179));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnIniciar.setLocation((this.getWidth()-btnIniciar.getWidth())/2, 300);
        btnIniciar.setFocusable(false);
        add(btnIniciar);
        
        btnVolver = new JButton("<html><body>&#129044;</body></html>");
        btnVolver.setSize(100, 30);
        btnVolver.setBackground(new Color(51, 157, 179));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setLocation(10, ALTO-70);
        btnVolver.setFocusable(false);
        add(btnVolver);
    }

    private void initListeners() {
        btnIniciar.addActionListener((event) -> {
            
        });

        btnIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnIniciar.setBackground(Color.WHITE);
                btnIniciar.setForeground(Color.BLACK);
                btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnIniciar.setBackground(new Color(51, 157, 179));
                btnIniciar.setForeground(Color.WHITE);
            }
        });
        
        btnVolver.addActionListener((event) -> {
            MenuInicio.getInstance().initTemplate();
            dispose();
        });

        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnVolver.setBackground(Color.WHITE);
                btnVolver.setForeground(Color.BLACK);
                btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnVolver.setBackground(new Color(51, 157, 179));
                btnVolver.setForeground(Color.WHITE);
            }
        });
    }

    public void initTemplate() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Craps");
        setSize(new Dimension(ANCHO, ALTO));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        initListeners();
        setVisible(true);
    }

}
