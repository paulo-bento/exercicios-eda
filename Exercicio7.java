public class Exercicio7 {

    static class Produto {
        String nome;
        double preco;
        int quantidadeEstoque;

        Produto(String nome, double preco, int quantidadeEstoque) {
            this.nome = nome;
            this.preco = preco;
            this.quantidadeEstoque = quantidadeEstoque;
        }

        @Override
        public String toString() {
            return nome + " | Preço: R$ " + String.format("%.2f", preco) +
                    " | Estoque: " + quantidadeEstoque + " unidades";
        }
    }

    static class No {
        Produto dado;
        No proximo;

        No(Produto dado) {
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

        void adiciona(Produto produto) {
            No novo = new No(produto);
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

        Produto pega(int indice) {
            if (indice < 0 || indice >= tamanho) {
                System.out.println("Índice inválido: " + indice);
                return null;
            }
            No atual = cabeca;
            for (int i = 1; i < indice; i++) { // Índice 0 dá problema na busca pela posição
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

        Produto pegaPrimeiro() {
            if (cabeca == null)
                return null;
            return cabeca.dado;
        }

        Produto pegaUltimo() {
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
                return "Estoque vazio.";
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
        ListaEncadeada estoque = new ListaEncadeada();

        estoque.adiciona(new Produto("Teclado Magnético", 349.90, 15));
        estoque.adiciona(new Produto("Mouse Gamer", 199.90, 30));
        estoque.adiciona(new Produto("Monitor IPS 24\"", 1299.90, 8));
        estoque.adiciona(new Produto("Headset Bass Boost", 299.90, 20));
        estoque.adiciona(new Produto("Cadeira Ergonômica", 2099.90, 12));

        System.out.println("=== Estoque de Produtos ===");
        System.out.println(estoque);

        int indiceBuscado = 2;
        System.out.println("Produto na posição " + indiceBuscado + ": " + estoque.pega(indiceBuscado));

        String busca1 = "Headset Bass Boost";
        String busca2 = "Webcam Full HD";
        System.out.println("\n\"" + busca1 + "\" está no estoque? " + estoque.contem(busca1));
        System.out.println("\"" + busca2 + "\" está no estoque? " + estoque.contem(busca2));

        System.out.println("\nPrimeiro produto: " + estoque.pegaPrimeiro());
        System.out.println("Último produto:   " + estoque.pegaUltimo());
    }
}