import java.util.LinkedList;
import java.util.Queue;

class Pessoa {
    String nome;
    String tipo; // "normal" ou "prioritária"

    public Pessoa(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
}

class FilaAtendimento<T> {
    private Queue<T> fila;

    public FilaAtendimento() {
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

class Exercicio4 {
    public static void main(String[] args) {
        FilaAtendimento<Pessoa> filaNormal = new FilaAtendimento<>();
        FilaAtendimento<Pessoa> filaPrioritaria = new FilaAtendimento<>();

        filaPrioritaria.enqueue(new Pessoa("Dona Maria", "prioritaria"));
        filaPrioritaria.enqueue(new Pessoa("Seu João", "prioritaria"));
        filaPrioritaria.enqueue(new Pessoa("Fulano Sicrano", "prioritaria"));
        filaPrioritaria.enqueue(new Pessoa("Sicrano Fulano", "prioritaria"));
        filaPrioritaria.enqueue(new Pessoa("Pessoa Legal", "prioritaria"));

        filaNormal.enqueue(new Pessoa("João Paulo", "normal"));
        filaNormal.enqueue(new Pessoa("Kaio César", "normal"));
        filaNormal.enqueue(new Pessoa("Felipe Erik", "normal"));
        filaNormal.enqueue(new Pessoa("Raul Carvalho", "normal"));

        System.out.println("=== Iniciando atendimento ===\n");

        int contadorPrioritario = 0;

        while (!filaPrioritaria.isEmpty() || !filaNormal.isEmpty()) {

            // Atende prioritária se houver e ainda não atingiu 3 seguidas
            if (!filaPrioritaria.isEmpty() && contadorPrioritario < 3) {
                Pessoa atendido = filaPrioritaria.dequeue();
                System.out.println("[PRIORITÁRIO] Atendendo: " + atendido.nome);
                contadorPrioritario++;

                // Atende normal se não houver prioritária ou já atendeu 3 seguidas
            } else if (!filaNormal.isEmpty()) {
                Pessoa atendido = filaNormal.dequeue();
                System.out.println("[NORMAL]      Atendendo: " + atendido.nome);
                contadorPrioritario = 0; // reseta o contador

                // Se não houver normais mas ainda há prioritárias, continua com elas
            } else {
                Pessoa atendido = filaPrioritaria.dequeue();
                System.out.println("[PRIORITÁRIO] Atendendo: " + atendido.nome);
                contadorPrioritario++;
            }
        }

        System.out.println("\nFila vazia. Todos foram atendidos.");
    }
}