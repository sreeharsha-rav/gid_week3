import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        double balance;
        // Create a new BankOperations object
        BankOperations bank = new BankOperations();

        // Chat bot interaction
        System.out.println("***** Welcome to the Bank Chat Bot *****");
        try {
            while (true) {
                // Get the user input
                System.out.println("What would you like to do?");
                message = scanner.nextLine();
                // Process the user input
                balance = bank.processOperation(message);
                // Display the result
                System.out.println("Your current balance is: " + balance);
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}