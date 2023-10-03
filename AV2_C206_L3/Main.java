package AV2_C206_L3;

public class Main {
    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        cidade.setNome("Ravenholm");

        Arma arma1 = new Arma();
        arma1.setTipoArma("Minigun");
        arma1.setForca(999);

        // Criando personagens
        Humano humano = new Humano();
        humano.setNome("Gabriel");
        humano.setIdade(22);
        humano.setVagalume(true);
        humano.setEnergia(100.0d);
        humano.setDistanciaEscuta(30.0d);
        humano.setVida(100);
        humano.modificarHabilidade(6, "Energia");
        humano.arma = arma1;

        Zumbi zumbi = new Zumbi();
        zumbi.setDiasInfeccao(4);
        zumbi.setVida(100);

        // Adicionando personagens
        cidade.adicionarPersonagens(humano);
        cidade.adicionarPersonagens(zumbi);

        // Mostrando informacoes
        cidade.listarPersonagens();
    }
}
