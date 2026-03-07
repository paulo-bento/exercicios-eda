public class Exercicio005 {

    public static void main(String[] args) {
        VetorStrings elementos = new VetorStrings(3);
        elementos.adiciona("Azul");
        elementos.adiciona("Verde");
        elementos.adiciona("Amarelo");

        System.out.println("Tamanho: " + elementos.tamanho());
        System.out.println("Vetor: " + elementos.toString());
        elementos.imprimeUmPorLinha();
    }
}

class VetorStrings {

    private String[] dados;
    private int tamanho;

    public VetorStrings(int capacidade) {
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