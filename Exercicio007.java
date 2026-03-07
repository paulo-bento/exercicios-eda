public class Exercicio007 {

    public static void main(String[] args) {
        VetorStrings007 elementos = new VetorStrings007(10);

        System.out.println("-- Chamando ultimo() antes de adicionar elementos --");
        System.out.println("Último: " + elementos.ultimo());

        elementos.adiciona("Verde");
        elementos.adiciona("Azul");
        elementos.adiciona("Amarelo");
        elementos.adiciona("Roxo");

        System.out.println("\n-- Chamando ultimo() depois de adicionar elementos --");
        System.out.println("Último: " + elementos.ultimo());
    }
}

class VetorStrings007 {

    private String[] dados;
    private int tamanho;

    public VetorStrings007(int capacidade) {
        this.dados = new String[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(String elemento) {
        this.dados[this.tamanho] = elemento;
        this.tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String ultimo() {
        if (this.tamanho == 0) {
            throw new RuntimeException("Vetor está vazio, não há último elemento.");
        }
        return this.dados[this.tamanho - 1];
    }

    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.dados[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contem(String elemento) {
        return this.busca(elemento) != -1;
    }

    public String toString() {
        String resultado = "[";
        for (int i = 0; i < this.tamanho; i++) {
            resultado += this.dados[i];
            if (i < this.tamanho - 1) {
                resultado += ", ";
            }
        }
        return resultado + "]";
    }

    public void imprimeUmPorLinha() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.dados[i]);
        }
    }
}