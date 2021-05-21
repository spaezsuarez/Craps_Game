package models;

public class Dado {
    
    public int obtenerValor(){
        int temp = (int) (Math.random() * 6 + 1);
        System.out.println(temp);
        return temp;
    }
    
}
