package Projeto_C206;

class Pokemano implements Evolucao {
    private String nome;
    private String tipo;
    private int idade;
    private int idadeMinimaParaEvoluir = 3;

    public Pokemano(String nome, String tipo, int idade) {
        this.nome = nome;
        this.tipo = tipo;
        this.idade = idade;
    }

    public void mostrarInfos(){
        System.out.print("| Nome: " + this.nome + " | Tipo: " + this.tipo + " | Idade: " + this.idade);
    }

    @Override
    public void evoluir() {
        if(idade > idadeMinimaParaEvoluir){
            System.out.println(this.nome + " acabou de evoluir!");
        }else{
            System.out.println(this.nome + " ainda não é velho o suficiente para evoluir!");
        }
    }


    // Getters & Setters
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public int getIdade() {
        return idade;
    }
}