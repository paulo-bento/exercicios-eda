import java.util.PriorityQueue;

class Tarefa implements Comparable<Tarefa> {
    String nome;
    int prioridade;
    int ordem;

    public Tarefa(String nome, int prioridade, int ordem) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.ordem = ordem;
    }

    @Override
    public int compareTo(Tarefa outra) {
        if (this.prioridade != outra.prioridade) {
            return this.prioridade - outra.prioridade;
        }
        return this.ordem - outra.ordem;
    }
}

public class Exercicio9 {
    public static void main(String[] args) {
        PriorityQueue<Tarefa> fila = new PriorityQueue<>();
        int contador = 0;

        // Adicionando tarefas
        fila.add(new Tarefa("Backup", 2, contador++));
        fila.add(new Tarefa("Atualização", 1, contador++));
        fila.add(new Tarefa("Antivírus", 3, contador++));
        fila.add(new Tarefa("Limpeza", 2, contador++));

        System.out.println("Fila inicial:");
        for (Tarefa t : fila) {
            System.out.println(t.nome + " (prioridade " + t.prioridade + ")");
        }

        System.out.println("\nExecução:");

        while (!fila.isEmpty()) {
            Tarefa atual = fila.poll();

            System.out.println("\nExecutando: " + atual.nome +
                    " (prioridade " + atual.prioridade + ")");

            System.out.println("Fila restante:");
            for (Tarefa t : fila) {
                System.out.println(t.nome + " (prioridade " + t.prioridade + ")");
            }
        }
    }
}