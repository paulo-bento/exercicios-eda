public class ShellSort {

    // Ordena o array usando Shell Sort
    public static void shellSort(int[] array) {
        int n = array.length;

        // Define o intervalo inicial (gap) como metade do tamanho do array
        int gap = n / 2;

        while (gap > 0) {
            System.out.println("--- Gap = " + gap + " ---");

            // A partir do elemento na posição gap, compara com o elemento gap posições antes
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                // Desloca os elementos maiores que temp para frente
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }

            imprimirArray(array);

            // Reduz o gap pela metade
            gap /= 2;
        }
    }

    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array original:");
        imprimirArray(array);
        System.out.println();

        shellSort(array);

        System.out.println();
        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}