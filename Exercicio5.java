public class Exercicio5 {
    public static int somaArray(int[] v, int i) {
        if (i == v.length) return 0;
        return v[i] + somaArray(v, i + 1);
    }

    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4};
        System.out.println("soma: " + somaArray(v, 0));
    }
}