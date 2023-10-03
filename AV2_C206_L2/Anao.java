package AV2_C206_L2;


public class Anao extends Habitante implements Mineracao {
    private float altura;
    private String reino;


    public void mostaInfo(){
        System.out.println();
        System.out.println("Infos do Anao:");
        super.mostraInfo();
        System.out.println("Altura: " + this.altura);
        System.out.println("Reino: " + this.reino);
    }

    public void atacar(){
        System.out.println("*Anao ataca*");
        super.atacar();
    }

    // Interface
    @Override
    public void minerar() {
        System.out.println("*Anao minera* *clang*");
    }

    // Setters
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }
}