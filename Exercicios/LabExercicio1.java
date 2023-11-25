import java.util.Scanner;

public class LabExercicio1 {
    enum Operation {
        SUM, SUBTRACTION, MULTIPLICATION, DIVISION, EXPONENTIATION
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("supew cute calculator 9000!!!1! ™");

        System.out.print("Pwease, enter the fiwst numba: ");
        float num1 = input.nextFloat();

        System.out.print("Now, entew the second numba: ");
        float num2 = input.nextFloat();

        System.out.println("Choose an cute operation: ");
        System.out.println("1. Sum");
        System.out.println("2. Subtwaaction");
        System.out.println("3. M-multipwication");
        System.out.println("4. Divwision uwu");
        System.out.println("5. Exponentiation");

        Operation choiche = Operation.values()[input.nextInt() - 1]; // Index starts at 0

        float result;
        switch (choiche) {
            case SUM -> result = num1 + num2;
            case SUBTRACTION -> result = num1 - num2;
            case MULTIPLICATION -> result = num1 * num2;
            case DIVISION -> {
                if (num2 != 0){
                    result = num1 / num2;
                } else {
                    System.out.println("Oopsie! Division by zero is not so cute :c");
                    return;
                }
            }
            case EXPONENTIATION -> result = (float)Math.pow(num1, num2);
            default -> {
                System.out.println("That's not a cute option :c");
                return;
            }
        }

        System.out.println("The wesult is: " + result + " >w<");
        System.out.println("Thankies for using the supew cute calculator 9000!!!1! ™");
    }
}
