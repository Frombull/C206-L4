package Projeto_C206;
import java.util.ArrayList;

class Pokedex {
    private ArrayList<PokemanoCapturado> pokemanos;

    // Constructor
    public Pokedex(){
        pokemanos = Arquivo.ler();
    }

    public void adicionarPokemano(PokemanoCapturado pokemano) {
        //pokemanos.add(pokemano);
        Arquivo.escrever(pokemano);
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
        boolean foundAny = false;
        
        for (PokemanoCapturado p : pokemanos) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                foundAny = true;
                p.mostrarInfos();
            }
        }

        if(!foundAny){
            System.out.println("| Nenhum pokemano desse tipo na pokedex");
        }
        
        System.out.println();
    }

    public void listarPokemanos(){
        pokemanos = Arquivo.ler();

        if(pokemanos.isEmpty()){
            System.out.println("| Pokedex vazia");
            return;
        }

        System.out.println("Lista de pokemanos:");
        for (PokemanoCapturado p : pokemanos) {
            p.mostrarInfos();
        }
        System.out.println();
    }


    // Getters & Setters
    public ArrayList<PokemanoCapturado> getPokemons() {
        return pokemanos;
    }
}
