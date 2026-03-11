package Parte2;

import java.util.Scanner;

public class TesteVetor007 {

    private String[] elementos;
    private int tamanho;

    public TesteVetor007(int capacidade) {
        elementos = new String[capacidade];
        tamanho = 0;
    }

    public void adicionar(String valor) {
        elementos[tamanho] = valor;
        tamanho++;
    }

    public void remove(int posicao) {

        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[tamanho - 1] = null;
        tamanho--;
    }

    public void imprimir() {
        System.out.print("[ ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println("]  tamanho = " + tamanho);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TesteVetor007 vetor = new TesteVetor007(10);

        vetor.adicionar("A");
        vetor.adicionar("B");
        vetor.adicionar("C");
        vetor.adicionar("D");
        vetor.adicionar("E");

        System.out.println("Vetor inicial:");
        vetor.imprimir();

        System.out.print("Digite a posição para remover: ");
        int pos = sc.nextInt();

        try {
            vetor.remove(pos);
            System.out.println("Após remover:");
            vetor.imprimir();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        sc.close();
    }
}
