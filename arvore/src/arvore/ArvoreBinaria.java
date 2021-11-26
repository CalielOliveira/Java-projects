package arvore;

import java.util.Scanner;


public class ArvoreBinaria {
    
    public static void main(String[] args){
        BArvore arvore1 = new BArvore();
        Scanner scan = new Scanner(System.in);

        System.out.printf("Escreva o numero a ser inserido: ");
        int number = Integer.valueOf(scan.nextLine());
        arvore1.inserirNo(number);
        
        boolean inLoop = true;
        while(inLoop){
            System.out.println("---escolha uma das opções---");
            System.out.println("1 - Inserir No");
            System.out.println("2 - Exibir No");
            System.out.println("3 - Excluir No");
            System.out.println("4 - Encerrar");
            
            int choice = Integer.valueOf(scan.nextLine());
            System.out.println("choice: "+choice);
            
            switch (choice) {
                case 1:
                    System.out.printf("Escreva o numero a ser inserido: ");
                    number = Integer.valueOf(scan.nextLine());
                    arvore1.inserirNo(number);
                    break;
                case 2:
                    System.out.print("Nó: ");
                    arvore1.exibirNo();
                    break;
                case 3:
                    System.out.printf("Escreva o numero a ser excluido: ");
                    number = Integer.valueOf(scan.nextLine());
                    arvore1.excluirNo(number);
                    break;
                case 4:
                    inLoop = false;                    
                    break;
            }
        }             
    }
}
