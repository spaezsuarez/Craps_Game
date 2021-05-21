package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuInicio extends Menu {
    
    private static MenuInicio instance;
    
    private JPanel backGround;
    private JButton btnIniciar, btnRegistrarse, btnAbonar,btnExit;
    private JMenuBar menuBar;
    private JMenu opciones;
    private JMenuItem reglas,acercaDe;
    
    private MenuInicio() {
        super.ANCHO = 600;
        super.ALTO = 600;
    }
    
    public static MenuInicio getInstance(){
        if(instance == null){
            instance = new MenuInicio();
        }
        return instance;
    }
    
   
    protected void initComponents() {
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        
        opciones = new JMenu("Opciones");
        
        reglas = new JMenuItem("Reglas",new ImageIcon("src/resources/menus/question.png"));
        reglas.setBackground(Color.WHITE);
        
        acercaDe = new JMenuItem("Acerca de",new ImageIcon("src/resources/menus/boton-de-informacion.png"));
        acercaDe.setBackground(Color.WHITE);
        
        opciones.add(reglas);
        opciones.add(acercaDe);
        
        menuBar.add(opciones);
        this.setJMenuBar(menuBar);
        
        backGround = new JPanel(null);
        backGround.setSize(new Dimension(ANCHO, ALTO));
        backGround.setLocation(0, 0);
        backGround.setBackground(Color.WHITE);
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
        setImagen(image, "menus/dados.png");
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
        btnRegistrarse.setBackground(new Color(51,157,179));
        btnRegistrarse.setForeground(Color.WHITE);
        backGround.add(btnRegistrarse);
        
        btnAbonar = new JButton("Abonar usuario");
        btnAbonar.setSize(200, 30);
        btnAbonar.setLocation((this.getWidth() - btnAbonar.getWidth()) / 2, 400);
        btnAbonar.setFocusable(false);
        btnAbonar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnAbonar.setBackground(new Color(51,157,179));
        btnAbonar.setForeground(Color.WHITE);
        backGround.add(btnAbonar);
        
        btnExit = new JButton("Salir");
        btnExit.setSize(200, 30);
        btnExit.setLocation((this.getWidth() - btnExit.getWidth()) / 2, 450);
        btnExit.setFocusable(false);
        btnExit.setFont(new Font("Arial", Font.PLAIN, 20));
        btnExit.setBackground(new Color(51,157,179));
        btnExit.setForeground(Color.WHITE);
        backGround.add(btnExit);
    }
    
    protected void initListeners() {
        
        reglas.addActionListener((event) -> {
            
            String result = "Inicialmente se realizara el lanzamiento de dos dados.\nCuando esto ocurra se tomaran ciertas reglas dependiendo del valor obtenido.\n"+
            "1) Si en el lanzamiento inicial el valor es 7 u 11 el jugador gana.\n" +
            "2) Si el valor es distinto, el jugador seguira lanzando hasta obtener el mismo número.\n"+ 
            "3) Si al lanzar por segunda vez obtiene el valor de 7 el jugador pierde."+
            "4) Si al lanzar por primera vez obtiene el valor de 2,3 o 12 el jugador pierde.";
            JOptionPane.showMessageDialog(null,result,"Reglas de este juego",JOptionPane.QUESTION_MESSAGE);
        });
        
        acercaDe.addActionListener((event) -> {
            String result = "Autor: Sergio David Paez Suarez \nPeril de Github: https://github.com/spaezsuarez \nRepositorio de este programa:https://github.com/spaezsuarez/Craps_Game";
            JOptionPane.showMessageDialog(null,result,"Información",JOptionPane.INFORMATION_MESSAGE);
        });
        
        //Boton para iniciar la partida
        btnIniciar.addActionListener((event) -> {
            MenuLogin menu = new MenuLogin();
            menu.initTemplate();
            dispose();
        });
        
        setHoverEffect(btnIniciar);
        
        //btnRegistrar
        btnRegistrarse.addActionListener((event) -> {
            MenuRegistro menu = new MenuRegistro();
            menu.initTemplate();
            dispose();
        });
        
        setHoverEffect(btnRegistrarse);
        
        //btnAbonar
        btnAbonar.addActionListener((event) -> {
            MenuAbonar menu = new MenuAbonar();
            menu.initTemplate();
            dispose();
        });
        
        setHoverEffect(btnAbonar);
        
        btnExit.addActionListener((event) -> {
            System.exit(0);
        });
        
        setHoverEffect(btnExit);
        
    }
    
}
