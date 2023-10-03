package AV2_C206_L2;

public class Mago extends Habitante implements Cura,Feitico {
    private String cor;


    public void atacar() {
        System.out.println("*Mago ataca*");
        super.atacar();
    }

    @Override
    public void mostraInfo() {
        System.out.println();
        System.out.println("Infos do Mago: ");
        super.mostraInfo();
        System.out.println("Cor: " + this.cor);
    }

    @Override
    public void curar() {
        float energia = this.getEnergia(); 
        energia *= 1.15f; 
        this.setEnergia(energia);
        System.out.println("Heroi curado");
        System.out.println("Energia apos cura: " + this.getEnergia());
    }

    @Override
    public void lancarFeitico() {
        float energia = this.getEnergia();
        //energia = (float)(energia - (energia * 0.1)); 
        energia *= 0.9f; 
        this.setEnergia(energia);
        System.out.println("*Mago lancou um feitico*"); 
        System.out.println("Energia atual: " + this.getEnergia());
    }

    // Setters
    public void setCor(String cor) {
        this.cor = cor;
    }
}