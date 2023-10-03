package AV2_C206_L1;

public abstract class Musico {
    protected static int contador = 0;
    protected int codigo;
    protected String nome;
    protected int idade;
    protected String musica;
    protected int pontuacao;

    // Agregacao
    Instrumento instrumento;


    // Constructor
    Musico() {
        Musico.contador++;
        this.codigo = contador;
    }

    public abstract void tocar();

    public void mostraInfo() {
        System.out.println("Codigo: "       + this.codigo);
        System.out.println("Nome: "     + this.nome);
        System.out.println("Idade: "    + this.idade);
        System.out.println("Musica: "  + this.musica);
        System.out.println("Pontuacao: "  + this.pontuacao);
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMusica() {
        return this.musica;
    }
    public void setMusica(String musica) {
        this.musica = musica;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}