package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.io.IOException;

import models.Partida;
import models.Jugador;
import persistence.ManejoArchivos;

public class MenuPartida extends Menu {

    private JLabel dadoUno, dadoDos, datosJugador;
    private JTextField inputApuesta;
    private JButton btnJugar, btnVolver;

    private Partida partida;

    public MenuPartida(String[] dataPlayer) {
        super.ANCHO = 600;
        super.ALTO = 500;
        partida = new Partida(new Jugador(dataPlayer[0], dataPlayer[1], Double.parseDouble(dataPlayer[2])));
       
    }

    private void setDataPlayer(String nombre, String saldo) {
        String data = "<html><body style='padding:10px;' ><p>Nombre: " + nombre + "</p><br><p>Saldo: " + saldo + "</p></body></html>";
        datosJugador.setText(data);
        repaint();
    }

    protected void initComponents() {
        datosJugador = new JLabel();
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
        setImagen(dadoUno, "game/dado1.png");
        add(dadoUno);

        dadoDos = new JLabel();
        dadoDos.setSize(new Dimension(100, 100));
        dadoDos.setLocation((this.getWidth() - dadoDos.getWidth()) / 2 + 100, 270);
        setImagen(dadoDos, "game/dado1.png");
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

    protected void initListeners() {
        
        setHoverEffect(btnJugar);
        setHoverEffect(btnVolver);
        
        btnJugar.addActionListener((event) -> {
            try {
                if (Double.parseDouble(inputApuesta.getText()) <= partida.getJugador().getSaldo()) {
                    ManejoArchivos insManejoArchivos = ManejoArchivos.getInstance();
                    partida.setValorApuesta(Double.parseDouble(inputApuesta.getText()));
                    int[] result = partida.jugarRonda();
                    inputApuesta.setEditable(false);

                    setImagen(dadoUno, "game/dado" + result[0] + ".png");
                    setImagen(dadoUno, "game/dado" + result[1] + ".png");
                    System.out.println("Result: " + result[2]);
                    repaint();

                    partida.determinarResultado();

                    if (partida.isResult() != null && partida.isResult().equals(Boolean.TRUE)) {
                        JOptionPane.showMessageDialog(null, "Gano", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                        partida.modificarSaldoJugador();
                        setDataPlayer(partida.getJugador().getNombre(), "" + partida.getJugador().getSaldo());
                        repaint();
                        insManejoArchivos.editarDatosJugador(partida.getJugador());

                        setImagen(dadoUno, "game/dado1.png");
                        setImagen(dadoUno, "game/dado1.png");
                        inputApuesta.setText("");

                        partida.setValorInicial(null);
                        partida.setValorSecundario(null);
                        
                        inputApuesta.setEditable(true);

                        repaint();

                    } else if (partida.isResult() != null && partida.isResult().equals(Boolean.FALSE)) {
                        JOptionPane.showMessageDialog(null, "Perdio", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
                        partida.modificarSaldoJugador();
                        setDataPlayer(partida.getJugador().getNombre(), "" + partida.getJugador().getSaldo());
                        
                        insManejoArchivos.editarDatosJugador(partida.getJugador());
                        inputApuesta.setEditable(true);
                        repaint();
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

        
        btnVolver.addActionListener((event) -> {
            MenuInicio.getInstance().initTemplate();
            dispose();
        });

        
    }
    
    public void initTemplate(){
        super.initTemplate();
        setDataPlayer(partida.getJugador().getNombre(), "" + partida.getJugador().getSaldo());
    }

}
