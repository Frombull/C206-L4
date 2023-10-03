package AV2_C206_L3;

public class Arma {
    private int forca;
    private String tipoArma;


    public void mostraInfos() {
        System.out.println("Infos da arma: " + tipoArma + " | " + forca);
    }


    // Getters and Setters
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }
}
