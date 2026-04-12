public class Exercicio1 {

    static class Aluno {
        String nome;
        String matricula;

        Aluno(String nome, String matricula) {
            this.nome = nome;
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + " | Matrícula: " + matricula;
        }
    }

    static class No {
        Aluno dado;
        No proximo;

        No(Aluno dado) {
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

        void adiciona(Aluno aluno) {
            No novo = new No(aluno);
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

        Aluno pegaPrimeiro() {
            if (cabeca == null)
                return null;
            return cabeca.dado;
        }

        Aluno pegaUltimo() {
            if (cabeca == null)
                return null;
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            return atual.dado;
        }

        int getTamanho() {
            return tamanho;
        }
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.adiciona(new Aluno("Ana Silva", "2026001"));
        lista.adiciona(new Aluno("Bruno Souza", "2026002"));
        lista.adiciona(new Aluno("Carla Mendes", "2026003"));
        lista.adiciona(new Aluno("Diego Ferreira", "2026004"));
        lista.adiciona(new Aluno("Elisa Rocha", "2026005"));

        System.out.println("=== Lista de Chamada ===");
        System.out.println(lista);

        System.out.println("Primeiro aluno: " + lista.pegaPrimeiro());
        System.out.println("Último aluno:   " + lista.pegaUltimo());
        System.out.println("Total de alunos: " + lista.getTamanho());
    }
}