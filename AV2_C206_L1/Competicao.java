package AV2_C206_L1;

public class Competicao {
    private Musico[] competidores = new Musico[10];


    public void addMusico(Musico musico) {
        for (int i = 0; i < competidores.length; i++) {
            if(competidores[i] == null){
                competidores[i] = musico;
                return;
            }
        }
        System.out.println("Maximo de competidores atingido!");
    }

    public void listarCompetidores() {
        for (int i = 0; i < competidores.length; i++) {
            if(competidores[i] != null){
                if(competidores[i] instanceof Pianista) {
                    Pianista auxPianista =(Pianista)competidores[i];
                    auxPianista.mostraInfo();
                    auxPianista.tocar();

                    auxPianista.errarPausa();
                    auxPianista.tocarAcorde();
                }
                else if(competidores[i] instanceof Violinista) {
                    Violinista auxViolinista =(Violinista)competidores[i];
                    auxViolinista.mostraInfo();
                    auxViolinista.tocar();

                    auxViolinista.desafinar();
                }
                else {
                    Cellista auxCellista =(Cellista)competidores[i];
                    auxCellista.mostraInfo();
                    auxCellista.tocar();

                    auxCellista.desafinar();
                }
            }
        }
    }
}
