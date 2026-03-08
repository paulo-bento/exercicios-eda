package Parte1;

import java.util.Arrays;
import java.util.Scanner;

public class ExercicioCTest008B {
    public static void main(String[] args) {
        System.out.println("Digite o Tamanho do vetor: ");
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        String[] vetor = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            System.out.println("Vcoê precisa digitar: " + i + " Elementos");
            String elemento = sc.next();
            vetor[i] = elemento;
        }
        System.out.println("Vetor completo: ");
        System.out.println(Arrays.toString(vetor));
        System.out.println();
        limparVetor(vetor);
        System.out.println("Vetor limpo: ");
        System.out.println(Arrays.toString(vetor));
        sc.close();
    }

    public static void limparVetor(String[] vetor){
        for  (int i = 0; i < vetor.length; i++) {
            vetor[i] = null;
        }
    }
}
