package Parte2;

import java.util.Scanner;

public class TesteVetor008 {

    private String[] elementos;
    private int tamanho;

    public TesteVetor008(int capacidade) {
        elementos = new String[capacidade];
        tamanho = 0;
    }

    public void adicionar(String valor) {
        elementos[tamanho] = valor;
        tamanho++;
    }

    public int busca(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
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

    public boolean remove(String elemento) {

        int pos = busca(elemento);

        if (pos == -1) {
            return false;
        }

        remove(pos);
        return true;
    }

    public void imprimir() {
        System.out.print("[ ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TesteVetor008 vetor = new TesteVetor008(10);

        vetor.adicionar("A");
        vetor.adicionar("B");
        vetor.adicionar("C");
        vetor.adicionar("B");
        vetor.adicionar("D");

        System.out.println("Vetor inicial:");
        vetor.imprimir();

        System.out.print("Digite o elemento para remover: ");
        String elemento = sc.next();

        boolean removido = vetor.remove(elemento);

        System.out.println("Resultado da remoção: " + removido);

        System.out.println("Vetor após tentativa de remoção:");
        vetor.imprimir();

        System.out.print("Digite o elemento para remover: ");
        String elementos = sc.next();

        boolean removidos = vetor.remove(elementos);

        System.out.println("Resultado da remoção: " + removidos);
        System.out.println("Vetor após tentativa de remoção:");
        vetor.imprimir();


        sc.close();
    }
}
