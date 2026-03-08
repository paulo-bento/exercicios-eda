package Parte1;

import java.util.Arrays;

public class Exercicio008 {
    public static void main(String[] args) {

        int[] vetor = {10, 20, 30, 40, 50};

        limparvetor(vetor);

        System.out.println(Arrays.toString(vetor));
    }

    public static void limparvetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 0;
        }
    }
}