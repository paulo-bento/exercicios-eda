public class Pilha {
    private String[] elementos;
    private int tamanho;
    private static final int CAPACIDADE = 100;

    public Pilha() {
        this.elementos = new String[CAPACIDADE];
        this.tamanho = 0;
    }

    public void empilha(String elemento) {
        if (tamanho == CAPACIDADE) {
            throw new RuntimeException("Pilha cheia! (overflow)");
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public String desempilha() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia! (underflow)");
        }
        tamanho--;
        return elementos[tamanho];
    }

    public String topo() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia!");
        }
        return elementos[tamanho - 1];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}