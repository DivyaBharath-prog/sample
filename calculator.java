public class calculator {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: java calculator <num1> <num2> <operation>");
            System.out.println("Operation: +, -, *, /");
            return;
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        String operation = args[2];

        double result;

        switch (operation) {

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    return;
                }
                result = num1 / num2;
                break;

            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        System.out.println("Operation: " + operation);
        System.out.println("Result: " + result);
    }
}
