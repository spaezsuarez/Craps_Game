package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class MenuPartida extends JFrame {
    
    private final int ANCHO = 600,ALTO = 500;
    
    private JLabel dadoUno,dadoDos,datosJugador;
    private JTextField inputApuesta;
    private JButton btnJugar;
    
    
    private void setImagen(JLabel label, String nombreImg) {
        String rutaBase = "src/resources/game/" + nombreImg;
        ImageIcon instr = new ImageIcon(rutaBase);
        Image imginstr = instr.getImage();
        Image nuevaimagen = imginstr.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(nuevaimagen);
        label.setIcon(imagen);
    }
    
    private void setDataPlayer(String nombre,String saldo){
        String data = "<html><body><p style='padding:10px;'>Nombre: "+nombre+"</p><br><p>Saldo:"+saldo+"</p><body></html>";
        datosJugador.setText(data);
        repaint();
    }
    
    private void initComponents(){
        datosJugador = new JLabel("<html><body style='padding:10px;'><p>Nombre: "+"</p><br><p>Saldo:"+"</p><body></html>");
        datosJugador.setSize(new Dimension(300,100));
        datosJugador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datosJugador.setLocation((this.getWidth()-datosJugador.getWidth()) /2, 50);
        add(datosJugador);
        
        inputApuesta = new JTextField();
        inputApuesta.setSize(new Dimension(200,20));
        inputApuesta.setHorizontalAlignment(JTextField.CENTER);
        inputApuesta.setFont(new Font("Arial",Font.PLAIN,15));
        inputApuesta.setLocation((this.getWidth()-inputApuesta.getWidth())/2+100, 200);
        add(inputApuesta);
        
        JLabel label = new JLabel("Valor de la apuesta: ");
        label.setSize(new Dimension(300,20));
        label.setLocation((this.getWidth()-inputApuesta.getWidth())/2-100, 200);
        add(label);
        
        dadoUno = new JLabel();
        dadoUno.setSize(new Dimension(100,100));
        dadoUno.setLocation((this.getWidth() - dadoUno.getWidth()) /2 -100, 270);
        setImagen(dadoUno, "dado1.png");
        add(dadoUno);
        
        dadoDos = new JLabel();
        dadoDos.setSize(new Dimension(100,100));
        dadoDos.setLocation((this.getWidth() - dadoDos.getWidth()) /2 +100, 270);
        setImagen(dadoDos, "dado1.png");
        add(dadoDos);
        
        btnJugar = new JButton("Tirar");
        btnJugar.setSize(100, 30);
        btnJugar.setFocusable(false);
        btnJugar.setBackground(new Color(51, 157, 179));
        btnJugar.setForeground(Color.WHITE);
        btnJugar.setFont(new Font("Arial",Font.PLAIN,20));
        btnJugar.setLocation((this.getWidth()-btnJugar.getWidth())/2, 400);
        add(btnJugar);
    }
    
    private void initListeners(){
        btnJugar.addActionListener((event) -> {
            MenuInicio.getInstance().initTemplate();
            dispose();
        });

        btnJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btnJugar.setBackground(Color.WHITE);
                btnJugar.setForeground(Color.BLACK);
                btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btnJugar.setBackground(new Color(51, 157, 179));
                btnJugar.setForeground(Color.WHITE);
            }
        });
    }
    
    public void initTempalte(){
        setLayout(null);
        Image icon = new ImageIcon(getClass().getResource("/resources/menus/dados.png")).getImage();
        setIconImage(icon);
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
