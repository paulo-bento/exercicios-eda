public class Exercicio6 {

    static class Convidado {
        String nome;
        String cpf;

        Convidado(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }

        @Override
        public String toString() {
            return nome + " | CPF: " + cpf;
        }
    }

    static class No {
        Convidado dado;
        No proximo;

        No(Convidado dado) {
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

        void adiciona(Convidado convidado) {
            No novo = new No(convidado);
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

        boolean contem(String cpf) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado.cpf.equals(cpf)) {
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
                return "Lista vazia.";
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
        ListaEncadeada lista = new ListaEncadeada();

        lista.adiciona(new Convidado("Felipe Erik", "111.222.333-44"));
        lista.adiciona(new Convidado("João Paulo", "222.333.444-55"));
        lista.adiciona(new Convidado("Kaio César", "333.444.555-66"));
        lista.adiciona(new Convidado("Raul Carvalho", "444.555.666-77"));
        lista.adiciona(new Convidado("Fulano de Tal", "555.666.777-88"));
        lista.adiciona(new Convidado("Maria Bonita", "666.777.888-99"));

        System.out.println("=== Lista de Convidados ===");
        System.out.println(lista);

        String busca1 = "444.555.666-77";
        String busca2 = "999.000.111-22";
        System.out.println("CPF " + busca1 + " está na lista? " + lista.contem(busca1));
        System.out.println("CPF " + busca2 + " está na lista? " + lista.contem(busca2));

        System.out.println("\nTotal de convidados: " + lista.getTamanho());
    }
}