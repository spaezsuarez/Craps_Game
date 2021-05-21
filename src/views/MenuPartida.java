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
import javax.swing.JOptionPane;
import java.io.IOException;

import models.Partida;
import models.Jugador;
import persistence.ManejoArchivos;

public class MenuPartida extends JFrame {

    private final int ANCHO = 600, ALTO = 500;

    private JLabel dadoUno, dadoDos, datosJugador;
    private JTextField inputApuesta;
    private JButton btnJugar, btnVolver;

    private Partida partida;

    public MenuPartida(String[] dataPlayer) {
        partida = new Partida(new Jugador(dataPlayer[0], dataPlayer[1], Double.parseDouble(dataPlayer[2])));
    }

    private void setImagen(JLabel label, String nombreImg) {
        String rutaBase = "src/resources/game/" + nombreImg;
        ImageIcon instr = new ImageIcon(rutaBase);
        Image imginstr = instr.getImage();
        Image nuevaimagen = imginstr.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(nuevaimagen);
        label.setIcon(imagen);
    }

    private void setDataPlayer(String nombre, String saldo) {
        String data = "<html><body><p style='padding:10px;'>Nombre: " + nombre + "</p><br><p>Saldo:" + saldo + "</p></body></html>";
        datosJugador.setText(data);
        repaint();
    }

    private void initComponents() {
        datosJugador = new JLabel("<html><body style='padding:10px;'><p>Nombre: " + "</p><br><p>Saldo:" + "</p></body></html>");
        datosJugador.setSize(new Dimension(300, 100));
        datosJugador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datosJugador.setLocation((this.getWidth() - datosJugador.getWidth()) / 2, 50);
        add(datosJugador);

        inputApuesta = new JTextField();
        inputApuesta.setSize(new Dimension(200, 20));
        inputApuesta.setHorizontalAlignment(JTextField.CENTER);
        inputApuesta.setFont(new Font("Arial", Font.PLAIN, 15));
        inputApuesta.setLocation((this.getWidth() - inputApuesta.getWidth()) / 2 + 100, 200);
        add(inputApuesta);

        JLabel label = new JLabel("Valor de la apuesta: ");
        label.setSize(new Dimension(300, 20));
        label.setLocation((this.getWidth() - inputApuesta.getWidth()) / 2 - 100, 200);
        add(label);

        dadoUno = new JLabel();
        dadoUno.setSize(new Dimension(100, 100));
        dadoUno.setLocation((this.getWidth() - dadoUno.getWidth()) / 2 - 100, 270);
        setImagen(dadoUno, "dado1.png");
        add(dadoUno);

        dadoDos = new JLabel();
        dadoDos.setSize(new Dimension(100, 100));
        dadoDos.setLocation((this.getWidth() - dadoDos.getWidth()) / 2 + 100, 270);
        setImagen(dadoDos, "dado1.png");
        add(dadoDos);

        btnJugar = new JButton("Tirar");
        btnJugar.setSize(100, 30);
        btnJugar.setFocusable(false);
        btnJugar.setBackground(new Color(51, 157, 179));
        btnJugar.setForeground(Color.WHITE);
        btnJugar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnJugar.setLocation((this.getWidth() - btnJugar.getWidth()) / 2, 400);
        add(btnJugar);

        btnVolver = new JButton("<html><body>&#129044;</body></html>");
        btnVolver.setSize(100, 30);
        btnVolver.setBackground(new Color(51, 157, 179));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setLocation(10, ALTO - 70);
        btnVolver.setFocusable(false);
        add(btnVolver);
    }

    private void initListeners() {
        btnJugar.addActionListener((event) -> {
            try {
                if (Double.parseDouble(inputApuesta.getText()) <= partida.getJugador().getSaldo()) {
                    ManejoArchivos insManejoArchivos = ManejoArchivos.getInstance();
                    partida.setValorApuesta(Double.parseDouble(inputApuesta.getText()));
                    int[] result = partida.jugarRonda();

                    setImagen(dadoUno, "dado" + result[0] + ".png");
                    setImagen(dadoUno, "dado" + result[1] + ".png");
                    System.out.println("Result: " + result[2]);
                    repaint();

                    partida.determinarResultado();

                    if (partida.isResult() != null && partida.isResult().equals(Boolean.TRUE)) {
                        JOptionPane.showMessageDialog(null, "Gano", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                        partida.modificarSaldoJugador();
                        setDataPlayer(partida.getJugador().getNombre(), "" + partida.getJugador().getSaldo());
                        repaint();
                        insManejoArchivos.editarDatosJugador(partida.getJugador());

                        setImagen(dadoUno, "dado1.png");
                        setImagen(dadoUno, "dado1.png");
                        inputApuesta.setText("");

                        partida.setValorInicial(null);
                        partida.setValorSecundario(null);

                        repaint();

                    } else if (partida.isResult() != null && partida.isResult().equals(Boolean.FALSE)) {
                        JOptionPane.showMessageDialog(null, "Perdio", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
                        partida.modificarSaldoJugador();
                        setDataPlayer(partida.getJugador().getNombre(), "" + partida.getJugador().getSaldo());
                        repaint();
                        insManejoArchivos.editarDatosJugador(partida.getJugador());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Asegurese que tiene suficient dinero para apostar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Tiene que haber un valor de apuesta", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }

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

    public void initTempalte() {
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
        setDataPlayer(partida.getJugador().getNombre(), "" + partida.getJugador().getSaldo());
        setVisible(true);

    }

}
