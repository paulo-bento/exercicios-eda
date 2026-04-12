public class Exercicio4 {

    static class Livro {
        String titulo;
        String autor;
        int anoPublicacao;

        Livro(String titulo, String autor, int anoPublicacao) {
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
        }

        @Override
        public String toString() {
            return "\"" + titulo + "\" - " + autor + " (" + anoPublicacao + ")";
        }
    }

    static class No {
        Livro dado;
        No proximo;

        No(Livro dado) {
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

        void adiciona(Livro livro) {
            No novo = new No(livro);
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

        Livro pegaPrimeiro() {
            if (cabeca == null)
                return null;
            return cabeca.dado;
        }

        Livro pegaUltimo() {
            if (cabeca == null)
                return null;
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            return atual.dado;
        }

        @Override
        public String toString() {
            if (cabeca == null)
                return "Catálogo vazio.";
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
        ListaEncadeada catalogo = new ListaEncadeada();

        catalogo.adiciona(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        catalogo.adiciona(new Livro("O Cortiço", "Aluísio Azevedo", 1890));
        catalogo.adiciona(new Livro("Vidas Secas", "Graciliano Ramos", 1938));
        catalogo.adiciona(new Livro("A Hora da Estrela", "Clarice Lispector", 1977));
        catalogo.adiciona(new Livro("Grande Sertão: Veredas", "João Guimarães Rosa", 1956));

        System.out.println("=== Catálogo de Livros ===");
        System.out.println(catalogo);

        System.out.println("Primeiro livro: " + catalogo.pegaPrimeiro());
        System.out.println("Último livro:   " + catalogo.pegaUltimo());
    }
}
