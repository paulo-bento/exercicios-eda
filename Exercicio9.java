public class Exercicio9 {

    static class Disciplina {
        String nome;
        double notaFinal;

        Disciplina(String nome, double notaFinal) {
            this.nome = nome;
            this.notaFinal = notaFinal;
        }

        @Override
        public String toString() {
            return nome + " | Nota Final: " + String.format("%.1f", notaFinal);
        }
    }

    static class No {
        Disciplina dado;
        No proximo;

        No(Disciplina dado) {
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

        void adiciona(Disciplina disciplina) {
            No novo = new No(disciplina);
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

        Disciplina pega(int indice) {
            if (indice < 0 || indice >= tamanho) {
                System.out.println("Índice inválido: " + indice);
                return null;
            }
            No atual = cabeca;
            for (int i = 1; i < indice; i++) {
                atual = atual.proximo;
            }
            return atual.dado;
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
                return "Boletim vazio.";
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
        ListaEncadeada boletim = new ListaEncadeada();

        boletim.adiciona(new Disciplina("Estrutura de Dados", 8.5));
        boletim.adiciona(new Disciplina("Banco de Dados I", 9.0));
        boletim.adiciona(new Disciplina("Redes de Computadores", 7.5));
        boletim.adiciona(new Disciplina("Desenvolvimento Web", 9.5));
        boletim.adiciona(new Disciplina("Extensão II", 8.0));

        System.out.println("=== Boletim de Notas ===");
        System.out.println(boletim);

        int indiceBuscado = 2;
        System.out.println("Disciplina na posição " + indiceBuscado + ": " + boletim.pega(indiceBuscado));

        String busca1 = "Banco de Dados";
        String busca2 = "Programação Orientada a Objetos";
        System.out.println("\n\"" + busca1 + "\" está no boletim? " + boletim.contem(busca1));
        System.out.println("\"" + busca2 + "\" está no boletim? " + boletim.contem(busca2));

        System.out.println("\nTotal de disciplinas: " + boletim.getTamanho());
    }
}