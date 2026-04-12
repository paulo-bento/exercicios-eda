public class Exercicio10 {

    static class Carro {
        String placa;
        String modelo;

        Carro(String placa, String modelo) {
            this.placa = placa;
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return modelo + " | Placa: " + placa;
        }
    }

    static class No {
        Carro dado;
        No proximo;

        No(Carro dado) {
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

        void adiciona(Carro carro) {
            No novo = new No(carro);
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

        boolean contem(String placa) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado.placa.equalsIgnoreCase(placa)) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        Carro pegaPrimeiro() {
            if (cabeca == null)
                return null;
            return cabeca.dado;
        }

        Carro pegaUltimo() {
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
                return "Estacionamento vazio.";
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
        ListaEncadeada estacionamento = new ListaEncadeada();

        estacionamento.adiciona(new Carro("ABC-1234", "Fiat Uno"));
        estacionamento.adiciona(new Carro("DEF-5678", "BYD Dolphin"));
        estacionamento.adiciona(new Carro("GHI-9012", "Chevrolet Onix"));
        estacionamento.adiciona(new Carro("JKL-3456", "Toyota Corolla"));
        estacionamento.adiciona(new Carro("MNO-7890", "Hyundai HB20"));

        System.out.println("=== Estacionamento ===");
        System.out.println(estacionamento);

        String busca1 = "GHI-9012";
        String busca2 = "ZZZ-0000";
        System.out.println("Placa " + busca1 + " está no estacionamento? " + estacionamento.contem(busca1));
        System.out.println("Placa " + busca2 + " está no estacionamento? " + estacionamento.contem(busca2));

        System.out.println("\nPrimeiro carro: " + estacionamento.pegaPrimeiro());
        System.out.println("Último carro:   " + estacionamento.pegaUltimo());
    }
}