public class Exercicio006 {

    public static void main(String[] args) {
        VetorStrings006 elementos = new VetorStrings006(10);
        elementos.adiciona("Verde");
        elementos.adiciona("Azul");
        elementos.adiciona("Amarelo");
        elementos.adiciona("Roxo");

        System.out.println("Tamanho: " + elementos.tamanho());
        System.out.println("Vetor: " + elementos.toString());

        System.out.println("\n-- Busca --");
        System.out.println("Posição de 'Azul': " + elementos.busca("Azul"));
        System.out.println("Posição de 'Laranja': " + elementos.busca("Laranja"));

        System.out.println("\n-- Contém --");
        System.out.println("Contém 'Verde': " + elementos.contem("Verde"));
        System.out.println("Contém 'Laranja': " + elementos.contem("Laranja"));
    }
}

class VetorStrings006 {

    private String[] dados;
    private int tamanho;

    public VetorStrings006(int capacidade) {
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