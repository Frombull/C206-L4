package AV2_C206_L2;

public class TerraMedia {
    private Habitante[] herois = new Habitante[10];


    public void addHabitante(Habitante habitate) {
        for (int i = 0; i < herois.length; i++) {
            if(herois[i] == null){
                herois[i] = habitate;
                return;
            }
        }
        System.out.println("Maximo de habitantes atingido!");
    }

    public void listarHabitantes() {
        for (int i = 0; i < herois.length; i++) {
            if(herois[i] != null){
                if(herois[i] instanceof Anao) {
                    // Anao Casting
                    Anao auxAnao =(Anao)herois[i];
                    auxAnao.mostraInfo();
                    auxAnao.minerar();
                    auxAnao.atacar();
                }
                else if(herois[i] instanceof Elfo) {
                    // Elfo Casting
                    Elfo auxElfo =(Elfo)herois[i];
                    auxElfo.mostraInfo();
                    auxElfo.atacar();
                    auxElfo.viajar();
                    auxElfo.curar();
                }
                else {
                    // Mago Casting
                    Mago auxMago =(Mago)herois[i];
                    auxMago.mostraInfo();
                    auxMago.lancarFeitico();
                    auxMago.atacar();
                    auxMago.curar();

                }
            }
        }
    }
}
