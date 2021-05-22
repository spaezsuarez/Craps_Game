package models;

public class Dado {
    
    public int obtenerValor(){
        int temp = (int) (Math.random() * 6 + 1);
        return temp;
    }
    
}
