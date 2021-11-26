package estruturadedados;
import java.util.Scanner;

//Selection Sort,  Heap Sort, Merge Sort, Bucket Sort 

public class EstruturaDeDados {
  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers;
        
        System.out.println("Informe qual método deseja usar");
        System.out.println("1 - Selection Sort");
        System.out.println("2 - Heap Sort");
        System.out.println("3 - Merge Sort");
        System.out.println("4 - Bucket Sort");
        System.out.println("Escolha: ");
        
        String choice = scan.nextLine();
        
        switch(choice){
            case "1":
                numbers = getVector();
                
                Ordenação.selectionSort(numbers);
                print(numbers);
                        
                break;
            case "2":
                numbers = getVector();
                
                Ordenação.heapSort(numbers);
                print(numbers);
                
                break;
                
            case "3":
                numbers = getVector();
                
                Ordenação.mergeSort(numbers);
                print(numbers);
                
                break;
                
            case "4":
                numbers = getVector();
                
                Ordenação.bucketSort(numbers);
                print(numbers);
                
                break;
        }
    }
    
    public static void print(int[] vetor){
        for (int i=0; i<vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }
    }
    
    public static int[] getVector(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Informe os valores do vetor (Ex.:1, 2, 3, 4): ");
        String[] stringNumbers = scan.nextLine().replace(" ", "").split(",");

        int[] numbers = new int[stringNumbers.length];
        for (int i=0; i<stringNumbers.length; i++){
            numbers[i] = Integer.valueOf(stringNumbers[i]);       
        }
        return numbers;
    }
    
}
