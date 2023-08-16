import java.util.Scanner;

public class Lab_exercicio_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nota da provinhea 1: ");
        float nota1 = input.nextFloat();

        System.out.println("Nota da provinhea 2: ");
        float nota2 = input.nextFloat();

        int media = (int)(nota1 + nota2 / 2);
        System.out.println("(INT) Media final: " + media);
    }
}
