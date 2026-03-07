public class Exercicio004 {

    public static void main(String[] args) {
        Vetor elementos = new Vetor(3);
        elementos.adiciona("Verde");
        elementos.adiciona("Azul");

        System.out.println(elementos.contem("Verde"));
        System.out.println(elementos.contem("Azul"));
        System.out.println(elementos.contem("Roxo"));   // não está no vetor
    }
}

class Vetor {

    private String[] dados;
    private int tamanho;

    public Vetor(int capacidade) {
        this.dados = new String[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(String elemento) {
        this.dados[this.tamanho] = elemento;
        this.tamanho++;
    }

    public boolean contem(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.dados[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }
}