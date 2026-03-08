package Parte1;

import java.util.Arrays;
import java.util.Scanner;

public class ExercicioCTest010B {
    static String[] Lista = {"Java","C#","Python","Lua","Assembly"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(Lista));
        System.out.println("Digite o nome que deseja substituir na lista: ");
        String subs = sc.next();
        System.out.println("Digite seu novo valor: ");
        String valor = sc.next();
        Suubstituit(subs, valor);
        System.out.println("Nova Lista: ");
        System.out.println(Arrays.toString(Lista));
        sc.close();
    }

    public static void Suubstituit(String substituto, String novo){
        for (int i = 0; i<Lista.length; i++){
            if (Lista[i].equals(substituto)){
                Lista[i] = novo;
            }
        }

    }

}
