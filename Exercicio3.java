public class Exercicio3 {

    static class Item {
        String nomeProduto;
        int quantidade;

        Item(String nomeProduto, int quantidade) {
            this.nomeProduto = nomeProduto;
            this.quantidade = quantidade;
        }

        @Override
        public String toString() {
            return nomeProduto + " (quantidade: " + quantidade + ")";
        }
    }

    static class No {
        Item dado;
        No proximo;

        No(Item dado) {
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

        void adiciona(Item item) {
            No novo = new No(item);
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

        Item pega(int indice) {
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

        boolean contem(String nomeProduto) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado.nomeProduto.equalsIgnoreCase(nomeProduto)) {
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

        lista.adiciona(new Item("Arroz", 2));
        lista.adiciona(new Item("Feijão", 1));
        lista.adiciona(new Item("Macarrão", 3));
        lista.adiciona(new Item("Óleo", 1));
        lista.adiciona(new Item("Sal", 1));
        lista.adiciona(new Item("Açúcar", 2));
        lista.adiciona(new Item("Café", 1));

        System.out.println("=== Lista de Compras ===");
        System.out.println(lista);

        int indiceBuscado = 3;
        System.out.println("Item na posição " + indiceBuscado + ": " + lista.pega(indiceBuscado));

        String busca1 = "Café";
        String busca2 = "Leite";
        System.out.println("\n\"" + busca1 + "\" está na lista? " + lista.contem(busca1));
        System.out.println("\"" + busca2 + "\" está na lista? " + lista.contem(busca2));

        System.out.println("\nTotal de itens: " + lista.getTamanho());
    }
}