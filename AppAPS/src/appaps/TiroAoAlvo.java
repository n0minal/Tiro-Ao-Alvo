package appaps;

import java.util.Scanner;

public class TiroAoAlvo {
    Ponto point;
    
    //constructor
    public TiroAoAlvo(int lado, int num){
        point = new Ponto(lado, num);
    }
    
    public void Joga(String nome){
        
        point.GerarPosicaoDoAlvo();
        
        System.out.println("====================================================");
        System.out.println("    Jogador " + nome);
        System.out.println("    Seu alvo está no intervalo [-" + (point.GetLado()/2) + ", +" + (point.GetLado()/2) + "]");
        System.out.println("    Você tem direito a " + point.GetTentativas() + " tiros");
        //pontuação maxima é igual ao tamanho do lado do quadrado para manter proporcionalidade com a distância
        System.out.println("    A pontuação máxima deste round é de " + point.GetLado() + " pontos!");
        System.out.println("====================================================");
        
        
        
        //instanciar classe fora do loop faz bem
        Scanner scan = new Scanner (System.in);
        
        for(int i = 0; i < point.GetTentativas(); i++){
            System.out.println("*** Tiro " + point.GetTiroAtual() + " — entre com o par x y:");

            int tiro_x = scan.nextInt();
            int tiro_y = scan.nextInt();
                    
            int distance = point.GetDistanciaEntrePontos(tiro_x, tiro_y, point.GetX(), point.GetY());
            int score = point.CalcularPontuacao(distance);
            point.SetTiroAtual(point.GetTiroAtual() + 1);
            System.out.println("Você fez " + score + " pontos!");
            point.SetParcial(point.GetParcial() + score);
            System.out.println("Sua parcial agora é " + point.GetParcial());            
        }
        System.out.println("Fim das tentativas cowboy... Você fez um total de " + point.GetParcial() + " pontos, parabéns!");
        System.out.println("O alvo estava em (X " + point.GetX() + ", Y " + point.GetY() + ")!");
    }
}
