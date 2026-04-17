public class Exercicio2 {
    public static int somatorio(int n) {
        if (n == 1) return 1;
        return n + somatorio(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("somatorio(5) = " + somatorio(5));
        System.out.println("somatorio(10) = " + somatorio(10));
    }
}