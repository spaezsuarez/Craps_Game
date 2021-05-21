package models;

public class Partida {
    
    private Dado dadoUno,dadoDos;
    private Jugador jugador;
    private double valorApuesta;
    private Integer valorInicial,valorSecundario;
    private Boolean result;
    
    public Partida(Jugador jugador){
        this.jugador = jugador;
        dadoUno = new Dado();
        dadoDos = new Dado();
        result = Boolean.FALSE;
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

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorSecundario() {
        return valorSecundario;
    }

    public void setValorSecundario(Integer valorSecundario) {
        this.valorSecundario = valorSecundario;
    }

    public Boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    
    public void determinarResultado(){
        
        if(valorInicial == 7 || valorInicial == 11){
            System.out.println("Caso 1");
            result = Boolean.TRUE;
        }else if(valorInicial == 2 || valorInicial == 3 || valorInicial == 12){
            System.out.println("Caso 2");
            result = Boolean.FALSE;
        }else if(valorInicial.equals(valorSecundario) && valorSecundario != null && valorInicial != null){
            System.out.println("Caso 3");
            System.out.println("");
             result = Boolean.TRUE;
        }else if((valorInicial != null && valorSecundario != null)&&( valorInicial != 7 && valorInicial != 11) && valorSecundario == 7){
            System.out.println("Caso 4");
            result = Boolean.FALSE;
        }else{
            result = null;
        }
        
    }
    
    public void modificarSaldoJugador(){
        if(result.equals(Boolean.TRUE))
            jugador.setSaldo(jugador.getSaldo() + valorApuesta);
        else
            jugador.setSaldo(jugador.getSaldo() - valorApuesta);
    }   
    
    public int[] jugarRonda(){
        int[] datos = jugador.lanzarDados(dadoUno, dadoDos);
        
        if(valorInicial == null)
            valorInicial = datos[2];
        else
            valorSecundario = datos[2];
        return datos;
    }
    
    
    
}
