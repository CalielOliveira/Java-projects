package estruturadedados;

public class Busca {
    
    public static boolean buscaLinear(int[] numbers, int n){
        for (int i=0; i<numbers.length; i++){
            if(numbers[i] == n){
                return true;
            }
        }
        return false;
    }
    
    public static boolean buscaBinaria(int[] numbers, int n){
        int max = numbers.length-1;
        int min = 0;
        
        while(min <= max){
            int placeHolder = (max+min)/2;
            if (numbers[placeHolder] > n){
                max = placeHolder-1;
            }
            else if (numbers[placeHolder] < n){
                    min = placeHolder+1;
            }
            else{
                return true;
            }
        }
        
        return false;
    }
    
}
