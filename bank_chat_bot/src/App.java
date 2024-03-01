import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        double balance;

        // Input number of requests
        System.out.println("Enter the number of requests: ");
        int requests = scanner.nextInt();
        scanner.nextLine();

        // Create a new BankOperations object
        BankOperations bank = new BankOperations();

        // Chat bot interaction
        System.out.println("***** Welcome to the Bank Chat Bot *****");
        try {
            while (requests > 0) {
                // Get the user input
                System.out.println("What would you like to do?");
                message = scanner.nextLine();
                // Process the user input
                balance = bank.processOperation(message);
                // Display the result
                System.out.println("Your current balance is: " + balance);
                System.out.println("-----------------------------");
                requests--;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        scanner.close();
    }
}