package Projeto_C206;
import java.util.ArrayList;

class Pokedex {
    private ArrayList<PokemanoCapturado> pokemanos;

    // Constructor
    public Pokedex(){
        pokemanos = new ArrayList<PokemanoCapturado>();
    }
    
    public void adicionarPokemano(PokemanoCapturado pokemano) {
        pokemanos.add(pokemano);
        System.out.println("[" + pokemano.getNome() + "] adicionado a pokedex");
    }
    
    public void removerPokemano(String nome) {
        for (PokemanoCapturado pokemon : pokemanos) {
            if (pokemon.getNome().equalsIgnoreCase(nome)) {
                pokemanos.remove(pokemon);
                System.out.println("Pokemon removido da pokedex");
                return;
            }
        }
        System.out.println("Pokemon não encontrado na pokedex");
    }
    
    public void procurarPorTipo(String tipo) {
        System.out.println("Pokemanos do tipo " + tipo + ": ");

        for (PokemanoCapturado p : pokemanos) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                p.mostrarInfos();
            }
        }

        System.out.println();
    }

    public void listarPokemanos(){
        if(pokemanos.isEmpty())
            System.out.println("| Pokedex vazia");

        System.out.println("Lista de pokemanos:");
        System.out.println("--------------------");
        for (PokemanoCapturado p : pokemanos) {
            p.mostrarInfos();
        }
        System.out.println("--------------------\n");
    }


    // Getters & Setters
    public ArrayList<PokemanoCapturado> getPokemons() {
        return pokemanos;
    }

    public void setPokemons(ArrayList<PokemanoCapturado> pokemanos) {
        this.pokemanos = pokemanos;
    }
}
