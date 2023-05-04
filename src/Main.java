import java.io.*;
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

        double result = 0;

        try {
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
        } catch (ArithmeticException ex) {
            System.out.println("Error! Division by zero");
            return;
        }

        File outFile = new File("output.txt");

        FileWriter out = new FileWriter(outFile);
        out.write(String.valueOf(result));
        out.flush();
        out.close();

        System.out.println(result);


    }
}