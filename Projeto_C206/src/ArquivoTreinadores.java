package Projeto_C206;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public abstract class ArquivoTreinadores {
    private static String fileName = "treinadores.txt";
    private static String filePath = System.getProperty("user.dir") + "/" + fileName;


    // Adiciona um treinador (CREATE)
    public static void escrever(Treinador treinador) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream(filePath, true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flags
            bw.write("++ Treinador ++\n");
            bw.write(treinador.getNome() + "\n");
            bw.write(treinador.getPokebolas() + "\n");
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

    // Retorna um arraylist com todos os treinadores (READ)
    public static ArrayList<Treinador> ler() {
        // ArrayList auxiliar para salvar dados encontrados no arquivo
        ArrayList<Treinador> encontrei = new ArrayList<>();
        
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
                if(lineReader.contains("++ Treinador ++")){
                    
                    // Criando com as variáveis auxiliares
                    String nome = br.readLine();
                    int pokebolas = Integer.parseInt(br.readLine());

                    Treinador aux = new Treinador(nome, pokebolas);

                    // Adicionando no arrayList
                    encontrei.add(aux);
                }
                lineReader = br.readLine();
            }
        }
        catch (Exception e) {
            if(fileName == null) {
                System.out.println(fileName);
                System.out.println("ERRO: " + e);
            }
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
        return encontrei;
    }

    // Procura por um treinador (UPDATE)
    public static void updateNome(String nomeAntigo, String nomeNovo) {
        ArrayList<Treinador> treinadores = ler();

        boolean found = false;
        Iterator<Treinador> iterator = treinadores.iterator();
        while (iterator.hasNext()) {
            Treinador t = iterator.next();
            if (t.getNome().equalsIgnoreCase(nomeAntigo)) {
                found = true;
                t.setNome(nomeNovo);
            }
        }

        if(!found){
            System.out.println("[" + nomeAntigo + "] nao encontrado\n");
            return;
        }

        limpar();
        for (Treinador t : treinadores) {
            escrever(t);
        }

        renomearArquivo("pokemanos_" + nomeAntigo.toLowerCase() + ".txt", "pokemanos_" + nomeNovo.toLowerCase() + ".txt");

        System.out.println("\n" + nomeAntigo + " agora se chama " + nomeNovo + "!\n");
    }

    // Procura um treinador por nome e remove o mesmo (DELETE)
    public static void deletarTreinador(String nomeRemover) {
        ArrayList<Treinador> treinadores = ler();

        boolean foundOne = false;
        Iterator<Treinador> iterator = treinadores.iterator();
        while (iterator.hasNext()) {
            Treinador t = iterator.next();
            if (t.getNome().equalsIgnoreCase(nomeRemover)) {
                foundOne = true;
                iterator.remove();
            }
        }

        if(!foundOne){
            System.out.println("[" + nomeRemover + "] nao encontrado\n");
            return;
        }

        limpar();
        for (Treinador t : treinadores) {
            escrever(t);
        }


        deletarArquivo(System.getProperty("user.dir") + "/pokemanos_" + nomeRemover.toLowerCase() + ".txt");

        System.out.println("" + nomeRemover + " removido\n");
    }

    // Remove todos os treinadores
    public static void limpar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("");
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        }
    }

    public static boolean renomearArquivo(String nomeAntigo, String nomeNovo) {
        String diretorio = System.getProperty("user.dir");
        File diretorioAtual = new File(diretorio);

        // Verificando se o diretorio
        if (!diretorioAtual.exists() || !diretorioAtual.isDirectory()) {
            return false;
        }

        // Procura pelo arquivo
        File[] arquivos = diretorioAtual.listFiles();
        
        // Arquivo nao encontrado
        if (arquivos == null)
            return false;

        for (File arquivo : arquivos) {
            if (arquivo.isFile() && arquivo.getName().equals(nomeAntigo)) {
                // Renomeia o arquivo
                File novoArquivo = new File(diretorio, nomeNovo);
                if (arquivo.renameTo(novoArquivo)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        // Arquivo nao encontrado
        return false;        
    }

    public static void deletarArquivo(String nomeArquivo) {
        File arquivoParaDeletar = new File(nomeArquivo);

        if (arquivoParaDeletar.exists()) {
            arquivoParaDeletar.delete();
        } else {
            System.out.println("ERRO: O arquivo não existe.");
        }
    }

}
