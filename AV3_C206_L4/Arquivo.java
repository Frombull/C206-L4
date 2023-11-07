package AV3_C206_L4;

import java.io.*;
import java.util.ArrayList;


public class Arquivo {
    public void escrever(Veiculo veiculo){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        String line;

        try {
            os = new FileOutputStream("veiculos.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flags
            bw.write("++ Veiculo ++\n");
            bw.write(veiculo.getMarca() + "\n");
            bw.write(veiculo.getModelo() + "\n");
            bw.write(veiculo.getAno() + "\n");
            bw.write(veiculo.getKmRodados() + "\n");
            bw.write(veiculo.getMotor().getPotencia() + "\n");
            bw.write(veiculo.getMotor().getNumCilindros() + "\n");
        }
        catch(Exception e) {
            System.out.println("ERRO: " + e);
        }
        finally{
            try{
                bw.close();
            }
            catch(IOException e) {
                e.printStackTrace();
                System.out.println();
            }
        }
    }



    public ArrayList<Veiculo> ler() {
        // ArrayList auxiliar para salvar encontrados no arquivo
        ArrayList<Veiculo> encontreiOVeiculo = new ArrayList<>();
        
        // Classes que permitem leitura de dados do arquivo
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // Variável auxiliar que servirá de flag para o while 
        String lineReader;

        try {
            is = new FileInputStream("veiculos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            lineReader = br.readLine();

            while (lineReader != null) {
                // Comparando se o que está em lineReader é igual a minha flag
                if(lineReader.contains("++ Veiculo ++")){
                    Veiculo veiculoAux = new Veiculo();

                    // Criando um filme com as variáveis auxiliares
                    veiculoAux.setMarca(br.readLine());
                    veiculoAux.setModelo(br.readLine());
                    veiculoAux.setAno(Integer.parseInt(br.readLine()));
                    veiculoAux.setKmRodados(Double.parseDouble(br.readLine()));

                    veiculoAux.getMotor().setPotencia(Double.parseDouble(br.readLine()));
                    veiculoAux.getMotor().setNumCilindros(Integer.parseInt(br.readLine()));

                    // Adicionando no arrayList
                    encontreiOVeiculo.add(veiculoAux);
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
        return encontreiOVeiculo;
    }   
}
