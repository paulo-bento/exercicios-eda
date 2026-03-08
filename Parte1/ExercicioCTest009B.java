package Parte1;

import java.util.Scanner;

public class ExercicioCTest009B {
    public static void main(String[] args) {
        System.out.println("Digite o tamanho da Lista: ");
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        String[] Lista = new String[tamanho];
        for (int i = 0; i < tamanho; i++) {
            System.out.println("DIGITE SEUS ELEMENTOS: ");
            Lista[i] = sc.next();
        }
        System.out.println("Digite a suposta ocorrencia: ");
        String ocorrencia = sc.next();

        System.out.println("Sua ocorrencia apareceu: ");
        contarOcorrencias(Lista, ocorrencia);
        sc.close();
    }

    public static void contarOcorrencias(String[] Lista, String ocorrencia) {
        int contador = 0;

        for (int i = 0; i < Lista.length; i++) {
            if (Lista[i].equals(ocorrencia)){
                contador += 1;
            }
        }
        System.out.println(contador);
    }
}
