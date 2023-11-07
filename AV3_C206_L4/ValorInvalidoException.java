package AV3_C206_L4;

public class ValorInvalidoException extends Exception {
    public ValorInvalidoException() {
        System.out.println("\n===============");
        System.out.println("""
                Nenhum veículo pode ter:\s
                - KmRodados menor que 0
                - Ano > 2024
                - Ano < 1960
                - Marca diferente de rollys-royce ou bentley
                - Potencia ou num de cilindros menor que 0
                """);
    }
}
