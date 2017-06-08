package appaps;

import java.util.Random;

public class Ponto {
    
    private final int lado;
    private final int tentativas;
    private int tiro_id;    
    private int x;
    private int y;   
    private int parcial;
    
    //construtor
    public Ponto(int lado, int num){
        this.lado = lado;
        this.tentativas = num;
        this.tiro_id = 1;
    }
    
    public void GerarPosicaoDoAlvo(){
       
        //definir limites de posição
        int max = lado/2;
        int min = (lado/2) * -1;          
        
        //gerar posições randômicas
        Random obj = new Random();
        
        int px = obj.nextInt(max + 1 - min) + min;
        int py = obj.nextInt(max + 1 - min) + min;  
        
        //alterar atributos privados 
        SetX(px);
        SetY(py);
    }
    
    
    //métodos getter
    public int GetX(){
        return x;
    }
    
    public int GetY(){
        return y;
    }
    
    public int GetDistanciaEntrePontos(int x1, int y1, int x2, int y2){
        int dist = (int) Math.hypot(x1-x2, y1-y2);
        return dist;
    }
    
    public int GetTiroAtual(){
        return tiro_id;
    }
    
    public int GetTentativas(){
        return tentativas;
    }
    
    public int GetParcial(){
        return parcial;
    }
    
    public int GetLado(){
        return lado;
    }
    //métodos setter
    public void SetX(int x){
        this.x = x;
    }
    
    public void SetY(int y){
        this.y = y;
    }
    
    public void SetTiroAtual(int tiro_id){
        this.tiro_id = tiro_id;
    }
    
    public void SetParcial(int score){
        parcial = score;
    }
    
    //métodos auxiliares 
    public int CalcularPontuacao(int distancia){
        //pontuação máxima = lado do quadrado 
        //pontuação do jogador = lado - distância do tiro (proporcionalidade)
        int p = lado - distancia;
        //caso o valor seja menor que 0, retornar 0 (caso o tiro tenha sido muito distante).
        return p < 0 ? 0 : p;
    }    
}
