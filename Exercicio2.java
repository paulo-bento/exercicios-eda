public class Exercicio2 {

    static class Musica {
        String titulo;
        String artista;

        Musica(String titulo, String artista) {
            this.titulo = titulo;
            this.artista = artista;
        }

        @Override
        public String toString() {
            return "\"" + titulo + "\" - " + artista;
        }
    }

    static class No {
        Musica dado;
        No proximo;

        No(Musica dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    static class ListaEncadeada {
        No cabeca;
        int tamanho;

        ListaEncadeada() {
            this.cabeca = null;
            this.tamanho = 0;
        }

        void adiciona(Musica musica) {
            No novo = new No(musica);
            if (cabeca == null) {
                cabeca = novo;
            } else {
                No atual = cabeca;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novo;
            }
            tamanho++;
        }

        // Percorre a lista comparando o título da música
        boolean contem(String titulo) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado.titulo.equalsIgnoreCase(titulo)) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        int getTamanho() {
            return tamanho;
        }

        @Override
        public String toString() {
            if (cabeca == null)
                return "Playlist vazia.";
            StringBuilder sb = new StringBuilder();
            No atual = cabeca;
            int i = 1;
            while (atual != null) {
                sb.append(i).append(". ").append(atual.dado).append("\n");
                atual = atual.proximo;
                i++;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListaEncadeada playlist = new ListaEncadeada();

        playlist.adiciona(new Musica("Hey Jude", "The Beatles"));
        playlist.adiciona(new Musica("Bohemian Rhapsody", "Queen"));
        playlist.adiciona(new Musica("A Banda", "Chico Buarque"));
        playlist.adiciona(new Musica("Chega de Saudade", "Tom Jobim"));
        playlist.adiciona(new Musica("Starman", "David Bowie"));
        playlist.adiciona(new Musica("Tiro ao Álvaro", "Elis Regina"));

        System.out.println("=== Playlist ===");
        System.out.println(playlist);

        String busca1 = "Hey Jude";
        String busca2 = "Chega de Saudade";
        String busca3 = "Taylor Swift"; // Artista de TikTok não entra na playlist

        System.out.println("\"" + busca1 + "\" está na playlist? " + playlist.contem(busca1));
        System.out.println("\"" + busca2 + "\" está na playlist? " + playlist.contem(busca2));
        System.out.println("\"" + busca3 + "\" está na playlist? " + playlist.contem(busca3));

        System.out.println("Total de músicas: " + playlist.getTamanho());
    }
}