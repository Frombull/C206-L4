package AV2_C206_L3;

public class Zumbi extends Personagem implements Infectar, Lutar {
    private int diasInfeccao;
    private boolean cego;
    private String tipoZumbi; // Adicionado para facilitar minha vida


    public void transformacao() {
        // Corredores – 2 a 14 dias de infecção, não são cegos
        // Perseguidores – 14 a 365 dias de infecção, não são cegos
        // Estaladores – mais de 365 dias de infecção, são cegos
        if (diasInfeccao < 2)
            return;



        if (diasInfeccao < 14) {
            cego = false;
            tipoZumbi = "Corredor";
        }
        else if (diasInfeccao < 365) {
            cego = false;
            tipoZumbi = "Perseguidor";
        }
        else {
            cego = true;
            tipoZumbi = "Estalador";
        }

        System.out.println();
        System.out.println("*Zumbi se transforma em um " + tipoZumbi + "*");
    }

    @Override
    public void mostraInfos() {
        System.out.println();
        System.out.println("Infos do Zumbi: ");
        super.mostraInfos();
        System.out.println("Dias infeccao: " + this.diasInfeccao);
        System.out.println("E cego: " + this.cego);
        System.out.println("Tipo de zumbi: " + this.tipoZumbi);
    }


    // Interfaces
    @Override
    public void infectou() {
        System.out.println("O zumbi mordeu e infectou um Humano"); // mordou
    }

    @Override
    public void atacar() {
        System.out.println("*Zumbi ataca*");
    }
    
    @Override
    public void defender() {
        System.out.println("*Zumbi defende*");
    }


    // Getter and Setters
    public void setDiasInfeccao(int diasInfeccao) {
        this.diasInfeccao = diasInfeccao;
    }
}
