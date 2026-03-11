import java.util.Scanner;

public class TesteVetor007 {

    private String[] elementos;
    private int tamanho;

    public TesteVetor007(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String valor) {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = valor;
            this.tamanho++;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    public void remove(int posicao) {

        if (posicao >= 0 && posicao < this.tamanho) {

            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }

            this.elementos[this.tamanho - 1] = null;
            this.tamanho--;

        } else {
            throw new IllegalArgumentException("Posição inválida");
        }
    }

    public void imprimir() {

        System.out.print("[ ");

        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.elementos[i] + " ");
        }

        System.out.println("] tamanho = " + this.tamanho);
    }

    public int indice(String elemento) {

        for (int i = 0; i < this.tamanho; i++) {

            if (this.elementos[i] != null && this.elementos[i].equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    public int indiceUltimo(String elemento) {

        for (int i = this.tamanho - 1; i >= 0; i--) {

            if (this.elementos[i] != null && this.elementos[i].equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    public void removerTodos(String elemento) {

        int pos;

        while ((pos = indice(elemento)) != -1) {
            remove(pos);
        }
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

        System.out.print("Digite outra posição para remover: ");
        pos = sc.nextInt();

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