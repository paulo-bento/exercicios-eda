public class InverterFrase {
    public static void main(String[] args) {
        String frase = "eu gosto de java";
        String[] palavras = frase.split(" ");
        Pilha pilha = new Pilha();

        for (String palavra : palavras) {
            pilha.empilha(palavra);
        }

        StringBuilder resultado = new StringBuilder();
        while (!pilha.estaVazia()) {
            resultado.append(pilha.desempilha());
            if (!pilha.estaVazia()) resultado.append(" ");
        }

        System.out.println(resultado.toString());
    }
}