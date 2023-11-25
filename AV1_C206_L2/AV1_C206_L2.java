import java.util.Scanner;


public class AV1_C206_L2 {
    public static void main(String[] args) {
        Plataforma metflix = new Plataforma();
        metflix.nome = "metflix";

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Seleciona uma opcao ae: \n" +
                    "1. Add serie\n" +
                    "2. Mostrar info da plataforma e series\n" +
                    "3. Mostrar nome da serie com mais temporadas\n" +
                    "4. Mostrar porcentagem e media aritmetica da nota das com 3 temporadas ou mais\n" +
                    "5. Sair");

            int userInput = Integer.parseInt(sc.nextLine());

            switch (userInput) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Nota: ");
                    double nota = Double.parseDouble(sc.nextLine());
                    System.out.print("Temporadas: ");
                    int temporadas = Integer.parseInt(sc.nextLine());
                    System.out.print("Finalizada (1/0): ");
                    boolean finalizada = (Integer.parseInt(sc.nextLine())) != 0;    // boolean b = (a != 0);
                    System.out.print("Nome do diretor: ");
                    String nomeDiretor = sc.nextLine();

                    Serie novaSerie = new Serie();
                    novaSerie.nome = nome;
                    novaSerie.nota = nota;
                    novaSerie.temporadas = temporadas;
                    novaSerie.finalizada = finalizada;
                    novaSerie.diretor.nome = nomeDiretor;

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
                    System.out.println("?");
                    break;
            }
        }
    }


    public static class Plataforma {
        public String nome;
        public Serie[] series = new Serie[30];


        public void mostrarInfo() {
            System.out.println("\n" + this.nome + " " + this.series.length + " series na plataforma");
            for (Serie serie : series) {
                if(serie == null)
                    continue;
                serie.mostrarInfo();
            }
            System.out.println();
        }

        public void addSerie(Serie serie) {
            for (int i = 0; i < series.length; i++) {
                if (series[i] == null) {
                    series[i] = serie;
                    System.out.println("\nSerie adicionada.\n");
                    return;
                }
            }
            System.out.println("\nPlataforma cheia, nao e possivel adicionar mais series.\n");
        }

        public void serieMaisLongaFinalizada() {
            int maxTemporadasFound = 0;
            Serie serieMaisLonga = null;

            for (Serie serie : series) {
                if (serie != null && serie.finalizada && serie.temporadas > maxTemporadasFound) {
                    maxTemporadasFound = serie.temporadas;
                    serieMaisLonga = serie;
                }
            }

            if (serieMaisLonga != null) 
                System.out.println("\nSerie com mais temporadas finalizadas: " + serieMaisLonga.nome + " com " + serieMaisLonga.temporadas + " temporadas\n");
            else 
                System.out.println("\nNenhuma serie finalizada encontrada.\n");
        }

        public void mediaPorcentagem() {
            int possuem3OuMaisTemporadas = 0;
            double somaDasNotas = 0.0;
            int numSeriesNaPlataforma = 0;

            for (Serie serie : series) {
                if (serie != null && serie.temporadas >= 3) {
                    somaDasNotas += serie.nota;
                    possuem3OuMaisTemporadas++;
                    numSeriesNaPlataforma++;
                }
            }

            if (possuem3OuMaisTemporadas > 0) {
                double porcentagem = (double) possuem3OuMaisTemporadas / numSeriesNaPlataforma * 100;
                double mediaNotas = somaDasNotas / possuem3OuMaisTemporadas;

                System.out.println("Porcentagem: " + porcentagem + " | Nota média: " + mediaNotas);
            } else {
                System.out.println("Nenhuma série com 3 ou mais temporadas encontrada.");
            }
        }
    }


    public static class Serie {
        public String nome;
        public double nota;
        public int temporadas;
        public boolean finalizada;
        public Diretor diretor;


        public Serie(){
            diretor = new Diretor();
        }

        public void mostrarInfo() {
            System.out.println(this.nome + " " + this.nota + " " + this.temporadas + " " + this.finalizada + " " + this.diretor.nome);
        }
    }


    public static class Diretor {
        public String nome;
    }

}
