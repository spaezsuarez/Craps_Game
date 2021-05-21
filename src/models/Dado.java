package models;

public class Dado {
    
    public int obtenerValor(){
        return (int) Math.random()*6 + 1;
    }
    
}
