package br.com.fatecpg.semana03;

import java.util.Scanner;

public class FuncaoDeDistancia {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a Palavra: ");
        String palavra = scanner.nextLine();
        System.out.print("Dicionario: ");
        String dicionario = scanner.nextLine();
        
        //String dicionario = "Santos";
        //String palavra = "Santu";
        System.out.println("Pontuacao: "+calcularPontuacao(palavra, dicionario));
        
    }
    
    public static float calcularPontuacao(String palavra, String dicionario){        
        
        float somaDicionario = compararDicionario(dicionario);
        float somaPalavra = contarCaracteresIguais(palavra, dicionario) + contarCaracteresIguaisEProporcionais(palavra, dicionario) + contarCaracteresIguaisENaMesmaPosicao(palavra, dicionario);       
        
        return   somaDicionario / somaPalavra;       
    }
    
    public static String converterMinusculo(String palavra){
        palavra = palavra.toLowerCase();
        return palavra;
    
    }
    public static int compararDicionario(String dicionario){
        int pontuacao = 0;
        dicionario = converterMinusculo(dicionario);
        
        for(int i=0; i < dicionario.length(); i++){
            for(int j=0; j < dicionario.length(); j++){
                if(dicionario.charAt(i) == dicionario.charAt(j)){
                    pontuacao++;
                }
            }
        }
        return pontuacao;
    }
    public static int contarCaracteresIguais(String palavra, String dicionario){
        int pontuacao = 0;
        palavra = converterMinusculo(palavra);
        dicionario = converterMinusculo(dicionario);
        
        for(int i=0; i < palavra.length(); i++){      
            for(int j=0; j < dicionario.length(); j++){                
                if(palavra.charAt(i) == dicionario.charAt(j)){
                    pontuacao++;
                }
            }
        
        }
        return pontuacao;
    }
    
    public static int contarCaracteresIguaisEProporcionais(String palavra, String dicionario){
        int pontuacao = 0;
        
        for(int i=0; i < palavra.length(); i++){      
            for(int j=0; j < dicionario.length(); j++){                
                if(palavra.charAt(i) == dicionario.charAt(j)){
                    pontuacao+=2;
                }
            }
        
        }
        return pontuacao;
    }
    
    public static int contarCaracteresIguaisENaMesmaPosicao(String palavra, String dicionario){
        int pontuacao = 0;
        palavra = converterMinusculo(palavra);
        dicionario = converterMinusculo(dicionario);
        
        for(int i=0; i < palavra.length(); i++){      
            for(int j=0; j < dicionario.length(); j++){                
                if(palavra.charAt(i) == dicionario.charAt(j) && i == j){
                    pontuacao+=3;
                }
            }
        
        }
        return pontuacao;
    }    
}