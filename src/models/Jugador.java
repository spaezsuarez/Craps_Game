package models;


public class Jugador {
    
    private String nombre,contraseña;
    private double saldo;
    
    public Jugador(String nombre,String contraseña,double saldo){
        this.saldo = saldo;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public int[]  lanzarDados(Dado dadoUno,Dado dadoDos){
        int[] result = new int[3];
        int valorUno = dadoUno.obtenerValor(), valorDos = dadoDos.obtenerValor();
        result[0] = valorUno;
        result[1] = valorDos;
        result[2] = valorUno + valorDos;
        return result;
    }

    @Override
    public String toString() {
        return nombre + "," + contraseña + "," + saldo;
    }
    
    
}
