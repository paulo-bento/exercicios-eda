public class Exercicio3 {
    public static String inverter(String s) {
        if (s.length() <= 1) return s;
        return inverter(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(inverter("java"));
        System.out.println(inverter("olá, mundo!"));
    }
}