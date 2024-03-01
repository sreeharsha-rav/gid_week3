public interface IBankAccountOperation {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double processOperation(String message);
}
