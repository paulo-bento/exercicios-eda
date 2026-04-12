public class Exercicio5 {

    static class Pagina {
        String titulo;
        String endereco;

        Pagina(String titulo, String endereco) {
            this.titulo = titulo;
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return titulo + " (" + endereco + ")";
        }
    }

    static class No {
        Pagina dado;
        No proximo;

        No(Pagina dado) {
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

        void adiciona(Pagina pagina) {
            No novo = new No(pagina);
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

        boolean contem(String endereco) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado.endereco.equalsIgnoreCase(endereco)) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        Pagina pegaUltimo() {
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

        @Override
        public String toString() {
            if (cabeca == null)
                return "Histórico vazio.";
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
        ListaEncadeada historico = new ListaEncadeada();

        historico.adiciona(new Pagina("Google", "www.google.com"));
        historico.adiciona(new Pagina("Wikipedia", "www.wikipedia.org"));
        historico.adiciona(new Pagina("GitHub", "www.github.com"));
        historico.adiciona(new Pagina("Stack Overflow", "www.stackoverflow.com"));
        historico.adiciona(new Pagina("Termo", "term.ooo"));
        historico.adiciona(new Pagina("YouTube", "www.youtube.com"));
        historico.adiciona(new Pagina("Mercado Livre", "www.mercadolivre.com.br"));
        historico.adiciona(new Pagina("WhatsApp Web", "web.whatsapp.com"));

        System.out.println("=== Histórico de Navegação ===");
        System.out.println(historico);

        String busca1 = "www.mercadolivre.com.br";
        String busca2 = "www.facebook.com";
        System.out.println("\"" + busca1 + "\" foi visitada? " + historico.contem(busca1));
        System.out.println("\"" + busca2 + "\" foi visitada? " + historico.contem(busca2));

        System.out.println("\nÚltima página visitada: " + historico.pegaUltimo());
        System.out.println("Total de páginas no histórico: " + historico.getTamanho());
    }
}