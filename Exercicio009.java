public class Exercicio009 {

    static String[] vetor = {"java", "python", "java", "c", "java", "python"};
    public static void main(String[] args) {

        int quantidade = contarOcorrencias("java");

        System.out.println(quantidade);
    }
    public static int contarOcorrencias(String elemento) {
        int contador = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(elemento)) {
                contador++;
            }
        }
        return contador;
    }
}