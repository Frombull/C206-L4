import java.util.Scanner;

public class LabExercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Litros vendidos: ");
        float litrosVendidos = scanner.nextFloat();

        System.out.println("Tipo de gazoza: ");
        System.out.println("A. Álcool");
        System.out.println("G. Gasolina");
        char tipoGazoza = scanner.next().charAt(0);
        tipoGazoza = Character.toLowerCase(tipoGazoza);

        float precoPorLitro;
        float descontoPorLitro;
        if(tipoGazoza == 'a'){
            precoPorLitro = 4.90f;
            descontoPorLitro = (litrosVendidos <= 20.0f) ? 4.0f : 6.0f;
        } else if(tipoGazoza == 'g') {
            precoPorLitro = 6.00f;
            descontoPorLitro = (litrosVendidos <= 20.0f) ? 3.0f : 5.0f;
        } else {
            System.out.println("Tendi nada");
            return;
        }

        float precoOriginal = litrosVendidos * precoPorLitro;
        float precoComDesconto = precoOriginal * (1.0f - (descontoPorLitro / 100.0f));

        System.out.println("Preço original: R$" + precoOriginal);
        System.out.println("Preço com descontos: R$" + precoComDesconto);
    }
}
