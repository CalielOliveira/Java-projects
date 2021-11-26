package estruturadedados;
//numbers = {1, 7, 5, 9, 3, 2, 8}

import java.util.Arrays;


public class Ordenação {
    
    public static void selectionSort(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < numbers.length; j++){  
                if (numbers[j] < numbers[index]){  
                    index = j;//identifica menor índice  
                }  
            }  
            int menorValor = numbers[index];   
            numbers[index] = numbers[i];  
            numbers[i] = menorValor;  
        }  

    }
    
    public static void binaryInsertionSort(int[] numbers){
        for (int i = 1; i < numbers.length; i++){
            int x = numbers[i];

            //Encontar o local para inserção
            //Math.abs - método tem a função de retornar o valor absoluto 
            //Arrays.binarySearch - encontrar um elemento específico dentro do array. 
            //Retorna a posição no array (inteiro)
            int j = Math.abs(Arrays.binarySearch(numbers, 0,i, x) + 1);

            // mundando para a posição correta
            //System.arraycopy - copia qualquer valor do array origem para o array destino
            System.arraycopy(numbers, j,numbers, j + 1, i - j);

            // colocando na posição correta
            numbers[j] = x;
        }

    }
    
    public static void insertionSort(int[] numbers){
        int i, j, chave;
        
        for (j = 1; j < numbers.length; j++){
            chave = numbers[j];
            
            for (i = j - 1; (i >= 0) && (numbers[i] > chave); i--){
                numbers[i + 1] = numbers[i];
            }
            
            numbers[i + 1] = chave;
        }

    }
    
    public static void quickSort(int[] numbers, int esquerda, int direita){
        int esq = esquerda;
        int dir = direita;
        int pivo = numbers[(esq + dir) / 2];
        int troca;

        while (esq <= dir) {
            while (numbers[esq] < pivo) {
                    esq = esq + 1;
            }
            while (numbers[dir] > pivo) {
                    dir = dir - 1;
            }
            if (esq <= dir) {
                    troca = numbers[esq];
                    numbers[esq] = numbers[dir];
                    numbers[dir] = troca;
                    esq = esq + 1;
                    dir = dir - 1;
            }
        }
    }
    
    //overload
    public static void quickSort(int[] numbers){
        int esq = 0;
        int dir = numbers.length-1;
        int pivo = numbers[(esq + dir) / 2];
        int troca;

        while (esq <= dir) {
            while (numbers[esq] < pivo) {
                    esq = esq + 1;
            }
            while (numbers[dir] > pivo) {
                    dir = dir - 1;
            }
            if (esq <= dir) {
                    troca = numbers[esq];
                    numbers[esq] = numbers[dir];
                    numbers[dir] = troca;
                    esq = esq + 1;
                    dir = dir - 1;
            }
        }
    }
        
    
    public static void bubbleSort(int[] numbers){
        int length = numbers.length;
        int aux;
        
        int trocados = 0;
        int count = 0;
        while(true){
            if (numbers[count] > numbers[count+1]){
                    aux = numbers[count+1];
                    numbers[count+1] = numbers[count];
                    numbers[count] = aux;
                    trocados++;                   
            }
            if (count == length-2){
                count = 0;
                if(trocados == 0){
                    break;                   
                }
                trocados = 0;            
            }else{
                count++;
            }
        }
        
    }
        
    
    public static void vetorOrdenado(int[] numbers){
        int lenght = numbers.length;
        int aux;
        
        for (int i=0; i<lenght-1; i++){
            for (int j=0; j<lenght-1-i; j++){
                if (numbers[j] > numbers[j+1]){
                    aux = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = aux;
                }
            }
        }
    }
}
