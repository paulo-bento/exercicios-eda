import java.util.PriorityQueue;

class Documento implements Comparable<Documento> {
    String nome;
    int paginas;
    int prioridade;
    int ordem;

    public Documento(String nome, int paginas, int prioridade, int ordem) {
        this.nome = nome;
        this.paginas = paginas;
        this.prioridade = prioridade;
        this.ordem = ordem;
    }

    @Override
    public int compareTo(Documento outro) {
        if (this.prioridade != outro.prioridade) {
            return this.prioridade - outro.prioridade;
        }
        return this.ordem - outro.ordem;
    }
}

public class Exercicio6 {
    public static void main(String[] args) {
        PriorityQueue<Documento> fila = new PriorityQueue<>();
        int contador = 0;

        fila.add(new Documento("Relatório", 10, 2, contador++));
        fila.add(new Documento("Contrato", 5, 1, contador++));
        fila.add(new Documento("Trabalho", 15, 3, contador++));
        fila.add(new Documento("Artigo", 8, 1, contador++));

        while (!fila.isEmpty()) {
            Documento d = fila.poll();
            System.out.println("Imprimindo: " + d.nome +
                    " (" + d.paginas + " páginas, prioridade " + d.prioridade + ")");
        }
    }
}