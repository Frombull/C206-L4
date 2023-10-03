package AV2_C206_L3;

public abstract class Personagem {
    public static int numPersonagens = 0;
    private int vida;
    private int idPersonagem;


    // Constructor
    Personagem() {
        Personagem.numPersonagens++;
        this.idPersonagem = numPersonagens;
    }

    public void mostraInfos() {
        System.out.println("Vida: " + this.vida);
        System.out.println("ID: " + this.idPersonagem);
    }

    // Getters and Setters
    public void setVida(int vida){
        this.vida = vida;
    }
}
