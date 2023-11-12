package Projeto_C206;

class Pokemano implements Evolucao {
    protected String nome;
    protected String tipo;
    protected int idade;
    protected int xp;

    public Pokemano(String nome, String tipo, int idade) {
        this.nome = nome;
        this.tipo = tipo;
        this.idade = idade;
    }

    public void mostrarInfos() {
        System.out.print("| Nome: " + this.nome + " | Tipo: " + this.tipo + " | Idade: " + this.idade);
    }

    @Override
    public void evoluir(Pokemano pokemano, int xp) {
        if(xp > 1_000) {
            System.out.println(pokemano.getNome() + " acabou de evoluir!");
        } else {
            System.out.println(pokemano.getNome() + " ainda não tem xp suficiente para evoluir!");
        }
    }


    // Getters & Setters
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public int getIdade() {
        return idade;
    }
}