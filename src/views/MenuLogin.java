package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import persistence.ManejoArchivos;

public class MenuLogin extends Menu {

    private JTextField inputName;
    private JPasswordField inputPass;
    private JButton btnIniciar, btnVolver;
    
    public MenuLogin(){
        super.ANCHO = 600;
        super.ALTO = 400;
    }

    private String getStringPass(char[] pass) {
        String result = "";
        for (int i = 0; i < pass.length; i++) {
            result += pass[i];
        }
        return result;
    }

    protected void initComponents() {
        JLabel image = new JLabel();
        image.setSize(new Dimension(150, 150));
        image.setLocation((this.getWidth() - image.getWidth()) / 2, 20);
        setImagen(image, "menus/user.png");
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
        btnIniciar.setLocation((this.getWidth() - btnIniciar.getWidth()) / 2, 300);
        btnIniciar.setFocusable(false);
        add(btnIniciar);

        btnVolver = new JButton("<html><body>&#129044;</body></html>");
        btnVolver.setSize(100, 30);
        btnVolver.setBackground(new Color(51, 157, 179));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setLocation(10, ALTO - 70);
        btnVolver.setFocusable(false);
        add(btnVolver);
    }

    protected void initListeners() {
        btnIniciar.addActionListener((event) -> {
            ManejoArchivos manejador = ManejoArchivos.getInstance();
            try {
                String[] data = manejador.obtenerDatosJugador(inputName.getText(), getStringPass(inputPass.getPassword()));
                if (data == null) {
                    JOptionPane.showMessageDialog(null, "Asegurese de estar registrado", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (Double.parseDouble(data[2]) == 0.0) {
                    JOptionPane.showMessageDialog(null, "Debe recargar su saldo para poder jugar", "Error", JOptionPane.ERROR_MESSAGE);
                    MenuInicio.getInstance().initTemplate();
                    dispose();
                } else {
                    System.out.println(data[0]);
                    MenuPartida menu = new MenuPartida(data);
                    menu.initTemplate();
                    dispose();
                }

            } catch (IOException ex) {}
        });

        setHoverEffect(btnIniciar);

        btnVolver.addActionListener((event) -> {
            MenuInicio.getInstance().initTemplate();
            dispose();
        });

        setHoverEffect(btnVolver);
    }

}
