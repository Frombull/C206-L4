package Projeto_C206;

class PokemanoCapturado extends Pokemano {
    private String pokebola;
    private String nomeTreinador;

    
    // Constructor
    public PokemanoCapturado(String nome, String tipo, int idade, String pokebola, String nomeTreinador) {
        super(nome, tipo, idade);
        this.pokebola = pokebola;
        this.nomeTreinador = nomeTreinador;
    }

    @Override
    public void mostrarInfos() {
        super.mostrarInfos();
        System.out.println(" | Pokebola: " + this.pokebola + " | Treinador: " + this.nomeTreinador);
    }

    @Override
    public void evoluir(int xp) {
        super.evoluir(xp);
    }


    // Getters & Setters
    public String getPokebola() {
        return pokebola;
    }
    public String getNomeTreinador() {
        return nomeTreinador;
    }
    public void setNomeTreinador(String nome) {
        this.nomeTreinador = nome;
    }
}
