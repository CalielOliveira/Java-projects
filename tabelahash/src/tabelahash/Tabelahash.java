package tabelahash;

import java.io.*;   
import java.util.*; 
import java.lang.*;

class Hash {
  public double item;
  public boolean ocupado;
  
  public Hash(boolean b) { // construtor
    ocupado = b;
  }
  
  public Hash(){
      ocupado = false;
  }
}

class HashLinear {
  private Hash[] tab;
  private int MAX;

  public HashLinear(int tam) {
    tab = new Hash[tam];
    MAX = tam;

  }
  
  private int funcaohash(double chave) {
        int v = (int) chave;
	return ( Math.abs(v) % MAX );
  }
  
  public void insere(double[] numbers) {
    
      
    for (int i=0; i<numbers.length; i++){
        int pos = funcaohash(numbers[i]); // CALCULA POSIÇAO

        // INICIO ROTINA TRATAMENTO DE COLISAO
        if (tab[pos].ocupado) { // se ocorreu colisao

            System.out.println("-> Ocorreu uma colisao na posicao " + pos);
            while (pos < MAX) {
                if (pos == MAX-1 ) pos = -1; // volta para o inicio da tabela
                pos++; // incremento mais um no indice
                if ( !tab[pos].ocupado ) // se a posição estiver livre
                   break; // sai do loop com o indice na posicao correta (pos sem colisão)
            }
        }
        tab[pos].item=numbers[i];
        tab[pos].ocupado = true;
    }
  }

  public int busca(double chave) { // Recuperando um elemento
     int pos = funcaohash(chave);
     if (tab[pos].ocupado) {
        if (tab[pos].item == chave) // Se o campo esta ocupado e o nome e chave são iguais
	   return pos; // saida imediata da função

           // INICIO ROTINA TRATAMENTO DE COLISAO (se o item e chave nao sao iguais)
           int iniciobusca = pos;
	   while (pos < MAX) { // percorre proximas posições do vetor
             if (pos == MAX-1) pos=-1; // volta para o inicio da tabela
             pos++; // incremento mais um no indice
	     if (tab[pos].ocupado && tab[pos].item == chave) // se o campo esta ocupado e o item foi encontrado
		 return pos; // saida imediata da função
	    if (pos == iniciobusca) return -1; // se percorreu tudo e nao encontrou
           }
	  //FIM ROTINA TRATAMENTO DE COLISAO
     }
     return -1;
  }

  public void apaga(double chave) {
    int pos = busca(chave);
    if (pos != -1) {
       tab[pos].ocupado = false;
       System.out.print("-> Dado tabela HASH[" + pos + "] apagado");
    }
    else System.out.print("Item nao encontrado");
  }

  public void imprime() {
    for (int i=0; i<MAX; i++)
       if ( tab[i].ocupado )
          System.out.print("\nPosição Hash[" + i + "] = " + tab[i].item);
  }
  

}

//////////////////////////////////////////////////////
public class Tabelahash {
    
  public static void main(String[] args) {
    Scanner le = new Scanner(System.in);
    double[] numbers;

    System.out.println("\n*********************************************************************");
    numbers = getVector();
    System.out.print("*********************************************************************");
    
    HashLinear tab = new HashLinear(numbers.length);
    tab.insere(numbers);
    
    System.out.print("\n\nBuscando campo\n>>> Digite valor decimal: ");
    double numero = le.nextDouble();
    if ( tab.busca(numero) != -1 )
       System.out.print("Item encontrado na posicao " + tab.busca(numero));
    else
       System.out.print("Item nao encontrado");
	
    System.out.print("\n\nApagando valor\n>>> Digite valor decimal: ");
    numero = le.nextDouble();
    tab.apaga(numero);
	
    System.out.print("\n\nMostrando Valores");
    tab.imprime();

    System.out.println("\n");
  }
  
  public static double[] getVector(){
    Scanner scan = new Scanner(System.in);

    System.out.println("Informe os valores do vetor (Ex.:1.2, 2.0, 3.3, 4.5): ");
    String[] stringNumbers = scan.nextLine().replace(" ", "").split(",");

    double[] numbers = new double[stringNumbers.length];
    for (int i=0; i<stringNumbers.length; i++){
        numbers[i] = Double.valueOf(stringNumbers[i]);       
    }
    return numbers;
}
}

