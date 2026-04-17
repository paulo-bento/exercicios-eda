public class Exercicio4 {
    public static boolean palindromo(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return palindromo(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("arara: " + palindromo("arara"));
        System.out.println("java: " + palindromo("java"));
        System.out.println("radar: " + palindromo("radar"));
    }
}