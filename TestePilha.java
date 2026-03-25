public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.empilha("A");
        pilha.empilha("B");
        pilha.empilha("C");

        System.out.println("Topo: " + pilha.topo());

        String removido = pilha.desempilha();
        System.out.println("Removido: " + removido);

        System.out.println("Topo: " + pilha.topo());
    }
}