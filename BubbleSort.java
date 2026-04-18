public class BubbleSort {

    // Ordena o array usando Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // A cada passagem, o maior elemento "borbulha" para o final
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j];
                    array[j]     = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.print("Passagem " + (i + 1) + ": ");
            imprimirArray(array);
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

        bubbleSort(array);

        System.out.println();
        System.out.println("Array ordenado:");
        imprimirArray(array);
    }
}