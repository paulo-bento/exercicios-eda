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

    // procurar primeira ocorrência
    public int indice(String elemento) {

        for (int i = 0; i < this.tamanho; i++) {

            if (this.elementos[i] != null && this.elementos[i].equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    // EXERCÍCIO 13
    // retorna última ocorrência
    public int indiceUltimo(String elemento) {

        for (int i = this.tamanho - 1; i >= 0; i--) {

            if (this.elementos[i] != null && this.elementos[i].equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    // EXERCÍCIO 14
    // remove todas ocorrências
    public void removerTodos(String elemento) {

        int pos;

        while ((pos = indice(elemento)) != -1) {
            remove(pos);
        }
    }

    // EXERCÍCIO 15
    // adiciona somente se não existir
    public boolean adicionarSeNaoExiste(String elemento) {

        if (indice(elemento) != -1) {
            return false;
        }

        adicionar(elemento);
        return true;
    }

    // EXERCÍCIO 16
    // insere depois da referência
    public boolean inserirDepois(String referencia, String novoElemento) {

        int pos = indice(referencia);

        if (pos == -1) {
            return false;
        }

        if (this.tamanho >= this.elementos.length) {
            return false;
        }

        for (int i = this.tamanho; i > pos + 1; i--) {
            this.elementos[i] = this.elementos[i - 1];
        }

        this.elementos[pos + 1] = novoElemento;
        this.tamanho++;

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TesteVetor007 vetor = new TesteVetor007(10);

        // TESTE VETOR 9 (indiceUltimo)
        vetor.adicionar("A");
        vetor.adicionar("B");
        vetor.adicionar("C");
        vetor.adicionar("B");
        vetor.adicionar("D");
        vetor.adicionar("B");

        System.out.println("Vetor inicial:");
        vetor.imprimir();

        System.out.println("Último índice de B: " + vetor.indiceUltimo("B"));

        // TESTE VETOR 10 (removerTodos)
        vetor.removerTodos("B");

        System.out.println("Após remover todos os B:");
        vetor.imprimir();

        // TESTE VETOR 11 (adicionarSeNaoExiste)
        vetor.adicionarSeNaoExiste("C");
        vetor.adicionarSeNaoExiste("E");

        System.out.println("Após adicionarSeNaoExiste:");
        vetor.imprimir();

        // TESTE VETOR 12 (inserirDepois)
        vetor.inserirDepois("A", "X");

        System.out.println("Após inserirDepois:");
        vetor.imprimir();

        sc.close();
    }
}