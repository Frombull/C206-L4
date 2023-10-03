package AV2_C206_L1;

public class Main {
    public static void main(String[] args) {
        Competicao competicao = new Competicao();

        // Instrumentos
        Instrumento instrumento1 = new Instrumento();
        instrumento1.setModelo("Modelo brabo");
        instrumento1.setCor("Muitas cores");
        instrumento1.setAno(1100);

        Instrumento instrumento2 = new Instrumento();
        instrumento1.setModelo("Modelo brabo");
        instrumento1.setCor("Muitas cores");
        instrumento1.setAno(1200);

        Instrumento instrumento3 = new Instrumento();
        instrumento1.setModelo("Modelo brabo");
        instrumento1.setCor("Muitas cores");
        instrumento1.setAno(1300);

        // Musicos
        Cellista cellista = new Cellista();
        cellista.setNome("Durrin");
        cellista.setIdade(10);
        cellista.setMusica("Musica");
        cellista.setPontuacao(100);
        cellista.setSentado(true);
        cellista.instrumento = instrumento1;

        Violinista violinista = new Violinista();
        violinista.setNome("Jaumzin");
        violinista.setIdade(20);
        violinista.setMusica("Musica");
        violinista.setPontuacao(20);
        violinista.setMarcaBreu("Nestle");
        violinista.setEspaleira(true);
        violinista.instrumento = instrumento2;

        Pianista pianista = new Pianista();
        pianista.setNome("Bob Esponja");
        pianista.setIdade(30);
        pianista.setMusica("Musica");
        pianista.setPontuacao(30);
        pianista.setAlturaBanco(40);
        pianista.instrumento = instrumento3;

        // Adicionando musicos
        competicao.addMusico(cellista);
        competicao.addMusico(violinista);
        competicao.addMusico(pianista);

        // Mostrando informacoes
        competicao.listarCompetidores();
    }
}
