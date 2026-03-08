package Parte2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio0011D {

    private String[] dados;
    private int tamanho;

    public Exercicio0011D(int capacidade) { //metodo criando o Vetor com seu tamanho e sua capacidade, tamanho regularoza 0 pois ainda não foi passado elemento
        dados = new String[capacidade];
        tamanho = 0;
    }

    public void adicionar(String elemento) { //metodo adicionar elementos com condicional para não gerar conflito entre o tamanho e quantidade de dados
        if (tamanho < dados.length) {
            dados[tamanho] = elemento;
            tamanho++;
        }
    }

    public void remove(int posicao) { // se a posição for menor que 0 ou menor/ igual o tamanho a posição consta como inválida
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < tamanho - 1; i++) { // percorrendo o tamanho e diminuindo 1 posição pois já que deixamos essa posição nula não contabiliza
            dados[i] = dados[i + 1];
        }

        tamanho--;
        dados[tamanho] = null; // limpa última posição
    }

    public void imprimir() {
        System.out.println(Arrays.toString(dados));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o tamanho do Vetor que desejas? ");
        int tamanho = sc.nextInt();
        Exercicio0011D vetor = new Exercicio0011D(tamanho);

        for  (int i = 0; i <= tamanho; i++) {
            System.out.println("Digite o nome dos elementos: ");
            String elemento = sc.next();
            vetor.adicionar(elemento);
        }

        System.out.println("Antes de remover:");
        vetor.imprimir();
        System.out.println("Digite a posição a ser removida: ");

        int posicao = sc.nextInt();
        vetor.remove(posicao);

        System.out.println("Depois de remover:");
        vetor.imprimir();
    }
}