package AV2_C206_L1;

public class Cellista extends Musico implements Som {
    private boolean sentado;

    @Override
    public void tocar() {
        if(this.instrumento != null)
            System.out.println("*Cellista toca*");
    }

    @Override
    public void mostraInfo() {
        System.out.println();
        System.out.println("Infos do Cellista: ");
        super.mostraInfo();
        System.out.println("Sentado: " + this.sentado);
    }

    @Override
    public void desafinar() {
        System.out.println("*Cellista desafina*");
        
        int pontuacao = this.getPontuacao();
        pontuacao *= 0.95;
        this.setPontuacao(pontuacao);
    }

    // Setter
    public void setSentado(boolean sentado) {
        this.sentado = sentado;
    }
}