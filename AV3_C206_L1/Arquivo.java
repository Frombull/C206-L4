package AV3_C206_L1;
import java.io.*;
import java.util.ArrayList;


public class Arquivo {
    public void escrever(Filme filme){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        String line;

        try{
            os = new FileOutputStream("filmes.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flags
            bw.write("++ Filme ++\n");
            bw.write(filme.getNomeFilme() + "\n");
            bw.write(filme.getGeneroFilme() + "\n");
            bw.write(filme.getDuracaoMin() + "\n");
        }
        catch(Exception e){
            System.out.println("ERRO: " + e);
        }
        finally{
            try{
                bw.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }



    public ArrayList<Filme> ler() {
        // ArrayList auxiliar para salvar filmes encontrados no arquivo
        ArrayList<Filme> encontreiOFilme = new ArrayList<>();
        
        // Classes que permitem leitura de dados do arquivo
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // Variável auxiliar que servirá de flag para o while 
        String lineReader;

    try {
        is = new FileInputStream("filmes.txt");
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        // Colocando o cursor no inicio do arquivo
        lineReader = br.readLine();

        while (lineReader != null) {
        // Comparando se o que está em lineReader é igual a minha flag 
            if(lineReader.contains("++ Filme ++")){
                // Variável auxiliar de filme Veiculo 
                Filme filmeAux = new Filme();

                // Criando um filme com as variáveis auxiliares 
                filmeAux.setNomeFilme(br.readLine());
                filmeAux.setGeneroFilme(br.readLine());
                filmeAux.setDuracaoMin(Integer.parseInt(br.readLine()));
                
                // Adicionando o filme no arrayList de Filme 
                encontreiOFilme.add(filmeAux);
            }
            lineReader = br.readLine();
        }
    } 
        catch (Exception e) {
            System.out.println("ERRO: " + e);
        } 
        finally {
            try {
                br.close();
            } 
            catch (Exception e) {
                System.out.println("ERRO: " + e);
            }
        }
        return encontreiOFilme;
    }   
}
