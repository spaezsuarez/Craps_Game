package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Menu extends JFrame {

    protected int ANCHO, ALTO;

    protected void setImagen(JLabel label, String nombreImagen) {
        String rutaBase = "src/resources/" + nombreImagen;
        ImageIcon instr = new ImageIcon(rutaBase);
        Image imginstr = instr.getImage();
        Image nuevaimagen = imginstr.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(nuevaimagen);
        label.setIcon(imagen);
    }
    
    protected String getStringPass(char[] pass){
        String result = "";
        for(int i = 0; i < pass.length;i++){
            result += pass[i];
        }
        return result;
    }

    protected void setHoverEffect(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                btn.setBackground(new Color(51, 157, 179));
                btn.setForeground(Color.WHITE);
            }
        });
    }

    protected abstract void initComponents();

    protected abstract void initListeners();

    public void initTemplate() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        Image icon = new ImageIcon(getClass().getResource("/resources/menus/dados.png")).getImage();
        setIconImage(icon);
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
