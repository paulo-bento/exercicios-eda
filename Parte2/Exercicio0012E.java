package Parte2;

import java.util.Scanner;

public class Exercicio0012E {
    private String[] elementos;
    private int tamanho;

    public Exercicio0012E(int capacidade) {
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
        System.out.println("] tamanho = " + tamanho);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Exercicio0012E vetor = new Exercicio0012E(10);

        vetor.adicionar("A");
        vetor.adicionar("B");
        vetor.adicionar("C");
        vetor.adicionar("D");
        vetor.adicionar("E");

        System.out.println("Vetor inicial:");
        vetor.imprimir();

        System.out.print("Digite o elemento para remover: ");
        String elemento = sc.next();

        boolean removido = vetor.remove(elemento);

        if (removido) {
            System.out.println("Elemento removido!");
        } else {
            System.out.println("Elemento não encontrado.");
        }

        vetor.imprimir();

        sc.close();
    }
}
