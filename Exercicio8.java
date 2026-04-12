public class Exercicio8 {

    static class Contato {
        String nome;
        String telefone;

        Contato(String nome, String telefone) {
            this.nome = nome;
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return nome + " | Telefone: " + telefone;
        }
    }

    static class No {
        Contato dado;
        No proximo;

        No(Contato dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    static class ListaEncadeada {
        No cabeca;
        int tamanho;

        ListaEncadeada() {
            this.cabeca = null;
            this.tamanho = 0;
        }

        void adiciona(Contato contato) {
            No novo = new No(contato);
            if (cabeca == null) {
                cabeca = novo;
            } else {
                No atual = cabeca;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novo;
            }
            tamanho++;
        }

        boolean contem(String nome) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado.nome.equalsIgnoreCase(nome)) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        int getTamanho() {
            return tamanho;
        }

        @Override
        public String toString() {
            if (cabeca == null)
                return "Agenda vazia.";
            StringBuilder sb = new StringBuilder();
            No atual = cabeca;
            int i = 1;
            while (atual != null) {
                sb.append(i).append(". ").append(atual.dado).append("\n");
                atual = atual.proximo;
                i++;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListaEncadeada agenda = new ListaEncadeada();

        agenda.adiciona(new Contato("Felipe Erik", "(83) 0123-4567"));
        agenda.adiciona(new Contato("João Paulo", "(83) 1234-5678"));
        agenda.adiciona(new Contato("Kaio César", "(83) 2345-6789"));
        agenda.adiciona(new Contato("Raul Carvalho", "(83) 3456-7890"));
        agenda.adiciona(new Contato("Fulano de Tal", "(83) 4567-8901"));
        agenda.adiciona(new Contato("Maria Bonita", "(83) 5678-9012"));

        System.out.println("=== Agenda de Contatos ===");
        System.out.println(agenda);

        String busca1 = "Maria Bonita";
        String busca2 = "Gusttavo Lima";
        System.out.println("\"" + busca1 + "\" está na agenda? " + agenda.contem(busca1));
        System.out.println("\"" + busca2 + "\" está na agenda? " + agenda.contem(busca2));

        System.out.println("\nTotal de contatos: " + agenda.getTamanho());
    }
}