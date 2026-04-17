public class Exercicio6 {
    public static int maior(int[] v, int i) {
        if (i == v.length - 1) return v[i];
        int maiorResto = maior(v, i + 1);
        return v[i] > maiorResto ? v[i] : maiorResto;
    }

    public static void main(String[] args) {
        int[] v = {3, 9, 2, 15, 7};
        System.out.println("maior: " + maior(v, 0));
    }
}