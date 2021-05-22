package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import models.Jugador;

import persistence.ManejoArchivos;

public class MenuRegistro extends Menu {
    
    private JTextField inputName,inputSaldoInicial;
    private JPasswordField inputPassUno,inputPassDos;
    private JButton btnIniciar, btnVolver;
    private JPanel namePane,passwordPane,saldoPane;

    public MenuRegistro() {
        ANCHO = 600;
        ALTO = 550;
    }
    
    protected void initComponents() {
        JLabel title = new JLabel("Registrarse");
        title.setSize(new Dimension(300,30));
        title.setLocation((this.getWidth()-title.getWidth())/2, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        
        namePane = new JPanel(null);
        namePane.setSize(new Dimension(ANCHO-20,100));
        namePane.setLocation(10, 70);
        namePane.setBackground(Color.WHITE);
        namePane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Nombre de usuario"));
        add(namePane);
        
        inputName = new JTextField();
        inputName.setSize(200, 30);
        inputName.setLocation((namePane.getWidth() - inputName.getWidth()) / 2, (namePane.getHeight()-inputName.getHeight())/2);
        inputName.setHorizontalAlignment(JTextField.CENTER);
        inputName.setFont(new Font("Arial", Font.PLAIN, 20));
        namePane.add(inputName);
        
        saldoPane = new JPanel(null);
        saldoPane.setSize(new Dimension(ANCHO-20,100));
        saldoPane.setLocation(10, 200);
        saldoPane.setBackground(Color.WHITE);
        saldoPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Saldo"));
        add(saldoPane);
        
        inputSaldoInicial = new JTextField();
        inputSaldoInicial.setSize(200, 30);
        inputSaldoInicial.setLocation((saldoPane.getWidth() - inputSaldoInicial.getWidth()) / 2, (saldoPane.getHeight()-inputSaldoInicial.getHeight())/2);
        inputSaldoInicial.setHorizontalAlignment(JTextField.CENTER);
        inputSaldoInicial.setFont(new Font("Arial", Font.PLAIN, 20));
        saldoPane.add(inputSaldoInicial);
        
        passwordPane = new JPanel(null);
        passwordPane.setSize(new Dimension(ANCHO-20,100));
        passwordPane.setLocation(10, 330);
        passwordPane.setBackground(Color.WHITE);
        passwordPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Contraseña"));
        add(passwordPane);
        
        inputPassUno = new JPasswordField();
        inputPassUno.setSize(200, 30);
        inputPassUno.setLocation((passwordPane.getWidth() - inputPassUno.getWidth()) / 2, (passwordPane.getHeight()-inputPassUno.getHeight())/2-20);
        inputPassUno.setHorizontalAlignment(JTextField.CENTER);
        inputPassUno.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordPane.add(inputPassUno);
        
        inputPassDos = new JPasswordField();
        inputPassDos.setSize(200, 30);
        inputPassDos.setLocation((passwordPane.getWidth() - inputPassDos.getWidth()) / 2, (passwordPane.getHeight()-inputPassDos.getHeight())/2+20);
        inputPassDos.setHorizontalAlignment(JTextField.CENTER);
        inputPassDos.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordPane.add(inputPassDos);

        btnIniciar = new JButton("Guardar Datos");
        btnIniciar.setSize(200, 30);
        btnIniciar.setBackground(new Color(51, 157, 179));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFont(new Font("Arial", Font.PLAIN, 15));
        btnIniciar.setLocation((this.getWidth()-btnIniciar.getWidth())/2, 450);
        add(btnIniciar);
        
        btnVolver = new JButton("<html><body>&#129044;</body></html>");
        btnVolver.setSize(100, 30);
        btnVolver.setBackground(new Color(51, 157, 179));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 30));
        btnVolver.setLocation(10, ALTO-70);
        btnVolver.setFocusable(false);
        add(btnVolver);
    }

    protected void initListeners() {
        btnIniciar.addActionListener((event) -> {
            String passUno = this.getStringPass(inputPassUno.getPassword());
            String passDos = this.getStringPass(inputPassDos.getPassword());
            if(passUno.equals(passDos)){
                ManejoArchivos instance = ManejoArchivos.getInstance();
                Jugador jugador = new Jugador(inputName.getText(),passUno,Double.parseDouble(inputSaldoInicial.getText()));
                try {
                    instance.registrarDatosJugador(jugador);
                    JOptionPane.showMessageDialog(null, "Datos registrados exitosamente","",JOptionPane.INFORMATION_MESSAGE); 
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error","Error",JOptionPane.ERROR_MESSAGE);
                }
                inputName.setText("");
                inputPassUno.setText("");
                inputPassDos.setText("");
                inputSaldoInicial.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas deben ser iguales","Error",JOptionPane.ERROR_MESSAGE);
                inputPassUno.setText("");
                inputPassDos.setText("");
            }
        });

        setHoverEffect(btnIniciar);
        
        btnVolver.addActionListener((event) -> {
            MenuInicio.getInstance().initTemplate();
            dispose();
        });

        setHoverEffect(btnVolver);
    }
}
