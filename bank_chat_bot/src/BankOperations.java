public class BankOperations implements IBankAccountOperation {
    private double balance;

    public BankOperations() {
        this.balance = 0;   // Set the initial balance to 0
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing " + amount + " into the bank...");
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        // Do not withraw if the amount is greater than the balance
        if (amount > this.balance) {
            System.out.println("Insufficient funds. Cannot withdraw " + amount + " from the bank.");
            return;
        }
        System.out.println("Withdrawing " + amount + " from the bank...");
        this.balance -= amount;
    }

    @Override
    public double processOperation(String message) {
        // convert the message to lowercase
        message = message.toLowerCase();
        // Check if message contains "see", "show"
        if (message.contains("see") || message.contains("show")) {
            return this.balance;
        }

        // Check if message contains "deposit", "put", "invest", "transfer"
        else if (message.contains("deposit") || message.contains("put") || message.contains("invest") || message.contains("transfer")) {
            String[] words = message.split(" "); // Split the message into words
            // Iterate through the words
            for (String word : words) {
                // Check if the word is a number
                if (word.matches("\\d+(\\.\\d+)?")) {
                    double amount = Double.parseDouble(word);
                    this.deposit(amount);
                    return this.balance;
                }
            }
        }

        // Check if message contains "withdraw", "pull"
        else if (message.contains("withdraw") || message.contains("pull")) {
            String[] words = message.split(" ");    // Split the message into words
            // Iterate through the words
            for (String word : words) {
                // Check if the word is a number
                if (word.matches("\\d+(\\.\\d+)?")) {
                    double amount = Double.parseDouble(word);
                    this.withdraw(amount);
                    return this.balance;
                }
            }
        }

        else {
            System.out.println("I'm sorry, I don't understand that.");
        }
        
        return this.balance;
    }
}
