package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import models.Jugador;

public class ManejoArchivos {

    private static ManejoArchivos instance;
    private String rutaArchivo;

    private ManejoArchivos() {
        rutaArchivo = "./src/persistence/data.txt";
    }

    public String[] obtenerDatosJugador(String nombre,String contraseña) throws FileNotFoundException, IOException {
        String[] datosJugador = new String[3];
        String cadena;
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            datosJugador = cadena.split(",");
            if(datosJugador[0].equals(nombre) && datosJugador[1].equals(contraseña)){
               return datosJugador;
            }
        }
        b.close();
        datosJugador = null;
        return datosJugador;
    }

    public void registrarDatosJugador(Jugador jugador) throws IOException {
        File archivo = new File(rutaArchivo);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(jugador.toString() + "\n");
        bw.close();

    }
    
    public void editarDatosJugador(Jugador jugador) throws IOException{
        String[] datosJugador = new String[3];
        String oldData = "";
        
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);
        
        String cadena;

        while ((cadena = b.readLine()) != null) {
            datosJugador = cadena.split(",");
            if(datosJugador[0].equals(jugador.getNombre()) && datosJugador[1].equals(jugador.getContraseña())){
                oldData += jugador.toString()+"\n";
            }else{
                oldData += cadena + " \n";
            }
        }
        File archivo = new File(rutaArchivo);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(oldData);
        bw.close();
        b.close();
    }

    public static ManejoArchivos getInstance() {
        if (instance == null) {
            instance = new ManejoArchivos();
        }
        return instance;
    }

}
