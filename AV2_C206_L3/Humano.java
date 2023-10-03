package AV2_C206_L3;

public class Humano extends Personagem implements Aprimorar, Lutar {
    private String nome;
    private int idade;
    private boolean vagalume;
    private double energia;
    private double distanciaEscuta;

    Arma arma;

    @Override
    public void mostraInfos(){
        System.out.println();
        System.out.println("Infos do Humano:");
        super.mostraInfos();
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("vagalume: " + this.vagalume);
        System.out.println("Energia: " + this.energia);
        System.out.println("Distancia que escuta: " + this.distanciaEscuta);
    }

    // Interfaces
    @Override
    public void atacar(){
        System.out.println("*Humano ataca*");
        System.out.println("Nome do humano: " + this.nome);
        arma.mostraInfos();
    }
    
    @Override
    public void defender(){
        System.out.println("*Humano defende*");
        System.out.println("Nome do humano: " + this.nome);
        arma.mostraInfos();
    }
    
    @Override
    public void modificarArma() {
        System.out.println("*Humano modifica arma*");
        int forcaArma = arma.getForca();
        forcaArma += 5;
        arma.setForca(forcaArma);
        arma.mostraInfos();
    }

    @Override
    public void modificarHabilidade(int qtdPilulas, String tipoHabilidade) {
        System.out.println("*Humano modifica habilidade*");
        if (qtdPilulas < 0){
            System.out.println("Quantidade de pilulas invalidas, favor informar um valor maior que 0");
            return;
        }

        if (tipoHabilidade.equalsIgnoreCase("Energia")) {
            if (qtdPilulas < 10)
                energia *= 1.02d;
            else if (qtdPilulas < 15)
                energia *= 1.04d;
            System.out.println("Nova energia: " + energia);
        } 
        else if (tipoHabilidade.equalsIgnoreCase("Escuta")) {
            if (qtdPilulas < 10)
                distanciaEscuta += 0.2d;
            else if (qtdPilulas < 15)
                distanciaEscuta += 0.5d;
            System.out.println("Nova distancia de escuta: " + distanciaEscuta);
        }
    }


    // Getters and Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setVagalume(boolean vagalume) {
        this.vagalume = vagalume;
    }

    public double getEnergia() {
        return energia;
    }
    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public double getDistanciaEscuta() {
        return distanciaEscuta;
    }
    public void setDistanciaEscuta(double distanciaEscuta) {
        this.distanciaEscuta = distanciaEscuta;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
