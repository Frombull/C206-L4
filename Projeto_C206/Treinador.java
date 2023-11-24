package Projeto_C206;

public class Treinador {
    private String nome;
    private int pokebolas;
    private Pokedex pokedex;


    public Treinador(String nome, int pokebolas) {
        this.nome = nome;
        this.pokebolas = pokebolas;
        pokedex = new Pokedex(this);

        // Comecando com alguns pokemanos iniciais na pokedex
        if(pokedex.getPokemanos().isEmpty()) {
            pokedex.adicionarPokemano(new PokemanoCapturado("Charmano", "Fogo", 1, "Normal", "Marco"));
            pokedex.adicionarPokemano(new PokemanoCapturado("Boobasauro", "Agua", 2, "Normal", "Marco"));
            pokedex.adicionarPokemano(new PokemanoCapturado("Pikachuchu", "Eletrico", 3, "Ultraball", "Vinicius"));
        }
    }
    

    // Getters & Setters
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pokedex getPokedex() {
        return this.pokedex;
    }

    public int getPokebolas(){
        return this.pokebolas;
    }
}
