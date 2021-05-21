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
    
    public int  lanzarDados(Dado dadoUno,Dado dadoDos){
        return dadoUno.obtenerValor() + dadoDos.obtenerValor();
    }

    @Override
    public String toString() {
        return nombre + "," + contraseña + "," + saldo;
    }
    
    
}
