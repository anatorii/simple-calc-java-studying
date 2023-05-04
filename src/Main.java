import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File outFile = new File("output.txt");
        FileWriter out = new FileWriter(outFile);

        File file = new File("input.txt");

        Scanner scanner = new Scanner(file);

        String expression;
        while (scanner.hasNextLine()) {
            expression = scanner.nextLine();
            doCalc(expression, out);
            out.write("\n");
        }
        out.close();
    }

    public static void doCalc(String expression, OutputStreamWriter out) throws IOException {
        String[] parts = expression.split(" ");

        double opLeft, opRight;

        try {
            opLeft = Double.parseDouble(parts[0]);
            opRight = Double.parseDouble(parts[2]);
        } catch (NumberFormatException | NullPointerException exception) {
            out.write(expression + " = Error! Not number");
            return;
        }

        if (!(parts[1].equals("+") || parts[1].equals("-") || parts[1].equals("/") || parts[1].equals("*"))) {
            out.write(expression + " = Operation Error!");
            return;
        }


        if (parts[1].equals("/") && opRight == 0.0) {
            out.write(expression + " = Error! Division by zero");
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
            out.write(expression + " = Error! Division by zero");
            return;
        }
        out.write(expression + " = " + result);
        out.flush();

    }
}