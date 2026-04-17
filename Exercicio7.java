public class Exercicio7 {
    public static int contarDigitos(int n) {
        if (n < 10) return 1;
        return 1 + contarDigitos(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("digitos(12345) = " + contarDigitos(12345));
        System.out.println("digitos(7) = " + contarDigitos(7));
        System.out.println("digitos(100) = " + contarDigitos(100));
    }
}