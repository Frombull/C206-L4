package AV2_C206_L2;

public class Elfo extends Habitante implements Cura {
    private String tribo;


    public void viajar() {
        System.out.println("O elfo está viajando !");
    }

    @Override
    public void mostraInfo() {
        System.out.println();
        System.out.println("Infos do Elfo: ");
        super.mostraInfo();
        System.out.println("Tribo: " + this.tribo);
    }

    public void atacar() {
        System.out.println("*Elfo ataca*");
        super.atacar();
    }

    // Using Interfaces
    @Override
    public void curar() {
        float energia = this.getEnergia();
        energia *= 1.15f; 
        this.setEnergia(energia);
        System.out.println("Heroi curado");
        System.out.println("Energia apos cura: " + this.getEnergia());
    }

    public void setTribo(String tribo) {
        this.tribo = tribo;
    }
}