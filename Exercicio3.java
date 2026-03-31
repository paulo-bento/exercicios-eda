import java.util.LinkedList;
import java.util.Queue;

class ClienteSuper {
    String nome;
    int quantidadeProdutos;

    public ClienteSuper(String nome, int quantidadeProdutos) {
        this.nome = nome;
        this.quantidadeProdutos = quantidadeProdutos;
    }
}

class FilaSuper<T> {
    private Queue<T> fila;

    public FilaSuper() {
        this.fila = new LinkedList<>();
    }

    public void enqueue(T item) {
        fila.add(item);
    }

    public T dequeue() {
        return fila.poll();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int size() {
        return fila.size();
    }
}

class Exercicio3 {
    public static void main(String[] args) {
        FilaSuper<ClienteSuper> filaCaixa = new FilaSuper<>();

        filaCaixa.enqueue(new ClienteSuper("Felipe Erik", 8));
        filaCaixa.enqueue(new ClienteSuper("João Paulo", 3));
        filaCaixa.enqueue(new ClienteSuper("Kaio César", 15));
        filaCaixa.enqueue(new ClienteSuper("Raul Carvalho", 1));
        filaCaixa.enqueue(new ClienteSuper("Pessoa Legal", 22));

        System.out.println("=== Caixa do supermercado ===\n");

        while (!filaCaixa.isEmpty()) {
            ClienteSuper atendido = filaCaixa.dequeue();
            System.out.println("Atendendo: " + atendido.nome
                    + " (" + atendido.quantidadeProdutos + " produtos)"
                    + " | Clientes restantes na fila: " + filaCaixa.size());
        }

        System.out.println("\nFila vazia. Caixa encerrado.");
    }
}