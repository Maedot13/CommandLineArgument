// File: Calculator.java
public class CommandLineDemo {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculator <num1> <operator> <num2>");
            System.out.println("Example: java Calculator 10 + 5");
            return;
        }
        
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[2]);
        String operator = args[1];
        double result = 0;
        
        switch (operator) {
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
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator. Use +, -, *, or /");
                return;
        }
        
        System.out.println("Result: " + result);
    }
}
