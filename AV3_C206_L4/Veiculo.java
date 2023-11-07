package AV3_C206_L4;

public class Veiculo implements Comparable<Veiculo> {
    private String marca;
    private String modelo;
    private int ano;
    private double kmRodados;


    private Motor motor;

    public Veiculo() {
        this.motor = new Motor();
    }


    public void mostrarInfos(){
        System.out.println("| Marca: " + this.marca);
        System.out.println("| Modelo: " + this.modelo);
        System.out.println("| Ano: " + this.ano);
        System.out.println("| Km Rodados: " + this.kmRodados);
        System.out.println("| --------------------");
    }

    @Override
    public int compareTo(Veiculo v) {
        return Integer.compare(this.ano, v.getAno());
    }


    // Getters & Setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getKmRodados() {
        return kmRodados;
    }
    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
