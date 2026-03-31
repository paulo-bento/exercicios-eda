import java.util.LinkedList;
import java.util.Queue;

class Cliente {
    String nome;
    int numeroSenha;

    public Cliente(String nome, int numeroSenha) {
        this.nome = nome;
        this.numeroSenha = numeroSenha;
    }
}

class Fila<T> {
    private Queue<T> fila;

    public Fila() {
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

class Exercicio2 {
    public static void main(String[] args) {

        Fila<Cliente> filaBanco = new Fila<>();

        filaBanco.enqueue(new Cliente("Ana Lima", 101));
        filaBanco.enqueue(new Cliente("Bruno Souza", 102));
        filaBanco.enqueue(new Cliente("Carla Dias", 103));
        filaBanco.enqueue(new Cliente("Diego Melo", 104));
        filaBanco.enqueue(new Cliente("Eva Costa", 105));
        filaBanco.enqueue(new Cliente("Felipe Neto", 106));

        System.out.println("=== Iniciando atendimento ===\n");

        while (!filaBanco.isEmpty()) {
            Cliente atendido = filaBanco.dequeue();
            System.out.println("Chamando senha " + atendido.numeroSenha
                    + " — " + atendido.nome);
        }

        System.out.println("\nFila vazia. Todos os clientes foram atendidos.");
    }
}