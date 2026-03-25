public class InverterPalavra {
    public static void main(String[] args) {
        String palavra = "hello";
        Pilha pilha = new Pilha();

        for (int i = 0; i < palavra.length(); i++) {
            pilha.empilha(String.valueOf(palavra.charAt(i)));
        }

        StringBuilder resultado = new StringBuilder();
        while (!pilha.estaVazia()) {
            resultado.append(pilha.desempilha());
        }

        System.out.println(resultado.toString());
    }
}