import java.util.Scanner;


public class AV1_C206_L1 {
    public static void main(String[] args) {
        Supermercado MercadinTop = new Supermercado();
        MercadinTop.nome = "MercadinTop";
        MercadinTop.cnpj = "cnpj123";
        MercadinTop.endereco = "Gridania";
        MercadinTop.numTelefone = "364320444";

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Seleciona uma opcao ae: \n" +
                    "1. Add item\n" +
                    "2. Mostrar info\n" +
                    "3. Mostrar info por categoria\n" +
                    "4. Mostrar info mais caro e barato\n" +
                    "5. Sair");
            int userInput = sc.nextInt();
            sc.nextLine();  

            switch (userInput) {
                case 1:
                    Produto novoProduto = new Produto();
                    
                    System.out.print("Nome: ");
                    novoProduto.nome = sc.nextLine();

                    System.out.print("Codigo de serie: ");
                    novoProduto.codigoSerie = sc.nextInt();
                    sc.nextLine();  
                    
                    System.out.print("Categoria: ");
                    novoProduto.categoria = sc.nextLine();
                    
                    System.out.print("Quantidade: ");
                    novoProduto.quantidade = sc.nextInt();
                    sc.nextLine();  
                    
                    System.out.print("Valor: ");
                    novoProduto.valor = sc.nextDouble();
                    sc.nextLine();  

                    MercadinTop.addProduto(novoProduto);
                    break;
                case 2:
                    MercadinTop.mostraInfo();
                    break;
                case 3:
                    MercadinTop.contarCategorias();
                    break;
                case 4:
                    MercadinTop.mostrarMaisCaroBarato();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("?");
                    break;
            }
        }
    }

    public static class Supermercado {
        public String nome;
        public String cnpj;
        public String endereco;
        public String numTelefone;
        public Produto[] produtos = new Produto[30];


        public void addProduto(Produto p) {
            for (int i = 0; i < produtos.length; i++) {
                if(produtos[i] == null) {
                    produtos[i] = p;
                    System.out.println("[Produto adicionado]\n");
                    return;
                }
            }
            System.out.println("[Maximo de produtos atingido]\n");
        }

        public void mostrarMaisCaroBarato() {
            Produto maisCaro = new Produto();
            Produto maisBarato = new Produto();

            maisCaro.valor = 0.0d;
            maisBarato.valor = Double.MAX_VALUE;
            
            for (Produto produto : produtos) {
                if (produto == null) 
                    continue;

                if (produto.valor > maisCaro.valor) {
                    maisCaro = produto;
                }

                if (produto.valor < maisBarato.valor) {
                    maisBarato = produto;
                }
            }

            System.out.println("Mais caro: ");
            maisCaro.mostrarInfos();

            System.out.println("Mais barato: ");
            maisBarato.mostrarInfos();
        }

        public void contarCategorias() {
            int higiene = 0;
            int utensilios = 0;
            int alimenticios = 0;

            String categoria;
            for (Produto produto : produtos) {
                if(produto == null)
                    continue;

                categoria = produto.categoria.toLowerCase();

                if(categoria.equals("higiene"))
                    higiene += produto.quantidade;
                else if(categoria.equals("utensilios"))
                    utensilios += produto.quantidade;
                else if(categoria.equals("alimenticios"))
                    alimenticios += produto.quantidade;
            }

            System.out.println("higiene: " + higiene);
            System.out.println("utensilios: " + utensilios);
            System.out.println("alimenticios: " + alimenticios);
            System.out.println();
        }

        public void mostraInfo() {
            System.out.println(this.nome + " " + this.cnpj + " " + this.endereco + " " + this.numTelefone);
            for (Produto produto : produtos) {
                if(produto == null)
                    continue;
                produto.mostrarInfos();
            }
            System.out.println();
        }
    }

    public static class Produto {
        public String nome;
        public int codigoSerie;
        public String categoria;
        public int quantidade;
        public double valor;


        public void mostrarInfos() {
            System.out.println(this.nome + " " + this.codigoSerie + " " + this.categoria + " " + this.quantidade + " " + this.valor);
        }
    }
}
