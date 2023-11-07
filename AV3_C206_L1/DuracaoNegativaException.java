package AV3_C206_L1;

public class DuracaoNegativaException extends Exception {
    public DuracaoNegativaException() {
        System.out.println("\n===============");
        System.out.println("Nenhum filme deve ser salvo com duracao menor ou igual a zero!");
    }
}
