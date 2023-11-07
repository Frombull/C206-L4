package AV3_C206_L1;

public class Filme implements Comparable<Filme> {
    private String nomeFilme;
    private String generoFilme;
    private int duracaoMin;


    @Override 
    public int compareTo(Filme f) {
        return this.nomeFilme.compareTo(f.getNomeFilme());
    }


    // getters & Setters
    public String getNomeFilme() {
        return nomeFilme;
    }
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }
    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }
    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }
}
