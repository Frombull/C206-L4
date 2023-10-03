package AV2_C206_L1;

public class Violinista extends Musico implements Som {
    private String marcaBreu;
    private boolean usaEspaleira;

    @Override
    public void tocar() {
        if(this.instrumento != null)
            System.out.println("*Violinista toca*");
    }


    @Override
    public void mostraInfo() {
        System.out.println();
        System.out.println("Infos do Violinista: ");
        super.mostraInfo();
        System.out.println("Breu: " + this.marcaBreu);
        System.out.println("Usa espaleira: " + this.usaEspaleira);
    }


    // Using Interfaces
    @Override
    public void desafinar() {
        System.out.println("*Violinista desafina*");
        
        int pontuacao = this.getPontuacao();
        if (usaEspaleira) {
            pontuacao *= 0.95;
        } else {
            pontuacao *= 0.90;
        }
        this.setPontuacao(pontuacao);
    }


    public String getMarcaBreu() {
        return this.marcaBreu;
    }
    public void setMarcaBreu(String marcaBreu) {
        this.marcaBreu = marcaBreu;
    }

    public boolean getEspaleira() {
        return usaEspaleira;
    }
    public void setEspaleira(boolean usaEspaleira) {
        this.usaEspaleira = usaEspaleira;
    }
}