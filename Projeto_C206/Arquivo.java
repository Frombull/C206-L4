package Projeto_C206;

import java.util.ArrayList;
import java.io.*;

public abstract class Arquivo {
    public static void escrever(Pokemano pokemano){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            String currentDirectory = System.getProperty("user.dir");
            String filePath = currentDirectory + "/pokemanos.txt";

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

    public static ArrayList<PokemanoCapturado> ler() {
        // ArrayList auxiliar para salvar dados encontrados no arquivo
        ArrayList<PokemanoCapturado> encontreiOPokemano = new ArrayList<>();
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // Variável auxiliar que servirá de flag para o while 
        String lineReader;

        try {
            String currentDirectory = System.getProperty("user.dir");
            String filePath = currentDirectory + "/pokemanos.txt";

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
}
