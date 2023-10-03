package AV2_C206_L2;

public class Main {
    public static void main(String[] args) {
        TerraMedia terraMedia = new TerraMedia();

        Arma arma1 = new Arma();
        arma1.setNomeArma("Arco");
        arma1.setMagica(true);

        Arma arma2 = new Arma();
        arma2.setNomeArma("Espada");
        arma2.setMagica(false);

        Arma arma3 = new Arma();
        arma3.setNomeArma("Martelo");
        arma3.setMagica(false);

        // Criando heroi
        Anao anao = new Anao();
        anao.setNome("Durrin");
        anao.setEnergia(100);
        anao.setIdade(40);
        anao.setAltura(120);
        anao.setReino("Erebor");
        anao.arma = arma3;

        // Criando heroi
        Mago mago = new Mago();
        mago.setNome("Gandalf");
        mago.setEnergia(1000);
        mago.setIdade(25);
        mago.setCor("White");
        mago.arma = arma2;

        // Criando heroi
        Elfo elfo = new Elfo();
        elfo.setNome("Pelegolas");
        elfo.setEnergia(800);
        elfo.setIdade(32);
        elfo.setTribo("Elfos negros");
        elfo.arma = arma1;

        // Adicionando herois
        terraMedia.addHabitante(anao);
        terraMedia.addHabitante(elfo);
        terraMedia.addHabitante(mago);

        // Mostrando informacoes
        terraMedia.listarHabitantes();
    }
}
