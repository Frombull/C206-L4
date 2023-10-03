package AV2_C206_L3;

public class Cidade {
    private String nome;
    private Personagem[] personagens = new Personagem[10];


    public void adicionarPersonagens(Personagem p) {
        for (int i = 0; i < personagens.length; i++) {
            if (personagens[i] == null){
                personagens[i] = p;
                return;
            }
        }
        System.out.println("Maximo de personagens atingido!");
    }

    public void listarPersonagens() {
        for (int i = 0; i < personagens.length; i++) {
            if (personagens[i] != null) {
                if (personagens[i] instanceof Humano) {
                    Humano humano =(Humano)personagens[i];
                    humano.mostraInfos();
                    humano.atacar();
                    humano.defender();
                    humano.modificarArma();
                }
                else {
                    Zumbi zumbi =(Zumbi)personagens[i];
                    zumbi.transformacao();
                    zumbi.mostraInfos();
                    zumbi.atacar();
                    zumbi.defender();
                    zumbi.infectou();
                }
            }
        }
        System.out.println();
        System.out.println("Nome da cidade: " + this.nome);
        System.out.println("Quantidade total de personagens: " + Personagem.numPersonagens);
        System.out.println();
    }

    // Getters and Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
}
