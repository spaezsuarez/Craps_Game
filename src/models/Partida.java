package models;


public class Partida {
    
    private Dado dadoUno,dadoDos;
    private Jugador jugador;
    private double valorApuesta;
    private int valorInicial,valorSecundario;
    private Boolean result;
    
    public Partida(Jugador jugador){
        this.jugador = jugador;
        dadoUno = new Dado();
        dadoDos = new Dado();
    }

    public Dado getDadoUno() {
        return dadoUno;
    }

    public void setDadoUno(Dado dadoUno) {
        this.dadoUno = dadoUno;
    }

    public Dado getDadoDos() {
        return dadoDos;
    }

    public void setDadoDos(Dado dadoDos) {
        this.dadoDos = dadoDos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public double getValorApuesta() {
        return valorApuesta;
    }

    public void setValorApuesta(double valorApuesta) {
        this.valorApuesta = valorApuesta;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorSecundario() {
        return valorSecundario;
    }

    public void setValorSecundario(int valorSecundario) {
        this.valorSecundario = valorSecundario;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    
    public void determinarResultado(){
        if(valorInicial == 7 || valorInicial == 11)
            result = true;
        
        if(valorInicial == valorSecundario)
            result = true;
        
        if((valorInicial != 7 && valorInicial != 11) && valorSecundario == 7)
            result = false;
        
        result = null;
    }
    
    public void modificarSaldoJugador(double valorCambio,boolean bono){
        if(bono)
            jugador.setSaldo(jugador.getSaldo() + valorCambio);
        else
            jugador.setSaldo(jugador.getSaldo() - valorCambio);
    }   
    
    public int[] jugarRonda(){
        int[] result = new int[3];
        
        int valorUno = this.jugador.lanzarDados(dadoUno, dadoDos);
        int valorDos = this.jugador.lanzarDados(dadoUno, dadoDos);
        
        result[0] = valorUno;
        result[1] = valorDos;
        result[2] = valorUno+valorDos;
        return result;
    }
    
    
    
}
