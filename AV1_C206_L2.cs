using System.Collections.Generic;
using System;

namespace ConsoleApp;

static public class AV1_C206_L2 {
    static public void Main() {
        Plataforma metflix = new Plataforma(nome: "metflix");

        while (true) {
            Console.WriteLine("Seleciona uma opção ae: \n" +
                              "1. Add serie\n" +
                              "2. Mostrar info da plataforma e series\n" +
                              "3. Mostrar nome da serie com mais temporadas\n" +
                              "4. Mostrar porcentagem e media aritmetica da nota das com 3 temporadas ou mais\n" +
                              "5. Sair");
            
            int userInput = Convert.ToInt32(Console.ReadLine());

            switch (userInput) {
                case 1:
                    Console.Write("Nome: ");
                    string nome = Console.ReadLine() ?? string.Empty;
                    Console.Write("Nota: ");
                    int nota = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Temporadas: ");
                    int temporadas = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Finalizada: ");
                    bool finalizada = Convert.ToBoolean(Console.ReadLine());
                    Console.Write("Nome do diretor: ");
                    string nomeDiretor = Console.ReadLine() ?? string.Empty;

                    Serie novaSerie = new Serie(
                        nome: nome,
                        nota: nota,
                        temporadas: temporadas,
                        finalizada: finalizada,
                        nomeDiretor: nomeDiretor
                    );

                    metflix.addSerie(novaSerie);
                    break;
                case 2:
                    metflix.mostrarInfo();
                    break;
                case 3:
                    metflix.serieMaisLongaFinalizada();
                    break;
                case 4:
                    metflix.mediaPorcentagem();
                    break;
                case 5:
                    return;
                default:
                    Console.WriteLine("?");
                    break;
            }
        }
    }


    public class Plataforma {
        private string nome;
        private List<Serie> series = new List<Serie>();

        public Plataforma(string nome) {
            this.nome = nome;
        }

        public void mostrarInfo() {
            Console.WriteLine(this.nome);
        }

        public void addSerie(Serie serie) {
            series.Add(serie);
            Console.WriteLine("Serie adicionada.");
        }

        public void serieMaisLongaFinalizada() {
            int maxTemporadasFound = 0;
            Serie serieMaisLonga;

            foreach (var serie in series) {
                if (serie.finalizada && serie.temporadas > maxTemporadasFound) {
                    maxTemporadasFound = serie.temporadas;
                    serieMaisLonga = serie;
                }
            }
        }

        public void mediaPorcentagem() {
            int possuem3OuMaisTemporadas = 0;
            double somaDasNotas = 0.0;

            if (series.Count == 0)
                return;

            foreach (var serie in series) {
                if (serie.temporadas > 3) {
                    somaDasNotas += serie.nota;
                    possuem3OuMaisTemporadas += 1;
                }
            }

            double porcentagem = (double)possuem3OuMaisTemporadas / series.Count;
            double mediaNotas = somaDasNotas / possuem3OuMaisTemporadas;

            Console.WriteLine($"Porcentagem: {porcentagem} | Nota media: {mediaNotas}");
        }
    }


    public class Serie {
        private string nome;
        public double nota;
        public int temporadas;
        public bool finalizada;
        private Diretor diretor;

        public Serie(string nome, double nota, int temporadas, bool finalizada, string nomeDiretor) {
            this.nome = nome;
            this.nota = nota;
            this.temporadas = temporadas;
            this.finalizada = finalizada;
            this.diretor = new Diretor(nome: nomeDiretor);
        }

        public void mostrarInfo() {
            Console.WriteLine(
                this.nome + " " + this.nota + " " + this.temporadas + " " + this.finalizada + this.diretor
            );
        }
    }


    private class Diretor {
        private string nome;

        public Diretor(string nome) {
            this.nome = nome;
        }
    }
}