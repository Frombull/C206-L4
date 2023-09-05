import java.util.Scanner;


public class AV1_C206_L4 {
    public static void main(String[] args) {
        Estante estanteBraba = new Estante();
        estanteBraba.idEstante = 666;
        estanteBraba.letra = 'c';

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Seleciona uma opcao ae: \n" +
                    "1. Add livro\n" +
                    "2. Mostrar info estantes e livros\n" +
                    "3. Mostrar porcentagem de livros em cada genero\n" +
                    "4. Mostrar info do livro e autor com mais e menos paginas\n" +
                    "5. Sair");
            int userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    Livro novoLivro = new Livro();

                    System.out.print("Titulo: ");
                    novoLivro.titulo = sc.next();

                    System.out.print("Genero literario: ");
                    novoLivro.genLiterario = sc.next();

                    System.out.print("Numero de folhas: ");
                    novoLivro.qtdFolhas = sc.nextInt();

                    System.out.print("Editora: ");
                    novoLivro.editora = sc.next();

                    System.out.print("nomeAutor: ");
                    novoLivro.autor.nome = sc.next();

                    System.out.print("Ano de nascimento do autor: ");
                    novoLivro.autor.anoNascimento = sc.nextInt();

                    System.out.print("Profissao do autor: ");
                    novoLivro.autor.profissao = sc.next();

                    estanteBraba.addLivros(novoLivro);
                    break;
                case 2:
                    estanteBraba.mostrarInfos();
                    break;
                case 3:
                    estanteBraba.porcentagemGen();
                    break;
                case 4:
                    estanteBraba.livroMaisEMenos();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("?");
                    break;
            }
        }
    }


    public static class Estante {
        private int idEstante;
        private char letra;
        private Livro[] livros = new Livro[30];


        public void addLivros(Livro livro) {
            for (int i = 0; i < livros.length; i++) {
                if (livros[i] == null) {
                    livros[i] = livro;
                    System.out.println("\nLivro adicionado.\n");
                    return;
                }
            }
            System.out.println("\nPrateleira cheia, nao e possivel adicionar mais livros.\n");
        }

        public void porcentagemGen() {
            int suspense = 0;
            int drama = 0;

            for (Livro livro : livros) {
                if(livro == null)
                    continue;
                if (livro.genLiterario.toLowerCase().equals("suspense"))
                    suspense++;
                else if (livro.genLiterario.toLowerCase().equals("drama"))
                    drama++;
            }

            int totalLivros = suspense + drama;
            if (totalLivros != 0) {
                System.out.println("Suspense " + (float)(suspense * 100 / totalLivros) + "%");
                System.out.println("Drama " + (float)(drama * 100 / totalLivros) + "%");
            }
            System.out.println();
        }

        public void livroMaisEMenos() {
            int maisFolhas = 0;
            int menosFolhas = Integer.MAX_VALUE;
            Livro livromaisPaginas = null;
            Livro livromenosPaginas = null;

            for (Livro livro : livros) {
                if(livro == null)
                    continue;

                if (livro.qtdFolhas > maisFolhas) {
                    maisFolhas = livro.qtdFolhas;
                    livromaisPaginas = livro;
                }
                if (livro.qtdFolhas < menosFolhas) {
                    menosFolhas = livro.qtdFolhas;
                    livromenosPaginas = livro;
                }
            }
            
            System.out.println();
            
            System.out.println("Mais paginas: ");
            if (livromaisPaginas != null) 
            livromaisPaginas.mostrarInfos();
            else
            System.out.println("Nao possui livro.");
            
            System.out.println();

            System.out.println("Menos paginas: ");
            if (livromenosPaginas != null)
                livromenosPaginas.mostrarInfos();
            else
                System.out.println("Nao possui livro.");
            
            System.out.println();
        }

        public void mostrarInfos() {
            System.out.println("\n" + idEstante + " " + letra);
            for (Livro livro : livros) {
                if(livro != null)
                    livro.mostrarInfos();
            }
            System.out.println();
        }
    }


    public static class Livro {
        private String titulo;
        public String genLiterario;
        public int qtdFolhas;
        public String editora;
        private Autor autor;


        public Livro() {
            this.autor = new Autor();
        }

        public void mostrarInfos() {
            System.out.println(this.titulo + " " + this.genLiterario + " " + this.qtdFolhas);
        }
    }


    public static class Autor {
        private String nome;
        private int anoNascimento;
        private String profissao;


        public void mostrarInfos() {
            System.out.println(this.nome + " " + this.anoNascimento + " " + this.profissao);
        }
    }

}
