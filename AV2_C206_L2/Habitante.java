package AV2_C206_L2;

public abstract class Habitante {
    public static int contador = 0;
    protected int id;
    protected String nome;
    protected int idade;
    protected float energia;

    // Agregacao
    Arma arma;


    // Constructor
    Habitante() {
        Habitante.contador++;
        this.id = contador;
    }

    public void atacar() {
        if(this.arma == null)
            System.out.println("Sem arma :v ");
        
            System.out.println();
        System.out.println("Infos da arma:");
        System.out.println("Nome: " + arma.getNomeArma());
        System.out.println("Magia: " + arma.isMagica());
        
        if(arma.isMagica()) {
            System.out.println("*Ataca com arma magica*");
            this.energia -= 20;
            System.out.println("Energia apos ataque: " + this.energia);
        } else {
            System.out.println("*Ataca com arma normal*");
            this.energia -= 10;
            System.out.println("Energia apos ataque: " + this.energia);
        }
    }

    public void mostraInfo() {
        System.out.println("ID: "       + this.id);
        System.out.println("Nome: "     + this.nome);
        System.out.println("Idade: "    + this.idade);
        System.out.println("Energia: "  + this.energia);
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getEnergia() {
        return energia;
    }
    public void setEnergia(float energia) {
        this.energia = energia;
    }
}