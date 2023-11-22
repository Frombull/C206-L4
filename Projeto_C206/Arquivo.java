package Projeto_C206;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public abstract class Arquivo {
    private static String fileName = "pokemanos.txt";
    private static String filePath = System.getProperty("user.dir") + "/" + fileName;


    // Adiciona um pokemano a pokedex (CREATE)
    public static void escrever(Pokemano pokemano) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream(filePath, true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flags
            bw.write("++ Pokemano ++\n");
            bw.write(pokemano.getNome() + "\n");
            bw.write(pokemano.getTipo() + "\n");
            bw.write(pokemano.getIdade() + "\n");
            bw.write(((PokemanoCapturado)pokemano).getPokebola() + "\n");
            bw.write(((PokemanoCapturado)pokemano).getNomeTreinador() + "\n");
        }
        catch(Exception e) {
            System.out.println("ERRO: " + e);
        }
        finally{
            try{
                if (bw != null) {
                    bw.close();
                }
            }
            catch(IOException e) {
                e.printStackTrace();
                System.out.println();
            }
        }
    }

    // Retorna um arraylist com todos os pokemanos da pokedex(READ)
    public static ArrayList<PokemanoCapturado> ler() {
        // ArrayList auxiliar para salvar dados encontrados no arquivo
        ArrayList<PokemanoCapturado> encontreiOPokemano = new ArrayList<>();
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // Variável auxiliar que servira de flag para o while 
        String lineReader;

        try {
            is = new FileInputStream(filePath);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            lineReader = br.readLine();

            while (lineReader != null) {
                // Comparando se o que está em lineReader é igual a minha flag
                if(lineReader.contains("++ Pokemano ++")){
                    
                    // Criando com as variáveis auxiliares
                    String nome = br.readLine();
                    String tipo = br.readLine();
                    int idade = Integer.parseInt(br.readLine());
                    String pokebola = br.readLine();
                    String nomeTreinador = br.readLine();

                    PokemanoCapturado pokemanoAux = new PokemanoCapturado(nome, tipo, idade, pokebola, nomeTreinador);

                    // Adicionando no arrayList
                    encontreiOPokemano.add(pokemanoAux);
                }
                lineReader = br.readLine();
            }
        }
        catch (Exception e) {
            System.out.println("ERRO: " + e);
        } 
        finally {
            try {
                if (br != null) {
                    br.close();
                }            }
            catch (Exception e) {
                System.out.println("ERRO: " + e);
            }
        }
        return encontreiOPokemano;
    }

    // Procura por um pokemano e muda o nome de seu treinador (UPDATE)
    public static void updateTreinador(String nomePokemon, String nomeTreinadorNovo) {
        ArrayList<PokemanoCapturado> pokemanos = ler();

        boolean found = false;
        Iterator<PokemanoCapturado> iterator = pokemanos.iterator();
        while (iterator.hasNext()) {
            PokemanoCapturado p = iterator.next();
            if (p.getNome().equalsIgnoreCase(nomePokemon)) {
                found = true;
                p.setNomeTreinador(nomeTreinadorNovo);
            }
        }

        if(!found){
            System.out.println("[" + nomePokemon + "] nao encontrado na pokedex\n");
            return;
        }

        limpar();
        for (PokemanoCapturado p : pokemanos) {
            escrever(p);
        }

        System.out.println("\n" + nomeTreinadorNovo + " agora e o novo treinador de [" + nomePokemon + "]!\n");
    }

    // Procura um pokemano por nome e remove o mesmo da pokedex (DELETE)
    public static void deletarPokemano(String nomeRemover) {
        ArrayList<PokemanoCapturado> pokemanos = ler();

        boolean foundOne = false;
        Iterator<PokemanoCapturado> iterator = pokemanos.iterator();
        while (iterator.hasNext()) {
            PokemanoCapturado p = iterator.next();
            if (p.getNome().equalsIgnoreCase(nomeRemover)) {
                foundOne = true;
                iterator.remove();
            }
        }

        if(!foundOne){
            System.out.println("[" + nomeRemover + "] nao encontrado na pokedex\n");
            return;
        }

        limpar();
        for (PokemanoCapturado p : pokemanos) {
            escrever(p);
        }

        System.out.println("[" + nomeRemover + "] removido da pokedex\n");
    }

    // Remove todos os pokemanos da pokedex
    public static void limpar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("");
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        }
    }
}
