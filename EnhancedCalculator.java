// EnhancedCalculator.java
import java.util.Scanner;

public class EnhancedCalculator {
    
    public static void main(String[] args) {
        // Handle flags first
        if (args.length == 0 || args[0].equals("--help") || args[0].equals("-h")) {
            showHelp();
            return;
        }
        
        if (args[0].equals("--version") || args[0].equals("-v")) {
            System.out.println("Enhanced Calculator v1.0");
            return;
        }
        
        if (args[0].equals("--interactive") || args[0].equals("-i")) {
            startInteractiveMode();
            return;
        }
        
        // Parse precision flag if present
        int precision = 2;
        int startIndex = 0;
        if (args[0].equals("--precision") && args.length >= 3) {
            try {
                precision = Integer.parseInt(args[1]);
                startIndex = 2;
            } catch (NumberFormatException e) {
                System.out.println("Invalid precision value. Using default: 2");
            }
        }
        
        // Process calculation
        processCalculation(args, startIndex, precision);
    }
    
    private static void processCalculation(String[] args, int startIndex, int precision) {
        try {
            // Check if we have enough arguments
            if (args.length - startIndex < 3 && !args[startIndex].equals("sqrt")) {
                System.out.println("Usage: java EnhancedCalculator <num1> <operator> <num2>");
                System.out.println("       java EnhancedCalculator sqrt <number>");
                return;
            }
            
            // Handle square root (single argument operation)
            if (args[startIndex].equals("sqrt")) {
                if (args.length - startIndex < 2) {
                    System.out.println("Usage: java EnhancedCalculator sqrt <number>");
                    return;
                }
                
                double num = Double.parseDouble(args[startIndex + 1]);
                if (num < 0) {
                    System.out.println("Error: Cannot calculate square root of negative number");
                    return;
                }
                
                double result = Math.sqrt(num);
                System.out.printf("√%.2f = %." + precision + "f%n", num, result);
                return;
            }
            
            // Parse numbers for two-argument operations
            double num1 = Double.parseDouble(args[startIndex]);
            String operator = args[startIndex + 1];
            double num2 = Double.parseDouble(args[startIndex + 2]);
            double result = 0;
            
            // Perform calculation
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed");
                        return;
                    }
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                case "^":
                    result = Math.pow(num1, num2);
                    break;
                default:
                    System.out.println("Error: Invalid operator '" + operator + "'");
                    System.out.println("Valid operators: +, -, *, /, %, ^, sqrt");
                    return;
            }
            
            // Display result with specified precision
            System.out.printf("%." + precision + "f %s %." + precision + "f = %." + precision + "f%n",
                num1, operator, num2, result);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter valid numbers.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
    
    private static void showHelp() {
        System.out.println("=== Enhanced Calculator ===");
        System.out.println("\nUSAGE:");
        System.out.println("  java EnhancedCalculator <num1> <operator> <num2>");
        System.out.println("  java EnhancedCalculator sqrt <number>");
        System.out.println("  java EnhancedCalculator --precision <n> <expression>");
        System.out.println("  java EnhancedCalculator --interactive");
        
        System.out.println("\nOPERATORS:");
        System.out.println("  +     Addition");
        System.out.println("  -     Subtraction");
        System.out.println("  * x   Multiplication");
        System.out.println("  /     Division");
        System.out.println("  %     Modulo");
        System.out.println("  ^     Power");
        System.out.println("  sqrt  Square root");
        
        System.out.println("\nOPTIONS:");
        System.out.println("  -h, --help         Show this help");
        System.out.println("  -v, --version      Show version");
        System.out.println("  -i, --interactive  Interactive mode");
        System.out.println("  --precision <n>    Decimal precision");
        
        System.out.println("\nEXAMPLES:");
        System.out.println("  java EnhancedCalculator 10 + 5");
        System.out.println("  java EnhancedCalculator 15 % 4");
        System.out.println("  java EnhancedCalculator 2 ^ 8");
        System.out.println("  java EnhancedCalculator sqrt 25");
        System.out.println("  java EnhancedCalculator --precision 4 22 / 7");
        System.out.println("  java EnhancedCalculator --interactive");
    }
    
    private static void startInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Interactive Calculator Mode ===");
        System.out.println("Type 'help' for commands, 'exit' to quit");
        
        while (true) {
            System.out.print("\ncalc> ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            
            if (input.equalsIgnoreCase("help")) {
                showHelp();
                continue;
            }
            
            if (input.isEmpty()) {
                continue;
            }
            
            String[] args = input.split("\\s+");
            processCalculation(args, 0, 2);
        }
        
        scanner.close();
    }
}
