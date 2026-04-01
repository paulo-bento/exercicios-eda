import java.util.PriorityQueue;
import java.util.Comparator;

class Paciente {
    String nome;
    int prioridade; 

    public Paciente(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String descricaoPrioridade() {
        switch (this.prioridade) {
            case 1:
                return "URGENTE";
            case 2:
                return "MÉDIA";
            case 3:
                return "BAIXA";
            default:
                return "DESCONHECIDA";
        }
    }
}

class FilaPrioridade<T> {
    private PriorityQueue<T> fila;

    public FilaPrioridade(Comparator<T> comparator) {
        this.fila = new PriorityQueue<>(comparator);
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

class Exercicio5 {
    public static void main(String[] args) {

        Comparator<Paciente> comparador = Comparator.comparingInt(p -> p.prioridade);

        FilaPrioridade<Paciente> filaProntoSocorro = new FilaPrioridade<>(comparador);

        filaProntoSocorro.enqueue(new Paciente("Kaio Cẽsar", 3));
        filaProntoSocorro.enqueue(new Paciente("Felipe Erik", 1));
        filaProntoSocorro.enqueue(new Paciente("João Paulo", 2));
        filaProntoSocorro.enqueue(new Paciente("Raul Carvalho", 1));
        filaProntoSocorro.enqueue(new Paciente("Fernanda Montenegro", 3));
        filaProntoSocorro.enqueue(new Paciente("Chico Buarque", 2));

        System.out.println("=== Pronto-socorro — iniciando atendimento ===\n");
        System.out.println("Pacientes na fila: " + filaProntoSocorro.size() + "\n");

        int ordem = 1;
        while (!filaProntoSocorro.isEmpty()) {
            Paciente atendido = filaProntoSocorro.dequeue();
            System.out.println(ordem + "º atendido: " + atendido.nome
                    + " [" + atendido.descricaoPrioridade() + "]");
            ordem++;
        }

        System.out.println("\nFila vazia. Atendimento encerrado.");
    }
}