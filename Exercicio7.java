import java.util.LinkedList;
import java.util.Queue;

class Chamada {
    String nome;
    String assunto;

    public Chamada(String nome, String assunto) {
        this.nome = nome;
        this.assunto = assunto;
    }
}

public class Exercicio7 {
    public static void main(String[] args) {
        Queue<Chamada> fila = new LinkedList<>();

        fila.add(new Chamada("Fulano", "Suporte"));
        fila.add(new Chamada("Cicrano", "Financeiro"));
        fila.add(new Chamada("Filho Fulano", "Dúvida"));
        fila.add(new Chamada("Filho Cicrano", "Reclamação"));

        while (!fila.isEmpty()) {
            Chamada atual = fila.poll();

            System.out.println("Atendendo: " + atual.nome +
                    " | Assunto: " + atual.assunto);

            System.out.println("Restam na fila: " + fila.size());
        }
    }
}