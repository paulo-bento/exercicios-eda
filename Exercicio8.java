import java.util.LinkedList;
import java.util.Queue;

class Processo {
    int id;
    int tempo;

    public Processo(int id, int tempo) {
        this.id = id;
        this.tempo = tempo;
    }
}

public class Exercicio8 {
    public static void main(String[] args) {
        Queue<Processo> fila = new LinkedList<>();

        fila.add(new Processo(1, 5));
        fila.add(new Processo(2, 3));
        fila.add(new Processo(3, 8));

        while (!fila.isEmpty()) {
            Processo atual = fila.poll();

            System.out.println("Executando processo ID: " + atual.id +
                    "  Tempo estimado: " + atual.tempo);

            System.out.println("Processo finalizado!\n");
        }
    }
}