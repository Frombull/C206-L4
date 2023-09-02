using System.Collections.Generic;
using System;

namespace ConsoleApp;

static public class AV1_C206_L4 {
    static public void Main() {
        Estante estanteBraba = new Estante(idEstante: 666, letra: 'a');

        while (true) {
            Console.WriteLine("Seleciona uma opção ae: \n" +
                              "1. Add livro\n" +
                              "2. Mostrar info estantes e livros\n" +
                              "3. Mostrar porcentagem de livros em cada genero\n" +
                              "4. Mostrar info do livro e autor com mais e menos paginas\n" +
                              "5. Sair");
            int userInput = Convert.ToInt32(Console.ReadLine());

            switch (userInput) {
                case 1:
                    Console.Write("Titulo: ");
                    string titulo = Console.ReadLine() ?? string.Empty;
                    Console.Write("Genero literario: ");
                    string genLiterario = Console.ReadLine() ?? string.Empty;
                    Console.Write("Numero de folhas: ");
                    int folhas = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Editora: ");
                    string editora = Console.ReadLine() ?? string.Empty;

                    Console.Write("nomeAutor: ");
                    string nomeAutor = Console.ReadLine() ?? string.Empty;
                    Console.Write("Ano de nascimento do autor: ");
                    int anoNascimentoAutor = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Profissao do autor: ");
                    string profissaoAutor = Console.ReadLine() ?? string.Empty;


                    Livro novoLivro = new Livro(
                        titulo: titulo,
                        genLiterario: genLiterario,
                        folhas: folhas,
                        editora: editora,
                        autorNome: nomeAutor,
                        AutorAnoNascimento: anoNascimentoAutor,
                        autorProfissao: profissaoAutor
                    );

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
                    Console.WriteLine("?");
                    break;
            }
        }
    }


    public class Estante {
        private int idEstante;
        private char letra;
        private List<Livro> livros = new List<Livro>();


        public Estante(int idEstante, char letra) {
            this.idEstante = idEstante;
            this.letra = letra;
        }

        public void addLivros(Livro livro) {
            livros.Add(livro);
            Console.WriteLine("Livro adicionado.");
        }

        public void porcentagemGen() {
            int suspense = 0;
            int drama = 0;

            foreach (var livro in livros) {
                if (livro.genLiterario.ToLower() == "suspense")
                    suspense++;
                else if (livro.genLiterario.ToLower() == "drama")
                    drama++;
            }

            int totalLivros = suspense + drama;
            if (totalLivros is not 0) {
                Console.WriteLine($"% suspense {suspense * 100 / totalLivros}");
                Console.WriteLine($"% drama {drama * 100 / totalLivros}");
            }
        }

        public void livroMaisEMenos() {
            int maisPaginas = 0;
            int menosPaginas = Int32.MaxValue;
            Livro livromaisPaginas = null;
            Livro livromenosPaginas = null;

            foreach (var livro in livros) {
                if (livro.folhas > maisPaginas) {
                    maisPaginas = livro.folhas;
                    livromaisPaginas = livro;
                }

                if (livro.folhas < menosPaginas) {
                    menosPaginas = livro.folhas;
                    livromenosPaginas = livro;
                }
            }

            Console.WriteLine("Mais paginas: ");
            livromaisPaginas.mostrarInfos();
            Console.WriteLine("Menos paginas: ");
            livromenosPaginas.mostrarInfos();
        }

        public void mostrarInfos() {
            Console.WriteLine(idEstante + " " + letra);
            foreach (var livro in livros) {
                livro.mostrarInfos();
            }
        }
    }


    public class Livro {
        private string titulo;
        public string genLiterario;
        public int folhas;
        private string editora;
        private Autor autor;


        public Livro(string titulo, string genLiterario, int folhas, string editora, string autorNome,
            int AutorAnoNascimento, string autorProfissao) {
            this.titulo = titulo;
            this.genLiterario = genLiterario;
            this.folhas = folhas;
            this.editora = editora;
            this.autor = new Autor(nome: autorNome, anoNascimento: AutorAnoNascimento, profissao: autorProfissao);
        }

        public void mostrarInfos() {
            Console.WriteLine(this.titulo + " " + this.genLiterario + " " + this.folhas + " " + this.editora);
        }
    }


    public class Autor {
        private string nome;
        private int anoNascimento;
        private string profissao;


        public Autor(string nome, int anoNascimento, string profissao) {
            this.nome = nome;
            this.anoNascimento = anoNascimento;
            this.profissao = profissao;
        }

        public void mostrarInfos() {
            Console.WriteLine(this.nome + " " + this.anoNascimento + " " + this.profissao);
        }
    }
}