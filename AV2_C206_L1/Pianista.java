package AV2_C206_L1;


public class Pianista extends Musico implements Tecnica, Tempo {
    private float alturaBanco;


    public void mostaInfo(){
        System.out.println();
        System.out.println("Infos do Pianista:");
        super.mostraInfo();
        System.out.println("Altura do banco: " + this.alturaBanco);
    }

    @Override
    public void tocar(){
        if(this.instrumento != null)
            System.out.println("*Pianista toca*");
    }

    // Interface
    @Override
    public void tocarAcorde() {
        System.out.println("*Pianista toca acorde*");
    }

    @Override
    public void errarPausa() {
        System.out.println("*Pianista erra pausa e recomeca*");
        
        int pontuacao = this.getPontuacao();
        pontuacao -= 25;
        this.setPontuacao(pontuacao);
    }

    // Getters and Setters
    public float getAlturaBanco() {
        return this.alturaBanco;
    }
    public void setAlturaBanco(float alturaBanco) {
        this.alturaBanco = alturaBanco;
    }
}