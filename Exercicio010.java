import java.util.Scanner;
import java.util.Arrays;

public class Exercicio010 {

    static String[] dados = {"Java","C#","Python","Lua","Assembly"};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o item a ser substituído:");
        String subs = sc.next();
        System.out.println("Agora digite o novo:");
        String novo = sc.next();
        substituir(subs, novo);

        System.out.println(Arrays.toString(dados));
        sc.close();
    }

    public static void substituir(String subs, String novo){
        for (int i = 0; i < dados.length; i++) {
            if (dados[i].equals(subs)) {
                dados[i] = novo;
            }

        }

    }
}