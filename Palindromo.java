public class Palindromo {
    public static void main(String[] args) {
        verificar("arara");
        verificar("casa");
    }

    public static void verificar(String palavra) {
        Pilha pilha = new Pilha();

        for (int i = 0; i < palavra.length(); i++) {
            pilha.empilha(String.valueOf(palavra.charAt(i)));
        }

        StringBuilder invertida = new StringBuilder();
        while (!pilha.estaVazia()) {
            invertida.append(pilha.desempilha());
        }

        if (palavra.equals(invertida.toString())) {
            System.out.println(palavra + " -> É palíndromo");
        } else {
            System.out.println(palavra + " -> Não é palíndromo");
        }
    }
}