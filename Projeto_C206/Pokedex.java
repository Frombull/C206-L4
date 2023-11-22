package Projeto_C206;
import java.util.ArrayList;

class Pokedex {
    private ArrayList<PokemanoCapturado> pokemanos;


    // Constructor
    public Pokedex() {
        pokemanos = Arquivo.ler();
    }

    public void adicionarPokemano(PokemanoCapturado pokemano) {
        Arquivo.escrever(pokemano);
        System.out.println("[" + pokemano.getNome() + "] adicionado a pokedex!\n");
    }

    public void removerPokemano(String nomeRemover) {
        Arquivo.deletarPokemano(nomeRemover);
    }
    
    public void procurarPorTipo(String tipo) {
        tipo = tipo.trim();
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

    public void listarPokemanos() {
        pokemanos = Arquivo.ler();

        if(pokemanos.isEmpty()){
            System.out.println("| Pokedex vazia!\n");
            return;
        }

        System.out.println("Lista de pokemanos:");
        for (PokemanoCapturado p : pokemanos) {
            p.mostrarInfos();
        }
        System.out.println();
    }

    public void trocarTreinador(String nomePokemano, String nomeTreinadorNovo) {
        Arquivo.updateTreinador(nomePokemano, nomeTreinadorNovo);
    }


    // Getters & Setters
    public ArrayList<PokemanoCapturado> getPokemons() {
        return pokemanos;
    }
}
