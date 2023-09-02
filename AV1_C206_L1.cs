using System.Collections.Generic;
using System;

namespace ConsoleApp;

static public class AV1_C206_L1 {
    static public void Main() {
        Supermercado MercadinTop = new Supermercado(
            nome: "MercadinTop",
            endereco: "Gridania",
            cnpj: "cnpj123",
            numTelefone: 364320444
        );
    
        while (true) {
            Console.WriteLine("Seleciona uma opção ae: \n" +
                              "1. Add item\n" +
                              "2. Mostrar info\n" +
                              "3. Mostrar info por categoria\n" +
                              "4. Mostrar info mais caro e barato\n" +
                              "5. Sair");
            int userInput = Convert.ToInt32(Console.ReadLine());
    
            switch (userInput) {
                case 1:
                    Console.Write("Nome: ");
                    string nome = Console.ReadLine() ?? string.Empty;
                    Console.Write("Codigo de serie: ");
                    int codigoSerie = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Categoria: ");
                    string categoria = Console.ReadLine();
                    Console.Write("Quantidade: ");
                    int quantidade = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Valor: ");
                    double valor = Convert.ToDouble(Console.ReadLine());
    
                    Produto novoProduto = new Produto(
                        nome: nome,
                        codigoSerie: codigoSerie,
                        categoria: categoria,
                        quantidade: quantidade,
                        valor: valor
                    );
    
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
                    Console.WriteLine("?");
                    break;
            }
        }
    }


    public class Supermercado {
        private string nome;
        private string cnpj;
        private string endereco;
        private int numTelefone;
        private List<Produto> produtos = new List<Produto>();

        public Supermercado(string nome, string cnpj, string endereco, int numTelefone) {
            this.nome = nome;
            this.cnpj = cnpj;
            this.endereco = endereco;
            this.numTelefone = numTelefone;
        }

        public void addProduto(Produto produto) {
            this.produtos.Add(produto);
            Console.WriteLine("[Produto adicionado]");
        }

        public void mostrarMaisCaroBarato() {
            double maisCaro = 0;
            double maisBarato = Int32.MaxValue;
            Produto produtoMaisCaro = null;
            Produto produtoMaisBarato = null;

            foreach (var produto in produtos) {
                if (produto.valor > maisCaro) {
                    maisCaro = produto.valor;
                    produtoMaisCaro = produto;
                }

                if (produto.valor < maisBarato) {
                    maisBarato = produto.valor;
                    produtoMaisBarato = produto;
                }
            }

            Console.WriteLine("Mais caro: ");
            produtoMaisCaro.mostrarInfos();

            Console.WriteLine("Mais barato: ");
            produtoMaisBarato.mostrarInfos();
        }

        public void contarCategorias() {
            foreach (var prod in produtos) {
                Console.WriteLine(prod.categoria);
            }
        }

        public void mostraInfo() {
            Console.WriteLine(this.nome + " " + this.cnpj + " " + this.endereco + " " + this.numTelefone);
            foreach (var produto in produtos) {
                produto.mostrarInfos();
            }
        }
    }


    public class Produto {
        private string nome;
        private int codigoSerie;
        public string categoria;
        private int quantidade;
        public double valor;

        public Produto(string nome, int codigoSerie, string categoria, int quantidade, double valor) {
            this.nome = nome;
            this.codigoSerie = codigoSerie;
            this.categoria = categoria;
            this.quantidade = quantidade;
            this.valor = valor;
        }

        public void mostrarInfos() {
            Console.WriteLine(this.nome + " " + this.codigoSerie + " " + this.categoria + " " + this.quantidade + " " +
                              this.valor);
        }
    }
}