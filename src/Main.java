import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("input.txt");


        Scanner scanner = new Scanner(file);
        String expression = scanner.nextLine();
        String[] parts = expression.split(" ");

        double opLeft, opRight;

        try {
            opLeft = Double.parseDouble(parts[0]);
            opRight = Double.parseDouble(parts[2]);
        } catch (NumberFormatException | NullPointerException exception) {
            System.out.println("Error! Not number");
            return;
        }

        if (!(parts[1].equals("+") || parts[1].equals("-") || parts[1].equals("/") || parts[1].equals("*"))) {
            System.out.println("Operation Error!");
            return;
        }


        if (parts[1].equals("/") && opRight == 0.0) {
            System.out.println("Error! Division by zero");
            return;
        }

        try {
            double result = 0;
            switch (parts[1]) {
                case "+":
                    result = opLeft + opRight;
                    break;
                case "-":
                    result = opLeft - opRight;
                    break;
                case "*":
                    result = opLeft * opRight;
                    break;
                case "/":
                    result = opLeft / opRight;
                    break;
            }
            System.out.println(result);
        } catch (ArithmeticException ex) {
            System.out.println("Error! Division by zero");
        }

    }
}