package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.Jugador;
import persistence.ManejoArchivos;

public class MenuAbonar extends Menu {
    
    private JButton btnVolver,btnABonar;
    private JTextField inputName,inputSaldo;
    private JPasswordField inputPassword;
    
    public MenuAbonar(){
        super.ANCHO = 600;
        super.ALTO = 400;
    }
    
    protected void initComponents() {
        JLabel title = new JLabel("Abonar");
        title.setSize(new Dimension(100,20));
        title.setFont(new Font("Arial",Font.BOLD,20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLocation((this.getWidth()-title.getWidth())/2, 10);
        add(title);
        
        btnABonar = new JButton("Abonar");
        btnABonar.setSize(new Dimension(100,30));
        btnABonar.setLocation((this.getWidth()-btnABonar.getWidth())/2, 300);
        btnABonar.setFocusable(false);
        btnABonar.setBackground(new Color(51, 157, 179));
        btnABonar.setForeground(Color.WHITE);
        btnABonar.setFont(new Font("Arial", Font.PLAIN, 20));
        add(btnABonar);
        
        JLabel titleName = new JLabel("Nombre: ");
        titleName.setSize(new Dimension(100,20));
        titleName.setFont(new Font("Arial",Font.PLAIN,15));
        titleName.setLocation((this.getWidth()-titleName.getWidth())/2-100, 100);
        add(titleName);
        
        inputName = new JTextField();
        inputName.setSize(new Dimension(100,20));
        inputName.setHorizontalAlignment(JTextField.CENTER);
        inputName.setFont(new Font("Arial",Font.PLAIN,15));
        inputName.setLocation((this.getWidth()-inputName.getWidth())/2+10, 100);
        add(inputName);
        
        JLabel titlePassword = new JLabel("Contraseña: ");
        titlePassword.setSize(new Dimension(100,20));
        titlePassword.setFont(new Font("Arial",Font.PLAIN,15));
        titlePassword.setLocation((this.getWidth()-titlePassword.getWidth())/2-100, 150);
        add(titlePassword);
        
        inputPassword = new JPasswordField();
        inputPassword.setSize(new Dimension(100,20));
        inputPassword.setHorizontalAlignment(JTextField.CENTER);
        inputPassword.setFont(new Font("Arial",Font.PLAIN,15));
        inputPassword.setLocation((this.getWidth()-inputPassword.getWidth())/2+10, 150);
        add(inputPassword);
        
        
        JLabel titleSaldo = new JLabel("Saldo: ");
        titleSaldo.setSize(new Dimension(100,20));
        titleSaldo.setFont(new Font("Arial",Font.PLAIN,15));
        titleSaldo.setLocation((this.getWidth()-titlePassword.getWidth())/2-100, 200);
        add(titleSaldo);
        
        inputSaldo = new JTextField();
        inputSaldo.setSize(new Dimension(100,20));
        inputSaldo.setHorizontalAlignment(JTextField.CENTER);
        inputSaldo.setFont(new Font("Arial",Font.PLAIN,15));
        inputSaldo.setLocation((this.getWidth()-inputSaldo.getWidth())/2+10, 200);
        add(inputSaldo);
        
        btnVolver = new JButton("<html><body>&#129044;</body></html>");
        btnVolver.setSize(100, 30);
        btnVolver.setBackground(new Color(51, 157, 179));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setLocation(10, ALTO - 70);
        btnVolver.setFocusable(false);
        add(btnVolver);
    }
    
    protected void initListeners(){
        setHoverEffect(btnABonar);
        
        btnABonar.addActionListener((event) -> {
            ManejoArchivos instancia = ManejoArchivos.getInstance();
            try {
                instancia.editarDatosJugador(new Jugador(inputName.getText(),getStringPass(inputPassword.getPassword()),Double.parseDouble(inputSaldo.getText())));
                JOptionPane.showMessageDialog(null, "Registro editado", "info", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al editar sus datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        setHoverEffect(btnVolver);
        
        btnVolver.addActionListener((event) -> {
            MenuInicio.getInstance().initTemplate();
            dispose();
        });
    }
    
    
}
